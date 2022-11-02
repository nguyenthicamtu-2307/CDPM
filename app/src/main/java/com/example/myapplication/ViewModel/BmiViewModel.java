package com.example.myapplication.ViewModel;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.Model.BimModel.BmiModel;
import com.example.myapplication.view.APP.SessionManager;

import java.util.HashMap;

public class BmiViewModel {
    private BmiModel repository;
    public MutableLiveData<Double> weight_out, height_out;

    public MutableLiveData<Double> getWeight_out(){
        return weight_out;
    }

    public MutableLiveData<Double> getHeight_out(){
        return height_out;
    }



    public BmiViewModel(@NonNull Application application) {
        repository = new BmiModel(application);
    }
    public void insertBmi(Double weight , Double height){
        repository.insertBmi(weight, height);
    }
    public void view_wei_hei(){
        repository.view_wei_hei();
        height_out = repository.getHeight_out();
        weight_out = repository.getWeight_out();
    }
}
