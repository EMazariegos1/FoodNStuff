package com.example.foodnstuff;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FoodListAdaptor extends RecyclerView.Adapter<FoodListAdaptor.ViewHolder> {
    List<String> names;
    List<Integer> images;
    List<Food> foods;
    Context context;
    LayoutInflater inflater;

    public FoodListAdaptor(Context c, List<String> name, List<Integer> image){
        context = c;
        names = name;
        images = image;
        this.inflater = LayoutInflater.from(c);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.food_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.foodImage.setImageResource(images.get(position));
        holder.foodName.setText(names.get(position));
    }


    @Override
    public int getItemCount() {
        return names.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageButton foodImage;
        TextView foodName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            foodImage = itemView.findViewById(R.id.food_image);
            foodName = itemView.findViewById(R.id.food_name);
        }
    }
}
