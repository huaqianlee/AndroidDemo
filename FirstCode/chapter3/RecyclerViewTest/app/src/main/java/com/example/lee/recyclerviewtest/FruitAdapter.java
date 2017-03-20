package com.example.lee.recyclerviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by lee on 17-3-20.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {

    private List<Fruit> mFruitlist;

    public FruitAdapter(List<Fruit> mFruitlist) {
        this.mFruitlist = mFruitlist;
    }

    static class  ViewHolder extends RecyclerView.ViewHolder {
        ImageView fruitImage;
        TextView fruitText;
        View fruitView;

        public ViewHolder(View itemView) {
            super(itemView);
            fruitView = itemView;
            fruitImage = (ImageView) itemView.findViewById(R.id.fruit_image);
            fruitText = (TextView) itemView.findViewById(R.id.fruit_name);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruititem,parent,false);
        final ViewHolder viewHolder = new ViewHolder(view);
        viewHolder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = mFruitlist.get(position);
                Toast.makeText(v.getContext(), "you clicked view " + fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        viewHolder.fruitText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = viewHolder.getAdapterPosition();
                Fruit fruit = mFruitlist.get(position);
                Toast.makeText(v.getContext(), "You clicked text " + fruit.getName(), Toast.LENGTH_SHORT).show();
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = mFruitlist.get(position);
        holder.fruitImage.setImageResource(fruit.getImageId());
        holder.fruitText.setText(fruit.getName());

    }

    @Override
    public int getItemCount() {
        return mFruitlist.size();
    }
}
