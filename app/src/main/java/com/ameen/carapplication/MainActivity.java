package com.ameen.carapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.ameen.carapplication.adapter.CarAdapter;
import com.ameen.carapplication.data.CarModule;
import com.ameen.carapplication.data.remote.ApiService;
import com.ameen.carapplication.data.remote.RetrofitSetting;
import com.ameen.carapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding mainBinding;
    private CarAdapter carAdapter;
    private ArrayList<CarModule> carList;
    private ApiService apiService;
    private MainViewModel mainViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        initView();
    }

    private void initView() {

        mainViewModel = new MainViewModel();
        mainViewModel.getCars();
        mainViewModel.carResponse.observe(this, new Observer<ArrayList<CarModule>>() {
            @Override
            public void onChanged(ArrayList<CarModule> carModules) {
                carAdapter.updateList(carModules);
            }
        });

        apiService = RetrofitSetting.getRetrofitClient().create(ApiService.class);

        carList = new ArrayList<>();
        carAdapter = new CarAdapter(this, carList);

        mainBinding.carRecycler.setAdapter(carAdapter);
        mainBinding.carRecycler.setLayoutManager(new LinearLayoutManager(this));

    }
}