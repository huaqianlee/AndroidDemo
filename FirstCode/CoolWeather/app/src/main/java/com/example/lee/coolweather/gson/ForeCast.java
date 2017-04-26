package com.example.lee.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lee on 17-4-26.
 */

public class ForeCast {
    public String date;

    @SerializedName("tmp")
    public Temperature temperature;

    @SerializedName("cond")
    public More more;


    private class Temperature {
        public String max;
        public String min;
    }

    private class More {
        @SerializedName("txt_d")
        public String info;
    }
}
