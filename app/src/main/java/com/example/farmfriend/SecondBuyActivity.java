package com.example.farmfriend;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SecondBuyActivity extends AppCompatActivity {
    Button cart, back;
    ImageView titleImageView;
    TextView title_text, description_text;
    String data1, data2;
    int myImage;
    EditText enter_price;
    Button post_button;

    DatabaseReference buyDBref;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_buy);

        titleImageView = findViewById(R.id.titleImageView);
        title_text = findViewById(R.id.title_text);
        description_text = findViewById(R.id.description_text);

        enter_price = findViewById(R.id.enter_price);
        post_button = findViewById(R.id.post_button);
        buyDBref = FirebaseDatabase.getInstance().getReference().child("BuyData");

        getData();
        setData();
        cart = findViewById(R.id.go_cart);
        cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cart_intent = new Intent(SecondBuyActivity.this,cart_page.class);
                startActivity(cart_intent);
            }
        });
        back = findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cart_intent = new Intent(SecondBuyActivity.this,buyPage.class);
                startActivity(cart_intent);
            }
        });

        post_button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                insertBuyData();
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
        title_text.setText(data1);
        description_text.setText(data2);
        titleImageView.setImageResource(myImage);
    }
    private void insertBuyData(){
        String item =  getIntent().getStringExtra("data1");
        String price = enter_price.getText().toString();

        String id = buyDBref.push().getKey();
        BuyData buy_data = new BuyData(id, item, price);
        assert id != null;

        buyDBref.child(id).setValue(buy_data);
        //buyDBref.push().setValue(buy_data);
        Toast.makeText(SecondBuyActivity.this, "Request Uploaded", Toast.LENGTH_SHORT).show();
    }
}