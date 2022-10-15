package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.ViewModel.SignupViewModel;

public class BMIActivity extends AppCompatActivity {
    private EditText weightt,heightt;
    private Button BMI;
    private ImageButton logout;
    private TextView result,nx;
    private SignupViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiactivity);
        weightt=findViewById(R.id.weight);
        heightt=findViewById(R.id.height);
        BMI=findViewById(R.id.btn);
        logout = findViewById(R.id.signOut);
        result=findViewById(R.id.result);
        nx=findViewById(R.id.nhan_xet);


        viewModel = new SignupViewModel(getApplication());
        viewModel.getLoggedStatus().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean ){
                    Intent myIntent = new Intent(BMIActivity.this, LoginActivity.class);
                    startActivity(myIntent);
                }
            }
        });


        BMI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double cn =Double.parseDouble(weightt.getText().toString().trim()) ;
                Double cc =Double.parseDouble( heightt.getText().toString().trim());
                Double BMI= Double.valueOf(Math.round( cn/(cc*cc)));
                result.setText(String.valueOf(BMI));
                if (BMI <18.5){
                    nx.setText("Bạn đang bị thiếu cân");
                }else {
                    if (18.5<BMI && BMI <24.9){
                        nx.setText("Bình thường");
                    }else {
                        nx.setText("bạn đang bị thừa cân");
                    }
                }

            }
        });

        logout.setOnClickListener(this::onClick);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signOut:
                viewModel.logout();
                break;
        }
    }

}