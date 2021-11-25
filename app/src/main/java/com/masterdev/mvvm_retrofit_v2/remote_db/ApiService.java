package com.masterdev.mvvm_retrofit_v2.remote_db;

import com.masterdev.mvvm_retrofit_v2.model.ResponseBanner;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("banner.php")
    Call<List<ResponseBanner>> getBanner();
}
