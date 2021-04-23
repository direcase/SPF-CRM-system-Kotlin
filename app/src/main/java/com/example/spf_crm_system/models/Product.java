package com.example.spf_crm_system.models;

public class Product {

    long id;
    String description;
    int price;
    String product_name;

    public Product(long id, String description, int price, String product_name) {
        this.id = id;
        this.description = description;
        this.price = price;
        this.product_name = product_name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
}
