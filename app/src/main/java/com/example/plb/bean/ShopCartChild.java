package com.example.plb.bean;

/**
 * Created by zhc on 2019/1/11.
 */
public class ShopCartChild {

    private int img;

    private String info;

    private double money;

    public ShopCartChild(int img, String info, double money) {
        this.img = img;
        this.info = info;
        this.money = money;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
