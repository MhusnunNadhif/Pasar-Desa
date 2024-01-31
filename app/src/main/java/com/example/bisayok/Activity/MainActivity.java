package com.example.bisayok.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.bisayok.Adapter.FoodListAdapter;
import com.example.bisayok.Domain.FoodDomain;
import com.example.bisayok.FishActivity;
import com.example.bisayok.R;
import com.google.android.play.core.integrity.v;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    TextView userlogin;
    ImageView userprof;
private RecyclerView.Adapter adapterFoodList;
private RecyclerView recyclerViewFood;
private FirebaseAuth mAuth;




   //@SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //getSupportActionBar().hide();
        ImageView imageView1 = findViewById(R.id.imageView3);
        TextView textView1 = findViewById(R.id.textView5);
        ImageView imageView2 = findViewById(R.id.imageView26);
        TextView textView2 = findViewById(R.id.textView24);
        ImageView imageView3 = findViewById(R.id.imageView24);
        TextView textView3 = findViewById(R.id.textView23);
        ImageView imageView4 = findViewById(R.id.imageView25);
        TextView textView4 = findViewById(R.id.textView22);


        initRecyclerview();
        bottomNavigation();
        getUserProfile();


        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aksi yang ingin dilakukan saat ImageView1 diklik
                // Misalnya, buka halaman terkait
                Intent intent = new Intent(MainActivity.this, FoodActiviity.class);
                startActivity(intent);
            }
        });

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aksi yang ingin dilakukan saat TextView1 diklik
                // Misalnya, buka halaman terkait
                Intent intent = new Intent(MainActivity.this, FoodActiviity.class);
                startActivity(intent);
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aksi yang ingin dilakukan saat ImageView2 diklik
                // Misalnya, buka halaman terkait
                Intent intent = new Intent(MainActivity.this, FruitActivity.class);
                startActivity(intent);
            }
        });

        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aksi yang ingin dilakukan saat TextView2 diklik
                // Misalnya, buka halaman terkait
                Intent intent = new Intent(MainActivity.this, FruitActivity.class);
                startActivity(intent);
            }
        });

        imageView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aksi yang ingin dilakukan saat ImageView3 diklik
                // Misalnya, buka halaman terkait
                Intent intent = new Intent(MainActivity.this, FishActivity.class);
                startActivity(intent);
            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aksi yang ingin dilakukan saat TextView3 diklik
                // Misalnya, buka halaman terkait
                Intent intent = new Intent(MainActivity.this, FishActivity.class);
                startActivity(intent);
            }
        });

        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aksi yang ingin dilakukan saat ImageView4 diklik
                // Misalnya, buka halaman terkait
                Intent intent = new Intent(MainActivity.this, BreadActivity.class);
                startActivity(intent);
            }
        });

        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Aksi yang ingin dilakukan saat TextView4 diklik
                // Misalnya, buka halaman terkait
                Intent intent = new Intent(MainActivity.this, BreadActivity.class);
                startActivity(intent);
            }
        });


    }





    public void getUserProfile() {
        // [START get_user_profile]
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String name = user.getDisplayName().toUpperCase();
            Uri photoUrl = user.getPhotoUrl();

            userlogin = (TextView) findViewById(R.id.userlog);
            userprof = findViewById(R.id.userprofil);
            userlogin.setText(name);
            userprof.setImageURI(photoUrl);
            Picasso.get().load(photoUrl).into(userprof);

        }
    }

    private void bottomNavigation() {
        LinearLayout homeBtn=findViewById(R.id.homeBtn);
        LinearLayout cartBtn=findViewById(R.id.cartBtn);
        LinearLayout settingBtn=findViewById(R.id.settingBtn);

        homeBtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,MainActivity.class)));

        cartBtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,CartActivity.class)));

        settingBtn.setOnClickListener(view -> startActivity(new Intent(MainActivity.this,SettingActivity.class)));
    }

    private void initRecyclerview() {
        ArrayList<FoodDomain> items=new ArrayList<>();
        items.add(new FoodDomain("Sate Ayam","Sate ayam adalah hidangan populer di Indonesia yang terdiri dari potongan daging ayam yang ditusuk dan dipanggang. Disajikan dengan bumbu kacang, rasanya gurih, manis, pedas, dan enak. Biasanya disajikan dengan nasi, mentimun, dan bawang merah.",
                "@drawable/fast_11", 15000,20,120,4));
        items.add(new FoodDomain("Nasi Krawu","Nasi Krawu adalah makanan khas dari daerah Gresik, Jawa Timur, Indonesia. Makanan ini terdiri dari nasi yang disajikan dengan lauk daging sapi yang dimasak dengan rempah-rempah khas dan diberi taburan serundeng kelapa yang gurih. Lauk daging sapi ini biasanya dimasak dengan cara direbus dalam kuah bumbu yang kaya akan rempah seperti serai, daun salam, lengkuas, kemiri, bawang merah, bawang putih, cabai, dan garam. Nasi Krawu juga biasanya disajikan dengan pelengkap seperti irisan timun, telur rebus, dan sambal. Makanan ini memiliki cita rasa yang kaya, gurih, dan sedikit pedas.",
                "@drawable/fast_22",10000,17,243,4.6));
        items.add(new FoodDomain("Kelan Ikan Sembilang","Hidangan tradisional khas Gresik kelan Sembilang adalah masakan asam pedas. Tekstur daging ikan lembut, bumbu rempah-rempah yang kuat membangkitkan selera makan.",
                "@drawable/fast_33",14000,10,154,4.8));

        recyclerViewFood=findViewById(R.id.view1);
        recyclerViewFood.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));


        adapterFoodList=new FoodListAdapter(items);
        recyclerViewFood.setAdapter(adapterFoodList);

    }
}