package com.example.myapplication.Model.Serverce;

public class Client {
    public static final String URL_001="http://192.168.143.2:8080/";
    public static APIService getAPIService(){
        return GetClient.GetClient(URL_001).create(APIService.class);
    }

}
