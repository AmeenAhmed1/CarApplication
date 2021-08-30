package com.ameen.carapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mainBinding.getRoot());

        initView();
        initViewModel();
    }

    private void initView() {

        carList = new ArrayList<>();
        carAdapter = new CarAdapter(this, carList);

        mainBinding.carRecycler.setAdapter(carAdapter);
        mainBinding.carRecycler.setLayoutManager(new LinearLayoutManager(this));

        mainBinding.swipeLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeHandler();
            }
        });

    }

    private void initViewModel(){
        mainViewModel = new MainViewModel();
        mainViewModel.getCars();
        mainViewModel.carResponse.observe(this, new Observer<ArrayList<CarModule>>() {
            @Override
            public void onChanged(ArrayList<CarModule> carModules) {
                carAdapter.updateList(carModules);
            }
        });
    }

    private void swipeHandler(){
        mainViewModel.getCars();
    }
}