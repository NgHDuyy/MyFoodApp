package com.example.myfoodapp.utils.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {
    private final SharedPreferences sharedPreferences;
    private final String IsLogin = "isLogin";

    public PreferenceHelper(Context context) {
        sharedPreferences = context.getSharedPreferences("preferencesHelper", Context.MODE_PRIVATE);
    }
    public Boolean isLogin() {
        return sharedPreferences.getBoolean(IsLogin, false);
    }
}
