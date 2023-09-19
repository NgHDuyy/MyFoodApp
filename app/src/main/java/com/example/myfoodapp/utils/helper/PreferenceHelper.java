package com.example.myfoodapp.utils.helper;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.myfoodapp.model.User;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class PreferenceHelper {
    private final SharedPreferences sharedPreferences;
    private final String IsLogin = "isLogin";
    private final String User = "user";

    public PreferenceHelper(Context context) {
        sharedPreferences = context.getSharedPreferences("preferencesHelper", Context.MODE_PRIVATE);
    }
    public Boolean isLogin() {
        return sharedPreferences.getBoolean(IsLogin, false);
    }

    public void setIsLogin(Boolean isLogin) {
        sharedPreferences.edit().putBoolean(IsLogin, isLogin).apply();
    }

    public String getUserInfo(int type) {
        User user;
        String strUser = sharedPreferences.getString(User, "");
        try {
            user = new Gson().fromJson(strUser, User.class);
        } catch (JsonSyntaxException e) {
            user = null;
        }
        if (user != null){
            switch (type){
                case 0: return user.getId();
                case 1: return user.getEmail();
                default: return "";
            }
        } else return "";
    }

    public User getUser(){
        User user;
        String strUser = sharedPreferences.getString(User, "");
        try {
            user = new Gson().fromJson(strUser, User.class);
        } catch (JsonSyntaxException e) {
            user = new User();
        }
        return user;
    }
    public void setUser(String strUser) {
        sharedPreferences.edit().putString(User, strUser).apply();
    }
    public void dangXuat() {
        sharedPreferences.edit()
                .putString("user", null)
                .apply();
    }






}
