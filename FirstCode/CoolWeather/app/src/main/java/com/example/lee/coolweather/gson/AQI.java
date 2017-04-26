package com.example.lee.coolweather.gson;

/**
 * Created by lee on 17-4-26.
 */

public class AQI {
    public AQICity city;

    public class AQICity {
        public String aqi;
        public String pm25;
    }
}
