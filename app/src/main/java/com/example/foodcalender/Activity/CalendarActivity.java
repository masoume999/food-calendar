package com.example.foodcalender.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;

import com.bumptech.glide.load.engine.Resource;
import com.example.foodcalender.Domain.ConvertDate;
import com.example.foodcalender.R;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.mohamadamin.persianmaterialdatetimepicker.date.DatePickerDialog;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalendarActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener {

    Spinner Days;
    String Day;
    String[] DayArray={"شنبه","یکشنبه","دوشنبه","سه‌شنبه","چهارشنبه","پنجشنبه","جمعه"};

    private ImageView breakfast_button1, lunch_button1, dinner_button1,
            breakfast_button2, lunch_button2, dinner_button2,
            breakfast_image, lunch_image1, lunch_image2, lunch_image3,
            dinner_image1, dinner_image2, dinner_image3,lunch_P_image1,
            lunch_P_image2,lunch_P_image3,dinner_P_image1,dinner_P_image2,
            dinner_P_image3,lunch_image11,lunch_image22,lunch_image33,
            dinner_image11,dinner_image22,dinner_image33;


    private TextView breakfast_button_txt1, lunch_button_txt1,
            dinner_button_txt1, breakfast_button_txt2,
            lunch_button_txt2, dinner_button_txt2,
            Saturday, Sunday, Monday, Tuesday,
            Wednesday, Thursday, Friday,lunch1_txt,lunch2_txt,lunch3_txt,
            dinner1_txt,dinner2_txt,dinner3_txt;


    private String nameOfDay = "";
    EditText editTextField;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);

        Days=findViewById(R.id.ADDSDay);
        Days.setOnItemSelectedListener(this);

        //Creating the ArrayAdapter instance having the country list
        ArrayAdapter aa = new ArrayAdapter(this,android.R.layout.simple_spinner_item,DayArray);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Setting the ArrayAdapter data on the Spinner
        Days.setAdapter(aa);

//        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.bottom_navigation);
//        navigation.setSelectedItemId(R.id.BottomBtnPlan);
//        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
//        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()) {
//                    case R.id.BottomBtnHome:
//                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
//                        overridePendingTransition(0,0);
//                    case R.id.BottomBtnPlan:
//                        return true;
//                    case R.id.BottomBtnProfile:
//                        startActivity(new Intent(getApplicationContext(),ProfileActivity.class));
//                        overridePendingTransition(0,0);
//                        return true;
//                }
//                return false;
//            }
//        });

//        breakfast_button1 = findViewById(R.id.breakfast_button1);
//        breakfast_button_txt1 = findViewById(R.id.breakfast_button_txt1);
//        breakfast_button2 = findViewById(R.id.breakfast_button2);
//        breakfast_button_txt2 = findViewById(R.id.breakfast_button_txt2);

        lunch_button1 = findViewById(R.id.lunch_button1);
        lunch_button_txt1 = findViewById(R.id.lunch_button_txt1);
        lunch_button2 = findViewById(R.id.lunch_button2);
        lunch_button_txt2 = findViewById(R.id.lunch_button_txt2);

        dinner_button1 = findViewById(R.id.dinner_button1);
        dinner_button_txt1 = findViewById(R.id.dinner_button_txt1);
        dinner_button2 = findViewById(R.id.dinner_button2);
        dinner_button_txt2 = findViewById(R.id.dinner_button_txt2);

        breakfast_image = findViewById(R.id.breakfast);
        lunch_image1  = findViewById(R.id.lunch1);
        lunch_image2 = findViewById(R.id.lunch2);
        lunch_image3 = findViewById(R.id.lunch3);

        lunch_image11  = findViewById(R.id.lunch11);
        lunch_image22 = findViewById(R.id.lunch22);
        lunch_image33 = findViewById(R.id.lunch33);

        lunch_P_image1  = findViewById(R.id.lunch1_plus);
        lunch_P_image2 = findViewById(R.id.lunch2_plus);
        lunch_P_image3 = findViewById(R.id.lunch3_plus);

        dinner_image1 = findViewById(R.id.dinner1);
        dinner_image2 = findViewById(R.id.dinner2);
        dinner_image3 = findViewById(R.id.dinner3);

        dinner_image11 = findViewById(R.id.dinner11);
        dinner_image22 = findViewById(R.id.dinner22);
        dinner_image33 = findViewById(R.id.dinner33);

        dinner_P_image1 = findViewById(R.id.dinner1_plus);
        dinner_P_image2 = findViewById(R.id.dinner2_plus);
        dinner_P_image3 = findViewById(R.id.dinner3_plus);

        lunch1_txt=findViewById(R.id.lunch1_txt1);
        lunch2_txt=findViewById(R.id.lunch2_txt1);
        lunch3_txt=findViewById(R.id.lunch3_txt1);

        dinner1_txt=findViewById(R.id.dinner1_txt1);
        dinner2_txt=findViewById(R.id.dinner2_txt1);
        dinner3_txt=findViewById(R.id.dinner3_txt1);


        lunch_image1.setClickable(false);
        lunch_image2.setClickable(false);
        lunch_image3.setClickable(false);
        dinner_image1.setClickable(false);
        dinner_image2.setClickable(false);
        dinner_image3.setClickable(false);

//        Saturday = findViewById(R.id.Saturday);
//        Sunday = findViewById(R.id.Sunday);
//        Monday = findViewById(R.id.Monday);
//        Tuesday = findViewById(R.id.Tuesday);
//        Wednesday = findViewById(R.id.Wednesday);
//        Thursday = findViewById(R.id.Thursday);
//        Friday = findViewById(R.id.Friday);


//        breakfast_button1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                breakfast_button1.setVisibility(View.INVISIBLE);
//                breakfast_button_txt1.setVisibility(View.INVISIBLE);
//                breakfast_button2.setVisibility(View.VISIBLE);
//                breakfast_button_txt2.setVisibility(View.VISIBLE);
//
//                lunch_button1.setVisibility(View.VISIBLE);
//                lunch_button_txt1.setVisibility(View.VISIBLE);
//                lunch_button2.setVisibility(View.INVISIBLE);
//                lunch_button_txt2.setVisibility(View.INVISIBLE);
//
//                dinner_button1.setVisibility(View.VISIBLE);
//                dinner_button_txt1.setVisibility(View.VISIBLE);
//                dinner_button2.setVisibility(View.INVISIBLE);
//                dinner_button_txt2.setVisibility(View.INVISIBLE);
//
//                breakfast_image.setClickable(true);
//                lunch_image1.setClickable(false);
//                lunch_image2.setClickable(false);
//                lunch_image3.setClickable(false);
//                dinner_image1.setClickable(false);
//                dinner_image2.setClickable(false);
//                dinner_image3.setClickable(false);
//            }
//        });

        lunch_image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editText = new EditText(CalendarActivity.this);
                AlertDialog dialog = new AlertDialog.Builder(CalendarActivity.this)
                        .setTitle("اضافه‌كردن غذا")
                        .setMessage("لطفا نام غذای مورد نظر خود را وارد نمائید")
                        .setView(editText)
                        .setNegativeButtonIcon(getDrawable(R.drawable.cancle_icon))
                        .setPositiveButtonIcon(getDrawable(R.drawable.ok_icon))
                        .setPositiveButton("", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                String FoodName = String.valueOf(editText.getText());
                                if(FoodName.equalsIgnoreCase(""))
                                {
                                    Toast.makeText(CalendarActivity.this,"لطفا نام غذا را وارد نمائید!!",Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    lunch1_txt.setText(FoodName);
                                    lunch_image1.setVisibility(View.INVISIBLE);
                                    lunch_P_image1.setVisibility(View.INVISIBLE);
                                    lunch_image11.setVisibility(View.VISIBLE);
                                    //Toast.makeText(CalendarActivity.this,FoodName,Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("", null)
                        .create();
                dialog.show();
            }
        });

        lunch_image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editText = new EditText(CalendarActivity.this);
                AlertDialog dialog = new AlertDialog.Builder(CalendarActivity.this)
                        .setTitle("اضافه‌كردن غذا")
                        .setMessage("لطفا نام غذای مورد نظر خود را وارد نمائید")
                        .setView(editText)
                        .setNegativeButtonIcon(getDrawable(R.drawable.cancle_icon))
                        .setPositiveButtonIcon(getDrawable(R.drawable.ok_icon))
                        .setPositiveButton("", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                String FoodName = String.valueOf(editText.getText());
                                if(FoodName.equalsIgnoreCase(""))
                                {
                                    Toast.makeText(CalendarActivity.this,"لطفا نام غذا را وارد نمائید!!",Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    lunch2_txt.setText(FoodName);
                                    lunch_image2.setVisibility(View.INVISIBLE);
                                    lunch_P_image2.setVisibility(View.INVISIBLE);
                                    lunch_image22.setVisibility(View.VISIBLE);
                                    //Toast.makeText(CalendarActivity.this,FoodName,Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("", null)
                        .create();
                dialog.show();
            }
        });

        lunch_image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editText = new EditText(CalendarActivity.this);
                AlertDialog dialog = new AlertDialog.Builder(CalendarActivity.this)
                        .setTitle("اضافه‌كردن غذا")
                        .setMessage("لطفا نام غذای مورد نظر خود را وارد نمائید")
                        .setView(editText)
                        .setNegativeButtonIcon(getDrawable(R.drawable.cancle_icon))
                        .setPositiveButtonIcon(getDrawable(R.drawable.ok_icon))
                        .setPositiveButton("", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                String FoodName = String.valueOf(editText.getText());
                                if(FoodName.equalsIgnoreCase(""))
                                {
                                    Toast.makeText(CalendarActivity.this,"لطفا نام غذا را وارد نمائید!!",Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    lunch3_txt.setText(FoodName);
                                    lunch_image3.setVisibility(View.INVISIBLE);
                                    lunch_P_image3.setVisibility(View.INVISIBLE);
                                    lunch_image33.setVisibility(View.VISIBLE);
                                    //Toast.makeText(CalendarActivity.this,FoodName,Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("", null)
                        .create();
                dialog.show();
            }
        });

        dinner_image1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            final EditText editText = new EditText(CalendarActivity.this);
            AlertDialog dialog = new AlertDialog.Builder(CalendarActivity.this)
                    .setTitle("اضافه‌كردن غذا")
                    .setMessage("لطفا نام غذای مورد نظر خود را وارد نمائید")
                    .setView(editText)
                    .setNegativeButtonIcon(getDrawable(R.drawable.cancle_icon))
                    .setPositiveButtonIcon(getDrawable(R.drawable.ok_icon))
                    .setPositiveButton("", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                            String FoodName = String.valueOf(editText.getText());
                            if(FoodName.equalsIgnoreCase(""))
                            {
                                Toast.makeText(CalendarActivity.this,"لطفا نام غذا را وارد نمائید!!",Toast.LENGTH_SHORT).show();
                            }
                            else {
                                dinner1_txt.setText(FoodName);
                                dinner_image1.setVisibility(View.INVISIBLE);
                                dinner_P_image1.setVisibility(View.INVISIBLE);
                                dinner_image11.setVisibility(View.VISIBLE);
                                //Toast.makeText(CalendarActivity.this,FoodName,Toast.LENGTH_SHORT).show();
                            }
                        }
                    })
                    .setNegativeButton("", null)
                    .create();
            dialog.show();
        }
        });

        dinner_image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editText = new EditText(CalendarActivity.this);
                AlertDialog dialog = new AlertDialog.Builder(CalendarActivity.this)
                        .setTitle("اضافه‌كردن غذا")
                        .setMessage("لطفا نام غذای مورد نظر خود را وارد نمائید")
                        .setView(editText)
                        .setNegativeButtonIcon(getDrawable(R.drawable.cancle_icon))
                        .setPositiveButtonIcon(getDrawable(R.drawable.ok_icon))
                        .setPositiveButton("", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                String FoodName = String.valueOf(editText.getText());
                                if(FoodName.equalsIgnoreCase(""))
                                {
                                    Toast.makeText(CalendarActivity.this,"لطفا نام غذا را وارد نمائید!!",Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    dinner2_txt.setText(FoodName);
                                    dinner_image2.setVisibility(View.INVISIBLE);
                                    dinner_P_image2.setVisibility(View.INVISIBLE);
                                    dinner_image22.setVisibility(View.VISIBLE);
                                    //Toast.makeText(CalendarActivity.this,FoodName,Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("", null)
                        .create();
                dialog.show();
            }
        });

        dinner_image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final EditText editText = new EditText(CalendarActivity.this);
                AlertDialog dialog = new AlertDialog.Builder(CalendarActivity.this)
                        .setTitle("اضافه‌كردن غذا")
                        .setMessage("لطفا نام غذای مورد نظر خود را وارد نمائید")
                        .setView(editText)
                        .setNegativeButtonIcon(getDrawable(R.drawable.cancle_icon))
                        .setPositiveButtonIcon(getDrawable(R.drawable.ok_icon))
                        .setPositiveButton("", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                                String FoodName = String.valueOf(editText.getText());
                                if(FoodName.equalsIgnoreCase(""))
                                {
                                    Toast.makeText(CalendarActivity.this,"لطفا نام غذا را وارد نمائید!!",Toast.LENGTH_SHORT).show();
                                }
                                else {
                                    dinner3_txt.setText(FoodName);
                                    dinner_image3.setVisibility(View.INVISIBLE);
                                    dinner_P_image3.setVisibility(View.INVISIBLE);
                                    dinner_image33.setVisibility(View.VISIBLE);
                                    //Toast.makeText(CalendarActivity.this,FoodName,Toast.LENGTH_SHORT).show();
                                }
                            }
                        })
                        .setNegativeButton("", null)
                        .create();
                dialog.show();
            }
        });

        lunch_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                lunch_button1.setVisibility(View.INVISIBLE);
                lunch_button_txt1.setVisibility(View.INVISIBLE);
                lunch_button2.setVisibility(View.VISIBLE);
                lunch_button_txt2.setVisibility(View.VISIBLE);

//                breakfast_button1.setVisibility(View.VISIBLE);
//                breakfast_button_txt1.setVisibility(View.VISIBLE);
//                breakfast_button2.setVisibility(View.INVISIBLE);
//                breakfast_button_txt2.setVisibility(View.INVISIBLE);

                dinner_button1.setVisibility(View.VISIBLE);
                dinner_button_txt1.setVisibility(View.VISIBLE);
                dinner_button2.setVisibility(View.INVISIBLE);
                dinner_button_txt2.setVisibility(View.INVISIBLE);

                lunch_image1.setClickable(true);
                lunch_image2.setClickable(true);
                lunch_image3.setClickable(true);
//                breakfast_image.setClickable(false);
                dinner_image1.setClickable(false);
                dinner_image2.setClickable(false);
                dinner_image3.setClickable(false);
            }
        });

        dinner_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dinner_button1.setVisibility(View.INVISIBLE);
                dinner_button_txt1.setVisibility(View.INVISIBLE);
                dinner_button2.setVisibility(View.VISIBLE);
                dinner_button_txt2.setVisibility(View.VISIBLE);

//                breakfast_button1.setVisibility(View.VISIBLE);
//                breakfast_button_txt1.setVisibility(View.VISIBLE);
//                breakfast_button2.setVisibility(View.INVISIBLE);
//                breakfast_button_txt2.setVisibility(View.INVISIBLE);

                lunch_button1.setVisibility(View.VISIBLE);
                lunch_button_txt1.setVisibility(View.VISIBLE);
                lunch_button2.setVisibility(View.INVISIBLE);
                lunch_button_txt2.setVisibility(View.INVISIBLE);

                dinner_image1.setClickable(true);
                dinner_image2.setClickable(true);
                dinner_image3.setClickable(true);
//                breakfast_image.setClickable(false);
                lunch_image1.setClickable(false);
                lunch_image2.setClickable(false);
                lunch_image3.setClickable(false);
            }
        });

        Calendar_init();
    }

    private void Calendar_init() {
//        Date todayDate = Calendar.getInstance().getTime();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
//        String todayString = formatter.format(todayDate);
//        System.out.println("***todayString***"+todayString);
        Date today = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String dateToStr = format.format(today);
        //System.out.println(dateToStr);
        System.out.println("***todayString***"+dateToStr);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.calendar_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save: {
//                Intent intent = new Intent(MainActivity.this, .class);
//                startActivity(intent);
                break;
            }
            case R.id.calendar: {
                DatePickerDialog dialog = new DatePickerDialog();
                dialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @SuppressLint("ResourceAsColor")
                    @RequiresApi(api = Build.VERSION_CODES.M)
                    @Override
                    public void onDateSet(DatePickerDialog view, int year, int monthOfYear, int dayOfMonth) {
                        nameOfDay = NameOfDay(dayOfMonth,monthOfYear+1,year);
                        makeWeek(nameOfDay, dayOfMonth, monthOfYear+1, year);
                        Saturday.setTextColor(Color.BLACK);
                        Sunday.setTextColor(Color.BLACK);
                        Monday.setTextColor(Color.BLACK);
                        Tuesday.setTextColor(Color.BLACK);
                        Wednesday.setTextColor(Color.BLACK);
                        Thursday.setTextColor(Color.BLACK);
                        Friday.setTextColor(Color.BLACK);

                        switch(nameOfDay) {
                            case "0 شنبه":
                                Saturday.setTextColor(Color.RED);
                                break;
                            case "1 شنبه":
                                Sunday.setTextColor(Color.RED);
                                break;
                            case "2 شنبه":
                                Monday.setTextColor(Color.RED);
                                break;
                            case "3 شنبه":
                                Tuesday.setTextColor(Color.RED);
                                break;
                            case "4 شنبه":
                                Wednesday.setTextColor(Color.RED);
                                break;
                            case "5 شنبه":
                                Thursday.setTextColor(Color.RED);
                                break;
                            case "6 جمعه":
                                Friday.setTextColor(Color.RED);
                                break;
                        }

                       // Toast.makeText(CalendarActivity.this,String.valueOf(dayOfMonth),Toast.LENGTH_LONG).show();
                    }
                });
                dialog.show(getFragmentManager(), "");
                break;
            }
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private String NameOfDay(int day, int M, int year){
        String nameOfDay = "";

        NumberFormat format = new DecimalFormat("00");
        NumberFormat format1 = new DecimalFormat("0000");

        SimpleDateFormat inFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date1 = null;

        ConvertDate convertDate=new ConvertDate();
        convertDate.PersianToGregorian(year,M,day);
        String date = format.format(convertDate.getDay()) + "-" + format.format(convertDate.getMonth()) + "-" + format1.format(convertDate.getYear());
        try {
            date1 = inFormat.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        SimpleDateFormat outFormat = new SimpleDateFormat("EEEE");
        String dayOfMonth = outFormat.format(date1);

        switch(dayOfMonth){
            case "Saturday":
                nameOfDay = "0 شنبه";
                break;
            case "Sunday":
                nameOfDay = "1 شنبه";
                break;
            case "Monday":
                nameOfDay = "2 شنبه";
                break;
            case "Tuesday":
                nameOfDay = "3 شنبه";
                break;
            case "Wednesday":
                nameOfDay = "4 شنبه";
                break;
            case "Thursday":
                nameOfDay = "5 شنبه";
                break;
            case "Friday":
                nameOfDay = "6 جمعه";
                break;
        }
        return nameOfDay;
    }

    private void makeWeek(String nameOfDay, int day, int month, int year){
        if(day<7 || day>23){
            makeWeek_Check(nameOfDay,day,month,year);
        }
        else{
            switch(nameOfDay){
                case "0 شنبه": {
                    Saturday.setText(String.valueOf(day));

                    Sunday.setText(String.valueOf(day + 1));
                    Monday.setText(String.valueOf(day + 2));
                    Tuesday.setText(String.valueOf(day + 3));
                    Wednesday.setText(String.valueOf(day + 4));
                    Thursday.setText(String.valueOf(day + 5));
                    Friday.setText(String.valueOf(day + 6));
                    break;
                }
                case "1 شنبه": {
                    Sunday.setText(String.valueOf(day));

                    Saturday.setText(String.valueOf(day - 1));
                    Monday.setText(String.valueOf(day + 1));
                    Tuesday.setText(String.valueOf(day + 2));
                    Wednesday.setText(String.valueOf(day + 3));
                    Thursday.setText(String.valueOf(day + 4));
                    Friday.setText(String.valueOf(day + 5));
                    break;
                }
                case "2 شنبه": {
                    Monday.setText(String.valueOf(day));

                    Saturday.setText(String.valueOf(day - 2));
                    Sunday.setText(String.valueOf(day - 1));
                    Tuesday.setText(String.valueOf(day + 1));
                    Wednesday.setText(String.valueOf(day + 2));
                    Thursday.setText(String.valueOf(day + 3));
                    Friday.setText(String.valueOf(day + 4));
                    break;
                }
                case "3 شنبه": {
                    Tuesday.setText(String.valueOf(day));

                    Saturday.setText(String.valueOf(day - 3));
                    Sunday.setText(String.valueOf(day - 2));
                    Monday.setText(String.valueOf(day - 1));
                    Wednesday.setText(String.valueOf(day + 1));
                    Thursday.setText(String.valueOf(day + 2));
                    Friday.setText(String.valueOf(day + 3));
                    break;
                }
                case "4 شنبه": {
                    Wednesday.setText(String.valueOf(day));

                    Saturday.setText(String.valueOf(day - 4));
                    Sunday.setText(String.valueOf(day - 3));
                    Monday.setText(String.valueOf(day - 2));
                    Tuesday.setText(String.valueOf(day - 1));
                    Thursday.setText(String.valueOf(day + 1));
                    Friday.setText(String.valueOf(day + 2));
                    break;
                }
                case "5 شنبه": {
                    Thursday.setText(String.valueOf(day));

                    Saturday.setText(String.valueOf(day - 5));
                    Sunday.setText(String.valueOf(day - 4));
                    Monday.setText(String.valueOf(day - 3));
                    Tuesday.setText(String.valueOf(day - 2));
                    Wednesday.setText(String.valueOf(day - 1));
                    Friday.setText(String.valueOf(day + 1));
                    break;
                }
                case "6 جمعه": {
                    Friday.setText(String.valueOf(day));

                    Saturday.setText(String.valueOf(day - 6));
                    Sunday.setText(String.valueOf(day - 5));
                    Monday.setText(String.valueOf(day - 4));
                    Tuesday.setText(String.valueOf(day - 3));
                    Wednesday.setText(String.valueOf(day - 2));
                    Thursday.setText(String.valueOf(day - 1));
                    break;
                }
            }
        }
    }

    private void makeWeek_Check(String nameOfDay, int day, int month, int year) {
        int pMonth;
        if (day < 7) {
            if(month == 1){
                pMonth = numberDaysOfMonth(12, year-1);
            }
            else{
                pMonth = numberDaysOfMonth(month - 1, year);
            }
            switch (nameOfDay) {
                case "0 شنبه": {
                    Saturday.setText(String.valueOf(day));

                    Sunday.setText(String.valueOf(day + 1));
                    Monday.setText(String.valueOf(day + 2));
                    Tuesday.setText(String.valueOf(day + 3));
                    Wednesday.setText(String.valueOf(day + 4));
                    Thursday.setText(String.valueOf(day + 5));
                    Friday.setText(String.valueOf(day + 6));
                    break;
                }
                case "1 شنبه": {
                    Sunday.setText(String.valueOf(day));

                    Monday.setText(String.valueOf(day + 1));
                    Tuesday.setText(String.valueOf(day + 2));
                    Wednesday.setText(String.valueOf(day + 3));
                    Thursday.setText(String.valueOf(day + 4));
                    Friday.setText(String.valueOf(day + 5));

                    if (day - 1 > 0) {
                        Saturday.setText(String.valueOf(day - 1));
                    } else {
                        Saturday.setText(String.valueOf(pMonth));
                    }
                    break;
                }
                case "2 شنبه": {
                    Monday.setText(String.valueOf(day));

                    Tuesday.setText(String.valueOf(day + 1));
                    Wednesday.setText(String.valueOf(day + 2));
                    Thursday.setText(String.valueOf(day + 3));
                    Friday.setText(String.valueOf(day + 4));

                    if (day - 2 > 0) {
                        Saturday.setText(String.valueOf(day - 2));
                        Sunday.setText(String.valueOf(day - 1));
                    } else {
                        Saturday.setText(String.valueOf(pMonth - 1));
                        Sunday.setText(String.valueOf(pMonth));
                    }

                    break;
                }
                case "3 شنبه": {
                    Tuesday.setText(String.valueOf(day));

                    Wednesday.setText(String.valueOf(day + 1));
                    Thursday.setText(String.valueOf(day + 2));
                    Friday.setText(String.valueOf(day + 3));

                    if (day - 3 > 0) {
                        Saturday.setText(String.valueOf(day - 3));
                        Sunday.setText(String.valueOf(day - 2));
                        Monday.setText(String.valueOf(day - 1));
                    } else {
                        Saturday.setText(String.valueOf(pMonth - 2));
                        Sunday.setText(String.valueOf(pMonth - 1));
                        Monday.setText(String.valueOf(pMonth));
                    }

                    break;
                }
                case "4 شنبه": {
                    Wednesday.setText(String.valueOf(day));


                    Thursday.setText(String.valueOf(day + 1));
                    Friday.setText(String.valueOf(day + 2));

                    if (day - 4 > 0) {
                        Saturday.setText(String.valueOf(day - 4));
                        Sunday.setText(String.valueOf(day - 3));
                        Monday.setText(String.valueOf(day - 2));
                        Tuesday.setText(String.valueOf(day - 1));
                    } else {
                        Saturday.setText(String.valueOf(pMonth - 3));
                        Sunday.setText(String.valueOf(pMonth - 2));
                        Monday.setText(String.valueOf(pMonth - 1));
                        Tuesday.setText(String.valueOf(pMonth));
                    }

                    break;
                }
                case "5 شنبه": {
                    Thursday.setText(String.valueOf(day));

                    Friday.setText(String.valueOf(day + 1));

                    if (day - 5 > 0) {
                        Saturday.setText(String.valueOf(day - 5));
                        Sunday.setText(String.valueOf(day - 4));
                        Monday.setText(String.valueOf(day - 3));
                        Tuesday.setText(String.valueOf(day - 2));
                        Wednesday.setText(String.valueOf(day - 1));
                    } else {
                        Saturday.setText(String.valueOf(pMonth - 4));
                        Sunday.setText(String.valueOf(pMonth - 3));
                        Monday.setText(String.valueOf(pMonth - 2));
                        Tuesday.setText(String.valueOf(pMonth - 1));
                        Wednesday.setText(String.valueOf(pMonth));
                    }

                    break;
                }
                case "6 جمعه": {
                    Friday.setText(String.valueOf(day));

                    if (day - 6 > 0) {
                        Saturday.setText(String.valueOf(day - 6));
                        Sunday.setText(String.valueOf(day - 5));
                        Monday.setText(String.valueOf(day - 4));
                        Tuesday.setText(String.valueOf(day - 3));
                        Wednesday.setText(String.valueOf(day - 2));
                        Thursday.setText(String.valueOf(day - 1));
                    } else {
                        Saturday.setText(String.valueOf(pMonth - 5));
                        Sunday.setText(String.valueOf(pMonth - 4));
                        Monday.setText(String.valueOf(pMonth - 3));
                        Tuesday.setText(String.valueOf(pMonth - 2));
                        Wednesday.setText(String.valueOf(pMonth - 1));
                        Thursday.setText(String.valueOf(pMonth));
                    }
                    break;
                }
            }
        } else if (day > 23) {
            int Month = numberDaysOfMonth(month, year);

            switch (nameOfDay) {
                case "0 شنبه": {
                    if (Month == 29) {
                        if(day == 24){
                            Saturday.setText(String.valueOf(day));
                            Sunday.setText(String.valueOf(day + 1));
                            Monday.setText(String.valueOf(day + 2));
                            Tuesday.setText(String.valueOf(day + 3));
                            Wednesday.setText(String.valueOf(day + 4));
                            Thursday.setText(String.valueOf(day + 5));
                            Friday.setText(String.valueOf(1));
                        }
                        else if(day == 25){
                            Saturday.setText(String.valueOf(day));
                            Sunday.setText(String.valueOf(day + 1));
                            Monday.setText(String.valueOf(day + 2));
                            Tuesday.setText(String.valueOf(day + 3));
                            Wednesday.setText(String.valueOf(day + 4));
                            Thursday.setText(String.valueOf(1));
                            Friday.setText(String.valueOf(2));
                        }
                        else if(day ==26){
                            Saturday.setText(String.valueOf(day));
                            Sunday.setText(String.valueOf(day + 1));
                            Monday.setText(String.valueOf(day + 2));
                            Tuesday.setText(String.valueOf(day + 3));
                            Wednesday.setText(String.valueOf(1));
                            Thursday.setText(String.valueOf(2));
                            Friday.setText(String.valueOf(3));
                        }
                        else if(day == 27){
                            Saturday.setText(String.valueOf(day));
                            Sunday.setText(String.valueOf(day + 1));
                            Monday.setText(String.valueOf(day + 2));
                            Tuesday.setText(String.valueOf(1));
                            Wednesday.setText(String.valueOf(2));
                            Thursday.setText(String.valueOf(3));
                            Friday.setText(String.valueOf(4));
                        }
                        else if(day == 28){
                            Saturday.setText(String.valueOf(day));
                            Sunday.setText(String.valueOf(day + 1));
                            Monday.setText(String.valueOf(1));
                            Tuesday.setText(String.valueOf(2));
                            Wednesday.setText(String.valueOf(3));
                            Thursday.setText(String.valueOf(4));
                            Friday.setText(String.valueOf(5));
                        }
                        else if(day == 29){
                            Saturday.setText(String.valueOf(day));
                            Sunday.setText(String.valueOf(1));
                            Monday.setText(String.valueOf(2));
                            Tuesday.setText(String.valueOf(3));
                            Wednesday.setText(String.valueOf(4));
                            Thursday.setText(String.valueOf(5));
                            Friday.setText(String.valueOf(6));
                        }
                    }
                    else if(Month == 30){
                        if(day == 25){
                            Saturday.setText(String.valueOf(day));
                            Sunday.setText(String.valueOf(day + 1));
                            Monday.setText(String.valueOf(day + 2));
                            Tuesday.setText(String.valueOf(day + 3));
                            Wednesday.setText(String.valueOf(day + 4));
                            Thursday.setText(String.valueOf(day + 5));
                            Friday.setText(String.valueOf(1));
                        }
                        else if(day == 26){
                            Saturday.setText(String.valueOf(day));
                            Sunday.setText(String.valueOf(day + 1));
                            Monday.setText(String.valueOf(day + 2));
                            Tuesday.setText(String.valueOf(day + 3));
                            Wednesday.setText(String.valueOf(day + 4));
                            Thursday.setText(String.valueOf(1));
                            Friday.setText(String.valueOf(2));
                        }
                        else if(day == 27){
                            Saturday.setText(String.valueOf(day));
                            Sunday.setText(String.valueOf(day + 1));
                            Monday.setText(String.valueOf(day + 2));
                            Tuesday.setText(String.valueOf(day + 3));
                            Wednesday.setText(String.valueOf(1));
                            Thursday.setText(String.valueOf(2));
                            Friday.setText(String.valueOf(3));
                        }
                        else if(day == 28){
                            Saturday.setText(String.valueOf(day));
                            Sunday.setText(String.valueOf(day + 1));
                            Monday.setText(String.valueOf(day + 2));
                            Tuesday.setText(String.valueOf(1));
                            Wednesday.setText(String.valueOf(2));
                            Thursday.setText(String.valueOf(3));
                            Friday.setText(String.valueOf(4));
                        }
                        else if(day == 29){
                            Saturday.setText(String.valueOf(day));
                            Sunday.setText(String.valueOf(day + 1));
                            Monday.setText(String.valueOf(1));
                            Tuesday.setText(String.valueOf(2));
                            Wednesday.setText(String.valueOf(3));
                            Thursday.setText(String.valueOf(4));
                            Friday.setText(String.valueOf(5));
                        }
                        else if(day == 30){
                            Saturday.setText(String.valueOf(day));
                            Sunday.setText(String.valueOf(1));
                            Monday.setText(String.valueOf(2));
                            Tuesday.setText(String.valueOf(3));
                            Wednesday.setText(String.valueOf(4));
                            Thursday.setText(String.valueOf(5));
                            Friday.setText(String.valueOf(6));
                        }
                    }
                    else if(Month == 31){
                        if(day == 26){
                            Saturday.setText(String.valueOf(day));
                            Sunday.setText(String.valueOf(day + 1));
                            Monday.setText(String.valueOf(day + 2));
                            Tuesday.setText(String.valueOf(day + 3));
                            Wednesday.setText(String.valueOf(day + 4));
                            Thursday.setText(String.valueOf(day + 5));
                            Friday.setText(String.valueOf(1));
                        }
                        else if(day == 27){
                            Saturday.setText(String.valueOf(day));
                            Sunday.setText(String.valueOf(day + 1));
                            Monday.setText(String.valueOf(day + 2));
                            Tuesday.setText(String.valueOf(day + 3));
                            Wednesday.setText(String.valueOf(day + 4));
                            Thursday.setText(String.valueOf(1));
                            Friday.setText(String.valueOf(2));
                        }
                        else if(day == 28){
                            Saturday.setText(String.valueOf(day));
                            Sunday.setText(String.valueOf(day + 1));
                            Monday.setText(String.valueOf(day + 2));
                            Tuesday.setText(String.valueOf(day + 3));
                            Wednesday.setText(String.valueOf(1));
                            Thursday.setText(String.valueOf(2));
                            Friday.setText(String.valueOf(3));
                        }
                        else if(day == 29){
                            Saturday.setText(String.valueOf(day));
                            Sunday.setText(String.valueOf(day + 1));
                            Monday.setText(String.valueOf(day + 2));
                            Tuesday.setText(String.valueOf(1));
                            Wednesday.setText(String.valueOf(2));
                            Thursday.setText(String.valueOf(3));
                            Friday.setText(String.valueOf(4));
                        }
                        else if(day == 30){
                            Saturday.setText(String.valueOf(day));
                            Sunday.setText(String.valueOf(day + 1));
                            Monday.setText(String.valueOf(1));
                            Tuesday.setText(String.valueOf(2));
                            Wednesday.setText(String.valueOf(3));
                            Thursday.setText(String.valueOf(4));
                            Friday.setText(String.valueOf(5));
                        }
                        else if(day == 31){
                            Saturday.setText(String.valueOf(day));
                            Sunday.setText(String.valueOf(1));
                            Monday.setText(String.valueOf(2));
                            Tuesday.setText(String.valueOf(3));
                            Wednesday.setText(String.valueOf(4));
                            Thursday.setText(String.valueOf(5));
                            Friday.setText(String.valueOf(6));
                        }
                    }
                    break;
                }
                case "1 شنبه": {
                    if (Month == 29) {
                        if(day == 25){
                            Saturday.setText(String.valueOf(day-1));
                            Sunday.setText(String.valueOf(day));
                            Monday.setText(String.valueOf(day + 1));
                            Tuesday.setText(String.valueOf(day + 2));
                            Wednesday.setText(String.valueOf(day + 3));
                            Thursday.setText(String.valueOf(day + 4));
                            Friday.setText(String.valueOf(1));
                        }
                        else if(day == 26){
                            Saturday.setText(String.valueOf(day-1));
                            Sunday.setText(String.valueOf(day));
                            Monday.setText(String.valueOf(day + 1));
                            Tuesday.setText(String.valueOf(day + 2));
                            Wednesday.setText(String.valueOf(day + 3));
                            Thursday.setText(String.valueOf(1));
                            Friday.setText(String.valueOf(2));
                        }
                        else if(day == 27){
                            Saturday.setText(String.valueOf(day-1));
                            Sunday.setText(String.valueOf(day));
                            Monday.setText(String.valueOf(day + 1));
                            Tuesday.setText(String.valueOf(day + 2));
                            Wednesday.setText(String.valueOf(1));
                            Thursday.setText(String.valueOf(2));
                            Friday.setText(String.valueOf(3));
                        }
                        else if(day == 28){
                            Saturday.setText(String.valueOf(day-1));
                            Sunday.setText(String.valueOf(day));
                            Monday.setText(String.valueOf(day + 1));
                            Tuesday.setText(String.valueOf(1));
                            Wednesday.setText(String.valueOf(2));
                            Thursday.setText(String.valueOf(3));
                            Friday.setText(String.valueOf(4));
                        }
                        else if(day == 29){
                            Saturday.setText(String.valueOf(day-1));
                            Sunday.setText(String.valueOf(day));
                            Monday.setText(String.valueOf(1));
                            Tuesday.setText(String.valueOf(2));
                            Wednesday.setText(String.valueOf(3));
                            Thursday.setText(String.valueOf(4));
                            Friday.setText(String.valueOf(5));
                        }
                    }
                    else if(Month == 30){
                        if(day == 26){
                            Saturday.setText(String.valueOf(day-1));
                            Sunday.setText(String.valueOf(day));
                            Monday.setText(String.valueOf(day + 1));
                            Tuesday.setText(String.valueOf(day + 2));
                            Wednesday.setText(String.valueOf(day + 3));
                            Thursday.setText(String.valueOf(day + 4));
                            Friday.setText(String.valueOf(1));
                        }
                        else if(day == 27){
                            Saturday.setText(String.valueOf(day-1));
                            Sunday.setText(String.valueOf(day));
                            Monday.setText(String.valueOf(day + 1));
                            Tuesday.setText(String.valueOf(day + 2));
                            Wednesday.setText(String.valueOf(day + 3));
                            Thursday.setText(String.valueOf(1));
                            Friday.setText(String.valueOf(2));
                        }
                        else if(day == 28){
                            Saturday.setText(String.valueOf(day-1));
                            Sunday.setText(String.valueOf(day));
                            Monday.setText(String.valueOf(day + 1));
                            Tuesday.setText(String.valueOf(day + 2));
                            Wednesday.setText(String.valueOf(1));
                            Thursday.setText(String.valueOf(2));
                            Friday.setText(String.valueOf(3));
                        }
                        else if(day == 29){
                            Saturday.setText(String.valueOf(day-1));
                            Sunday.setText(String.valueOf(day));
                            Monday.setText(String.valueOf(day + 1));
                            Tuesday.setText(String.valueOf(1));
                            Wednesday.setText(String.valueOf(2));
                            Thursday.setText(String.valueOf(3));
                            Friday.setText(String.valueOf(4));
                        }
                        else if(day == 30){
                            Saturday.setText(String.valueOf(day-1));
                            Sunday.setText(String.valueOf(day));
                            Monday.setText(String.valueOf(1));
                            Tuesday.setText(String.valueOf(2));
                            Wednesday.setText(String.valueOf(3));
                            Thursday.setText(String.valueOf(4));
                            Friday.setText(String.valueOf(5));
                        }
                    }
                    else if(Month == 31){
                        if(day == 27){
                            Saturday.setText(String.valueOf(day-1));
                            Sunday.setText(String.valueOf(day));
                            Monday.setText(String.valueOf(day + 1));
                            Tuesday.setText(String.valueOf(day + 2));
                            Wednesday.setText(String.valueOf(day + 3));
                            Thursday.setText(String.valueOf(day + 4));
                            Friday.setText(String.valueOf(1));
                        }
                        else if(day == 28){
                            Saturday.setText(String.valueOf(day-1));
                            Sunday.setText(String.valueOf(day));
                            Monday.setText(String.valueOf(day + 1));
                            Tuesday.setText(String.valueOf(day + 2));
                            Wednesday.setText(String.valueOf(day + 3));
                            Thursday.setText(String.valueOf(1));
                            Friday.setText(String.valueOf(2));
                        }
                        else if(day == 29){
                            Saturday.setText(String.valueOf(day-1));
                            Sunday.setText(String.valueOf(day));
                            Monday.setText(String.valueOf(day + 1));
                            Tuesday.setText(String.valueOf(day + 2));
                            Wednesday.setText(String.valueOf(1));
                            Thursday.setText(String.valueOf(2));
                            Friday.setText(String.valueOf(3));
                        }
                        else if(day == 30){
                            Saturday.setText(String.valueOf(day-1));
                            Sunday.setText(String.valueOf(day));
                            Monday.setText(String.valueOf(day + 1));
                            Tuesday.setText(String.valueOf(1));
                            Wednesday.setText(String.valueOf(2));
                            Thursday.setText(String.valueOf(3));
                            Friday.setText(String.valueOf(4));
                        }
                        else if(day == 31){
                            Saturday.setText(String.valueOf(day-1));
                            Sunday.setText(String.valueOf(day));
                            Monday.setText(String.valueOf(1));
                            Tuesday.setText(String.valueOf(2));
                            Wednesday.setText(String.valueOf(3));
                            Thursday.setText(String.valueOf(4));
                            Friday.setText(String.valueOf(5));
                        }
                    }
                    break;
                }
                case "2 شنبه": {
                    if (Month == 29) {
                        if(day == 26){
                            Saturday.setText(String.valueOf(day-2));
                            Sunday.setText(String.valueOf(day-1));
                            Monday.setText(String.valueOf(day));
                            Tuesday.setText(String.valueOf(day + 1));
                            Wednesday.setText(String.valueOf(day + 2));
                            Thursday.setText(String.valueOf(day + 3));
                            Friday.setText(String.valueOf(1));
                        }
                        else if(day == 27){
                            Saturday.setText(String.valueOf(day-2));
                            Sunday.setText(String.valueOf(day-1));
                            Monday.setText(String.valueOf(day));
                            Tuesday.setText(String.valueOf(day + 1));
                            Wednesday.setText(String.valueOf(day + 2));
                            Thursday.setText(String.valueOf(1));
                            Friday.setText(String.valueOf(2));
                        }
                        else if(day == 28){
                            Saturday.setText(String.valueOf(day-2));
                            Sunday.setText(String.valueOf(day-1));
                            Monday.setText(String.valueOf(day));
                            Tuesday.setText(String.valueOf(day + 1));
                            Wednesday.setText(String.valueOf(1));
                            Thursday.setText(String.valueOf(2));
                            Friday.setText(String.valueOf(3));
                        }
                        else if(day == 29){
                            Saturday.setText(String.valueOf(day-2));
                            Sunday.setText(String.valueOf(day-1));
                            Monday.setText(String.valueOf(day));
                            Tuesday.setText(String.valueOf(1));
                            Wednesday.setText(String.valueOf(2));
                            Thursday.setText(String.valueOf(3));
                            Friday.setText(String.valueOf(4));
                        }
                    }
                    else if(Month == 30){
                        if(day == 27){
                            Saturday.setText(String.valueOf(day-2));
                            Sunday.setText(String.valueOf(day-1));
                            Monday.setText(String.valueOf(day));
                            Tuesday.setText(String.valueOf(day + 1));
                            Wednesday.setText(String.valueOf(day + 2));
                            Thursday.setText(String.valueOf(day + 3));
                            Friday.setText(String.valueOf(1));
                        }
                        else if(day == 28){
                            Saturday.setText(String.valueOf(day-2));
                            Sunday.setText(String.valueOf(day-1));
                            Monday.setText(String.valueOf(day));
                            Tuesday.setText(String.valueOf(day + 1));
                            Wednesday.setText(String.valueOf(day + 2));
                            Thursday.setText(String.valueOf(1));
                            Friday.setText(String.valueOf(2));
                        }
                        else if(day == 29){
                            Saturday.setText(String.valueOf(day-2));
                            Sunday.setText(String.valueOf(day-1));
                            Monday.setText(String.valueOf(day));
                            Tuesday.setText(String.valueOf(day + 1));
                            Wednesday.setText(String.valueOf(1));
                            Thursday.setText(String.valueOf(2));
                            Friday.setText(String.valueOf(3));
                        }
                        else if(day == 30){
                            Saturday.setText(String.valueOf(day-2));
                            Sunday.setText(String.valueOf(day-1));
                            Monday.setText(String.valueOf(day));
                            Tuesday.setText(String.valueOf(1));
                            Wednesday.setText(String.valueOf(2));
                            Thursday.setText(String.valueOf(3));
                            Friday.setText(String.valueOf(4));
                        }
                    }
                    else if(Month == 31){
                        if(day == 28){
                            Saturday.setText(String.valueOf(day-2));
                            Sunday.setText(String.valueOf(day-1));
                            Monday.setText(String.valueOf(day));
                            Tuesday.setText(String.valueOf(day + 1));
                            Wednesday.setText(String.valueOf(day + 2));
                            Thursday.setText(String.valueOf(day + 3));
                            Friday.setText(String.valueOf(1));
                        }
                        else if(day == 29){
                            Saturday.setText(String.valueOf(day-2));
                            Sunday.setText(String.valueOf(day-1));
                            Monday.setText(String.valueOf(day));
                            Tuesday.setText(String.valueOf(day + 1));
                            Wednesday.setText(String.valueOf(day + 2));
                            Thursday.setText(String.valueOf(1));
                            Friday.setText(String.valueOf(2));
                        }
                        else if(day == 30){
                            Saturday.setText(String.valueOf(day-2));
                            Sunday.setText(String.valueOf(day-1));
                            Monday.setText(String.valueOf(day));
                            Tuesday.setText(String.valueOf(day + 1));
                            Wednesday.setText(String.valueOf(1));
                            Thursday.setText(String.valueOf(2));
                            Friday.setText(String.valueOf(3));
                        }
                        else if(day == 31){
                            Saturday.setText(String.valueOf(day-2));
                            Sunday.setText(String.valueOf(day-1));
                            Monday.setText(String.valueOf(day));
                            Tuesday.setText(String.valueOf(1));
                            Wednesday.setText(String.valueOf(2));
                            Thursday.setText(String.valueOf(3));
                            Friday.setText(String.valueOf(4));
                        }
                    }
                    break;
                }
                case "3 شنبه": {
                    if (Month == 29) {
                        if(day == 27){
                            Saturday.setText(String.valueOf(day-3));
                            Sunday.setText(String.valueOf(day-2));
                            Monday.setText(String.valueOf(day-1));
                            Tuesday.setText(String.valueOf(day));
                            Wednesday.setText(String.valueOf(day + 1));
                            Thursday.setText(String.valueOf(day + 2));
                            Friday.setText(String.valueOf(1));
                        }
                        else if(day == 28){
                            Saturday.setText(String.valueOf(day-3));
                            Sunday.setText(String.valueOf(day-2));
                            Monday.setText(String.valueOf(day-1));
                            Tuesday.setText(String.valueOf(day));
                            Wednesday.setText(String.valueOf(day + 1));
                            Thursday.setText(String.valueOf(1));
                            Friday.setText(String.valueOf(2));
                        }
                        else if(day == 29){
                            Saturday.setText(String.valueOf(day-3));
                            Sunday.setText(String.valueOf(day-2));
                            Monday.setText(String.valueOf(day-1));
                            Tuesday.setText(String.valueOf(day));
                            Wednesday.setText(String.valueOf(1));
                            Thursday.setText(String.valueOf(2));
                            Friday.setText(String.valueOf(3));
                        }
                    }
                    else if(Month == 30){
                        if(day == 28){
                            Saturday.setText(String.valueOf(day-3));
                            Sunday.setText(String.valueOf(day-2));
                            Monday.setText(String.valueOf(day-1));
                            Tuesday.setText(String.valueOf(day));
                            Wednesday.setText(String.valueOf(day + 1));
                            Thursday.setText(String.valueOf(day + 2));
                            Friday.setText(String.valueOf(1));
                        }
                        else if(day == 29){
                            Saturday.setText(String.valueOf(day-3));
                            Sunday.setText(String.valueOf(day-2));
                            Monday.setText(String.valueOf(day-1));
                            Tuesday.setText(String.valueOf(day));
                            Wednesday.setText(String.valueOf(day + 1));
                            Thursday.setText(String.valueOf(1));
                            Friday.setText(String.valueOf(2));
                        }
                        else if(day == 30){
                            Saturday.setText(String.valueOf(day-3));
                            Sunday.setText(String.valueOf(day-2));
                            Monday.setText(String.valueOf(day-1));
                            Tuesday.setText(String.valueOf(day));
                            Wednesday.setText(String.valueOf(1));
                            Thursday.setText(String.valueOf(2));
                            Friday.setText(String.valueOf(3));
                        }
                    }
                    else if(Month == 31){
                        if(day == 29){
                            Saturday.setText(String.valueOf(day-3));
                            Sunday.setText(String.valueOf(day-2));
                            Monday.setText(String.valueOf(day-1));
                            Tuesday.setText(String.valueOf(day));
                            Wednesday.setText(String.valueOf(day + 1));
                            Thursday.setText(String.valueOf(day + 2));
                            Friday.setText(String.valueOf(1));
                        }
                        else if(day == 30){
                            Saturday.setText(String.valueOf(day-3));
                            Sunday.setText(String.valueOf(day-2));
                            Monday.setText(String.valueOf(day-1));
                            Tuesday.setText(String.valueOf(day));
                            Wednesday.setText(String.valueOf(day + 1));
                            Thursday.setText(String.valueOf(1));
                            Friday.setText(String.valueOf(2));
                        }
                        else if(day == 31){
                            Saturday.setText(String.valueOf(day-3));
                            Sunday.setText(String.valueOf(day-2));
                            Monday.setText(String.valueOf(day-1));
                            Tuesday.setText(String.valueOf(day));
                            Wednesday.setText(String.valueOf(1));
                            Thursday.setText(String.valueOf(2));
                            Friday.setText(String.valueOf(3));
                        }
                    }
                    break;
                }
                case "4 شنبه": {
                    if (Month == 29) {
                        if(day == 28){
                            Saturday.setText(String.valueOf(day-4));
                            Sunday.setText(String.valueOf(day-3));
                            Monday.setText(String.valueOf(day-2));
                            Tuesday.setText(String.valueOf(day-1));
                            Wednesday.setText(String.valueOf(day));
                            Thursday.setText(String.valueOf(day + 1));
                            Friday.setText(String.valueOf(1));
                        }
                        else if(day == 29){
                            Saturday.setText(String.valueOf(day-4));
                            Sunday.setText(String.valueOf(day-3));
                            Monday.setText(String.valueOf(day-2));
                            Tuesday.setText(String.valueOf(day-1));
                            Wednesday.setText(String.valueOf(day));
                            Thursday.setText(String.valueOf(1));
                            Friday.setText(String.valueOf(2));
                        }
                    }
                    else if(Month == 30){
                        if(day == 29){
                            Saturday.setText(String.valueOf(day-4));
                            Sunday.setText(String.valueOf(day-3));
                            Monday.setText(String.valueOf(day-2));
                            Tuesday.setText(String.valueOf(day-1));
                            Wednesday.setText(String.valueOf(day));
                            Thursday.setText(String.valueOf(day + 1));
                            Friday.setText(String.valueOf(1));
                        }
                        else if(day == 30){
                            Saturday.setText(String.valueOf(day-4));
                            Sunday.setText(String.valueOf(day-3));
                            Monday.setText(String.valueOf(day-2));
                            Tuesday.setText(String.valueOf(day-1));
                            Wednesday.setText(String.valueOf(day));
                            Thursday.setText(String.valueOf(1));
                            Friday.setText(String.valueOf(2));
                        }
                    }
                    else if(Month == 31){
                        if(day == 30){
                            Saturday.setText(String.valueOf(day-4));
                            Sunday.setText(String.valueOf(day-3));
                            Monday.setText(String.valueOf(day-2));
                            Tuesday.setText(String.valueOf(day-1));
                            Wednesday.setText(String.valueOf(day));
                            Thursday.setText(String.valueOf(day + 1));
                            Friday.setText(String.valueOf(1));
                        }
                        else if(day == 31){
                            Saturday.setText(String.valueOf(day-4));
                            Sunday.setText(String.valueOf(day-3));
                            Monday.setText(String.valueOf(day-2));
                            Tuesday.setText(String.valueOf(day-1));
                            Wednesday.setText(String.valueOf(day));
                            Thursday.setText(String.valueOf(1));
                            Friday.setText(String.valueOf(2));
                        }
                    }
                    break;
                }
                case "5 شنبه": {
                    if (Month == 29) {
                        if(day == 29){
                            Saturday.setText(String.valueOf(day-5));
                            Sunday.setText(String.valueOf(day-4));
                            Monday.setText(String.valueOf(day-3));
                            Tuesday.setText(String.valueOf(day-2));
                            Wednesday.setText(String.valueOf(day-1));
                            Thursday.setText(String.valueOf(day));
                            Friday.setText(String.valueOf(1));
                        }
                    }
                    else if(Month == 30){
                        if(day == 30){
                            Saturday.setText(String.valueOf(day-5));
                            Sunday.setText(String.valueOf(day-4));
                            Monday.setText(String.valueOf(day-3));
                            Tuesday.setText(String.valueOf(day-2));
                            Wednesday.setText(String.valueOf(day-1));
                            Thursday.setText(String.valueOf(day));
                            Friday.setText(String.valueOf(1));
                        }
                    }
                    else if(Month == 31){
                        if(day == 31){
                            Saturday.setText(String.valueOf(day-5));
                            Sunday.setText(String.valueOf(day-4));
                            Monday.setText(String.valueOf(day-3));
                            Tuesday.setText(String.valueOf(day-2));
                            Wednesday.setText(String.valueOf(day-1));
                            Thursday.setText(String.valueOf(day));
                            Friday.setText(String.valueOf(1));
                        }
                    }
                    break;
                }
                case "6 جمعه": {
                    if (Month == 29) {
                        if(day == 29){
                            Saturday.setText(String.valueOf(day-6));
                            Sunday.setText(String.valueOf(day-5));
                            Monday.setText(String.valueOf(day-4));
                            Tuesday.setText(String.valueOf(day-3));
                            Wednesday.setText(String.valueOf(day-2));
                            Thursday.setText(String.valueOf(day-1));
                            Friday.setText(String.valueOf(day));
                        }
                    }
                    else if(Month == 30){
                        if(day == 30){
                            Saturday.setText(String.valueOf(day-6));
                            Sunday.setText(String.valueOf(day-5));
                            Monday.setText(String.valueOf(day-4));
                            Tuesday.setText(String.valueOf(day-3));
                            Wednesday.setText(String.valueOf(day-2));
                            Thursday.setText(String.valueOf(day-1));
                            Friday.setText(String.valueOf(day));
                        }
                    }
                    else if(Month == 31){
                        if(day == 31){
                            Saturday.setText(String.valueOf(day-6));
                            Sunday.setText(String.valueOf(day-5));
                            Monday.setText(String.valueOf(day-4));
                            Tuesday.setText(String.valueOf(day-3));
                            Wednesday.setText(String.valueOf(day-2));
                            Thursday.setText(String.valueOf(day-1));
                            Friday.setText(String.valueOf(day));
                        }
                    }
                    break;
                }
            }
        }
    }

    private int numberDaysOfMonth(int month, int year){
        String day1 = "";
        String day2 = "";
        String[] array1;
        String[] array2;

        int num = 0;
        switch (month){
            case 1:
                num = 31;
                break;
            case 2:
                num = 31;
                break;
            case 3:
                num = 31;
                break;
            case 4:
                num = 31;
                break;
            case 5:
                num = 31;
                break;
            case 6:
                num = 31;
                break;
            case 7:
                num = 30;
                break;
            case 8:
                num = 30;
                break;
            case 9:
                num = 30;
                break;
            case 10:
                num = 30;
                break;
            case 11:
                num = 30;
                break;
            case 12:
                day1 = NameOfDay(29,12,year);
                day2 = NameOfDay(1,1,year+1);

                array1 = day1.split(" ");
                array2 = day2.split(" ");

                int minus = Integer.parseInt(array2[0])-Integer.parseInt(array1[0]);

                if(minus>1 || minus == -5){
                    num = 30;
                }
                else{
                    num = 29;
                }
                break;
        }
        return num;
    }

    //Performing action onItemSelected and onNothing selected
    @Override
    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
        Day=DayArray[position];
        Toast.makeText(getApplicationContext(),Day , Toast.LENGTH_LONG).show();
    }
    @Override
    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}
