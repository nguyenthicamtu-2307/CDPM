package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.ViewModel.SignupViewModel;

public class SignupActivity extends AppCompatActivity {

    private EditText emailEdit, passEdit, passfirmEdit, nameEdit;
    private Button signUp;
    private TextView signIn;
    private SignupViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        viewModel = new SignupViewModel(getApplication());
        if (viewModel.getUserData() != null){
            viewModel.getUserData().observe(this, new Observer<String>() {
                @Override
                public void onChanged(String s) {
                    if (s != null || s != "") {
                        Intent myIntent = new Intent(SignupActivity.this, BMIActivity.class);
                        startActivity(myIntent);
                    }
                }
            });
        }


        signUp = (Button) findViewById(R.id.btnSignUp);
        nameEdit = (EditText) findViewById(R.id.name);
        emailEdit = (EditText) findViewById(R.id.email);
        passEdit = (EditText) findViewById(R.id.pass);
        passfirmEdit = (EditText) findViewById(R.id.passconfirm);
        signIn = (TextView) findViewById(R.id.btnSignIn);

        signIn.setOnClickListener(this::onClick);
        signUp.setOnClickListener(this::onClick);

    }
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnSignIn:
                startActivity(new Intent(this, LoginActivity.class));
                break;
            case R.id.btnSignUp:
                register();
                break;
        }
    }

    public void register(){
        final String name = nameEdit.getText().toString().trim();
        final String email = emailEdit.getText().toString().trim();
        final String password = passEdit.getText().toString().trim();
        final String conpass = passfirmEdit.getText().toString().trim();

        if (name.isEmpty()) {
            nameEdit.setError("name is required");
            nameEdit.requestFocus();
            return;
        }
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

        if (password.isEmpty()) {
            passEdit.setError("password is required");
            passEdit.requestFocus();
            return;
        }

        if (password.length() < 6) {
            passEdit.setError("Min password length should be 6 characters");
            passEdit.requestFocus();
            return;
        }
        if(conpass.isEmpty()){
            passfirmEdit.setError("confirm password is required");
            return;
        }
        if(!password.equals(conpass)){
            passfirmEdit.setError("Passwords are not matching ");
            return;
        }

        viewModel.signup(name, password, email);
    }

}
