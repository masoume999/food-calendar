package com.example.foodcalender.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.icu.text.UnicodeSetSpanner;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.foodcalender.Adapter.CategoryAdapter;
import com.example.foodcalender.Adapter.SuggestionDinnerAdapter;
import com.example.foodcalender.Adapter.SuggestionLunchAdapter;
import com.example.foodcalender.Domain.CategoryDomain;
import com.example.foodcalender.Domain.Food;
import com.example.foodcalender.Domain.FoodDomain;
import com.example.foodcalender.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter_catrgory, adapter_SuggestionLunch,adapter_SuggestionDinner;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setSelectedItemId(R.id.BottomBtnHome);
        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.BottomBtnHome:
                        return true;
                    case R.id.BottomBtnPlan:
                        startActivity(new Intent(getApplicationContext(),MenuManagementActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.BottomBtnProfile:
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });


        recyclerViewCategory();
        recyclerViewSuggestionLunch();
        recyclerViewSuggestionDinner();
    }


//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.BottomBtnHome:
//                    return true;
////                    Toast.makeText(MainActivity.this,"HOME",Toast.LENGTH_LONG).show();
//                case R.id.BottomBtnPlan:
//                    startActivity(new Intent(getApplicationContext(),CalendarActivity.class));
//                    overridePendingTransition(0,0);
//                    return true;
//                    //Toast.makeText(MainActivity.this,"PLAN",Toast.LENGTH_LONG).show();
//                    //Intent intent=new Intent(MainActivity.this,CalendarActivity.class);
//                case R.id.BottomBtnProfile:
//                    startActivity(new Intent(getApplicationContext(),CalendarActivity.class));
//                    overridePendingTransition(0,0);
//                    return true;
////                    Toast.makeText(MainActivity.this,"PROFILE",Toast.LENGTH_LONG).show();
////                    Intent intent2=new Intent(MainActivity.this,ProfileActivity.class);
////                    startActivity(intent2);
//            }
//            return false;
//        }
//    };

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView_category);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("ایرانی", "iranian_cat"));
        categoryList.add(new CategoryDomain("مدرن", "modern_cat"));
        categoryList.add(new CategoryDomain("پیتزا", "pizza_cat"));
        categoryList.add(new CategoryDomain("همبرگر", "burger_cat"));
        categoryList.add(new CategoryDomain("دسر", "dassert_cat"));

        adapter_catrgory = new CategoryAdapter(this,categoryList);
        recyclerViewCategoryList.setAdapter(adapter_catrgory);
    }

    private void recyclerViewSuggestionLunch() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView_SuggestionLunch);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<Food> foodlist = new ArrayList<>();
        foodlist.add(new Food("بادمجان شکم‌پر","۹۰ دقیقه","...","...", R.drawable.lunch1));
        foodlist.add(new Food("چیزبرگر","۴۰ دقیقه","..."," ...", R.drawable.burger));
        foodlist.add(new Food("قورمه‌سبزی","۳۲۰ دقیقه","...","...", R.drawable.lunch4));
        foodlist.add(new Food("پیتزا سبزیجات","۴۰ دقیقه","...","...", R.drawable.pizza2));


        adapter_SuggestionLunch = new SuggestionLunchAdapter(this,foodlist);
        recyclerViewPopularList.setAdapter(adapter_SuggestionLunch);

    }

    private void recyclerViewSuggestionDinner() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView_SuggestionDinner);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<Food> foodlist = new ArrayList<>();
        foodlist.add(new Food("پاستا آربیتا", "۴۰ دقیقه","...","...",R.drawable.pasta_arabita));
        foodlist.add(new Food("سالاد سزار", "۲۰ دقیقه", "..." ,"...",R.drawable.dinner2));
        foodlist.add(new Food("ته‌چین مرغ", "۹۰ دقیقه", "...","...",R.drawable.dinner3));
        foodlist.add(new Food("کتلت", "۶۰ دقیقه", "...","...",R.drawable.dinner4));

        adapter_SuggestionDinner = new SuggestionDinnerAdapter(this,foodlist);
        recyclerViewPopularList.setAdapter(adapter_SuggestionDinner);

    }
    public void show_all_category(View view)
    {
        Intent intent=new Intent(MainActivity.this,CategoriesActivity.class);
        startActivity(intent);
    }
}
