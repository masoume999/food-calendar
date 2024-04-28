package com.example.foodcalender.Activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodcalender.R;

public class phoneNumber_Activity extends AppCompatActivity {

    public static String phone_Number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone_number);

        final EditText inputMobile = findViewById(R.id.inputMobile);
        final Button buttonGetOTP = findViewById(R.id.buttonGetOTP);
        final TextView Error = findViewById(R.id.Error);

        inputMobile.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!inputMobile.getText().toString().trim().isEmpty()){
                    buttonGetOTP.setForeground(null);
                    return;
                }
                if(inputMobile.getText().toString().trim().isEmpty()){
                    int color = R.color.foreGround;
                    buttonGetOTP.setForeground(new ColorDrawable(getResources().getColor(color)));
                    return;
                }
            }
            @Override
            public void afterTextChanged(Editable editable) {
                int size = inputMobile.length();
                char array[] = inputMobile.getText().toString().toCharArray();
                if(size != 11 || array[0] != '0' || array[1] != '9'){
                    inputMobile.setBackground(getResources().getDrawable(R.drawable.border_edittext));
                    Error.setVisibility(View.VISIBLE);
                }
                else {
                    inputMobile.setBackground(getResources().getDrawable(R.drawable.background_edittext));
                    Error.setVisibility(View.INVISIBLE);
                }
                if(inputMobile.getText().toString().trim().isEmpty()){
                    inputMobile.setBackground(getResources().getDrawable(R.drawable.background_edittext));
                    Error.setVisibility(View.INVISIBLE);
                }
            }
        });

        buttonGetOTP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputMobile.getText().toString().trim().isEmpty()){
                    Toast.makeText(phoneNumber_Activity.this,"شماره موبایل را وارد کنید",Toast.LENGTH_SHORT).show();
                    return;
                }
                phone_Number=inputMobile.getText().toString();
                Intent intent = new Intent(getApplicationContext(),verificationCode_Activity.class);
                intent .putExtra("mobile",inputMobile.getText().toString());
                startActivity(intent);
            }
        });
    }
}