package com.example.farmfriend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class buyPage extends AppCompatActivity {
    Button home;
    Button cart;

    RecyclerView recycler_View;
    String st1[], st2[];
    int images[] = {R.drawable.weat, R.drawable.cotton, R.drawable.chilly, R.drawable.rice,
            R.drawable.sugercane, R.drawable.pepper, R.drawable.turmeric, R.drawable.corn, R.drawable.ragi};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_page);

        recycler_View = findViewById(R.id.recyclerView);

        st1 = getResources().getStringArray(R.array.items);
        st2 = getResources().getStringArray(R.array.description);

        MyBuyAdapter myAdapter = new MyBuyAdapter(this, st1, st2, images);
        recycler_View.setAdapter(myAdapter);
        recycler_View.setLayoutManager(new LinearLayoutManager(this));

        home = findViewById(R.id.to_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home_intent = new Intent(buyPage.this,MainActivity.class);
                startActivity(home_intent);

            }
        });

        cart = findViewById(R.id.go_cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cart_intent = new Intent(buyPage.this,cart_page.class);
                startActivity(cart_intent);
            }
        });
    }
}