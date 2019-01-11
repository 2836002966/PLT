package com.example.plb.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.plb.R;
import com.example.plb.bean.ProductInfo;

import java.util.ArrayList;
import java.util.List;

public class ProductInfoActivity extends Activity implements View.OnClickListener,AdapterView.OnItemSelectedListener{
    private ListView mProListView;  //商品的Listview
    private List<ProductInfo> productInfoList = new ArrayList<>();  //商品数据
    private MyProductInfoAdapter myProductInfoAdapter;              //商品信息适配器
    private Spinner mSpinner;       //综合下拉
    private Context mContext;       //当前上下文
    private EditText mEditSearch;   //搜索框
    private ImageButton mBackBtn;   //返回
    private LinearLayout mShaiXuanLayout;     //筛选

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_info);
        mContext = this;

        initData();
        init();

    }

    private void init(){
        mEditSearch = findViewById(R.id.search);
        mBackBtn = findViewById(R.id.back_btn);
        mBackBtn.setOnClickListener(this);
        mShaiXuanLayout = findViewById(R.id.shaixuan);
        mShaiXuanLayout.setOnClickListener(this);

        mProListView = findViewById(R.id.list_view_product_info);
        myProductInfoAdapter = new MyProductInfoAdapter();
        mProListView.setAdapter(myProductInfoAdapter);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getBaseContext()
                , R.array.zonghe, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner = findViewById(R.id.zonghe_spinner);
        mSpinner.setAdapter(adapter);
        mSpinner.setOnItemSelectedListener(this);

    }
    private void initData(){
        //添加商品数据
        for (int i=0;i<4;i++){
            productInfoList.add(new ProductInfo("哇哈哈",2,false,2,"五一市场"));
            productInfoList.add(new ProductInfo("快线营养",10,false,4,"六一市场"));
            productInfoList.add(new ProductInfo("粤利粤",20,true,8,"七一市场"));
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_btn:
                finish();
                break;
            case R.id.shaixuan:
                openShaiXuan();
                break;
        }
    }

    private void openShaiXuan(){

    }

    //综合的子项选择
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public class MyProductInfoAdapter extends BaseAdapter{
        @Override
        public int getCount() {
            return productInfoList.size();
        }
        @Override
        public Object getItem(int position) {
            return productInfoList.get(position);
        }
        @Override
        public long getItemId(int position) {
            return position;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ProductInfo holder;
            if (convertView==null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_productinfo, null);
                holder = productInfoList.get(position);

                //初始化图片按钮、信息介绍layout
                holder.mProImageButton = convertView.findViewById(R.id.productinfo_img);
                holder.mProDataLayout = convertView.findViewById(R.id.productinfo_data);
                holder.mJinKouImage = convertView.findViewById(R.id.productinfo_shop_jinkou);
                holder.mShopName = convertView.findViewById(R.id.productinfo_shop_name);
                holder.mMinNum = convertView.findViewById(R.id.productinfo_min_shop_number);
                holder.mDanjia = convertView.findViewById(R.id.productinfo_shop_price);
                holder.mMarket = convertView.findViewById(R.id.productinfo_market);

                //处理图片按钮功能
                holder.mProImageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(ProductInfoActivity.this
                                ,"123",Toast.LENGTH_SHORT).show();
                    }
                });
                //点击显示商品详情/传值
                holder.mProDataLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(ProductInfoActivity.this
                                ,DetailsActivity.class);
                        intent.putExtra("id",88888);
                        intent.putExtra("shopName",holder.getShopName());
                        intent.putExtra("shopMarket",holder.getMarket());
                        startActivity(intent);
                    }
                });

                //给显示商品模块的各项控件设值
                if(!holder.isShowJK()){
                    holder.mJinKouImage.setVisibility(View.INVISIBLE);
                }else {
                    holder.mJinKouImage.setVisibility(View.VISIBLE);
                }
                holder.mShopName.setText(holder.getShopName()+"");
                holder.mMinNum.setText(holder.getMinNum()+"");
                holder.mDanjia.setText(holder.getDanjia()+"");
                holder.mMarket.setText(holder.getMarket()+"");
                
                convertView.setTag(holder);
            }else {
                holder = (ProductInfo) convertView.getTag();
            }
            return convertView;
        }
    }

}
