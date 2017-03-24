package com.example.lee.broadcasettest2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver2 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Toast.makeText(context, "Received in MyReceiver2!", Toast.LENGTH_SHORT).show();
        //abortBroadcast();
    }
}
