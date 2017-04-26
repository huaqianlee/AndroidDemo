package com.example.lee.coolweather.gson;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lee on 17-4-26.
 */

public class Suggestion {
    @SerializedName("conf")
    public Comfrot comfrot;

    @SerializedName("cw")
    public CarWash carWash;

    public Sport sport;


    private class Comfrot {
        @SerializedName("txt")
        public String info;
    }

    private class CarWash {
        @SerializedName("txt")
        public String info;
    }

    private class Sport {
        @SerializedName("txt")
        public String info;
    }
}
