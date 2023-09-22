package com.example.myfoodapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

import com.example.myfoodapp.R;
import com.example.myfoodapp.databinding.ActivitySignInBinding;
import com.example.myfoodapp.model.ResponeObject;
import com.example.myfoodapp.model.User;
import com.example.myfoodapp.utils.apis.ApiHelper;
import com.example.myfoodapp.utils.helper.PreferenceHelper;
import com.example.myfoodapp.utils.listener.StringCallback;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SignInActivity extends AppCompatActivity {
    private ActivitySignInBinding binding;
    private List<User> mListUser = new ArrayList<>();
    private User mUser;
    private PreferenceHelper preferenceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        binding = ActivitySignInBinding.inflate( getLayoutInflater() );
        View view = binding.getRoot();
        preferenceHelper = new PreferenceHelper( this );
        setContentView( view );
        onClickLisner();
    }

    private void onClickLisner() {
        binding.tvSignUp.setOnClickListener( view -> {
            Intent intent = new Intent( SignInActivity.this, SignUpActivity.class );
            startActivity( intent );
        } );
        binding.btnSignIn.setOnClickListener( view -> {
            dangNhap();
        } );

    }

    private void dangNhap() {
        String str_email = binding.edtEmail.getText().toString().trim();
        String str_password = binding.edtPass.getText().toString().trim();
        getListUser(str_email,str_password);
        clickLogin(str_email,str_password);
    }

    private void clickLogin( String strEmail, String strPassword) {
        if (mListUser == null || mListUser.isEmpty()) {
            Toast.makeText(SignInActivity.this, "Email hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
            return;
        }

        boolean isHasUser = false;
        for (User user : mListUser) {
            if (strEmail.equals(user.getEmail()) && strPassword.equals(user.getPassword())) {
                isHasUser = true;
                mUser = user;
                break;
            }
        }
        if (isHasUser) {
            Toast.makeText( this, "h1", Toast.LENGTH_SHORT ).show();
            //MainActivity
            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putSerializable("Object_user", mUser);
            preferenceHelper.setIsLogin(true);
            preferenceHelper.setUser(new Gson().toJson(mUser));
            intent.putExtras(bundle);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(SignInActivity.this, "Email hoặc mật khẩu không đúng", Toast.LENGTH_SHORT).show();
        }
    }

//    private void getListUser() {
//        new ApiHelper().getListUser(str -> {
//            if (str.isEmpty()) {
//                mListUser = new ArrayList<>();
//            } else {
//                Type type = new TypeToken<List<User>>() {
//                }.getType();
//                mListUser = new Gson().fromJson(str, type);
//            }
//        });
//    }
    private void getListUser(String email, String password){
        new ApiHelper().SignIn( email, password, str -> {
            if (str.isEmpty()) {
                mListUser = new ArrayList<>();
            } else {
                Type type = new TypeToken<List<User>>() {
                }.getType();
                mListUser = new Gson().fromJson(str, type);
            }
        } );
    }
}