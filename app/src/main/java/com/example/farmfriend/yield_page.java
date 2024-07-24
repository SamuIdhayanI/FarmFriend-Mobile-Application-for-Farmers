package com.example.farmfriend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class yield_page extends AppCompatActivity {
    ListView sellListView;
    List<SellData> sellDataList;
    DatabaseReference sellDBref;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yield_page);

        sellListView = findViewById(R.id.sellListView);
        sellDataList = new ArrayList<>();

        sellDBref = FirebaseDatabase.getInstance().getReference("SellData");

        sellDBref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                sellDataList.clear();

                for (DataSnapshot sellDatasnap : snapshot.getChildren()){
                    SellData selldata = sellDatasnap.getValue(SellData.class);
                    sellDataList.add(selldata);
                }
                SellListAdapter adapter = new SellListAdapter(yield_page.this,sellDataList);
                sellListView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }
}