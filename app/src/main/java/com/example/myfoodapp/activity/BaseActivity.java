package com.example.myfoodapp.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.myfoodapp.utils.helper.PreferenceHelper;
import com.example.myfoodapp.utils.livedata.AppViewModel;

public class BaseActivity extends AppCompatActivity {
    PreferenceHelper preferenceHelper;
    AppViewModel viewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        preferenceHelper = new PreferenceHelper(this);
        viewModel = new ViewModelProvider(this).get(AppViewModel.class);
    }
}
