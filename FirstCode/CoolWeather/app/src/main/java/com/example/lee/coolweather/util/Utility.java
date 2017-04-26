package com.example.lee.coolweather.util;

import android.text.TextUtils;

import com.example.lee.coolweather.db.City;
import com.example.lee.coolweather.db.County;
import com.example.lee.coolweather.db.Province;
import com.example.lee.coolweather.gson.Weather;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lee on 17-4-18.
 */

public class Utility {

    /*解析处理服务器返回的省JSON数据*/
    public static boolean handleProvinceResponce(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allProvinces = new JSONArray(response);
                for (int i=0; i<allProvinces.length(); i++) {
                    JSONObject provinceObject = allProvinces.getJSONObject(i);
                    Province province = new Province();
                    province.setProvinceName(provinceObject.getString("name"));
                    province.setProvinceCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /*解析市级数据*/
    public static boolean handleCityResponce(String responce,int provinceId) {
        if (!TextUtils.isEmpty(responce)) {
            try {
                JSONArray allCities = new JSONArray(responce);
                for (int i=0;i<allCities.length();i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setCityName(cityObject.getString("name"));
                    city.setCityCOde(cityObject.getInt("id"));
                    city.setProvinceId(provinceId);
                    city.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    /*解析县级书籍*/
    public static boolean handlecountyResponce(String responce, int cityId){
        if (!TextUtils.isEmpty(responce)){
            try {
                JSONArray allCountries = new JSONArray(responce);
                for (int i=0; i<allCountries.length();i++){
                    JSONObject countyObject = allCountries.getJSONObject(i);
                    County county = new County();
                    county.setcountyName(countyObject.getString("name"));
                    county.setWeatherId(countyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }


    /*解析天气数据*/
    public static Weather handleWeatherResponce(String responce) {
        try {
            JSONObject jsonObject = new JSONObject(responce);
            JSONArray jsonArray = jsonObject.getJSONArray("HeWeather");
            String weatherContent = jsonArray.getJSONObject(0).toString();
            return new Gson().fromJson(weatherContent,Weather.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  null;
    }
}
