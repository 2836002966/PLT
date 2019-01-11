package com.example.plb.bean;

import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by admin on 2019/1/2.
 */

public class ProductInfo {

    public RelativeLayout mProDataLayout;
    public ImageButton mProImageButton;

    //mProDataLayout（右侧的商品信息块所需的值）
    private boolean isShowJK;   //是否显示进口图标
    private String shopName;    //商品名
    private int minNum;         //最小购买数量
    private int danjia;         //单价
    private String market;      //市场
    //对应以上值的控件
    public ImageView mJinKouImage;  //进口图标的控件
    public TextView mShopName;
    public TextView mMinNum;
    public TextView mDanjia;
    public TextView mMarket;


    public ProductInfo(String shopName , int minNum , boolean isShowJK, int danjia , String market) {
        this.shopName = shopName;
        this.minNum = minNum;
        this.isShowJK = isShowJK;
        this.danjia = danjia;
        this.market = market;
    }

    public boolean isShowJK() {
        return isShowJK;
    }

    public void setShowJK(boolean showJK) {
        isShowJK = showJK;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getMinNum() {
        return minNum;
    }

    public void setMinNum(int minNum) {
        this.minNum = minNum;
    }

    public int getDanjia() {
        return danjia;
    }

    public void setDanjia(int danjia) {
        this.danjia = danjia;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

}
