package com.example.myapplication.view;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.myapplication.R;

import org.jetbrains.annotations.NotNull;

import io.ghyeok.stickyswitch.widget.StickySwitch;

public class GenderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gender);
        ImageView female = findViewById(R.id.female_gender);
        ImageView male = findViewById(R.id.male_gender);

        StickySwitch stickySwitch = (StickySwitch) findViewById(R.id.sticky_switch);
        stickySwitch.setOnSelectedChangeListener(new StickySwitch.OnSelectedChangeListener() {
            @Override
            public void onSelectedChange(@NotNull StickySwitch.Direction direction, @NotNull String text) {
                if (direction.equals(StickySwitch.Direction.RIGHT)) {
                    stickySwitch.setSliderBackgroundColor(getResources().getColor(R.color.switch_pink));
                    stickySwitch.setSwitchColor(getResources().getColor(R.color.switch_green));
                    female.setImageResource(R.drawable.male);
                    male.setImageResource(R.drawable.female);
                } else {
                    stickySwitch.setSliderBackgroundColor(getResources().getColor(R.color.switch_green));
                    stickySwitch.setSwitchColor(getResources().getColor(R.color.switch_pink));
                    female.setImageResource(R.drawable.female);
                    male.setImageResource(R.drawable.male);
                }
            }
        });
    }
}