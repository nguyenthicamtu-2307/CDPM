package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myapplication.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Timer;
import java.util.TimerTask;

public class WalkthroughActivity extends AppCompatActivity {
    private Timer mtime;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_walkthrough);
        mtime=new Timer();
        mtime.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent=new Intent(WalkthroughActivity.this,LoginActivity.class);
                startActivity(intent);
                finish();
            }
        },3000);

    }
}