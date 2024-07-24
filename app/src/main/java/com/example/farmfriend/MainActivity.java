package com.example.farmfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private Button sell, buy, cart, btnLogout, yield;
    FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        btnLogout=findViewById(R.id.btnLogout);
        btnLogout.setOnClickListener(view ->{
            mAuth.signOut();
            startActivity(new Intent(MainActivity.this, LoginActivity.class));

        });

        sell = findViewById(R.id.sell_button);
        sell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sell_intent = new Intent(MainActivity.this,sellPage.class);
                startActivity(sell_intent);
            }
        });
        buy =  findViewById(R.id.buy_button);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent buy_intent = new Intent(MainActivity.this,buyPage.class);
                startActivity(buy_intent);
            }
        });
        cart = findViewById(R.id.go_cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cart_intent = new Intent(MainActivity.this,cart_page.class);
                startActivity(cart_intent);
            }
        });
        yield = findViewById(R.id.go_yield);
        yield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sell_intent = new Intent(MainActivity.this,yield_page.class);
                startActivity(sell_intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if (user == null){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }
    }
}