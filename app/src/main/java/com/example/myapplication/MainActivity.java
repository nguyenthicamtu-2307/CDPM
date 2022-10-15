package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.myapplication.view.LoginActivity;

public class MainActivity extends AppCompatActivity {

    private Button Logout;
    private LoginViewModels viewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Logout = (Button) findViewById(R.id.Logout);

        viewModel = new LoginViewModels(getApplication());

        viewModel.getLoggedStatus().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean){
                    Intent myIntent = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(myIntent);
                }
            }
        });

        Logout.setOnClickListener(this::onClick);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.Logout:
                viewModel.signout();
                break;
        }
    }
}