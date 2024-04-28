package com.example.foodcalender.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodcalender.Domain.Reminder;
import com.example.foodcalender.R;

import java.util.List;


public class Reminder_RecyclerViewAdapter extends RecyclerView.Adapter<Reminder_RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<Reminder> mData ;


    public Reminder_RecyclerViewAdapter(Context mContext, List<Reminder> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.reminder_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.reminder_name.setText(mData.get(position).getName());
        holder.reminder_time.setText(mData.get(position).getTime());
        holder.reminder_date.setText(mData.get(position).getDate());

        holder.reminder_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ConstraintLayout reminder_item;
        TextView reminder_name,reminder_time,reminder_date;

        public MyViewHolder(View itemView) {
            super(itemView);

            reminder_name = (TextView) itemView.findViewById(R.id.reminder_name);
            reminder_time = (TextView) itemView.findViewById(R.id.reminder_time);
            reminder_date = (TextView) itemView.findViewById(R.id.reminder_date);
            reminder_item = (ConstraintLayout) itemView.findViewById(R.id.reminder_item);
        }
    }


}


