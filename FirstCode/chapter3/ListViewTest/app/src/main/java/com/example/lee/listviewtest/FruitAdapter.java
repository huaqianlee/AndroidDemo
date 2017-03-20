package com.example.lee.listviewtest;

import android.content.Context;
import android.provider.ContactsContract;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by lee on 17-3-20.
 */

public class FruitAdapter extends ArrayAdapter<Fruit> {

    private  int resourceId;

    public FruitAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Fruit> objects) {
        super(context, resource, objects);
        resourceId = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        Fruit fruit = getItem(position);  // 获取当前的Fruit实例
//        View view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false); //from构建LayoutInflater对象动态加载布局
        View view;
        ViewHolder viewHolder;   //通过内部类对控件实例缓存
        if (convertView == null) {
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.fruitImage = (ImageView) view.findViewById(R.id.fruit_image);
            viewHolder.fruitText = (TextView) view.findViewById(R.id.fruit_text);
            view.setTag(viewHolder);  //将vieholder存入view中
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.fruitImage.setImageResource(fruit.getImageId());
        viewHolder.fruitText.setText(fruit.getName());
/*        ImageView imageView = (ImageView) view.findViewById(R.id.fruit_image);
        TextView textView = (TextView) view.findViewById(R.id.fruit_text);

        imageView.setImageResource(fruit.getImageId());
        textView.setText(fruit.getName());*/

        return view;
    }

    class  ViewHolder {
        ImageView fruitImage;
        TextView  fruitText;
    }
}
