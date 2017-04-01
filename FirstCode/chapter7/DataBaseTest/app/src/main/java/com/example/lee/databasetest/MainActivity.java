package com.example.lee.databasetest;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final MyDataBaseHelper helper0 = new MyDataBaseHelper(this, "book.db", null, 1);
        Button createButton = (Button) findViewById(R.id.create_book);
        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper0.getWritableDatabase();
            }
        });
        Button createAgain = (Button) findViewById(R.id.create_again);
        final MyDataBaseHelper helper = new MyDataBaseHelper(this,"book.db",null,2);
        createAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                helper.getWritableDatabase();
            }
        });
        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = helper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("name", "The first code");
                values.put("author", "guo lin");
                values.put("pages", 500);
                values.put("price", 90);
                db.insert("Book", null, values);
                values.clear();
                values.put("name", "Just for fun");
                values.put("author", "Linus");
                values.put("pages", 500);
                values.put("price", 90);
                db.insert("Book", null, values);
                values.clear();
            }
        });
        Button updateData = (Button) findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = helper.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("price",1000);
                db.update("Book", values,"name=?",new String[]{"Just for fun"});
            }
        });
        Button delData = (Button) findViewById(R.id.del_data);
        delData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = helper.getWritableDatabase();
                db.delete("Book","price < ?", new String[]{"100"});
            }
        });
        Button queryData = (Button) findViewById(R.id.query_data);
        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteDatabase db = helper.getWritableDatabase();
                Cursor cursor = db.query("Book",null,null,null,null,null,null);
                if (cursor.moveToFirst()) {
                    do{
                        String name = cursor.getString(cursor.getColumnIndex("name"));
                        String author = cursor.getString(cursor.getColumnIndex("author"));
                        int pages = cursor.getInt(cursor.getColumnIndex("pages"));
                        double price = cursor.getDouble(cursor.getColumnIndex("price"));
                        Log.d("MainActivity", "This book name is  "+name);
                        Log.d("MainActivity", "This book author is  "+author);
                        Log.d("MainActivity", "This book pages is  "+pages);
                        Log.d("MainActivity", "This book price is  "+price);

                    } while (cursor.moveToNext());
                }
            }
        });
    }
}
