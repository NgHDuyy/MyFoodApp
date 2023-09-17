package com.example.myfoodapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myfoodapp.R;
import com.example.myfoodapp.databinding.ActivitySignUpBinding;

public class SignUpActivity extends AppCompatActivity {
    private ActivitySignUpBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        binding=ActivitySignUpBinding.inflate( getLayoutInflater() );
        View view= binding.getRoot();
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
        binding.tvSignIn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this,SignInActivity.class );
                startActivity( intent );
            }
        } );
    }
}