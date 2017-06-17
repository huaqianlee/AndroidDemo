package com.example.lee.devilweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lee on 17/06/17.
 */

public class Forecast {
    public String date;

    @SerializedName("tmp")
    public Temperature temperature;

    @SerializedName("cond")
    public More more;

    public class Temperature {
        public String max;
        public String min;
    }

    public class More {
        @SerializedName("txt")
        public String info;
    }
}
