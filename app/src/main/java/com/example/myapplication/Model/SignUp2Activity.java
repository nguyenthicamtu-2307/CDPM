package com.example.myapplication.Model;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class SignUp2Activity extends AppCompatActivity {
    private Button btnSignIn,btnSignUp;
    private EditText edtname, edtDob, edtPhone, edtEmail;
    private User userSignUp;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up2);
        getSupportActionBar().hide();
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        btnSignIn = findViewById(R.id.btnSignIn);
        edtname=(EditText) findViewById(R.id.edtname);
        edtDob=(EditText) findViewById(R.id.edtdob);
        edtPhone=(EditText) findViewById(R.id.edtsdt);
        edtEmail=(EditText) findViewById(R.id.edtemail);
        btnSignUp=(Button) findViewById(R.id.btnSignUp);
        Bundle bundle =getIntent().getExtras();
        if (bundle!=null)
        {
            User user=new User();
            Log.e("User not null", "User not null");
            user= (User) bundle.get("objectNewUser");
            if (user!=null){
                userSignUp=user;
                Log.e("User transfer", userSignUp.getUserName()+" "+ userSignUp.getPassWord());
            }
        }
        else{
            Log.e("User null", "User null");
        }
        edtDob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PickDate();
            }
        });
        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("User", userSignUp.getUserName()+" "+userSignUp.getPassWord());
                String hoten=edtname.getText().toString();
                String txtdob= edtDob.getText().toString();
                Date dob=new Date(txtdob);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                String Dob = formatter.format(dob);
                String phone=edtPhone.getText().toString();
                String email=edtEmail.getText().toString();
                userSignUp.setHoTen(hoten);
                userSignUp.setEmail(email);
                userSignUp.setSdt(phone);
                userSignUp.setNgaySinh(Dob);
                Log.e("User SignUp",userSignUp.getUserName()+" "+userSignUp.getHoTen());
                clickSignUp(userSignUp);
            }
        });
        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUp2Activity.this,SignInActivity.class);
                startActivity(intent);
            }
        });
    }
    private void clickSignUp(User newUser)
    {

    }
    private void PickDate(){
        final Calendar calendar=Calendar.getInstance();
        int ngay=calendar.get(Calendar.DATE);
        int thang=calendar.get(Calendar.MONTH);
        int nam=calendar.get(Calendar.YEAR);
        DatePickerDialog datePick=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(year, month, dayOfMonth);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("MM/dd/yyyy");
                edtDob.setText(simpleDateFormat.format(calendar.getTime()));
            }
        },nam,thang,ngay);
        datePick.show();
    }
}
