package com.example.plb.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.plb.R;
import com.example.plb.bean.ShopCartItem;

import java.util.List;

/**
 * Created by zhc on 2019/1/4.
 */
public class ShopCartAdapter extends BaseAdapter {

    private Context context;
    private List<ShopCartItem> items;
    private LinearLayout content;

    public ShopCartAdapter(Context context, List<ShopCartItem> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null){
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.item_shopcart,null);
            holder.address = convertView.findViewById(R.id.address);
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        content = convertView.findViewById(R.id.content);
        holder.address.setText(items.get(position).getAddress());
        for (int i = 0; i < items.size(); i++) {
            for (int j = 0; j < items.get(i).getImgs().size(); j++) {
                final int index = j;
                View view = LayoutInflater.from(context)
                        .inflate(R.layout.item_horizontalscrollview,null);
                ImageView img = view.findViewById(R.id.img);
                TextView money = view.findViewById(R.id.money);
                CheckBox ck = view.findViewById(R.id.ck);
                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(context,index + "",Toast.LENGTH_SHORT).show();
                    }
                });
                img.setImageResource(items.get(i).getImgs().get(j));
                money.setText("￥" + items.get(i).getMoneys().get(j)+"");
                content.addView(view);
            }
        }
        return convertView;
    }

    class ViewHolder{
        TextView address;
    }

}
