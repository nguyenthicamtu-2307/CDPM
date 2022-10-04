package com.example.myapplication.ViewModel;

import android.app.Application;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.Model.ConnectFirebase;
import com.google.firebase.auth.FirebaseUser;

public class SignupViewModel extends AndroidViewModel {
    private ConnectFirebase repository;
    private MutableLiveData<FirebaseUser> userData;
    private MutableLiveData<Boolean> loggedStatus;

    public SignupViewModel(@NonNull Application application) {
        super(application);
        repository = new ConnectFirebase(application);
        userData = repository.getFirebaseUserMutableLiveData();
        loggedStatus = repository.getUserLoggedMutableLiveData();
    }


    public MutableLiveData<FirebaseUser> getUserData() {
        return userData;
    }

    public MutableLiveData<Boolean> getLoggedStatus() {
        return loggedStatus;
    }


    @RequiresApi(api = Build.VERSION_CODES.P)
    public void signup(String email, String pass) {
        repository.register(email, pass);
    }


}


