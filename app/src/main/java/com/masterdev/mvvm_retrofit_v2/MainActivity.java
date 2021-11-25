package com.masterdev.mvvm_retrofit_v2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.masterdev.mvvm_retrofit_v2.local_db.AppDatabase;
import com.masterdev.mvvm_retrofit_v2.model.AdapterBanner;
import com.masterdev.mvvm_retrofit_v2.model.ResponseBanner;
import com.masterdev.mvvm_retrofit_v2.remote_db.ApiServiceProvider;
import com.masterdev.mvvm_retrofit_v2.repository.BannerRepository;
import com.masterdev.mvvm_retrofit_v2.view_model.BannerViewModel;
import com.masterdev.mvvm_retrofit_v2.view_model.BannerViewModelFactory;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvBanner;
    private AdapterBanner adapterBanner;
    private BannerViewModel bannerViewModel;
    private BannerRepository bannerRepository;
    private BannerViewModelFactory bannerViewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        initialise();
        showBanners();

    }

    private void initialise() {
        bannerRepository = new BannerRepository(ApiServiceProvider.getApiService(), AppDatabase.getAppDatabase(getApplicationContext()).getDao());
        bannerViewModelFactory = new BannerViewModelFactory(bannerRepository);

    }

    private void showBanners() {
        bannerViewModel = new ViewModelProvider(this, bannerViewModelFactory).get(BannerViewModel.class);
        bannerViewModel.getBanner().observe(this, new Observer<List<ResponseBanner>>() {
            @Override
            public void onChanged(List<ResponseBanner> responseBanners) {
                adapterBanner = new AdapterBanner(responseBanners);
                rvBanner.setAdapter(adapterBanner);
            }
        });
    }

    private void findViews() {
        rvBanner = findViewById(R.id.rv_banner);
        rvBanner.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));
    }
}