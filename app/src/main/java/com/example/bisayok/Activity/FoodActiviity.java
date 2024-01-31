package com.example.bisayok.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.bisayok.R;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FoodActiviity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        Toast.makeText(this, "Halaman Food", Toast.LENGTH_SHORT).show();
    }
}