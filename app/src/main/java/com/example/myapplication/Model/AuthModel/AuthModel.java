package com.example.myapplication.Model.AuthModel;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.Application;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

import com.example.myapplication.view.BMIActivity;
import com.example.myapplication.view.LoginActivity;
import com.example.myapplication.view.SignupActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

public class AuthModel extends AppCompatActivity {

    private Application application;
    private MutableLiveData<FirebaseUser> firebaseUserMutableLiveData;
    private MutableLiveData<Boolean> userLoggedMutableLiveData;
    private FirebaseAuth auth;

    public MutableLiveData<FirebaseUser> getFirebaseUserMutableLiveData() {
        return firebaseUserMutableLiveData;
    }

    public MutableLiveData<Boolean> getUserLoggedMutableLiveData() {
        return userLoggedMutableLiveData;
    }

    public AuthModel(Application application){
        this.application = application;
        firebaseUserMutableLiveData = new MutableLiveData<>();
        userLoggedMutableLiveData = new MutableLiveData<>();
        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null){
            firebaseUserMutableLiveData.postValue(auth.getCurrentUser());
        }
    }

    public void login(String email , String pass){

        auth = FirebaseAuth.getInstance();
        auth.signInWithEmailAndPassword(email, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    firebaseUserMutableLiveData.postValue(auth.getCurrentUser());
                    Toast.makeText(application, "Login Thành Công", Toast.LENGTH_SHORT).show();

                }else{
                    Toast.makeText(application, "Failed to login", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void register(String email , String pass){
        auth.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            User user = new User(email);
                            FirebaseDatabase.getInstance().getReference("Users")
                                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                                    .setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            if(task.isSuccessful()){
                                                Toast.makeText(application, "User has been register successfully", Toast.LENGTH_LONG).show();
                                            }else {
                                                Toast.makeText(application, "Failed to register ! Try again!", Toast.LENGTH_LONG).show();
                                            }
                                        }
                                    });
                        }else {
                            Toast.makeText(application, "Failed to register !", Toast.LENGTH_LONG).show();
                        }
                    }
                });
    }

    public void signOut(){
        auth.signOut();
        userLoggedMutableLiveData.postValue(true);
    }

}

