package com.example.farmfriend;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

public class MyBuyAdapter extends RecyclerView.Adapter<MyBuyAdapter.MyViewHolder> {
    String str_data1[], str_data2[];
    int int_images[];
    Context context;

    public MyBuyAdapter(Context ct, String s1[], String s2[], int img[]){
        context = ct;
        str_data1 = s1;
        str_data2 = s2;
        int_images = img;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_buy_row, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint("RecyclerView")
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.myText1.setText(str_data1[position]);
        holder.myText2.setText(str_data2[position]);
        holder.myImage.setImageResource(int_images[position]);
        holder.mainBuyLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, SecondBuyActivity.class);
                intent.putExtra("data1", str_data1[position]);
                intent.putExtra("data2", str_data2[position]);
                intent.putExtra("myImage", int_images[position]);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return int_images.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        TextView myText1, myText2;
        ImageView myImage;
        ConstraintLayout mainBuyLayout;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            myText1 = itemView.findViewById(R.id.items);
            myText2 = itemView.findViewById(R.id.description);
            myImage = itemView.findViewById(R.id.myImageView);
            mainBuyLayout = itemView.findViewById(R.id.mainBuyLayout);

        }
    }
}