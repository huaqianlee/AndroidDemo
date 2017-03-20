package com.example.lee.listviewtest;

/**
 * Created by lee on 17-3-20.
 */

public class Fruit {
    private int imageId;
    private String name;

    public Fruit(int imageId, String name) {
        this.imageId = imageId;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }


    public String getName() {
        return name;
    }
}
