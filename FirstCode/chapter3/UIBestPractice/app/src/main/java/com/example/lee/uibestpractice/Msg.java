package com.example.lee.uibestpractice;

/**
 * Created by lee on 17-3-22.
 */

public class Msg {

    public static final int TYPE_RECEIVED = 0;
    public static final int TYPE_SENT = 1;
    private String content;
    private int  type;


    public Msg(String content, int type) {
        this.content = content;
        this.type = type;
    }


    public String getContent() {
        return content;
    }

    public int getType() {
        return type;
    }
}
