package com.ameen.carapplication;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.ameen.carapplication.data.CarModule;
import com.ameen.carapplication.data.remote.ApiService;
import com.ameen.carapplication.data.remote.RetrofitSetting;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by (Ameen Essa) on 8/30/2021
 * Copyright (c) 2021 . All rights reserved.
 *
 * @Ameen.MobileDev@gmail.com
 */
public class MainViewModel extends ViewModel {

    public MutableLiveData<ArrayList<CarModule>> carResponse = new MutableLiveData();
    private ApiService apiService;

    public void getCars() {

        apiService = RetrofitSetting.getRetrofitClient().create(ApiService.class);

        apiService.getCars(1).enqueue(new Callback<ArrayList<CarModule>>() {
            @Override
            public void onResponse(Call<ArrayList<CarModule>> call, Response<ArrayList<CarModule>> response) {
                carResponse.postValue(response.body());
            }

            @Override
            public void onFailure(Call<ArrayList<CarModule>> call, Throwable t) {

            }
        });
    }
}
