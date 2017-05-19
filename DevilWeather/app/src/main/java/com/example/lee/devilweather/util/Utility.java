package com.example.lee.devilweather.util;

import com.example.lee.devilweather.db.Province;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by lee on 17-5-19.
 */

public class Utility {
    public static boolean handleProvinceData (String jsonData) {
        Gson gson = new Gson();
        List<Province> provinces = gson.fromJson(jsonData, new TypeToken<Province>(){}.getType());
        for (Province province :
                provinces) {
            if (province == null) {
                return false;
            }
            province.save();
        }
        return true;
    }
}
