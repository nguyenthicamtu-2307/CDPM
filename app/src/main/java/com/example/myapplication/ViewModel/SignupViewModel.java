package com.example.myapplication.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.Model.AuthModel.User_Auth_Model;

public class SignupViewModel {

    private User_Auth_Model repository;
    private MutableLiveData<Boolean> loggedStatus;
    private MutableLiveData<String> getUserData;


    public MutableLiveData<Boolean> getLoggedStatus() {
        return loggedStatus;
    }
    public MutableLiveData<String> getUserData() {
        return getUserData;
    }


    public SignupViewModel(@NonNull Application application) {
        repository = new User_Auth_Model(application);
        loggedStatus = repository.getUserLoggedMutableLiveData();
        getUserData = repository.getUserMutableLiveData();
    }

    public void Login(String email , String pass){
        repository.login(email, pass);

    }
    public void signup(String name , String pass, String email){
        repository.register(name, pass, email);
    }
    public void logout(){
        repository.signOut();
    }
}
