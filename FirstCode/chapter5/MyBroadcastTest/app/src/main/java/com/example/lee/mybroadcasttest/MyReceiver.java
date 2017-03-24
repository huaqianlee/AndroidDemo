package com.example.lee.mybroadcasttest;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Received broadcast in MyReceiver!", Toast.LENGTH_SHORT).show();
        abortBroadcast();
    }
}
