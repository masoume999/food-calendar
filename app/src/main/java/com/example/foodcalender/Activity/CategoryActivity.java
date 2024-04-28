package com.example.foodcalender.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.foodcalender.Adapter.RecyclerViewAdapter;
import com.example.foodcalender.Domain.Food;
import com.example.foodcalender.R;

import java.util.ArrayList;
import java.util.List;

public class CategoryActivity extends AppCompatActivity {

    List<Food> lstFood;
    public static String categoryName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        categoryName = getIntent().getStringExtra("category");

        ActionBar actionBar = getSupportActionBar();

        switch (categoryName) {
            case "iranianFood":
                actionBar.setTitle(R.string.iranianFood);
                break;
            case "modernFood":
                actionBar.setTitle(R.string.modernFood);
                break;
            case "breakfast":
                actionBar.setTitle(R.string.breakfast);
                break;
            case "dietaryFood":
                actionBar.setTitle(R.string.dietaryFood);
                break;
            case "seaFood":
                actionBar.setTitle(R.string.seaFood);
                break;
            case "vegetableFood":
                actionBar.setTitle(R.string.vegetableFood);
                break;
            case "mahalliFood":
                actionBar.setTitle(R.string.mahalliFood);
                break;
            case "melalFood":
                actionBar.setTitle(R.string.melalFood);
                break;
            case "appetizer":
                actionBar.setTitle(R.string.appetizer);
                break;
            case "dessert":
                actionBar.setTitle(R.string.dessert);
                break;
        }


        lstFood = new ArrayList<>();
        lstFood.add(new Food("پیتزا سبزیجات","30 دقیقه","...","...",R.drawable.sabz_pitza));
        lstFood.add(new Food("لازانیا","100 دقیقه","...","...",R.drawable.lagsana));
        lstFood.add(new Food("پیتزا پیده","45 دقیقه","...","...",R.drawable.pide));
        lstFood.add(new Food("پاستای آرابیتا","60 دقیقه","...","...",R.drawable.pasta_arabita));
        lstFood.add(new Food("سالاد سزار","30 دقیقه","...","...",R.drawable.sezar_salad));
        lstFood.add(new Food("پیتزای مارگاریتا","30 دقیقه","...","...",R.drawable.margarita));
        lstFood.add(new Food("نان سیر","30 دقیقه","...","...",R.drawable.nan_sir));
        lstFood.add(new Food("بیف استراگانف","40 دقیقه","...","...",R.drawable.beef_stroganoff_recipe_main));



        RecyclerView myrv = (RecyclerView) findViewById(R.id.recyclerview_id);
        RecyclerViewAdapter myAdapter = new RecyclerViewAdapter(this,lstFood);
        myrv.setLayoutManager(new GridLayoutManager(this,2));
        myrv.setAdapter(myAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.back_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.back :{
                Intent intent = new Intent(CategoryActivity.this, CategoriesActivity.class);
                startActivity(intent);
                break;
            }
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
