package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.myapplication.R;
import com.example.myapplication.ViewModel.SignupViewModel;
import com.google.firebase.auth.FirebaseAuth;

public class SignupActivity extends AppCompatActivity implements View.OnClickListener {

    private FirebaseAuth mAuth;
    private EditText emailEdit, passEdit, passfirm;
    private Button signUp, signIn;
    private SignupViewModel viewModel;
    private ProgressBar progressBar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        signUp = (Button) findViewById(R.id.btnSignUp);
        emailEdit = (EditText) findViewById(R.id.email);
        passEdit = (EditText) findViewById(R.id.pass);
        passfirm = (EditText) findViewById(R.id.passconfirm);

        signUp.setOnClickListener(this);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnSignUp:
                registerUser();
                break;
        }

    }

    public void registerUser(){
        String email = emailEdit.getText().toString().trim();
        String pass = passEdit.getText().toString().trim();
        String pass2 = passfirm.getText().toString().trim();

        if(email.isEmpty()){
            emailEdit.setError("email is required");
            emailEdit.requestFocus();
            return;
        }
        if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            emailEdit.setError("Please provide valid email");
            emailEdit.requestFocus();
            return;
        }

        if(pass.isEmpty()){
            passEdit.setError("email is required");
            passEdit.requestFocus();
            return;
        }

        if(pass.length() < 6){
            passEdit.setError("Min password length should be 6 characters");
            passEdit.requestFocus();
            return;
        }

//        if(pass2 != pass ){
//            passfirm.setError("Password confirm is not true");
//            passfirm.requestFocus();
//            return;
//        }

        viewModel = new SignupViewModel(getApplication());
            viewModel.signup(email, pass);
    }
}