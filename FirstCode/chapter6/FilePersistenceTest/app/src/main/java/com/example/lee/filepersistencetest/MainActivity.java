package com.example.lee.filepersistencetest;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.input_text);
        String inputText = load();
        Log.d(TAG, inputText);
        if (!TextUtils.isEmpty(inputText)) {
            editText.setText(inputText);
            editText.setSelection(inputText.length());
            Toast.makeText(this, "Restoring succeeded!", Toast.LENGTH_SHORT).show();
        }
    }

    private String load() {
        FileInputStream in = null;
        BufferedReader reader = null;
        StringBuilder string = new StringBuilder();
        try {
            in = openFileInput("data");
            String line = "";
            reader = new BufferedReader(new InputStreamReader(in));
            while ((line = reader.readLine()) != null ) {
                string.append(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string.toString();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String content = editText.getText().toString();
        Log.d(TAG, content);
        save(content);
    }

    private void save(String s) {
        FileOutputStream out = null;
        BufferedWriter writer = null;
        try {
            out = openFileOutput("data", Context.MODE_PRIVATE);
            writer = new BufferedWriter(new OutputStreamWriter(out));
            writer.write(s);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }


}
