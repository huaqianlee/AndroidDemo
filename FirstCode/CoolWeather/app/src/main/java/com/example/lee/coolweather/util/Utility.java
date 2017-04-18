package com.example.lee.coolweather.util;

import android.text.TextUtils;

import com.example.lee.coolweather.db.City;
import com.example.lee.coolweather.db.Country;
import com.example.lee.coolweather.db.Province;

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
    public static boolean handleCountryResponce(String responce, int cityId){
        if (!TextUtils.isEmpty(responce)){
            try {
                JSONArray allCountries = new JSONArray(responce);
                for (int i=0; i<allCountries.length();i++){
                    JSONObject countryObject = allCountries.getJSONObject(i);
                    Country country = new Country();
                    country.setCountryName(countryObject.getString("name"));
                    country.setWeatherId(countryObject.getString("weather_id"));
                    country.setCityId(cityId);
                    country.save();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
