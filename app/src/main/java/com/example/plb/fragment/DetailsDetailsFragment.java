package com.example.plb.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.plb.R;
import com.example.plb.bean.ShopBean;

/**
 * Created by 陈 on 2019/1/2.
 */

public class DetailsDetailsFragment extends Fragment {
    private View view;
    private TextView details_shopname;
    private ImageView shop_details_iv;
    DetailsShopFragment ds = new DetailsShopFragment (  );
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate ( R.layout.fragment_details_details,null );
        initView();
        initDate ();
        return view;
    }

    private void initView() {
        details_shopname = view.findViewById ( R.id.details_shopname );
        shop_details_iv = view.findViewById ( R.id.shop_details_iv );
    }

    public void initDate() {
       details_shopname.setText ( ""+ds.info );
       Glide.with ( view.getContext () ).load ( ds.detailedurl ).into ( shop_details_iv );
    }
}
