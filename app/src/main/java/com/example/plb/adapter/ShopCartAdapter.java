package com.example.plb.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.plb.R;
import com.example.plb.bean.ShopCartChild;
import com.example.plb.bean.ShopCartGroup;

import java.util.List;

/**
 * Created by zhc on 2019/1/4.
 */
public class ShopCartAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<ShopCartGroup> groups;
    private List<List<ShopCartChild>>child;
    private ViewHolderGroup holderGroup = null;
    private ViewHolderChild holderChild = null;
    private TextView moneyView;
    private int i=1;
    public ShopCartAdapter(Context context, List<ShopCartGroup>groups, List<List<ShopCartChild>>child,TextView moneyView) {
        this.context = context;
        this.groups =groups;
        this.child=child;
        this.moneyView=moneyView;
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return child.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return null;
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return null;
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
        return false;
    }

    @Override
    public View getGroupView(final int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            holderGroup = new ViewHolderGroup();
            convertView = LayoutInflater.from(context).inflate(R.layout.group_shopcart, null);
            holderGroup.select = convertView.findViewById(R.id.selectAll);
            holderGroup.address = convertView.findViewById(R.id.address);
            holderGroup.arrow = convertView.findViewById(R.id.arrow);
            convertView.setTag(holderGroup);
        } else {
            holderGroup = (ViewHolderGroup) convertView.getTag();
        }
        if (isExpanded)
            holderGroup.arrow.setImageResource(R.mipmap.below);
        else
        holderGroup.arrow.setImageResource(R.mipmap.right);
        holderGroup.address.setText(groups.get(groupPosition).getAddress());
        holderGroup.select.setChecked(groups.get(groupPosition).isChecked());
        holderGroup.select.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                groups.get(groupPosition).setChecked(isChecked);
                for(int i=0;i<child.get(groupPosition).size();i++){
//                    if(isChecked){
//                        child.get(groupPosition).get(i).setChecked(true);
//                    }else{
//                        child.get(groupPosition).get(i).setChecked(false);
//                    }
                }
                notifyDataSetChanged();
            }
        });
        return convertView;
    }


    @Override
    public View getChildView(int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        if (convertView == null) {
            holderChild = new ViewHolderChild();
            convertView = LayoutInflater.from(context).inflate(R.layout.child_shopcart, null);
            holderChild.select = convertView.findViewById(R.id.select);
            holderChild.img = convertView.findViewById(R.id.img);
            holderChild.info = convertView.findViewById(R.id.info);
            holderChild.money = convertView.findViewById(R.id.money);
            convertView.setTag(holderChild);
        } else {
            holderChild = (ViewHolderChild) convertView.getTag();
        }
        holderChild.img.setImageResource(child.get(groupPosition).get(childPosition).getImg());
        holderChild.info.setText(child.get(groupPosition).get(childPosition).getInfo());
        holderChild.money.setText("￥" + child.get(groupPosition).get(childPosition).getMoney());
        holderChild.select.setChecked(child.get(groupPosition).get(childPosition).getChecked());
        holderChild.select.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                child.get(groupPosition).get(childPosition).setChecked(isChecked);
                double money=0;
                for(int i=0;i<child.size();i++){
                    for(int k=0;k<child.get(i).size();k++){
                        if(child.get(i).get(k).getChecked()){
                            money+=child.get(i).get(k).getMoney();
                            moneyView.setText(money+"");
                            notifyDataSetChanged();
                        }
                    }

                }

            }
        });
        return convertView;
    }


    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }


    private static class ViewHolderGroup {
        CheckBox select;
        TextView address;
        ImageView arrow;
    }

    private static class ViewHolderChild {
        CheckBox select;
        ImageView img;
        TextView info;
        TextView money;
    }

}
