package com.example.lee.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

//    private String [] data ={"Apple", "Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry",
//              "Mango","Apple", "Banana","Orange","Watermelon","Pear","Grape","Pineapple","Strawberry","Cherry","Mango"};

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

/*        ArrayAdapter<String>  adapter =  new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1,data);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);*/

        initFruits();
        FruitAdapter adapter = new FruitAdapter(MainActivity.this, R.layout.fruit_item, fruitList);
        ListView listView = (ListView) findViewById(R.id.list_view);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, fruitList.get(position).getName(),Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void initFruits() {
        for (int i = 0; i<2; i++) {
            Fruit apple = new Fruit(R.drawable.apple_pic, "Apple");
            fruitList.add(apple);
            Fruit banana = new Fruit(R.drawable.banana_pic,"Banana");
            fruitList.add(banana);
            Fruit orange = new Fruit(R.drawable.orange_pic,"Orange");
            fruitList.add(orange);
            Fruit watermelon = new Fruit(R.drawable.watermelon_pic, "Watermelon");
            fruitList.add(watermelon);
            Fruit pear = new Fruit(R.drawable.pear_pic, "Pear");
            fruitList.add(pear);
            Fruit grape = new Fruit(R.drawable.grape_pic, "Grape");
            fruitList.add(grape);
            Fruit pineapple = new Fruit(R.drawable.pineapple_pic, "Pineapple");
            fruitList.add(pineapple);
            Fruit straberry = new Fruit(R.drawable.strawberry_pic, "Straberry");
            fruitList.add(straberry);
            Fruit cherry = new Fruit(R.drawable.cherry_pic, "Cherry");
            fruitList.add(cherry);
            Fruit mango = new Fruit(R.drawable.mango_pic, "Mango");
            fruitList.add(mango);
        }
    }
}
