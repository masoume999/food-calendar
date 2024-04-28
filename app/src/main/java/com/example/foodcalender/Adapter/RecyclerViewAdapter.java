package com.example.foodcalender.Adapter;

import android.content.Context;
import android.content.Intent;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodcalender.Activity.FoodActivity;
import com.example.foodcalender.Domain.Food;
import com.example.foodcalender.R;

import java.util.List;


public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Food> mData ;


    public RecyclerViewAdapter(Context mContext, List<Food> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.cardveiw_item_food,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_title.setText(mData.get(position).getTitle());
//        holder.tv_bakingTime.setText(mData.get(position).getBakingTime());
//        holder.tv_material.setText(mData.get(position).getMaterial());
//        holder.tv_recipe.setText(mData.get(position).getRecipe());
        holder.img_thumbnail.setImageResource(mData.get(position).getThumbnail());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, FoodActivity.class);

                // passing data to the book activity
                intent.putExtra("Title",mData.get(position).getTitle());
                intent.putExtra("BakingTime",mData.get(position).getBakingTime());
                intent.putExtra("Material",mData.get(position).getMaterial());
                intent.putExtra("Recipe",mData.get(position).getRecipe());
                intent.putExtra("Thumbnail",mData.get(position).getThumbnail());
                // start the activity
                mContext.startActivity(intent);

            }
        });



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_title,tv_bakingTime,tv_material,tv_recipe;
        ImageView img_thumbnail;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_title = (TextView) itemView.findViewById(R.id.food_title_id);
            tv_bakingTime = (TextView) itemView.findViewById(R.id.txtTime1);
            tv_material = (TextView) itemView.findViewById(R.id.txtMaterial1);
            tv_recipe = (TextView) itemView.findViewById(R.id.txtRecipe1);
            img_thumbnail = (ImageView) itemView.findViewById(R.id.food_img_id);
            cardView = (CardView) itemView.findViewById(R.id.cardview_id);


        }
    }


}
