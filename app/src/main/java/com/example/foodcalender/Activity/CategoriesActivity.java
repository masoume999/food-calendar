package com.example.foodcalender.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.example.foodcalender.R;

public class CategoriesActivity extends AppCompatActivity implements View.OnClickListener{

    private CardView iranianFood;
    private CardView modernFood;
    private CardView breakfast;
    private CardView dietaryFood;
    private CardView seaFood;
    private CardView vegetableFood;
    private CardView mahalliFood;
    private CardView melalFood;
    private CardView appetizer;
    private CardView dessert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        initObjects();
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
                Intent intent = new Intent(CategoriesActivity.this, MainActivity.class);
                startActivity(intent);
                break;
            }
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initObjects(){

        iranianFood=findViewById(R.id.iranianFood);
        modernFood=findViewById(R.id.modernFood);
        breakfast=findViewById(R.id.breakfast);
        dietaryFood=findViewById(R.id.dietaryFood);
        seaFood=findViewById(R.id.seaFood);
        vegetableFood=findViewById(R.id.vegetableFood);
        mahalliFood=findViewById(R.id.mahalliFood);
        melalFood=findViewById(R.id.melalFood);
        appetizer=findViewById(R.id.appetizer);
        dessert=findViewById(R.id.dessert);

        iranianFood.setOnClickListener(this);
        modernFood.setOnClickListener(this);
        breakfast.setOnClickListener(this);
        dietaryFood.setOnClickListener(this);
        seaFood.setOnClickListener(this);
        vegetableFood.setOnClickListener(this);
        mahalliFood.setOnClickListener(this);
        melalFood.setOnClickListener(this);
        appetizer.setOnClickListener(this);
        dessert.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.iranianFood:
                Intent intent = new Intent(CategoriesActivity.this, CategoryActivity.class);
                intent.putExtra("category", "iranianFood");
                startActivity(intent);
                break;
            case R.id.modernFood:
                intent = new Intent(CategoriesActivity.this, CategoryActivity.class);
                intent.putExtra("category", "modernFood");
                startActivity(intent);
                break;
            case R.id.breakfast:
                intent = new Intent(CategoriesActivity.this, CategoryActivity.class);
                intent.putExtra("category", "breakfast");
                startActivity(intent);
                break;
            case R.id.dietaryFood:
                intent = new Intent(CategoriesActivity.this, CategoryActivity.class);
                intent.putExtra("category", "dietaryFood");
                startActivity(intent);
                break;
            case R.id.seaFood:
                intent = new Intent(CategoriesActivity.this, CategoryActivity.class);
                intent.putExtra("category", "seaFood");
                startActivity(intent);
                break;
            case R.id.vegetableFood:
                intent = new Intent(CategoriesActivity.this, CategoryActivity.class);
                intent.putExtra("category", "vegetableFood");
                startActivity(intent);
                break;
            case R.id.mahalliFood:
                intent = new Intent(CategoriesActivity.this, CategoryActivity.class);
                intent.putExtra("category", "mahalliFood");
                startActivity(intent);
                break;
            case R.id.melalFood:
                intent = new Intent(CategoriesActivity.this, CategoryActivity.class);
                intent.putExtra("category", "melalFood");
                startActivity(intent);
                break;
            case R.id.appetizer:
                intent = new Intent(CategoriesActivity.this, CategoryActivity.class);
                intent.putExtra("category", "appetizer");
                startActivity(intent);
                break;
            case R.id.dessert:
                intent = new Intent(CategoriesActivity.this, CategoryActivity.class);
                intent.putExtra("category", "dessert");
                startActivity(intent);
                break;
        }
    }
}
