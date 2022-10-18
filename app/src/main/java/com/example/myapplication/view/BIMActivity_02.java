package com.example.myapplication.view;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.myapplication.Model.BimModel.BmiModel;
import com.example.myapplication.R;
import com.example.myapplication.ViewModel.BmiViewModel;

public class BIMActivity_02 extends AppCompatActivity {

    public TextView BMIText, NhanxtText;
    private BmiViewModel bmiViewModel;
    private ImageButton imageBack;
    public LinearLayout layout;
    public Button btnGoOn;
    public Double weight, height;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);

        bmiViewModel = new BmiViewModel(getApplication());
        BMIText = (TextView) findViewById(R.id.txtBMI);
        NhanxtText = (TextView) findViewById(R.id.txtNhanxet);
        imageBack = (ImageButton) findViewById(R.id.back);
        layout = (LinearLayout) findViewById(R.id.layouttron);
        btnGoOn = (Button) findViewById(R.id.btnGoOn);
        view_BMI();

        imageBack.setOnClickListener(this::onClick);
        btnGoOn.setOnClickListener(this::onClick);

    }

    public void onClick(View v){
        switch (v.getId()) {
            case R.id.back:
                startActivity(new Intent(this, BMIActivity.class));
                break;
            case R.id.btnGoOn:
                bmiViewModel.insertBmi(weight,height);
                break;
        }
    }

    public void view_BMI(){

        weight = getIntent().getDoubleExtra("weight", 0);
        height = getIntent().getDoubleExtra("height", 0);

        Double heightt = height/100 ;
        Double BMI = weight/(heightt*heightt);
        double result = Math.round(BMI*100.0)/100.0;
        BMIText.setText(String.valueOf(result));

        if (BMI < 18.5){
            NhanxtText.setText("Bạn bị thiếu cân!");
        } else {
            if (BMI < 25) {
                NhanxtText.setText("Cơ thể bạn ở trạng thái bình thường!");
            }else {
                if (BMI < 30){
                    NhanxtText.setText("Cơ thể bạn đang thừa cân!");
                }else {
                    NhanxtText.setText("Báo động: Cơ thể bạn đang béo phì!");
                }
            }
        }

    }
}
