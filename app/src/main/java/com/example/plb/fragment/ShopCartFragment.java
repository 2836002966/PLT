package com.example.plb.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.plb.R;
import com.example.plb.adapter.ShopCartAdapter;
import com.example.plb.bean.ShopCartItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhc on 2018/12/27.
 * 购物车
 */
public class ShopCartFragment extends Fragment implements View.OnClickListener{

    private View view;
    private TextView manager;
    private TextView total;
    private TextView money;
    private Button settlement;
    private Button delete;
    private List<ShopCartItem> items;
    private List<Integer> imgs1,imgs2,imgs3;
    private List<Double> moneys1,moneys2,moneys3;
    private ListView listView;
    private ShopCartAdapter mAdapter;
    private boolean mark = true;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shopcart,null);
        initView();
        initData();
        return view;
    }

    private void initView() {
        manager = view.findViewById(R.id.manager);
        manager.setOnClickListener(this);
        total = view.findViewById(R.id.total);
        money = view.findViewById(R.id.money);
        settlement = view.findViewById(R.id.settlement);
        settlement.setOnClickListener(this);
        delete = view.findViewById(R.id.delete);
        delete.setOnClickListener(this);
        listView = view.findViewById(R.id.listView);
    }

    private void initData() {
        int[] imgs = {R.mipmap.adgn,R.mipmap.bhc,
                R.mipmap.cht,R.mipmap.dove,R.mipmap.firstcode,
                R.mipmap.hn,R.mipmap.jly,R.mipmap.ksf,
                R.mipmap.ls,R.mipmap.mn,R.mipmap.qidu};
        double[] moneys = {6.80,2.50,6.80,40.60,45.80,
        4.60,5.20,3.20,2.50,2.30,5.50};
        items = new ArrayList<>();
        imgs1 = new ArrayList<>();
        imgs2 = new ArrayList<>();
        imgs3 = new ArrayList<>();
        moneys1 = new ArrayList<>();
        moneys2 = new ArrayList<>();
        moneys3 = new ArrayList<>();
        for (int i = 0; i < imgs.length; i++) {
            imgs1.add(imgs[i]);
            imgs2.add(imgs[i]);
            imgs3.add(imgs[i]);
        }
        for (int i = 0; i < moneys.length; i++) {
            moneys1.add(moneys[i]);
            moneys2.add(moneys[i]);
            moneys3.add(moneys[i]);
        }
        items.add(new ShopCartItem("五一市场",imgs1,moneys1));
        items.add(new ShopCartItem("衡州市场",imgs2,moneys2));
        items.add(new ShopCartItem("桥南市场",imgs3,moneys3));
        mAdapter = new ShopCartAdapter(getContext(),items);
        listView.setAdapter(mAdapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.manager:
                if (mark){
                    mark = false;
                    manager.setText(R.string.complete);
                    settlement.setVisibility(View.GONE);
                    total.setVisibility(View.GONE);
                    money.setVisibility(View.GONE);
                    delete.setVisibility(View.VISIBLE);
                }else {
                    mark = true;
                    manager.setText(R.string.manager);
                    settlement.setVisibility(View.VISIBLE);
                    total.setVisibility(View.VISIBLE);
                    money.setVisibility(View.VISIBLE);
                    delete.setVisibility(View.GONE);
                }
                break;
            case R.id.settlement:
                Toast.makeText(getContext(),"您还没有选择商品哦！",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(getContext(),"您还没有选择商品哦！",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
