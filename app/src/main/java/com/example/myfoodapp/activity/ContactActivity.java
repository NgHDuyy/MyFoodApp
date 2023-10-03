package com.example.myfoodapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.example.myfoodapp.R;
import com.example.myfoodapp.databinding.ActivityContactBinding;

public class ContactActivity extends AppCompatActivity {
    private ActivityContactBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
       binding=ActivityContactBinding.inflate( getLayoutInflater() );
       View view=binding.getRoot();
       setContentView( view );
       onClickLister();

    }

    private void onClickLister() {
        binding.cvFacebook.setOnClickListener( view -> {
            String url = "https://www.facebook.com/ng.h.dyu";

            // Create an Intent with action ACTION_VIEW and the URL
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));

            // Start the activity to open the URL
            startActivity(intent);
        } );
    }
}