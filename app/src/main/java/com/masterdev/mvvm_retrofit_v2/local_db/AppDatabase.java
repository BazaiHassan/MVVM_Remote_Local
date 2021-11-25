package com.masterdev.mvvm_retrofit_v2.local_db;


import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.masterdev.mvvm_retrofit_v2.model.ResponseBanner;

@Database(version = 1, exportSchema = false, entities = {ResponseBanner.class})
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase appDatabase;

    public static AppDatabase getAppDatabase(Context context) {
        if (appDatabase == null) {
            appDatabase = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "db_shopping_items")
                    .allowMainThreadQueries()
                    .build();
        }

        return appDatabase;
    }

    public abstract BannerDao getDao();
}