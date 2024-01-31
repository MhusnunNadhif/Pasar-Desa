package com.example.bisayok.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.widget.Toast;


import com.example.bisayok.R;

public class BreadActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bread);
        Toast.makeText(this, "Halaman Bread", Toast.LENGTH_SHORT).show();
    }
}