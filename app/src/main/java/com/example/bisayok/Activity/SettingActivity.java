package com.example.bisayok.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.bisayok.Helper.ManagementCart;
import com.example.bisayok.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.squareup.picasso.Picasso;


public class SettingActivity extends AppCompatActivity {
//    Button btnLogOut;


    TextView userlogin, btnLogOut;
    ImageView userprof;
    private ImageView bckBtn2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        initView();
        setVariable();
        getUserProfile();
        logout();


    }

    private void logout(){
        btnLogOut = findViewById(R.id.logot);
        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Logout();
            }
        });

    }

    private void Logout() {
        FirebaseAuth.getInstance().signOut();
        startActivity(new Intent(SettingActivity.this, LoginActivity.class));
    }

    public void getUserProfile() {
        // [START get_user_profile]
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        if (user != null) {
            String name = user.getDisplayName().toUpperCase();
            Uri photoUrl = user.getPhotoUrl();

            userlogin = (TextView) findViewById(R.id.userset);
            userprof = findViewById(R.id.fotoset);
            userlogin.setText(name);
            userprof.setImageURI(photoUrl);
            Picasso.get().load(photoUrl).into(userprof);

        }
    }

    private void setVariable() {
        bckBtn2.setOnClickListener(view -> finish());
    }

    private void initView() {
        bckBtn2=findViewById(R.id.bckBtn2);
    }
}