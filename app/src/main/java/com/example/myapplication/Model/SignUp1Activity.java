package com.example.myapplication.Model;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class SignUp1Activity extends AppCompatActivity {
    private Button btnNext, btnSignIn;
    private EditText txtUsername;
    private EditText txtPassword;
    private EditText txtPassword2nd;
    private User userSignUp;
    private String existUser;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup1);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        txtUsername = (EditText) findViewById(R.id.edtuser);
        txtPassword = (EditText) findViewById(R.id.edtpw);
        txtPassword2nd = (EditText) findViewById(R.id.edtcpw);
        btnNext =findViewById(R.id.btnnext);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=txtUsername.getText().toString().trim();
                String password=txtPassword.getText().toString().trim();
                String password2nd=txtPassword2nd.getText().toString().trim();
                if (!username.isEmpty() && !password.isEmpty() && !password2nd.isEmpty()){
                    if (password.equals(password2nd))
                    {
                        clickNext(username, MD5.md5(password));
                    }
                    else
                    {
                        Toast.makeText(SignUp1Activity.this, "Xác nhận mật khẩu không chính xác. Vui lòng nhập lại", Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(SignUp1Activity.this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                    Log.e("No full info Error", "Error no full info");
                    return;
                }
            }
        });
        btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp1Activity.this,SignInActivity.class);
                startActivity(intent);
            }
        });
    }
    private void clickNext(String username, String password){

    }
}
