package com.example.myapplication.Model.AuthModel;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class User_Auth_Model {
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReferenceFromUrl("https://healthy-app-e78bf-default-rtdb.firebaseio.com/");
    private Application application;
    private MutableLiveData<String> UserMutableLiveData;
    private MutableLiveData<Boolean> userLoggedMutableLiveData;




    public MutableLiveData<String> getUserMutableLiveData() {
        return UserMutableLiveData;
    }

    public MutableLiveData<Boolean> getUserLoggedMutableLiveData() {
        return userLoggedMutableLiveData;
    }
    public User_Auth_Model(Application application){
        this.application = application;
        userLoggedMutableLiveData = new MutableLiveData<>();
        UserMutableLiveData = new MutableLiveData<>();

    }

    public void login(String name , String pass){
        databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                if(snapshot.hasChild(name)){
                    final String getPassword = snapshot.child(name).child("password").getValue(String.class);
                    if(getPassword.equals(pass)){
                        UserMutableLiveData.postValue(name);
                        Toast.makeText(application, "Successfully Logged in",Toast.LENGTH_SHORT).show();

                    }else {
                        Toast.makeText(application, "Wrong Password",Toast.LENGTH_SHORT).show();
                    }
                }else {
                    Toast.makeText(application, "Wrong User",Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void register(String name , String pass, String email){
        databaseReference.child("users").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if(snapshot.hasChild(name)){
                    Toast.makeText(application, "The name is already register",Toast.LENGTH_SHORT).show();
                }else {
                    databaseReference.child("users").child(name).child("email").setValue(email);
                    databaseReference.child("users").child(name).child("password").setValue(pass);
                    Toast.makeText(application, "User register successfully",Toast.LENGTH_SHORT).show();
                    UserMutableLiveData.postValue(name);
                }
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error){
            }
        });
    }

    public void signOut(){
        UserMutableLiveData.postValue("");
        userLoggedMutableLiveData.postValue(true);
    }

}


