package com.masterdev.mvvm_retrofit_v2.view_model;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.masterdev.mvvm_retrofit_v2.repository.BannerRepository;

public class BannerViewModelFactory implements ViewModelProvider.Factory {

    private BannerRepository bannerRepository;

    public BannerViewModelFactory(BannerRepository bannerRepository) {
        this.bannerRepository = bannerRepository;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        return (T) new BannerViewModel(bannerRepository);
    }
}
