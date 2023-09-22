package com.example.myfoodapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.example.myfoodapp.R;
import com.example.myfoodapp.databinding.ActivitySignUpBinding;
import com.example.myfoodapp.utils.apis.ApiHelper;
import com.example.myfoodapp.utils.listener.StringCallback;

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
        binding.btnSignUp.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str_email = binding.edtEmail.getText().toString().trim();
                String str_password = binding.edtPass.getText().toString().trim();
                String str_name =binding.edtName.getText().toString().trim();
                String str_phone =binding.edtPhone.getText().toString().trim();
                String str_address =binding.edtAddress.getText().toString().trim();
                if (TextUtils.isEmpty(str_email)) {
                    Toast.makeText(getApplicationContext(), "Bạn chưa nhập Email", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(str_password)) {
                    Toast.makeText(getApplicationContext(), "Bạn chưa nhập mật khẩu", Toast.LENGTH_SHORT).show();
                } else if (TextUtils.isEmpty(str_name)) {
                    Toast.makeText(getApplicationContext(), "Bạn chưa nhập tên người dùng", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(str_phone)) {
                    Toast.makeText(getApplicationContext(), "Bạn chưa nhập số điện thoại", Toast.LENGTH_SHORT).show();
                }else if (TextUtils.isEmpty(str_address)) {
                    Toast.makeText(getApplicationContext(), "Bạn chưa nhập địa chỉ", Toast.LENGTH_SHORT).show();
                }else {
                    if (str_password.equals(str_password)) {
                        new ApiHelper().signUp( str_email, str_password,str_name,str_phone,str_address, new StringCallback() {
                            @Override
                            public void execute(String str) {
                                if (!str.isEmpty()){
                                    Toast.makeText(SignUpActivity.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                                    finish();
                                } else {
                                    Toast.makeText(SignUpActivity.this, "Đăng ký thất bại", Toast.LENGTH_SHORT).show();
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