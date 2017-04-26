package com.example.lee.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lee on 17-4-26.
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
