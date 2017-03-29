package com.example.lee.savepassworddemo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText usrName;
    private EditText password;
    private CheckBox rememberCheck;
    private Button login;
    private SharedPreferences prf;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        usrName = (EditText) findViewById(R.id.usr_name);
        password = (EditText) findViewById(R.id.password);
        rememberCheck = (CheckBox) findViewById(R.id.remember_pass);
        login = (Button) findViewById(R.id.login);

        prf = PreferenceManager.getDefaultSharedPreferences(this);
        boolean isRemember = prf.getBoolean("remember_pass", false);
        if (isRemember) {
            rememberCheck.setChecked(true);
            usrName.setText(prf.getString("usr_name",""));
            password.setText(prf.getString("password",""));
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = usrName.getText().toString();
                String pass = password.getText().toString();
                if (account.equals("andy") && pass.equals("123456")) {
                    editor = prf.edit();
                    if (rememberCheck.isChecked()) {
                        editor.putBoolean("remember_pass", true);
                        editor.putString("usr_name", account);
                        editor.putString("password", pass);
                    } else {
                        editor.clear();
                    }
                    editor.apply();
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "The usrname or password is invaild!", Toast.LENGTH_SHORT).show();
                }


            }
        });



    }
}
