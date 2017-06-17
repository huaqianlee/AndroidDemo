package com.example.lee.devilweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lee on 16/06/17.
 */

public class Basic {
    @SerializedName("city")
    public String cityName;

    @SerializedName("id")
    public String weatherId;

    public Update update;

    public class Update {
        @SerializedName("loc")
        public String updateTime;
    }
}
