package com.example.myapplication.ViewModel;

import android.app.Application;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.Model.AuthModel.AuthModel;
import com.google.firebase.auth.FirebaseUser;

public class LoginViewModels {

    private AuthModel repository;
    private MutableLiveData<FirebaseUser> userData;
    private MutableLiveData<Boolean> loggedStatus;

    public MutableLiveData<FirebaseUser> getUserData() {
        return userData;
    }

    public MutableLiveData<Boolean> getLoggedStatus() {
        return loggedStatus;
    }

    public LoginViewModels(@NonNull Application application) {
        repository = new AuthModel(application);
        userData = repository.getFirebaseUserMutableLiveData();
        loggedStatus = repository.getUserLoggedMutableLiveData();
    }

    public void signIn(String email , String pass){
        repository.login(email, pass);
    }
    public void signout(){
        repository.signOut();
    }
}


