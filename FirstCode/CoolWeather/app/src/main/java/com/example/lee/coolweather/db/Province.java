package com.example.lee.coolweather.db;

import org.litepal.crud.DataSupport;

/**
 * Created by lee on 17-4-18.
 */

public class Province extends DataSupport{
    private int id;   // 每个实体类都应该有的字段
    private String provinceName;
    private int provinceCode;


    public String getProvinceName() {
        return provinceName;
    }

    public void setProvinceName(String provinceName) {
        this.provinceName = provinceName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(int provinceCode) {
        this.provinceCode = provinceCode;
    }
}
