package com.example.foodcalender.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodcalender.Adapter.SuggestionLunchAdapter;
import com.example.foodcalender.Domain.Food;
import com.example.foodcalender.Domain.FoodDomain;
import com.example.foodcalender.R;

import java.util.ArrayList;

import static com.example.foodcalender.Activity.CategoryActivity.categoryName;

public class FoodActivity extends AppCompatActivity {

    private TextView tvtitle,tvtime,tvmaterial,tvrecipe;
    private ImageView img;
    private Button insertbtn;
    private RecyclerView.Adapter adapter_SimilarFoods;

    private RecyclerView recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        tvtitle = (TextView) findViewById(R.id.txttitle);
        tvtime = (TextView) findViewById(R.id.txtTime1);
        tvmaterial = (TextView) findViewById(R.id.txtMaterial1);
        tvrecipe = (TextView) findViewById(R.id.txtRecipe1);
        img = (ImageView) findViewById(R.id.foodthumbnail);


        // Recieve data
        Intent intent = getIntent();
        String Title = intent.getExtras().getString("Title");
        String BakingTime = intent.getExtras().getString("BakingTime");
        String Material = intent.getExtras().getString("Material");
        String Recipe = intent.getExtras().getString("Recipe");
        int image = intent.getExtras().getInt("Thumbnail") ;

        // Setting values
        tvtitle.setText(Title);
        tvtime.setText("زمان تهیه: "+BakingTime);
        tvmaterial.setText(Material);
        tvrecipe.setText(Recipe);
        img.setImageResource(image);

        recyclerViewSimilarFoods();


    }

    private void recyclerViewSimilarFoods() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView_similarFoods);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<Food> foodlist = new ArrayList<>();
        foodlist.add(new Food("پیتزا پپرونی", "۴۰ دقیقه","...","...",R.drawable.pizza1));
        foodlist.add(new Food("سالاد سزار", "۲۰ دقیقه", "..." ,"...",R.drawable.dinner2));
        foodlist.add(new Food("ته‌چین مرغ", "۹۰ دقیقه", "...","...",R.drawable.dinner3));
        foodlist.add(new Food("کتلت", "۶۰ دقیقه", "...","...",R.drawable.dinner4));

        adapter_SimilarFoods = new SuggestionLunchAdapter(this,foodlist);
        recyclerViewPopularList.setAdapter(adapter_SimilarFoods);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.back_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.back :{
                Intent intent = new Intent(FoodActivity.this, CategoryActivity.class);
                intent.putExtra("category", categoryName);
                startActivity(intent);
                startActivity(intent);
                break;
            }
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void insert(View view) {
    }
}
