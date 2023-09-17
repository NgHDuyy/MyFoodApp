package com.example.myfoodapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.myfoodapp.R;
import com.example.myfoodapp.databinding.ActivitySignInBinding;

public class SignInActivity extends AppCompatActivity {
    private ActivitySignInBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        binding=ActivitySignInBinding.inflate( getLayoutInflater() );
        View view =binding.getRoot();
        setContentView( view );
        onClickLisner();
    }

    private void onClickLisner() {
        binding.tvForgetPass.setOnClickListener( view -> {
            Intent intent = new Intent(SignInActivity.this,ForgetPasswordActivity2.class );
            startActivity( intent );
        } );
        binding.tvSignUp.setOnClickListener( view -> {
            Intent intent= new Intent(SignInActivity.this,SignUpActivity.class);
            startActivity( intent );
        } );
    }
}