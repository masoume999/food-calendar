package com.example.foodcalender.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.example.foodcalender.Adapter.MenuAdapter;
import com.example.foodcalender.Domain.Utils_Menu;
import com.example.foodcalender.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MenuManagementActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview_demo)
    RecyclerView recyclerviewDemo;
    private int menu_id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_management);
        ButterKnife.bind(this);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setSelectedItemId(R.id.BottomBtnPlan);
        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.BottomBtnHome:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                    case R.id.BottomBtnPlan:
                        return true;
                    case R.id.BottomBtnProfile:
                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });
        loadMenuInformation();
    }

    private void loadMenuInformation() {
        MenuAdapter menuAdapter = new MenuAdapter(getApplicationContext(), Utils_Menu.loadMenuData());
        recyclerviewDemo.setLayoutManager(new LinearLayoutManager(this));
        recyclerviewDemo.setAdapter(menuAdapter);
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
                Intent intent = new Intent(MenuManagementActivity.this,CalendarActivity.class);
                startActivity(intent);
                finish();
                break;
            }
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }


    public void addIcon(View view) {

        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("اضافه کردن منوی جدید");
        alert.setMessage("لطفا نام منو را وارد نمائید.");

        // Set an EditText view to get user input
        final EditText input = new EditText(this);
        alert.setView(input);

        alert.setPositiveButton("تائید", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                String MenuName = String.valueOf(input.getText());

                if(MenuName.equalsIgnoreCase(""))
                {
                    Toast.makeText(MenuManagementActivity.this,"لطفا نام را وارد نمائید!!",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(MenuManagementActivity.this,MenuName,Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MenuManagementActivity.this,CalendarActivity.class);
                    startActivity(intent);
                }
            }
        });

        alert.setNegativeButton("انصراف", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
            }
        });

        alert.show();
    }

}
