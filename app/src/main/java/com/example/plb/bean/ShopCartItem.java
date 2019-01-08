package com.example.plb.bean;

import java.util.List;

/**
 * Created by zhc on 2019/1/4.
 */
public class ShopCartItem {

    private String address;

    private List<Integer> imgs;

    private List<Double> moneys;

    public ShopCartItem(String address, List<Integer> imgs, List<Double> moneys) {
        this.address = address;
        this.imgs = imgs;
        this.moneys = moneys;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<Integer> getImgs() {
        return imgs;
    }

    public void setImgs(List<Integer> imgs) {
        this.imgs = imgs;
    }

    public List<Double> getMoneys() {
        return moneys;
    }

    public void setMoneys(List<Double> moneys) {
        this.moneys = moneys;
    }
}
