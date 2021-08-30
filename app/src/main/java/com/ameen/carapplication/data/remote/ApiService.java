package com.ameen.carapplication.data.remote;

import com.ameen.carapplication.data.CarModule;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by (Ameen Essa) on 8/30/2021
 * Copyright (c) 2021 . All rights reserved.
 *
 * @Ameen.MobileDev@gmail.com
 */
public interface ApiService {

    @GET("/cars")
    Call<CarModule> getCars(@Query("page") int pageNumber);

}
