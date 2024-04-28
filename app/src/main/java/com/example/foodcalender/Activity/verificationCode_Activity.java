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

public class verificationCode_Activity extends AppCompatActivity {

    private EditText inputCode1, inputCode2, inputCode3, inputCode4;
    private Button buttonVerify;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verification_code);

        buttonVerify = findViewById(R.id.buttonVerify);
        TextView textMobile = findViewById(R.id.txtMobile);
        textMobile.setText( " کد تایید به "  + getIntent().getStringExtra("mobile") + " ارسال شد");

        inputCode1 = findViewById(R.id.inputCode1);
        inputCode2 = findViewById(R.id.inputCode2);
        inputCode3 = findViewById(R.id.inputCode3);
        inputCode4 = findViewById(R.id.inputCode4);

        setupOTPInputs();

        buttonVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputCode1.getText().toString().trim().isEmpty() || inputCode2.getText().toString().trim().isEmpty() || inputCode3.getText().toString().trim().isEmpty() || inputCode4.getText().toString().trim().isEmpty()){
                    Toast.makeText(verificationCode_Activity.this,"شماره موبایل را وارد کنید",Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(getApplicationContext(),NameActivity.class);
                startActivity(intent);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void setupOTPInputs() {
        inputCode1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().trim().isEmpty()){
                    inputCode2.requestFocus();
                }
                if(!inputCode1.getText().toString().trim().isEmpty() && !inputCode2.getText().toString().trim().isEmpty() && !inputCode3.getText().toString().trim().isEmpty() && !inputCode4.getText().toString().trim().isEmpty()){
                    buttonVerify.setForeground(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(inputCode1.getText().toString().trim().isEmpty() || inputCode2.getText().toString().trim().isEmpty() || inputCode3.getText().toString().trim().isEmpty() || inputCode4.getText().toString().trim().isEmpty()){
                    int color = R.color.foreGround;
                    buttonVerify.setForeground(new ColorDrawable(getResources().getColor(color)));
                }
            }
        });
        inputCode2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().trim().isEmpty()){
                    inputCode3.requestFocus();
                }
                if(!inputCode1.getText().toString().trim().isEmpty() && !inputCode2.getText().toString().trim().isEmpty() && !inputCode3.getText().toString().trim().isEmpty() && !inputCode4.getText().toString().trim().isEmpty()){
                    buttonVerify.setForeground(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(inputCode1.getText().toString().trim().isEmpty() || inputCode2.getText().toString().trim().isEmpty() || inputCode3.getText().toString().trim().isEmpty() || inputCode4.getText().toString().trim().isEmpty()){
                    int color = R.color.foreGround;
                    buttonVerify.setForeground(new ColorDrawable(getResources().getColor(color)));
                }
            }
        });
        inputCode3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!charSequence.toString().trim().isEmpty()){
                    inputCode4.requestFocus();
                }
                if(!inputCode1.getText().toString().trim().isEmpty() && !inputCode2.getText().toString().trim().isEmpty() && !inputCode3.getText().toString().trim().isEmpty() && !inputCode4.getText().toString().trim().isEmpty()){
                    buttonVerify.setForeground(null);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(inputCode1.getText().toString().trim().isEmpty() || inputCode2.getText().toString().trim().isEmpty() || inputCode3.getText().toString().trim().isEmpty() || inputCode4.getText().toString().trim().isEmpty()){
                    int color = R.color.foreGround;
                    buttonVerify.setForeground(new ColorDrawable(getResources().getColor(color)));
                }
            }
        });
        inputCode4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                buttonVerify.setForeground(null);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(inputCode1.getText().toString().trim().isEmpty() || inputCode2.getText().toString().trim().isEmpty() || inputCode3.getText().toString().trim().isEmpty() || inputCode4.getText().toString().trim().isEmpty()){
                    int color = R.color.foreGround;
                    buttonVerify.setForeground(new ColorDrawable(getResources().getColor(color)));
                }
            }
        });
    }
}