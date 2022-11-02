package com.example.myapplication.Model.BimModel;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;


import com.example.myapplication.ViewModel.SignupViewModel;
import com.example.myapplication.view.APP.SessionManager;

import com.example.myapplication.view.BIMActivity_02;
import com.example.myapplication.view.BMIActivity;
import com.example.myapplication.view.LoginActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.zip.DeflaterOutputStream;

public class BmiModel extends AppCompatActivity {


    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://healthy-app-e78bf-default-rtdb.firebaseio.com/");
    private Application application;
    public SessionManager sessionManager;
    public String UserName;

    public MutableLiveData<Double> weight_out, height_out;

    public MutableLiveData<Double> getWeight_out(){
        return weight_out;
    }

    public MutableLiveData<Double> getHeight_out(){
        return height_out;
    }

    public BmiModel(Application application) {
        this.application = application;
        height_out = new MutableLiveData<Double>();
        weight_out = new MutableLiveData<Double>();

        sessionManager = new SessionManager(application);
        HashMap<String, String> user = sessionManager.getUserDetail();
        UserName = user.get(sessionManager.USERNAME);

    }


    public void insertBmi(Double weight , Double height ){
        databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                    databaseReference.child("users").child(UserName).child("weight").setValue(weight);
                    databaseReference.child("users").child(UserName).child("height").setValue(height);
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error){
            }
        });
    }


    public void view_wei_hei(){
        databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                    Double weight = snapshot.child(UserName).child("weight").getValue(Double.class);
                    Double height = snapshot.child(UserName).child("height").getValue(Double.class);
                    weight_out.setValue(weight);
                    height_out.setValue(height);
                Toast.makeText(application, "weight" + weight_out.getValue(),Toast.LENGTH_SHORT).show();
                Toast.makeText(application, "height" + height_out.getValue(),Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}
