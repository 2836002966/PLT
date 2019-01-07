package com.example.plb.activity;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.plb.R;

/**
 * Created by 陈 on 2019/1/3.
 */

public class AddShopPopupwindow extends PopupWindow{
    private View view;
    private ImageView imageView;
    private ImageView shop_img;//商品图片
    private TextView shop_name;//商品名称
    private TextView shop_beginSum;//商品起售数量
    private TextView shop_Price;//商品价格
    private TextView shop_Num;//商品可售数量
    private TextView shop_buyNum;//购买数量
    private ImageButton delete_shopNum;//减少数目
    private ImageButton add_shopNum;//增加数目
    private TextView shop_Sum;//商品购买数量
    private TextView num_tv;//底部商品购买数量
    private TextView money_tv;//商品总价
    private Button add_btn;//确认数目后加入进货单
    int i=1;
    public AddShopPopupwindow(Activity context, View.OnClickListener itemsOnClick){
        super(context);
        initView(context, itemsOnClick);
    }

    private void initView(final Activity context, View.OnClickListener itemsOnClick) {
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE);
        view = mInflater.inflate(R.layout.layout_addshop, null);
        initview();
        delete_shopNum.setOnClickListener (new MyOnClickListener());
        add_shopNum.setOnClickListener (new MyOnClickListener());
        imageView = view.findViewById(R.id.diss);
        imageView.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View view) {
                //销毁弹出框
                dismiss();
                backgroundAlpha(context, 1f);
            }
        } );
        //设置SelectPicPopupWindow的View
        this.setContentView(view);
        //设置SelectPicPopupWindow弹出窗体的宽
        this.setWidth( WindowManager.LayoutParams.MATCH_PARENT);
        //设置SelectPicPopupWindow弹出窗体的高
        this.setHeight( WindowManager.LayoutParams.WRAP_CONTENT);
        //设置SelectPicPopupWindow弹出窗体可点击
        this.setFocusable(true);
        //设置PopupWindow可触摸
        this.setTouchable(true);
        //设置SelectPicPopupWindow弹出窗体动画效果
//    this.setAnimationStyle(R.style.select_anim);
        //实例化一个ColorDrawable颜色为半透明
        ColorDrawable dw = new ColorDrawable(0x00000000);
        //设置SelectPicPopupWindow弹出窗体的背景
        this.setBackgroundDrawable(dw);
        backgroundAlpha(context, 0.5f);//0.0-1.0
        this.setOnDismissListener(new OnDismissListener() {

            @Override
            public void onDismiss() {
                backgroundAlpha(context, 1f);
            }
        });
    }

    /**
     * 设置添加屏幕的背景透明度
     *
     * @param v
     */

    void backgroundAlpha(Activity context, float v) {
        WindowManager.LayoutParams lp = context.getWindow().getAttributes();
        lp.alpha = v;
        context.getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        context.getWindow().setAttributes(lp);
    }

    private void initview() {
        shop_img = view.findViewById ( R.id.shop_img );
        shop_name = view.findViewById ( R.id.shop_name );
        shop_beginSum = view.findViewById ( R.id.shop_beginSum );
        shop_Price = view.findViewById ( R.id.shop_Price );
        shop_buyNum = view.findViewById ( R.id.shop_buyNum );
        delete_shopNum = view.findViewById ( R.id.delete_shopNum );
        add_shopNum = view.findViewById ( R.id.add_shopNum );
        shop_Sum = view.findViewById ( R.id.shop_Sum );
        num_tv = view.findViewById ( R.id.num_tv );
        money_tv = view.findViewById ( R.id.money_tv );
        add_btn = view.findViewById ( R.id.add_btn );
    }

    private class MyOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId ()){
                case R.id.add_shopNum:
                    i++;
                    shop_Sum.setText ( i+"" );
                    money_tv.setText ( "￥"+i*Float.parseFloat ( shop_Price.getText ().toString ())+"" );
                    num_tv.setText ("共"+i+"箱" );
                    break;
                case R.id.delete_shopNum:
                    if (i<2){
                        Toast.makeText ( view.getContext (),"商品最少起售为1",Toast.LENGTH_SHORT ).show ();
                    }else {
                        i--;
                    }
                    shop_Sum.setText ( i+"" );
                    num_tv.setText ( "共"+i+"箱" );
                    money_tv.setText ( "￥"+i*Float.parseFloat ( shop_Price.getText ().toString ())+"" );
                    break;
            }
        }
    }
}
