package com.example.myapplication.view;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.ViewModel.LoginViewModels;
import com.example.myapplication.ViewModel.SignupViewModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEdit, passEdit;
    private TextView signUpText;
    private Button signInBtn;
    private FirebaseAuth mAuth;
    private LoginViewModels viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailEdit = findViewById(R.id.email);
        passEdit = findViewById(R.id.pass);
        signInBtn = findViewById(R.id.btnSignIn);
        signUpText = findViewById(R.id.signUpText);


        viewModel = new LoginViewModels(getApplication());

        viewModel.getUserData().observe(this, new Observer<FirebaseUser>() {
            @Override
            public void onChanged(FirebaseUser firebaseUser) {
                if (firebaseUser != null){
                    Intent myIntent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(myIntent);
                }
            }
        });

        signUpText.setOnClickListener(this::onClick);
        signInBtn.setOnClickListener(this::onClick);


    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.signUpText:
                startActivity(new Intent(this, SignupActivity.class));
                break;

            case R.id.btnSignIn:
                userLogin();
                break;

        }
    }

    public void userLogin() {
        String email = emailEdit.getText().toString().trim();
        String pass = passEdit.getText().toString().trim();


        if (email.isEmpty()) {
            emailEdit.setError("email is required");
            emailEdit.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            emailEdit.setError("Please provide valid email");
            emailEdit.requestFocus();
            return;
        }

        if (pass.isEmpty()) {
            passEdit.setError("email is required");
            passEdit.requestFocus();
            return;
        }

        if (pass.length() < 6) {
            passEdit.setError("Min password length should be 6 characters");
            passEdit.requestFocus();
            return;
        }

            viewModel.signIn(email, pass);
    }
}