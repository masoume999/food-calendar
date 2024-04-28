package com.example.foodcalender.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodcalender.Activity.FoodActivity;
import com.example.foodcalender.Domain.Food;
import com.example.foodcalender.Domain.FoodDomain;
import com.example.foodcalender.R;

import java.util.ArrayList;

public class SuggestionLunchAdapter extends RecyclerView.Adapter<SuggestionLunchAdapter.ViewHolder> {
    ArrayList<Food> foodDomains;
    private Context mContext ;


    public SuggestionLunchAdapter(Context mContext,ArrayList<Food> FoodDomains) {
        this.foodDomains = FoodDomains;
        this.mContext = mContext;

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_suggestion_lunch, parent, false);

        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.title.setText(foodDomains.get(position).getTitle());
        //holder.time1.setText(String.valueOf(foodDomains.get(position).gettime1()));
        holder.time2.setText(String.valueOf(foodDomains.get(position).getBakingTime()));

        holder.img.setImageResource(foodDomains.get(position).getThumbnail());

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, FoodActivity.class);

                // passing data to the book activity
                intent.putExtra("Title",foodDomains.get(position).getTitle());
                intent.putExtra("BakingTime",foodDomains.get(position).getBakingTime());
                intent.putExtra("Material",foodDomains.get(position).getMaterial());
                intent.putExtra("Recipe",foodDomains.get(position).getRecipe());
                intent.putExtra("Thumbnail",foodDomains.get(position).getThumbnail());
                // start the activity
                mContext.startActivity(intent);

            }
        });
        //int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(foodDomains.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());

//        Glide.with(holder.itemView.getContext())
//                .load(drawableResourceId)
//                .into(holder.img);

//        holder.addBtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(holder.itemView.getContext(), ShowDetailActivity.class);
//                intent.putExtra("object", foodDomains.get(position));
//                holder.itemView.getContext().startActivity(intent);
//            }
//        });

    }


    @Override
    public int getItemCount() {
        return foodDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, time1,time2;
        ImageView img;
        TextView addBtn;
        LinearLayout linearLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_food_lunch);
            time1 = itemView.findViewById(R.id.time1_food_lunch);
            time2 = itemView.findViewById(R.id.time2_food_lunch);
            img = itemView.findViewById(R.id.imageBtn_food_lunch);
            linearLayout=itemView.findViewById(R.id.suggestionLunch);

            //addBtn = itemView.findViewById(R.id.addBtn);
        }
    }
}
