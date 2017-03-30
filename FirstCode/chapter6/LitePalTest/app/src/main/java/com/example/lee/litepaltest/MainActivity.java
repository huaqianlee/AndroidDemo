package com.example.lee.litepaltest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.crud.DataSupport;
import org.litepal.tablemanager.Connector;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button createDataBase = (Button) findViewById(R.id.create_book);
        createDataBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Connector.getDatabase();
            }
        });

        Button addData = (Button) findViewById(R.id.add_data);
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("Just for fun");
                book.setAuthor("Linus");
                book.setPages(500);
                book.setPrice(70);
                book.setPress("Linus");
                book.save();
            }
        });

        Button modifyData = (Button) findViewById(R.id.modify_data);
        modifyData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setName("Just for fun2");
                book.setAuthor("Linus2");
                book.setPages(500);
                book.setPrice(70);
                book.setPress("Linus2");
                book.save();
                book.setPrice(1000);
                book.save();
            }
        });

        Button updateData = (Button) findViewById(R.id.update_data);
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Book book = new Book();
                book.setPrice(10);
                book.setPress("Lee");
                book.updateAll("name = ? and author = ?", "Just for fun", "Linus");
            }
        });

        Button delDate = (Button) findViewById(R.id.del_data);
        delDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DataSupport.deleteAll(Book.class,"price < ?", "15");
            }
        });

        Button queryData = (Button) findViewById(R.id.query_data);
        queryData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Book> books = DataSupport.findAll(Book.class);
                for (Book book : books) {
                    Log.d("############","The Name is " + book.getName() );
                    Log.d("############", "The author is " + book.getAuthor());
                    Log.d("############", "The price is " + book.getPrice());
                    Log.d("############", "The pages is " + book.getPages());
                    Log.d("############", "The press is " + book.getPress());
                }
            }
        });

    }
}
