package com.example.farmfriend;

public class SellData {
    String id;
    String item;
    String quantity;
    String measure;
    public SellData(){

    }

    public SellData(String id, String item, String quantity, String measure) {
        this.id = id;
        this.item = item;
        this.quantity = quantity;
        this.measure = measure;
    }

    public String getId() {
        return id;
    }

    public String getItem() {
        return item;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getMeasure() {
        return measure;
    }
}
