package com.example.lee.androidthreadtest;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private TextView textView;
    public static final int UPDATE_TEXT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button updateText = (Button) findViewById(R.id.update);
        textView = (TextView) findViewById(R.id.text);
        updateText.setOnClickListener(this);
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case UPDATE_TEXT:
                    textView.setText(("Nice to meet you!"));
                    break;
                default:
                    break;
            }
        }
    };

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.update:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        //textView.setText("Nice to meet you!");
                        updateText("Nice to meet you!");
      /*                  Message message = new Message();
                        message.what = UPDATE_TEXT;
                        handler.sendMessage(message);*/
                    }
                }).start();
        }
    }

    private void updateText(final String s) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textView.setText(s);
            }
        });
    }


}
