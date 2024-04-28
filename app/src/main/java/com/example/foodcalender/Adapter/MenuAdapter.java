package com.example.foodcalender.Adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodcalender.Activity.CalendarActivity;
import com.example.foodcalender.Domain.Menu;
import com.example.foodcalender.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.MenuVH> {
    Context mcontext;
    List<Menu> list;
    public int mSelectedItem = -1;

    public MenuAdapter(Context context, List<Menu> list) {
        this.mcontext = context;
        this.list = list;
    }


    @Override
    public MenuAdapter.MenuVH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mcontext).inflate(R.layout.layout_data, parent, false);

        //return vHolder;
        return new MenuAdapter.MenuVH(view);
    }

    @Override
    public void onBindViewHolder(MenuAdapter.MenuVH holder, int position) {
        holder.rviewRadiobutton.setChecked(position == mSelectedItem);
        holder.loadData(position);


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MenuVH extends RecyclerView.ViewHolder{
        @BindView(R.id.textView_rvname)
        TextView textViewRvname;
        //        @BindView(R.id.textView_rvloc)
//        TextView textViewRvloc;
        @BindView(R.id.rview_radiobutton)
        RadioButton rviewRadiobutton;

        @BindView(R.id.Edit_icon)
        ImageButton EditButton;

        @BindView(R.id.Show_icon)
        ImageButton ShowButton;

        @BindView(R.id.Delete_icon)
        ImageButton DeleteButton;


        public MenuVH(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);


        }

        void loadData(final int position) {
            textViewRvname.setText(list.get(position).getName());
            //textViewRvloc.setText(list.get(position).getLocation());
            View.OnClickListener listener = new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mSelectedItem = getAdapterPosition();
                    notifyDataSetChanged();
                    Toast.makeText(mcontext, "" + list.get(position).getName(), Toast.LENGTH_SHORT).show();


                }
            };
            rviewRadiobutton.setOnClickListener(listener);
            itemView.setOnClickListener(listener);
            EditButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println("***********EDIT**********");
                    Intent intent = new Intent(mcontext, CalendarActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mcontext.startActivity(intent);
                }
            });
            ShowButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.out.println("***********SHOW**********");
                    Intent intent = new Intent(mcontext, CalendarActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mcontext.startActivity(intent);
                }
            });
            DeleteButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    new AlertDialog.Builder(v.getContext())
                            .setTitle("حذف کردن")
                            .setIcon(R.mipmap.alert_icon)
                            .setMessage("آیا می‌خواهید منو را حذف کنید؟")
                            .setPositiveButton("بله", new DialogInterface.OnClickListener()
                            {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    //delete
                                }

                            })
                            .setNegativeButton("خیر", null)
                            .show();
                }
            });
        }


    }
}
