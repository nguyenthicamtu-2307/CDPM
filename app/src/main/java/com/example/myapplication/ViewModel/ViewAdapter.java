package com.example.myapplication.ViewModel;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.myapplication.ViewModel.Fragment.HomeFragment;
import com.example.myapplication.ViewModel.Fragment.Menufragment;
import com.example.myapplication.ViewModel.Fragment.Settingfragment;

public class ViewAdapter extends FragmentStatePagerAdapter {


    public ViewAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return  new HomeFragment();
            case 1:
                return new Menufragment();
            case 2:
                return new Settingfragment();
            default:
                return new HomeFragment();
        }

    }

    @Override
    public int getCount() {
        return 3;
    }
}
