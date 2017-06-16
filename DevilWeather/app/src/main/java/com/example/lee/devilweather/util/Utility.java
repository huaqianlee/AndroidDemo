package com.example.lee.devilweather.util;

import android.text.TextUtils;

import com.example.lee.devilweather.db.City;
import com.example.lee.devilweather.db.County;
import com.example.lee.devilweather.db.Province;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by lee on 17-5-19.
 */

public class Utility {
    /*Parse and handle province data*/
    public static boolean handleProvinceData (String jsonData) {
/*        if (!TextUtils.isEmpty(jsonData)) {
            Gson gson = new Gson();
            List<Province> provinces = gson.fromJson(jsonData, new TypeToken<Province>() {
            }.getType());
            for (Province province :
                    provinces) {
                if (province == null) {
                    return false;
                }
                province.save();
            }
            return true;
        }
        return false;*/

        if (!TextUtils.isEmpty(jsonData)) {
            try {
                JSONArray allProvices = new JSONArray(jsonData);
                for (int i = 0; i < allProvices.length(); i++) {
                    JSONObject provinceObject = allProvices.getJSONObject(i);
                    Province province = new Province();
                    province.setName(provinceObject.getString("name"));
                    province.setCode(provinceObject.getInt("id"));
                    province.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;

    }

    /*Parse and handle city data*/
    public static boolean handleCityData(String jsonData, int provinceId) {
        if (!TextUtils.isEmpty(jsonData)) {
            try {
                JSONArray allCities = new JSONArray(jsonData);
                for (int i = 0; i < allCities.length(); i++) {
                    JSONObject cityObject = allCities.getJSONObject(i);
                    City city = new City();
                    city.setName(cityObject.getString("name"));
                    city.setCode(cityObject.getInt("id"));
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

    /*Parse and handle county data*/
    public static boolean handleCountyData(String jsonData, int cityId) {
        if (!TextUtils.isEmpty(jsonData)) {
            try {
                JSONArray allCounties = new JSONArray(jsonData);
                for (int i = 0; i<allCounties.length(); i++) {
                    JSONObject coutyObject = allCounties.getJSONObject(i);
                    County county = new County();
                    county.setName(coutyObject.getString("name"));
                    county.setWeatherId(coutyObject.getString("weather_id"));
                    county.setCityId(cityId);
                    county.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}
