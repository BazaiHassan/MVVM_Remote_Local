package com.masterdev.mvvm_retrofit_v2.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "tbl_banner")
public class ResponseBanner {
    @SerializedName("image")
    private String image;

    @SerializedName("id")
    @PrimaryKey
    private int id;

    public String getImage(){
        return image;
    }

    public int getId(){
        return id;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setId(int id) {
        this.id = id;
    }
}
