package com.example.lee.networktest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView reponseText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button sendRequest = (Button) findViewById(R.id.send_request);
        reponseText = (TextView) findViewById(R.id.response_text);
        sendRequest.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_request:
                Log.d("MainActivity", "Get the click!");
                //sendRequestByHttpUrlConnection();
                sendRequestByOkHttp();
                break;
            default:
        }
    }

    private void sendRequestByOkHttp() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    OkHttpClient client = new OkHttpClient();
                    Request request = new Request.Builder().url("http://www.baidu.com").build();
                    Response response = client.newCall(request).execute();
                    String text = response.body().string();
                    showResponse(text);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private void sendRequestByHttpUrlConnection() {
        Log.d("MainActivity.Thread", "In thread soon!");
        new Thread(new Runnable() {
            @Override
            public void run() {
                Log.d("MainActivity.Thread", "In thread!" );
                HttpURLConnection connection = null;
                BufferedReader reader = null;
                try {
                    URL url = new URL("http://www.biying.com");
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();
                    reader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        response.append(line);
                        Log.d("MainActivity.Thread","the content is "+line+"\n");
                    }
                    Log.d("MainActivity.Thread", "The len = " + response.length());
                    showResponse(response.toString());
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    if (reader != null) {
                        try {
                            reader.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    if (connection!=null) {
                        connection.disconnect();
                    }
                }
            }
        }).start();
    }

    private void showResponse(final String s) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                reponseText.setText(s);
            }
        });
    }
}
