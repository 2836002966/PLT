package com.example.plb.activity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.plb.R;
import com.example.plb.bean.ProductInfo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ProductInfoActivity extends Activity implements Serializable,View.OnClickListener,AdapterView.OnItemSelectedListener{
    private ListView mProListView;  //商品的Listview
    private List<ProductInfo> productInfoList = new ArrayList<>();  //商品数据
    private MyProductInfoAdapter myProductInfoAdapter;              //商品信息适配器
    private Spinner mSpinner;       //综合下拉
    private Context mContext;       //当前上下文
    private EditText mEditSearch;   //搜索框
    private ImageButton mBackBtn;   //返回
    private ImageButton mShoppingCar;         //购物车
    private LinearLayout mShaiXuanLayout;     //筛选

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            //让应用主题内容占用系统状态栏的空间,注意:下面两个参数必须一起使用 stable 牢固的
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN|View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            //设置状态栏颜色为透明
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }

        setContentView(R.layout.activity_product_info);
        mContext = this;

        initData();
        init();

        //输入完内容点击搜索后，隐藏键盘
        mEditSearch.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_SEARCH) {
                    handled = true;
                     /*隐藏软键盘*/
                    InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    if (inputMethodManager.isActive()) {
                        inputMethodManager.hideSoftInputFromWindow(ProductInfoActivity.this.getCurrentFocus().getWindowToken(), 0);
                    }
                }
                return handled;
            }
        });
    }

    @SuppressLint("ResourceAsColor")
    private void init(){
        mEditSearch = findViewById(R.id.search);

        mShoppingCar = findViewById(R.id.shopping_car_btn);
        mShoppingCar.setOnClickListener(this);
        mBackBtn = findViewById(R.id.back_btn);
        mBackBtn.setOnClickListener(this);
        mShaiXuanLayout = findViewById(R.id.shaixuan);
        mShaiXuanLayout.setOnClickListener(this);

        //商品信息
        mProListView = findViewById(R.id.list_view_product_info);
        myProductInfoAdapter = new MyProductInfoAdapter();
        mProListView.setAdapter(myProductInfoAdapter);

        //综合下拉栏
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
            productInfoList.add(new ProductInfo(R.mipmap.wahaha,"哇哈哈",2,false,2,"五一市场"));
            productInfoList.add(new ProductInfo(R.mipmap.hn,"快线营养",10,false,4,"六一市场"));
            productInfoList.add(new ProductInfo(R.mipmap.ala,"粤利粤",20,true,8,"七一市场"));
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
            case R.id.shopping_car_btn:
                break;
        }
    }

    private void openShaiXuan(){
        Dialog dialog = new Dialog(mContext,R.style.ProductInfoDialogStyle);
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_productinfo_rightmenu,null);
        //将布局设置给Dialog
        dialog.setContentView(view);
        //获取当前窗口
        Window dialogWindow = dialog.getWindow();
        //设置dialog从右边弹出
        dialogWindow.setGravity(Gravity.RIGHT);
        //获得窗口体属性
        WindowManager.LayoutParams lp = dialogWindow.getAttributes();
        //设置或修改属性
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.height = WindowManager.LayoutParams.MATCH_PARENT;

        //将获得的窗口体属性设置给dialog
        dialogWindow.setAttributes(lp);
        dialog.show();
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
                            View bigView = LayoutInflater.from(mContext)
                                .inflate(R.layout.item_productinfo_big_image,null);
                        ImageView imageView = bigView.findViewById(R.id.big_show);
                        imageView.setImageResource(holder.getProImageButtonPath());
                        Log.d("888", imageView.toString());

                        Dialog dialog = new Dialog(ProductInfoActivity.this);
                        dialog.setContentView(bigView);
                        dialog.show();
                        Toast.makeText(ProductInfoActivity.this
                                ,holder.getProImageButtonPath()
                                ,Toast.LENGTH_SHORT).show();
                    }
                });

                holder.mProDataLayout.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //点击显示商品详情/传值
                        Intent intent = new Intent(ProductInfoActivity.this
                                ,DetailsActivity.class);
                        intent.putExtra("shopName",holder.getShopName());
                        intent.putExtra("market",holder.getMarket());
                        startActivityForResult(intent,88888);
                    }
                });

                //给显示商品模块的各项控件设值
                holder.mProImageButton.setBackgroundResource(holder.getProImageButtonPath());
                holder.mShopName.setText(holder.getShopName()+"");
                holder.mMinNum.setText(holder.getMinNum()+"");
                if(!holder.isShowJK()){
                    holder.mJinKouImage.setVisibility(View.INVISIBLE);
                }else {
                    holder.mJinKouImage.setVisibility(View.VISIBLE);
                }
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
