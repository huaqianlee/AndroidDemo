package com.example.lee.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lee on 17-4-26.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More {
        @SerializedName("txt")
        public String  info;
    }
}
