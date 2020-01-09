package com.example.administrator.myapplication.bean;

public class ShopBean {
    private String id;
    private String shopTitle;
    private String shopPrice;

    public String getId() {
        return id;
    }
    public void setId(String id){
        this.id = id;
    }

    public String getShopTitle() {
        return shopTitle;
    }

    public void setShopTitle(String shopTitle) {
        this.shopTitle = shopTitle;
    }

    public String getShopPrice() {
        return shopPrice;
    }

    public void setShopPrice(String shopPrice) {
        this.shopPrice = shopPrice;
    }
}
