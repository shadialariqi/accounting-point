package com.example.end;

public class student {

    String name_product;
    int quantity, price_sale;

    public student(String name_product,int quantity,int price_sale) {
        this.name_product = name_product;
        this.quantity = quantity;
        this.price_sale = price_sale;
    }
    public student(){}

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice_sale() {
        return price_sale;
    }

    public void setPrice_sale(int price_sale) {
        this.price_sale = price_sale;
    }
}
