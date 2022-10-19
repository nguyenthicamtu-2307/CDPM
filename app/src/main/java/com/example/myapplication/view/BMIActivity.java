package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myapplication.Model.BimModel.BmiModel;
import com.example.myapplication.R;
import com.example.myapplication.ViewModel.BmiViewModel;
import com.example.myapplication.ViewModel.SignupViewModel;

public class BMIActivity extends AppCompatActivity {
    private EditText weightEdit,heightEdit;
    private Button btnBmi;
    private ImageButton logout;
    private TextView result,nx;
    private SignupViewModel viewModel;
    private BmiViewModel bmiViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bimbackup);
        weightEdit=findViewById(R.id.editWeigh);
        heightEdit=findViewById(R.id.editWeigh);
        btnBmi=findViewById(R.id.imageButton2);
//        logout = findViewById(R.id.signOut);
//        result=findViewById(R.id.result);
//        nx=findViewById(R.id.nhan_xet);


        viewModel = new SignupViewModel(getApplication());
        bmiViewModel = new BmiViewModel(getApplication());

        viewModel.getLoggedStatus().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean ){
                    Intent myIntent = new Intent(BMIActivity.this, LoginActivity.class);
                    startActivity(myIntent);
                }
            }
        });

        btnBmi.setOnClickListener(this::onClick);
//        logout.setOnClickListener(this::onClick);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signOut:
                viewModel.logout();
                break;
            case R.id.imageButton2:
                insertBmi();
                break;
        }
    }

    public void insertBmi(){
        String weightstring = weightEdit.getText().toString().trim();
        String heightstring = heightEdit.getText().toString().trim();
        if (weightstring.isEmpty()) {
            weightEdit.setError("weight is required");
            weightEdit.requestFocus();
            return;
        }

        if (heightstring.isEmpty()) {
            heightEdit.setError("height is required");
            heightEdit.requestFocus();
            return;
        }
        Double weight =Double.parseDouble(weightEdit.getText().toString().trim()) ;
        Double height =Double.parseDouble(heightEdit.getText().toString().trim());


        Double heightt = height/100 ;
        Double BMI = weight/(heightt*heightt);

        Drawable drawable = getDrawable(R.drawable.vienbotron);
        GradientDrawable gradientDrawable = (GradientDrawable) drawable;

        if (BMI < 18.5){
            gradientDrawable.setStroke(50, Color.BLUE);
        } else {
            if (BMI < 25) {
                gradientDrawable.setStroke(50, Color.GREEN);
            }else {
                if (BMI < 30){
                    gradientDrawable.setStroke(50, Color.YELLOW);
                }else {
                    gradientDrawable.setStroke(50, Color.RED);
                }
            }
        }
        Intent myIntent = new Intent(BMIActivity.this, BIMActivity_02.class);
        myIntent.putExtra("weight", weight);
        myIntent.putExtra("height", height);
        startActivity(myIntent);
    }

}