package com.example.myapplication.ViewModel;

import android.app.Application;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.Model.AuthModel.AuthModel;
import com.google.firebase.auth.FirebaseUser;

public class SignupViewModel {

    private AuthModel repository;
    private MutableLiveData<FirebaseUser> userData;
    private MutableLiveData<Boolean> loggedStatus;

    public SignupViewModel(@NonNull Application application) {
        repository = new AuthModel(application);
        userData = repository.getFirebaseUserMutableLiveData();
        loggedStatus = repository.getUserLoggedMutableLiveData();
    }

    public void signup(String email , String pass){
        repository.register(email, pass);

    }
}
