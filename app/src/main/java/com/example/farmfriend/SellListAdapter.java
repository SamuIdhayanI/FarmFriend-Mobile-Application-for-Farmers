package com.example.farmfriend;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class SellListAdapter extends ArrayAdapter {

    private Activity mContext;
    List<SellData> sellDataList;

    public SellListAdapter(Activity mContext, List<SellData> sellDataList){
        super(mContext,R.layout.sell_list_item,sellDataList);
        this.mContext = mContext;
        this.sellDataList = sellDataList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = mContext.getLayoutInflater();
        View listItemView = inflater.inflate(R.layout.sell_list_item,null,true);

        TextView item = listItemView.findViewById(R.id.sell_item);
        TextView measure = listItemView.findViewById(R.id.measure);
        TextView quantity = listItemView.findViewById(R.id.quantity);

        SellData sellData = sellDataList.get(position);

        item.setText(sellData.getItem());
        measure.setText(sellData.getMeasure());
        quantity.setText(sellData.getQuantity());

        return listItemView;
    }
}
