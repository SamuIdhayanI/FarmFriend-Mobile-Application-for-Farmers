package com.example.farmfriend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class cart_page extends AppCompatActivity {
    ListView buyListView;
    List<BuyData> buyDataList;
    DatabaseReference buyDBref;
    private Button yield;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_page);

        buyListView = findViewById(R.id.buyListView);
        buyDataList = new ArrayList<>();

        buyDBref = FirebaseDatabase.getInstance().getReference("BuyData");

        buyDBref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                buyDataList.clear();

                for (DataSnapshot buyDatasnap : snapshot.getChildren()){
                    BuyData buydata = buyDatasnap.getValue(BuyData.class);
                    buyDataList.add(buydata);
                }
                BuyListAdapter adapter = new BuyListAdapter(cart_page.this,buyDataList);
                buyListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        yield = findViewById(R.id.go_yield);
        yield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sell_intent = new Intent(cart_page.this,yield_page.class);
                startActivity(sell_intent);
            }
        });
    }
}