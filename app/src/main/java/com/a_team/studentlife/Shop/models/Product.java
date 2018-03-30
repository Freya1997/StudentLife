package com.a_team.studentlife.Shop.models;

public class Product {
    private int imageResourceId;
    private String productName;
    private String productPrice;
    private boolean isLoading = false;
    private boolean isNew = false;
    private boolean isAdded = false;

    public Product(int imageResourceId, String productName, String productPrice, boolean isNew) {
        this.imageResourceId = imageResourceId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.isNew = isNew;
    }

    public Product() {
    }

    public boolean isNew() {
        return isNew;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public boolean isLoading() {
        return isLoading;
    }

    public void setLoading(boolean loading) {
        isLoading = loading;
    }

    public void setAdded(boolean added) {
        this.isAdded = added;
    }

    public void setNew(boolean aNew) {
        isNew = aNew;
    }


    public boolean isAdded() {
        return isAdded;
    }
}