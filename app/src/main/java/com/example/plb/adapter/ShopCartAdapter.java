package com.example.plb.adapter;

import android.content.Context;
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
    private List<List<ShopCartChild>> childs;
    private ViewHolderGroup holderGroup = null;
    private ViewHolderChild holderChild = null;

    public ShopCartAdapter(Context context, List<ShopCartGroup> groups,
                           List<List<ShopCartChild>> childs) {
        this.context = context;
        this.groups = groups;
        this.childs = childs;
    }

    @Override
    public int getGroupCount() {
        return groups.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return childs.get(groupPosition).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return groups.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return childs.get(groupPosition).get(childPosition);
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
        holderChild.img.setImageResource(childs.get(groupPosition).get(childPosition).getImg());
        holderChild.info.setText(childs.get(groupPosition).get(childPosition).getInfo());
        holderChild.money.setText("￥" + childs.get(groupPosition).get(childPosition).getMoney());
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
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
