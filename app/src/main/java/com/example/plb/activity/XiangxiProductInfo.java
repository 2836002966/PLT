package com.example.plb.activity;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.plb.R;
import com.example.plb.bean.ProductInfo;

import java.util.ArrayList;
import java.util.List;

public class XiangxiProductInfo extends Activity implements View.OnClickListener{
    private ListView mProListView;  //商品的Listview
    private List<ProductInfo> productInfoList = new ArrayList<>();  //商品数据
    private MyProductInfoAdapter myAdapter; //自定义商品信息适配器
    private Context mContext;       //当前上下文
    private EditText mEditSearch;   //搜索框
    private ImageButton mBackBtn;   //返回
    private Dialog mProDialog;      //点击商品信息底部弹出对话框
    private View mProDialogView;    //底部对话框的视图

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

        mProListView = findViewById(R.id.list_view_product_info);
        myAdapter = new MyProductInfoAdapter();
        mProListView.setAdapter(myAdapter);
    }
    private void initData(){
        for (int i=0;i<12;i++){
            ProductInfo pro = new ProductInfo(i,"哦"+i+"啊");
            productInfoList.add(i,pro);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.back_btn:
                finish();
                break;
        }
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
            Log.d("88888", "getView: "+"进来了");
            ProductInfo holder;
            if (convertView==null) {
                convertView = LayoutInflater.from(mContext).inflate(R.layout.item_productinfo, null);
                holder = productInfoList.get(position);

                holder.mProImageButton =  convertView.findViewById(R.id.productinfo_img);
                holder.mProDataLayout = convertView.findViewById(R.id.productinfo_data);
                //点击列表图片进行图片放大
                holder.mProImageButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("88888", "onClick: btn");
                    }
                });
                //点击列表底部弹出对话框
                holder.mProDataLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //给自定义对话框设置样式
                        mProDialog = new Dialog(mContext,R.style.ProductInfoDialogStyle);
                        //绑定视图布局
                        mProDialogView = LayoutInflater.from(mContext)
                                .inflate(R.layout.activity_product_info_dialog,null);
                        //... 给对话框中控件附加功能

                        //给自定义对话框绑定布局
                        mProDialog.setContentView(mProDialogView);
                        //获取当前Activity所在的窗口
                        Window dialogwindow = mProDialog.getWindow();
                        //设置对话框从窗口底部弹出
                        dialogwindow.setGravity(Gravity.BOTTOM);

                        //获取窗口的属性
                        WindowManager.LayoutParams layoutParams = dialogwindow.getAttributes();
                        layoutParams.y = 0;    //设置对话窗从底部弹出的间距
                        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;   //设置宽
                        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;  //设置高

                        //将属性设置给窗口
                        dialogwindow.setAttributes(layoutParams);
                        mProDialog.show();
                    }
                });

                convertView.setTag(holder);
            }else {
                holder = (ProductInfo) convertView.getTag();
            }

            return convertView;
        }
    }

}
