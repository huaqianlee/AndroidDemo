package com.example.lee.networktest;

/**
 * Created by lee on 17-5-12.
 */

interface HttpCallbackListener {
    void onFinish(String s);

    void onError(Exception e);
}
