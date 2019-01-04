package com.example.plb.bean;

import android.net.Uri;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

/**
 * Created by admin on 2019/1/2.
 */

public class ProductInfo {

    private int proIndex;   //商品序列索引
    private String proImages;  //商品图片路径
    public ImageButton mProImageButton;    //商品图片按钮
    public RelativeLayout mProDataLayout;  //商品数据布局

    public ProductInfo(int proIndex,String proImages) {

        this.proIndex = proIndex;
        this.proImages = proImages;
    }

    public int getProIndex() {
        return proIndex;
    }

    public void setProIndex(int proIndex) {
        this.proIndex = proIndex;
    }

    public String getProImages() {
        return proImages;
    }

    public void setProImages(String proImages) {
        this.proImages = proImages;
    }


}
