package com.example.plb.bean;

/**
 * Created by admin on 2019/1/11.
 */

public class HomeToShop {

    private String shopName;    //商品名
    private String market;      //市场

    public HomeToShop(String shopName, String market) {
        this.shopName = shopName;
        this.market = market;
    }

    public HomeToShop() {
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

}
