package com.example.agripoc.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.agripoc.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override
    protected void onStart() {
        super.onStart();
        setContentView(R.layout.activity_main);

    }
}