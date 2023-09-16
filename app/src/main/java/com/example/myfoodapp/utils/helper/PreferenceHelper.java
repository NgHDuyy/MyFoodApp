package com.example.myfoodapp.utils.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceHelper {
    private final SharedPreferences sharedPreferences;

    public PreferenceHelper(Context context) {
        sharedPreferences = context.getSharedPreferences("preferencesHelper", Context.MODE_PRIVATE);
    }
}
