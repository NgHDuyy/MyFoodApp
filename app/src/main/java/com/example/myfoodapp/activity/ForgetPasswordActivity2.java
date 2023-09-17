package com.example.myfoodapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.myfoodapp.R;
import com.example.myfoodapp.databinding.ActivityForgetPassword2Binding;

public class ForgetPasswordActivity2 extends AppCompatActivity {
    private ActivityForgetPassword2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        binding = ActivityForgetPassword2Binding.inflate( getLayoutInflater() );
        View view = binding.getRoot();
        setContentView( view );
        onClickListen();
    }

    private void onClickListen() {
        binding.icBack.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        } );
    }
}