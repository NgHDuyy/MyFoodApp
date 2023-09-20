package com.example.myfoodapp.utils.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {
    private final SharedPreferences sharedPreferences;
    private final StringHelper stringHelper;

    public PreferenceHelper(Context context) {
        sharedPreferences = context.getSharedPreferences("preferencesHelper", Context.MODE_PRIVATE);
        stringHelper = new StringHelper();
    }

    public boolean isLogin() {
        return sharedPreferences.getBoolean(stringHelper.IsLogin, true);
    }

    public void setIsLogin(Boolean value) {
        sharedPreferences.edit().putBoolean(stringHelper.IsLogin, value).apply();
    }


}

class StringHelper {
    public String IsLogin = "IsLogin";
}
