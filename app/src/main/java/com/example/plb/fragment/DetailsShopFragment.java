package com.example.plb.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.plb.AddShopPopupwindow;
import com.example.plb.R;

/**
 * Created by 陈 on 2019/1/2.
 */

public class DetailsShopFragment extends Fragment implements View.OnClickListener {
    private View view;
    private Button add_shop;//加入进货单
    private AddShopPopupwindow mPopwindow;
    private ImageView shop_img;//商品图片
    private TextView shop_name;//商品名称
    private TextView shop_beginSum;//商品起售数量
    private TextView shop_Price;//商品价格
    private TextView shop_Num;//商品可售数量
    private TextView shop_buyNum;//购买数量
    private ImageButton delete_shopNum;//减少数目
    private ImageButton add_shopNum;//减少数目
    private TextView shop_Sum;//商品购买数量
    private TextView num_tv;//底部商品购买数量
    private TextView money_tv;//商品总价
    private Button add_btn;//确认数目后加入进货单
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate ( R.layout.fragment_details_shop,null );
        add_shop = view.findViewById ( R.id.add_shop );
        add_shop.setOnClickListener ( this );
        return view;
    }

    @Override
    public void onClick(View v) {
        mPopwindow = new AddShopPopupwindow(getActivity (), null);
        mPopwindow.showAtLocation(view,
                Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
    }
}
