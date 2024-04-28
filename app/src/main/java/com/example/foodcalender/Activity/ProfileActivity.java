package com.example.foodcalender.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodcalender.Adapter.Reminder_RecyclerViewAdapter;
import com.example.foodcalender.Domain.Reminder;
import com.example.foodcalender.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mohamadamin.persianmaterialdatetimepicker.time.RadialPickerLayout;
import com.mohamadamin.persianmaterialdatetimepicker.time.TimePickerDialog;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProfileActivity extends AppCompatActivity {

    List<Reminder> lstReminder;
    NameActivity nameActivity;
    phoneNumber_Activity phoneNumber_activity;

    Switch Lunch_Switch,Dinner_Switch;
    //private EditText lunch_editTextHour, lunch_editTextMin,dinner_editTextHour, dinner_editTextMin;
    private TextView txtTime_L,txtTime_D;
    private ImageView buttonTime_L, buttonTime_D;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        txtTime_L = findViewById(R.id.txtTime_Lunch);
        buttonTime_L = findViewById(R.id.btnTime_L);

        txtTime_D = findViewById(R.id.txtTime_Dinner);
        buttonTime_D = findViewById(R.id.btnTime_D);

//        lunch_editTextHour = findViewById(R.id.lunch_edtH);
//        lunch_editTextMin = findViewById(R.id.lunch_edtM);
//
//        dinner_editTextHour = findViewById(R.id.dinner_edtH);
//        dinner_editTextMin = findViewById(R.id.dinner_edtM);

        buttonTime_L.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showtime_L();

//                String sHour = lunch_editTextHour.getText().toString().trim();
//                String sMin = lunch_editTextMin.getText().toString().trim();
//
//                if(sHour.isEmpty() || sMin.isEmpty()){
//                    showtime_L();
//                }
//                else {
//                    showtime_L(sHour,sMin);
//                }
            }
        });

        buttonTime_D.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showtime_D();

//                String sHour = dinner_editTextHour.getText().toString().trim();
//                String sMin = dinner_editTextMin.getText().toString().trim();
//
//                if(sHour.isEmpty() || sMin.isEmpty()){
//                    showtime_D();
//                }
//                else {
//                    showtime_D(sHour,sMin);
//                }
            }
        });

        // initiate a Switch
        Lunch_Switch = (Switch) findViewById(R.id.lunch_switchbtn);
        // check current state of a Switch (true or false).
        Boolean Lunch_switchState = Lunch_Switch.isChecked();


        // initiate a Switch
        Dinner_Switch = (Switch) findViewById(R.id.dinner_switchbtn);
        // check current state of a Switch (true or false).
        Boolean Dinner_switchState = Dinner_Switch.isChecked();


        String name="name";
        //name=nameActivity.User_name;
        TextView Name=findViewById(R.id.nameTxt);
        Name.setText(name);

        String phone_num="09128765432";
        //phone_num=phoneNumber_activity.phone_Number;
        TextView Phone=findViewById(R.id.phoneNumberTxt);
        Phone.setText(phone_num);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        navigation.setSelectedItemId(R.id.BottomBtnProfile);
        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.BottomBtnHome:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                    case R.id.BottomBtnPlan:
                        startActivity(new Intent(getApplicationContext(),MenuManagementActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.BottomBtnProfile:
                        return true;
                }
                return false;
            }
        });


//        lstReminder = new ArrayList<>();
//        lstReminder.add(new Reminder("بار گذاشتن آبگوشت","07:30","پنجشنبه 31 اردیبهشت"));
//        lstReminder.add(new Reminder("خرید اول هفته","18:00","شنبه 13 آبان"));
//        lstReminder.add(new Reminder("مهمونی مادرشوهر","20:45","پنجشنبه 18 آبان"));
//        lstReminder.add(new Reminder("خرید از هایپرمارکت","19:30","دوشنبه 22 آبان"));

//        RecyclerView myrv = (RecyclerView) findViewById(R.id.reminderRecyclerview_id);
//        Reminder_RecyclerViewAdapter myAdapter = new Reminder_RecyclerViewAdapter(this,lstReminder);
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        myrv.setLayoutManager(linearLayoutManager);
//        myrv.setAdapter(myAdapter);
    }

    private void showtime_L(){
        SimpleDateFormat hour=new SimpleDateFormat("HH");
        String sHour=hour.format(new Date());
        SimpleDateFormat min=new SimpleDateFormat("mm");
        String sMin=min.format(new Date());
        //Toast.makeText(DateTimeActivity.this,sHour+":"+sMin,Toast.LENGTH_LONG).show();
        showtime_L(sHour,sMin);
    }
    private void showtime_L(String sHour, String sMin){

        int hour=Integer.parseInt(sHour);
        int min=Integer.parseInt(sMin);

        TimePickerDialog dialog = TimePickerDialog.newInstance(new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute) {
                NumberFormat format = new DecimalFormat("00");
                String sTime = format.format(hourOfDay)+ ":"+format.format(minute);
                txtTime_L.setText(sTime);
                Toast.makeText(ProfileActivity.this,sTime,Toast.LENGTH_SHORT).show();
            }

        },hour,min,true);
        dialog.show(getFragmentManager(), "");
    }

    private void showtime_D(){
        SimpleDateFormat hour=new SimpleDateFormat("HH");
        String sHour=hour.format(new Date());
        SimpleDateFormat min=new SimpleDateFormat("mm");
        String sMin=min.format(new Date());
        //Toast.makeText(DateTimeActivity.this,sHour+":"+sMin,Toast.LENGTH_LONG).show();
        showtime_D(sHour,sMin);
    }
    private void showtime_D(String sHour, String sMin){

        int hour=Integer.parseInt(sHour);
        int min=Integer.parseInt(sMin);

        TimePickerDialog dialog = TimePickerDialog.newInstance(new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute) {
                NumberFormat format = new DecimalFormat("00");
                String sTime = format.format(hourOfDay)+ ":"+format.format(minute);
                txtTime_D.setText(sTime);
                Toast.makeText(ProfileActivity.this,sTime,Toast.LENGTH_SHORT).show();

            }

        },hour,min,true);
        dialog.show(getFragmentManager(), "");
    }

//    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
//            = new BottomNavigationView.OnNavigationItemSelectedListener() {
//
//        @Override
//        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//            switch (item.getItemId()) {
//                case R.id.BottomBtnHome:
//                    Toast.makeText(ProfileActivity.this,"HOME",Toast.LENGTH_LONG).show();
//                    Intent intent2=new Intent(ProfileActivity.this,MainActivity.class);
//                    startActivity(intent2);
//                    return true;
//                case R.id.BottomBtnPlan:
//                    Toast.makeText(ProfileActivity.this,"PLAN",Toast.LENGTH_LONG).show();
//                    Intent intent=new Intent(ProfileActivity.this,CalendarActivity.class);
//                    startActivity(intent);
//                    return true;
//                case R.id.BottomBtnProfile:
//                    Toast.makeText(ProfileActivity.this,"PROFILE",Toast.LENGTH_LONG).show();
//                    return true;
//            }
//            return false;
//        }
//    };
}