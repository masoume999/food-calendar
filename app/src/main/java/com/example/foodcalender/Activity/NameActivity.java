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
import android.widget.Toast;

import com.example.foodcalender.R;

public class NameActivity extends AppCompatActivity {
    public static String User_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        final EditText inputName = findViewById(R.id.inputName);
        final Button buttonSubmit = findViewById(R.id.buttonSubmit);

        inputName.addTextChangedListener(new TextWatcher(){
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { }
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(!inputName.getText().toString().trim().isEmpty()){
                    buttonSubmit.setForeground(null);
                    return;
                }
                if(inputName.getText().toString().trim().isEmpty()){
                    int color = R.color.foreGround;
                    buttonSubmit.setForeground(new ColorDrawable(getResources().getColor(color)));
                    return;
                }
            }
            @Override
            public void afterTextChanged(Editable editable) { }
        });

        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(inputName.getText().toString().trim().isEmpty()){
                    Toast.makeText(NameActivity.this,"نام را وارد کنید",Toast.LENGTH_SHORT).show();
                    return;
                }

                User_name=inputName.getText().toString();
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                intent .putExtra("name",inputName.getText().toString());
                startActivity(intent);
            }
        });
    }
}
