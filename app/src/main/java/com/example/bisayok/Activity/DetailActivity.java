package com.example.bisayok.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bisayok.Domain.FoodDomain;
import com.example.bisayok.Helper.ManagementCart;
import com.example.bisayok.R;

public class DetailActivity extends AppCompatActivity {
private Button addToCartBtn;
private TextView plusBtn, minusBtn, titleTxt, feeTxt, numberOrderTxt, descriptionTxt, starTxt, caloryTxt, timeTxt;
private ImageView picFood;
private FoodDomain object;
private int numberOrder = 1;
private ManagementCart managementCart;
private ImageView bckBtn1;

private double tax;

private RecyclerView.Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        managementCart=new ManagementCart(DetailActivity.this);

        initView();
        getBundle();
        setVariable();
    }

    private void setVariable() {
        bckBtn1.setOnClickListener(view -> finish());
    }

    private void getBundle() {
        object=(FoodDomain) getIntent().getSerializableExtra("object");

        int drawableResourceId=this.getResources().getIdentifier(object.getPicUrl(), "drawable",this.getPackageName());
        Glide.with(this)
                .load(drawableResourceId)
                .into(picFood);

        titleTxt.setText(object.getTittle());
        feeTxt.setText("Rp"+object.getPrice());
        descriptionTxt.setText(object.getDescription());
        numberOrderTxt.setText(""+numberOrder);
        caloryTxt.setText(object.getEnergy()+"Cal");
        starTxt.setText(object.getScore()+"");
        timeTxt.setText(object.getTime()+" min");
        addToCartBtn.setText("Add to cart - Rp"+Math.round(numberOrder*object.getPrice()));

        plusBtn.setOnClickListener(view -> {
            numberOrder = numberOrder +1;
            numberOrderTxt.setText(""+numberOrder);
            addToCartBtn.setText("Add to cart - Rp"+Math.round(numberOrder*object.getPrice()));
        });

        minusBtn.setOnClickListener(view -> {
            numberOrder = numberOrder -1;
            numberOrderTxt.setText(""+numberOrder);
            addToCartBtn.setText("Add to cart - Rp"+Math.round(numberOrder*object.getPrice()));
        });

        addToCartBtn.setOnClickListener(view -> {
            object.setNumberinCart(numberOrder);
            managementCart.insertFood(object);
        });

    }

    private void initView() {
        addToCartBtn=findViewById(R.id.addToCartBtn);
        timeTxt=findViewById(R.id.timeTxt);
        feeTxt =findViewById(R.id.priceTxt);
        titleTxt =findViewById(R.id.titleTxt);
        descriptionTxt=findViewById(R.id.descriptionTxt);
        numberOrderTxt=findViewById(R.id.numberItemTxt);
        plusBtn=findViewById(R.id.plusCardBtn);
        minusBtn=findViewById(R.id.minusCardBtn);
        picFood=findViewById(R.id.foodPic);
        starTxt=findViewById(R.id.StarTxt);
        caloryTxt=findViewById(R.id.calTxt);
        bckBtn1=findViewById(R.id.bckBtn1);

    }
}