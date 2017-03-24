package me.huaqianlee.broadcastbestpractice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Lee on 2017/3/24.
 */

public class BaseActivity extends AppCompatActivity {

    private ForceOfflineReceiver forceOfflineReceiver;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCollector.addActivity(this);
    }

    /**
     * Dispatch onPause() to fragments.
     */
    @Override
    protected void onPause() {
        super.onPause();
        if (forceOfflineReceiver != null) {
            unregisterReceiver(forceOfflineReceiver);
        }
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        IntentFilter intentFilter = new IntentFilter("me.huaqianlee.broadcast.FORCE_OFFLINE");
        forceOfflineReceiver = new ForceOfflineReceiver();
        registerReceiver(forceOfflineReceiver,intentFilter);
    }

    private class ForceOfflineReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(final Context context, Intent intent) {

            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("warning");
            builder.setMessage("You are forced to offline. Please try to login again");
            builder.setCancelable(false);
            builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    ActivityCollector.finishAll();
                    Intent intent = new Intent(context, LoginActivity.class);
                    startActivity(intent);
                }
            });
            builder.show();

        }

    }
}
