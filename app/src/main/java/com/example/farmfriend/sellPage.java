package com.example.farmfriend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class sellPage extends AppCompatActivity {
    private Button home, cart;

    RecyclerView recyclerView;
    String s1[], s2[];
    int images[] = {R.drawable.weat, R.drawable.cotton, R.drawable.chilly, R.drawable.rice,
            R.drawable.sugercane, R.drawable.pepper, R.drawable.turmeric, R.drawable.corn, R.drawable.ragi};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sell_page);

        recyclerView = findViewById(R.id.recyclerView);

        s1 = getResources().getStringArray(R.array.items);
        s2 = getResources().getStringArray(R.array.description);

        MySellAdapter myAdapter = new MySellAdapter(this, s1, s2,images);
        recyclerView.setAdapter(myAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        home = findViewById(R.id.to_home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home_intent = new Intent(sellPage.this,MainActivity.class);
                startActivity(home_intent);

            }
        });
        cart = findViewById(R.id.go_cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cart_intent = new Intent(sellPage.this,cart_page.class);
                startActivity(cart_intent);
            }
        });
    }
}