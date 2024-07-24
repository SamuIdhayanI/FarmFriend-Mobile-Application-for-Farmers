package com.example.farmfriend;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.ArrayAdapter;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class BuyListAdapter extends ArrayAdapter{

        private Activity mContext;
        List<BuyData> buyDataList;

        public BuyListAdapter(Activity mContext, List<BuyData> buyDataList){
            super(mContext,R.layout.buy_list_item,buyDataList);
            this.mContext = mContext;
            this.buyDataList = buyDataList;
        }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.buy_list_item,null,true);

        TextView buy_item = listItemView.findViewById(R.id.buy_item);
        TextView buy_price = listItemView.findViewById(R.id.buy_price);

        BuyData buyData = buyDataList.get(position);

        buy_item.setText(buyData.getItem());
        buy_price.setText(buyData.getPrice());

        return listItemView;
    }
}
