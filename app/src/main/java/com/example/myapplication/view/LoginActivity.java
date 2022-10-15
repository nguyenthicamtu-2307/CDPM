package com.example.myapplication.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.myapplication.R;
import com.example.myapplication.ViewModel.SignupViewModel;

public class LoginActivity extends AppCompatActivity {


    private EditText nameEdit, passEdit;
    private TextView signUpText;
    private Button signInBtn;
    private SignupViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        viewModel = new SignupViewModel(getApplication());
        if (viewModel.getUserData() != null){
                viewModel.getUserData().observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(String s) {
                        if (s != null || s != "") {
                            Intent myIntent = new Intent(LoginActivity.this, BMIActivity.class);
                            startActivity(myIntent);
                        }
                    }
                });
        }

        nameEdit = findViewById(R.id.name);
        passEdit = findViewById(R.id.pass);
        signInBtn = findViewById(R.id.btnSignIn);
        signUpText = findViewById(R.id.signUpText);

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
        String name = nameEdit.getText().toString().trim();
        String pass = passEdit.getText().toString().trim();

        if (name.isEmpty()) {
            nameEdit.setError("name is required");
            nameEdit.requestFocus();
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

        viewModel.Login(name, pass);
    }
}