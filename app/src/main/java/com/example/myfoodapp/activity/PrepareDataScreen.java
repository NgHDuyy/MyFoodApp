package com.example.myfoodapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.myfoodapp.R;

public class PrepareDataScreen extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prepare_data_screen);

        getListFood();
        getHistoryOrder();
        new Handler().postDelayed(()->{
            startActivity(new Intent(this, MainActivity.class));
            finish();
        }, 1000);
    }

    private void getListFood() {

    }

    private void getHistoryOrder() {

    }
}