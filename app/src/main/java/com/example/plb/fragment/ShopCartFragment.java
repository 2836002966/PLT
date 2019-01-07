package com.example.plb.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.plb.R;

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
    private boolean mark = true;
    private ListView listView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shopcart,null);
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
        listView=view.findViewById(R.id.listview);

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
