package com.example.agripoc.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.agripoc.R;

public class MainActivity extends AppCompatActivity {

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