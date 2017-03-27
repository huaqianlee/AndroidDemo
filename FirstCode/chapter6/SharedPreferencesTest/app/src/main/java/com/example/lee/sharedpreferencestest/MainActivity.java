package com.example.lee.sharedpreferencestest;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button saveData = (Button) findViewById(R.id.save);
        Button restoreData = (Button) findViewById(R.id.restore);

        saveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = getSharedPreferences("data", MODE_PRIVATE).edit();
                editor.putString("name", "Li Hua");
                editor.putBoolean("married", true);
                editor.putInt("age",29);
                editor.apply();
            }
        });

        restoreData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences spf = getSharedPreferences("data", MODE_PRIVATE);
                String name = spf.getString("name","");
                Boolean isMarried = spf.getBoolean("married",false);
                int age = spf.getInt("age", 18);
                Log.d(TAG, "The name is " + name);
                Log.d(TAG, "Married is "+ isMarried);
                Log.d(TAG, "The age is " + age);
            }
        });
    }
}
