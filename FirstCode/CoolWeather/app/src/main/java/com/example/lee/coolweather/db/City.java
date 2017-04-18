package com.example.lee.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by lee on 17-4-18.
 */

public class City extends DataSupport {
    private int id;
    private String cityName;
    private int cityCOde;
    private int provinceId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public int getCityCOde() {
        return cityCOde;
    }

    public void setCityCOde(int cityCOde) {
        this.cityCOde = cityCOde;
    }

    public int getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(int provinceId) {
        this.provinceId = provinceId;
    }
}
