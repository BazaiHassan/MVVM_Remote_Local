package com.masterdev.mvvm_retrofit_v2.view_model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.masterdev.mvvm_retrofit_v2.model.ResponseBanner;
import com.masterdev.mvvm_retrofit_v2.repository.BannerRepository;

import java.util.List;

public class BannerViewModel extends ViewModel {

    private BannerRepository repository;

    public BannerViewModel(BannerRepository repository) {
        this.repository = repository;
        repository.getBannerRemote();
    }

    public LiveData<List<ResponseBanner>> getBanner(){
        return repository.getBannerLocal();
    }
}
