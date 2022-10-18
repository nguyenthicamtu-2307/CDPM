package com.example.myapplication.view.APP;

import static android.content.Context.MODE_PRIVATE;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {

    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public Context context;
    int PRIVATE_MODE = 0;

    private static final String PREF_NAME = "LOGIN";
    private static final String LOGIN = "IS_LOGIN";
    public static final String NAME = "USERNAMe";
    public static final String USERNAME = "NAME";
    public static final String EMAIL = "EMAIL";
    public static final String ID = "ID";
    public static final String PASSWORD = "PASSWORD";
    public static final String PHONE = "PHONE";
    public static final String DATEOFBIRTH = "DATEOFBIRTH";
    public static final String ADDRESS = "ADDRESS";
    public static final String ADDRESSSPECIFIC = "ADDRESSSPECIFIC";


    public SessionManager(Context context){
        this.context = context;
        sharedPreferences = context.getSharedPreferences("LOGIN", PRIVATE_MODE);
        editor = sharedPreferences.edit();
    }

    public void createSession(String username){

//        editor.putBoolean(LOGIN,true);
        editor.putString(USERNAME,username);
//        editor.putString(EMAIL,email);
//        editor.putString(PHONE,phone);
//        editor.putString(DATEOFBIRTH,dateofbirth);
//        editor.putString(ID,id);
        editor.commit();
    }

//     public void createSession(String name, String email,String phone,String dateofbirth,String id){
//
//        editor.putBoolean(LOGIN,true);
//        editor.putString(NAME,name);
//        editor.putString(EMAIL,email);
//        editor.putString(PHONE,phone);
//        editor.putString(DATEOFBIRTH,dateofbirth);
//        editor.putString(ID,id);
//        editor.apply();
//     }

//    public void createSession2(String name, String phone,String address, String addressSpecific,String id){
//
//        editor.putBoolean(LOGIN,true);
//        editor.putString(NAME,name);
//        editor.putString(PHONE,phone);
//        editor.putString(ADDRESS,address);
//        editor.putString(ADDRESSSPECIFIC,addressSpecific);
//        editor.putString(ID,id);
//
//        editor.apply();
//    }

     public boolean isLoggin(){
        return sharedPreferences.getBoolean(LOGIN,false);
     }

//    public void checked(){
//        if(this.isLoggin()){
//            Intent i =new Intent(context, Signin.class);
//            context.startActivity(i);
//            ((Home)context).finish();
//        }
//    }

    public HashMap<String, String> getUserDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(USERNAME,sharedPreferences.getString(USERNAME,null));
//        user.put(NAME,sharedPreferences.getString(NAME,null));
//        user.put(EMAIL,sharedPreferences.getString(EMAIL,null));
//        user.put(PASSWORD,sharedPreferences.getString(PASSWORD,null));
//        user.put(PHONE,sharedPreferences.getString(PHONE,null));
//        user.put(DATEOFBIRTH,sharedPreferences.getString(DATEOFBIRTH,null));
//        user.put(ID,sharedPreferences.getString(ID,null));

        return user;
    }
//    public HashMap<String, String> getUserDetail2(){
//        HashMap<String,String> user = new HashMap<>();
//        user.put(NAME,sharedPreferences.getString(NAME,null));
//        user.put(PHONE,sharedPreferences.getString(PHONE,null));
//        user.put(ADDRESS,sharedPreferences.getString(ADDRESS,null));
//        user.put(ADDRESSSPECIFIC,sharedPreferences.getString(ADDRESSSPECIFIC,null));
//        user.put(ID,sharedPreferences.getString(ID,null));
//
//        return user;
//    }
//    public void Logout(){
//        editor.clear();
//        editor.commit();
//        Intent i =new Intent(context, DangNhap.class);
//        context.startActivity(i);
//        ((Profile)context).finish();
//    }
//    public void Login(){
//        editor.putString("remember","true");
//        editor.apply();
//        Intent i =new Intent(context, TrangChu.class);
//        context.startActivity(i);
//        ((DangNhap)context).finish();
//    }
}
