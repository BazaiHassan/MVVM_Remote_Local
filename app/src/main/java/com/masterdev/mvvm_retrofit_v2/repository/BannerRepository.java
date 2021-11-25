package com.masterdev.mvvm_retrofit_v2.repository;

import androidx.lifecycle.LiveData;

import com.masterdev.mvvm_retrofit_v2.local_db.BannerDao;
import com.masterdev.mvvm_retrofit_v2.model.ResponseBanner;
import com.masterdev.mvvm_retrofit_v2.remote_db.ApiService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BannerRepository {

    private ApiService apiService;
    private BannerDao bannerDao;

    public BannerRepository(ApiService apiService, BannerDao bannerDao) {
        this.apiService = apiService;
        this.bannerDao = bannerDao;
    }

    public void getBannerRemote() {
        apiService.getBanner().enqueue(new Callback<List<ResponseBanner>>() {
            @Override
            public void onResponse(Call<List<ResponseBanner>> call, Response<List<ResponseBanner>> response) {
                List<ResponseBanner> banners = response.body();
                bannerDao.insertBanner(banners);
            }

            @Override
            public void onFailure(Call<List<ResponseBanner>> call, Throwable t) {

            }
        });
    }

    public LiveData<List<ResponseBanner>> getBannerLocal() {
        return bannerDao.getBanners();
    }
}
