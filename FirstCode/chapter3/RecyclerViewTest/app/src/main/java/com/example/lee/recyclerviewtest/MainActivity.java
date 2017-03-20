package com.example.lee.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        //layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);  // 列表横向显示

        recyclerView.setLayoutManager(layoutManager);
        FruitAdapter adapter = new FruitAdapter(fruitList);
        recyclerView.setAdapter(adapter);

    }

    private void initFruits() {
        for (int i = 0; i<2; i++) {
            Fruit apple = new Fruit(R.drawable.apple_pic, getRandomLenName("Apple"));
            fruitList.add(apple);
            Fruit banana = new Fruit(R.drawable.banana_pic,getRandomLenName("Banana"));
            fruitList.add(banana);
            Fruit orange = new Fruit(R.drawable.orange_pic,getRandomLenName("Orange"));
            fruitList.add(orange);
            Fruit watermelon = new Fruit(R.drawable.watermelon_pic, getRandomLenName("Watermelon"));
            fruitList.add(watermelon);
            Fruit pear = new Fruit(R.drawable.pear_pic, getRandomLenName("Pear"));
            fruitList.add(pear);
            Fruit grape = new Fruit(R.drawable.grape_pic, getRandomLenName("Grape"));
            fruitList.add(grape);
            Fruit pineapple = new Fruit(R.drawable.pineapple_pic, getRandomLenName("Pineapple"));
            fruitList.add(pineapple);
            Fruit straberry = new Fruit(R.drawable.strawberry_pic, getRandomLenName("Straberry"));
            fruitList.add(straberry);
            Fruit cherry = new Fruit(R.drawable.cherry_pic, getRandomLenName("Cherry"));
            fruitList.add(cherry);
            Fruit mango = new Fruit(R.drawable.mango_pic, getRandomLenName("Mango"));
            fruitList.add(mango);
        }
    }

    private String getRandomLenName (String name){
        Random random = new Random();
        int len = random.nextInt(20)+1;
        StringBuilder builder = new StringBuilder();
        for (int i =0 ; i<len; i++){
            builder.append(name);
        }
        return  builder.toString();

    }
}
