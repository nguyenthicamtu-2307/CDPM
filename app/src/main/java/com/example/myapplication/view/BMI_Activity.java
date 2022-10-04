package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;

public class BMI_Activity extends AppCompatActivity {

    Button btn;
    EditText height, weight;
    TextView result, nx;

    @SuppressLint("DefaultLocale")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);


        btn = findViewById(R.id.btn);
        height = findViewById(R.id.height);
        weight = findViewById(R.id.weight);
        result = findViewById(R.id.result);
        nx = findViewById(R.id.nhan_xet);

        btn.setOnClickListener(view -> {
            double h, w, res;
            if (height.getText().toString().trim().isEmpty() || weight.getText().toString().trim().isEmpty() || Double.parseDouble(height.getText().toString()) * Double.parseDouble(height.getText().toString()) == 0) {
                height.setText(String.format("%.2f", 0.0));
                weight.setText(String.format("%.2f", 0.0));
                result.setText(String.format("%.2f", 0.0));
                nx.setText(R.string.nh_n_x_t);
            } else {
                h = Double.parseDouble((height.getText()).toString()) / 100;
                w = Double.parseDouble((weight.getText()).toString());
                res = w / (h * h);
                result.setText(String.format("%.2f", res));
                if (res < 18) {
                    nx.setText(R.string.nguoi_gay);
                } else if (res < 24.9) {
                    nx.setText(R.string.binh_thuong);
                } else if (res < 29.9) {
                    nx.setText(R.string.beo_phi_1);
                } else if (res < 34.9) {
                    nx.setText(R.string.beo_phi_2);
                } else {
                    nx.setText(R.string.beo_phi_3);
                }
            }
        });
    }
}