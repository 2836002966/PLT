package com.example.plb.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.plb.R;
import com.example.plb.fragment.ShopFragment;

/**
 * Created by Administrator on 2019/1/3.
 */

public class MyListAdapter extends BaseAdapter{

    private Context context;
    private String[] strings;
    public static int mPosition;
    private int resource;

    public MyListAdapter(Context context, String[] strings, int resource) {
        this.context = context;
        this.strings = strings;
        this.resource = resource;
    }

    @Override
    public int getCount() {
        return strings.length;
    }

    @Override
    public Object getItem(int position) {
        return strings[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView= LayoutInflater.from(context).inflate(R.layout.listview_item,null);
        TextView textView=convertView.findViewById(R.id.stores_textView);
        mPosition=position;
        textView.setText(strings[position]);
        if (position== ShopFragment.mPosition){
            convertView.setBackgroundColor(Color.parseColor("#a9b7b7"));
        }else {
            convertView.setBackgroundColor(Color.WHITE);
        }

        return convertView;
    }


}
