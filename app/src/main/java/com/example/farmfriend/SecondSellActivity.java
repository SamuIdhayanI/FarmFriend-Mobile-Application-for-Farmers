package com.example.farmfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SecondSellActivity extends AppCompatActivity {
    Button back, yield;
    ImageView mainImageView;
    TextView title, description;
    String data1, data2;
    int myImage;
    Button post_button;
    EditText enter_quantity;
    Spinner m_spinner;


    DatabaseReference sellDBref;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_sell);

        mainImageView = findViewById(R.id.mainImageView);
        title = findViewById(R.id.title);
        description = findViewById(R.id.description);

        enter_quantity = findViewById(R.id.enter_quantity);
        m_spinner = findViewById(R.id.m_spinner);
        post_button = findViewById(R.id.post_button);

        sellDBref = FirebaseDatabase.getInstance().getReference().child("SellData");

        getData();
        setData();

        back = findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cart_intent = new Intent(SecondSellActivity.this,sellPage.class);
                startActivity(cart_intent);
            }
        });
        post_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                insertSellData();
            }
        });
        yield = findViewById(R.id.go_yield);
        yield.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent sell_intent = new Intent(SecondSellActivity.this,yield_page.class);
                startActivity(sell_intent);
            }
        });

    }
    private void getData(){
        if(getIntent().hasExtra("myImage")&& getIntent().hasExtra("data1") && getIntent().hasExtra("data2")){
            data1 = getIntent().getStringExtra("data1");
            data2 = getIntent().getStringExtra("data2");
            myImage = getIntent().getIntExtra("myImage", 1);
        }else {
            Toast.makeText(this, "No.data", Toast.LENGTH_SHORT).show();
        }
    }

    private void setData(){
        title.setText(data1);
        description.setText(data2);
        mainImageView.setImageResource(myImage);
    }
    private void insertSellData(){
        String item =  getIntent().getStringExtra("data1");
        String quantity = enter_quantity.getText().toString();
        String measure = m_spinner.getSelectedItem().toString();

        String id = sellDBref.push().getKey();
        SellData sell_data = new SellData(id, item, quantity, measure);
        assert id != null;

        sellDBref.child(id).setValue(sell_data);
        //buyDBref.push().setValue(buy_data);
        Toast.makeText(SecondSellActivity.this, "Request Uploaded", Toast.LENGTH_SHORT).show();
    }
}