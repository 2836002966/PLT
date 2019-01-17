package com.example.plb.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.plb.R;
import com.example.plb.activity.FirmOrder;
import com.example.plb.adapter.ShopCartAdapter;


import com.example.plb.bean.ShopCartChild;
import com.example.plb.bean.ShopCartGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhc on 2018/12/27.
 * 购物车
 */
public class ShopCartFragment extends Fragment implements View.OnClickListener {

    private View view;
    private TextView manager;
    private TextView total;
    private TextView money;
    private Button settlement;
    private Button delete;
    private Context context;
    private List<ShopCartGroup> groups;

    private List<ShopCartChild> child1, child2, child3;
    private List<List<ShopCartChild>>childs;
    private ExpandableListView exList;
    private ShopCartAdapter mAdapter;
    private boolean mark = true;
    private boolean isClisk = false;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shopcart, null);
        context = getContext();
        initData();
        initView();
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
        exList = view.findViewById(R.id.ex_list);
        mAdapter=new ShopCartAdapter(getActivity(),groups,childs,money);
        exList.setAdapter(mAdapter);
        for (int i = 0; i < mAdapter.getGroupCount(); i++) {
            exList.expandGroup(i);
        }
    }

    private void initData() {
        groups = new ArrayList<>();
        groups.add(new ShopCartGroup("五一市场",true));
        groups.add(new ShopCartGroup("衡州市场",true));
        groups.add(new ShopCartGroup("桥南市场",true));

        childs = new ArrayList<>();

        child1 = new ArrayList<>();
        child1.add(new ShopCartChild(R.mipmap.adgn, "哇哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈"
                , 6.80));
        child1.add(new ShopCartChild(R.mipmap.adgn, "哇哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈"
                , 6.80));
        child1.add(new ShopCartChild(R.mipmap.adgn, "哇哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈"
                , 6.80));
        childs.add(child1);

        child2 = new ArrayList<>();
        child2.add(new ShopCartChild(R.mipmap.adgn, "哇哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈"
                , 6.80));
        child2.add(new ShopCartChild(R.mipmap.adgn, "哇哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈"
                , 6.80));
        child2.add(new ShopCartChild(R.mipmap.adgn, "哇哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈"
                , 6.80));
        childs.add(child2);

        child3 = new ArrayList<>();
        child3.add(new ShopCartChild(R.mipmap.adgn, "哇哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈"
                , 6.80));
        child3.add(new ShopCartChild(R.mipmap.adgn, "哇哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈"
                , 6.80));
        child3.add(new ShopCartChild(R.mipmap.adgn, "哇哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈"
                , 6.80));
        childs.add(child3);
    }
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.manager:
                if (mark) {
                    mark = false;
                    manager.setText(R.string.complete);
                    settlement.setVisibility(View.GONE);
                    total.setVisibility(View.GONE);
                    money.setVisibility(View.GONE);
                    delete.setVisibility(View.VISIBLE);
                } else {
                    mark = true;
                    manager.setText(R.string.manager);
                    settlement.setVisibility(View.VISIBLE);
                    total.setVisibility(View.VISIBLE);
                    money.setVisibility(View.VISIBLE);
                    delete.setVisibility(View.GONE);
                }
                break;
            case R.id.settlement:
                Intent intent = new Intent(getActivity(), FirmOrder.class);
                startActivity(intent);
                break;
            case R.id.delete:
                Toast.makeText(getContext(), "您还没有选择商品哦！", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
