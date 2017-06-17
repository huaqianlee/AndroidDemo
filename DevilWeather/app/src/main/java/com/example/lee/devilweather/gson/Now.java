package com.example.lee.devilweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lee on 16/06/17.
 */

public class Now {
    @SerializedName("tmp")
    public String temperature;

    @SerializedName("cond")
    public More more;

    public class More {
        @SerializedName("txt")
        public String info;
    }

}
