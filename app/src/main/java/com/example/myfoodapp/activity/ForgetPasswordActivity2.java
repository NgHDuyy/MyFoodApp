package com.example.myfoodapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.myfoodapp.R;
import com.example.myfoodapp.databinding.ActivityForgetPassword2Binding;
import com.example.myfoodapp.model.User;
import com.example.myfoodapp.utils.apis.ApiHelper;
import com.example.myfoodapp.utils.helper.PreferenceHelper;
import com.example.myfoodapp.utils.listener.StringCallback;

public class ForgetPasswordActivity2 extends AppCompatActivity {
    private ActivityForgetPassword2Binding binding;
    private User user;
    private PreferenceHelper preferenceHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        binding = ActivityForgetPassword2Binding.inflate( getLayoutInflater() );
        View view = binding.getRoot();
        setContentView( view );
        preferenceHelper=new PreferenceHelper( this );
        user=preferenceHelper.getUser();

        onClickListen();
    }

    private void onClickListen() {
        binding.icBack.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        } );
        binding.btnConfirm.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_old = binding.oldPass.getText().toString().trim();
                String str_new_password = binding.newPass.getText().toString().trim();
                String str_confirmPass=binding.confirmPass.getText().toString().trim();
                if (TextUtils.isEmpty(str_old)) {
                    Toast.makeText(getApplicationContext(), "Bạn chưa nhập mật khẩu cũ", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(str_new_password)) {
                    Toast.makeText(getApplicationContext(), "Bạn chưa nhập mật khẩu mới", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(str_confirmPass)) {
                    Toast.makeText(getApplicationContext(), "Bạn chưa nhập lại mật khẩu mới", Toast.LENGTH_SHORT).show();
                } else {
                    if (str_new_password.equals(str_confirmPass)) {
                        new ApiHelper().signUp(user.getId() , str_confirmPass, new StringCallback() {
                            @Override
                            public void execute(String str) {
                                if (!str.isEmpty()){
                                    Toast.makeText(ForgetPasswordActivity2.this, "Đổi Pass thành công", Toast.LENGTH_SHORT).show();
                                    Intent intent = new Intent(ForgetPasswordActivity2.this,SignInActivity.class);
                                    startActivity( intent );
                                    finish();
                                } else {
                                    Toast.makeText(ForgetPasswordActivity2.this, "Đổi Pass thất bại", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    } else {
                        Toast.makeText(getApplicationContext(), "Nhập lại mật khẩu sai", Toast.LENGTH_SHORT).show();
                    }

                }

            }
        } );
    }
}