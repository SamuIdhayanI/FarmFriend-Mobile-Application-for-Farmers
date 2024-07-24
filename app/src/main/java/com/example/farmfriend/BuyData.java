package com.example.farmfriend;

public class BuyData {
    String id;
    String item;
    String price;

    public BuyData(){

    }
    public BuyData(String id, String item, String price) {
        this.id = id;
        this.item = item;
        this.price = price;
    }
    public String getId(){
        return id;
    }

    public String getItem() {
        return item;
    }

    public String getPrice() {
        return price;
    }
}
