package com.example.foodcalender.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.foodcalender.Domain.Food;
import com.example.foodcalender.Domain.FoodDomain;
import com.example.foodcalender.R;

import java.util.ArrayList;

public class SimilarFoodsAdapter extends RecyclerView.Adapter<SimilarFoodsAdapter.ViewHolder> {
    ArrayList<Food> foodDomains;

    public SimilarFoodsAdapter(ArrayList<Food> FoodDomains) {
        this.foodDomains = FoodDomains;
    }

    @NonNull
    @Override
    public SimilarFoodsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_similar_foods, parent, false);

        return new SimilarFoodsAdapter.ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull final SimilarFoodsAdapter.ViewHolder holder, final int position) {
        holder.title.setText(foodDomains.get(position).getTitle());
        //holder.time1.setText(String.valueOf(foodDomains.get(position).gettime1()));
        holder.time2.setText(String.valueOf(foodDomains.get(position).getBakingTime()));

        holder.img.setImageResource(foodDomains.get(position).getThumbnail());

//        int drawableResourceId = holder.itemView.getContext().getResources().getIdentifier(foodDomains.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());
//
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


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_food_dinner);
            time1 = itemView.findViewById(R.id.time1_food_dinner);
            time2 = itemView.findViewById(R.id.time2_food_dinner);
            img = itemView.findViewById(R.id.imageBtn_food_dinner);
            //addBtn = itemView.findViewById(R.id.addBtn);
        }
    }
}

