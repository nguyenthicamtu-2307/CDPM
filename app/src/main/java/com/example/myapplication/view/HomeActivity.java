package com.example.myapplication.view;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.myapplication.R;
import com.example.myapplication.ViewModel.ViewAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    private BottomNavigationView navigationView;
    private ViewPager mview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
         navigationView=findViewById(R.id.bottom_nav);
         mview=findViewById(R.id.viewpager);
         setMview();
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
//                        Toast.makeText(HomeActivity.this, "Home", Toast.LENGTH_SHORT).show();
                        mview.setCurrentItem(0);
                    case R.id.action_setting:
//                        Toast.makeText(HomeActivity.this, "setting", Toast.LENGTH_SHORT).show();
                        mview.setCurrentItem(1);
                    case R.id.menu:
//                        Toast.makeText(HomeActivity.this, "thực đơn", Toast.LENGTH_SHORT).show();
                        mview.setCurrentItem(2);
                }
                return true;
            }
        });
    }
    private void setMview(){
        ViewAdapter viewAdapter=new ViewAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mview.setAdapter(viewAdapter);
      mview.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
          @Override
          public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

          }

          @Override
          public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        navigationView.getMenu().findItem(R.id.action_home).setChecked(true);
                        break;
                    case 1:
                        navigationView.getMenu().findItem(R.id.menu).setChecked(true);
                        break;
                    case 2:
                        navigationView.getMenu().findItem(R.id.action_setting).setChecked(true);
                        break;
                }
          }

          @Override
          public void onPageScrollStateChanged(int state) {

          }
      });
    }
}