package com.example.plb.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.plb.activity.AddShopPopupwindow;
import com.example.plb.R;
import com.example.plb.bean.ShopMarket;

/**
 * Created by 陈 on 2019/1/2.
 */

public class DetailsShopFragment extends Fragment {
    private View view;
    private Button add_shop;//加入进货单
    private AddShopPopupwindow mPopwindow;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate ( R.layout.fragment_details_shop,null );

        //处理 郑钦文给你发送过来的商品数据
        isHandle();

        add_shop = view.findViewById (R.id.add_shop );
        add_shop.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                mPopwindow = new AddShopPopupwindow(getActivity (), null);
                mPopwindow.showAtLocation(view,
                        Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL, 0, 0);
            }
        } );

        return view;
    }

    private void isHandle(){
        int id = getActivity().getIntent().getIntExtra("id",1);
        if (id==88888){
            HomeToShop homeToShop = new HomeToShop();
            String str = homeToShop.getShopName();
            Toast.makeText(getContext(),"测试"+str,Toast.LENGTH_SHORT).show();

            Toast.makeText(getContext(),"测试",Toast.LENGTH_SHORT).show();
        }
    }

}
