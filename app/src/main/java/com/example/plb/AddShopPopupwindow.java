package com.example.plb;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.PopupWindow;

/**
 * Created by 陈 on 2019/1/3.
 */

public class AddShopPopupwindow extends PopupWindow {
    private View view;
    private ImageView imageView;
    public AddShopPopupwindow(Activity context, View.OnClickListener itemsOnClick){
        super(context);
        initView(context, itemsOnClick);
    }

    private void initView(final Activity context, View.OnClickListener itemsOnClick) {
        LayoutInflater mInflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE);
        view = mInflater.inflate(R.layout.layout_addshop, null);
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
        //设置非PopupWindow区域是否可触摸
//    this.setOutsideTouchable(false);
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
}