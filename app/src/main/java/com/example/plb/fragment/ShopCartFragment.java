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
    private String[] groups = {"五一市场", "衡州大市场"};
    private String[][] childs={{"A1","A2","A3","A4"},{"A1","A2","A3", "B4"},{"A1","A2","A3","C4"}};
    private ExpandableListView expandableListView;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shopcart,null);
        initView();
        expandableListView = (ExpandableListView) view.findViewById(R.id.expandableListView);

        expandableListView.setAdapter(new MyExpandableListView());
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
    class MyExpandableListView  extends BaseExpandableListAdapter {
        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return childs[groupPosition].length;
        }

        @Override
        public Object getGroup(int groupPosition) {
            return groups[groupPosition];
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return childs[groupPosition][childPosition];
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return childPosition;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {

            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_group, null);
            }
            TextView tv_group = (TextView) convertView.findViewById(R.id.tv_group);
            tv_group.setText(groups[groupPosition]);
            return convertView;
        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_child, null);
            }

            ImageView iv_child = (ImageView) convertView.findViewById(R.id.iv_child);
            TextView tv_child = (TextView) convertView.findViewById(R.id.tv_child);

            //iv_child.setImageResource(resId);
            tv_child.setText(childs[groupPosition][childPosition]);

            return convertView;
        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }
}
