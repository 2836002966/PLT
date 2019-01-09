package com.example.plb.activity;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.plb.R;
import com.example.plb.fragment.HasCompleteFragment;
import com.example.plb.fragment.HasPaymentFragment;
import com.example.plb.fragment.StayPaymentFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * 我的订单
 */
public class OrderActivity extends AppCompatActivity implements View.OnClickListener{

    private TextView tv_stayPayment, tv_hasPayment, tv_hasComplete;
    private ViewPager vp_viewPager;
    private StayPaymentFragment stayPaymentFragment;
    private HasPaymentFragment hasPaymentFragment;
    private HasCompleteFragment hasCompleteFragment;
    private List<Fragment> mFragmentList = new ArrayList<Fragment>();
    private FragmentAdapter mFragmentAdapter;
    private ImageView iv_exit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        initUI();
        mFragmentAdapter = new FragmentAdapter(this.getSupportFragmentManager(), mFragmentList);
        vp_viewPager.setOffscreenPageLimit(4);  //ViewPager的缓存为4帧
        vp_viewPager.setAdapter(mFragmentAdapter);  //开启适配器
        vp_viewPager.setCurrentItem(0); //初始设置ViewPager选中第一帧
        tv_stayPayment.setTextColor(Color.parseColor("#ffffff"));  //选中第一个颜色的字体
        tv_stayPayment.setBackgroundColor(Color.parseColor("#ed6a1a"));  //选中第一个颜色的背景
        //ViewPager的监听事件
        vp_viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                /*此方法在页面被选中时调用*/
                changeTextColor(i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    /**
     * 初始化布局
     */
    private void initUI() {
        tv_stayPayment = findViewById(R.id.tv_stayPayment);
        tv_hasPayment = findViewById(R.id.tv_hasPayment);
        tv_hasComplete = findViewById(R.id.tv_hasComplete);
        vp_viewPager = findViewById(R.id.vp_viewPager);
        iv_exit = findViewById(R.id.iv_exit);
        tv_stayPayment.setOnClickListener(this);
        tv_hasPayment.setOnClickListener(this);
        tv_hasComplete.setOnClickListener(this);
        iv_exit.setOnClickListener(this);
        stayPaymentFragment = new StayPaymentFragment();
        hasPaymentFragment = new HasPaymentFragment();
        hasCompleteFragment = new HasCompleteFragment();
        //给FragmentList添加数据
        mFragmentList.add(stayPaymentFragment);
        mFragmentList.add(hasPaymentFragment);
        mFragmentList.add(hasCompleteFragment);
    }

    /**
     * 点击底部Text 动态修改ViewPager的内容
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_stayPayment:
                vp_viewPager.setCurrentItem(0, true);
                break;
            case R.id.tv_hasPayment:
                vp_viewPager.setCurrentItem(1, true);
                break;
            case R.id.tv_hasComplete:
                vp_viewPager.setCurrentItem(2, true);
                break;
            case R.id.iv_exit:
                finish();

                break;
                default:
                    break;
        }
    }

    public class FragmentAdapter extends FragmentPagerAdapter{

        List<Fragment> fragmentList = new ArrayList<Fragment>();

        public FragmentAdapter(FragmentManager fm, List<Fragment> fragmentList) {
            super(fm);
            this.fragmentList = fragmentList;
        }

        @Override
        public Fragment getItem(int i) {
            return fragmentList.get(i);
        }

        @Override
        public int getCount() {
            return fragmentList.size();
        }
    }

    /*
     *由ViewPager的滑动修改底部导航Text的颜色
     */
    private void changeTextColor(int position) {
        if (position == 0) {
            tv_stayPayment.setTextColor(Color.parseColor("#ffffff"));
            tv_stayPayment.setBackgroundColor(Color.parseColor("#ed6a1a"));
            tv_hasPayment.setTextColor(Color.parseColor("#000000"));
            tv_hasPayment.setBackgroundColor(Color.parseColor("#bdb8b4"));
            tv_hasComplete.setTextColor(Color.parseColor("#000000"));
            tv_hasComplete.setBackgroundColor(Color.parseColor("#bdb8b4"));
        } else if (position == 1) {
            tv_stayPayment.setTextColor(Color.parseColor("#000000"));
            tv_stayPayment.setBackgroundColor(Color.parseColor("#bdb8b4"));
            tv_hasPayment.setTextColor(Color.parseColor("#ffffff"));
            tv_hasPayment.setBackgroundColor(Color.parseColor("#ed6a1a"));
            tv_hasComplete.setTextColor(Color.parseColor("#000000"));
            tv_hasComplete.setBackgroundColor(Color.parseColor("#bdb8b4"));
        } else if (position == 2) {
            tv_stayPayment.setTextColor(Color.parseColor("#000000"));
            tv_stayPayment.setBackgroundColor(Color.parseColor("#bdb8b4"));
            tv_hasPayment.setTextColor(Color.parseColor("#000000"));
            tv_hasPayment.setBackgroundColor(Color.parseColor("#bdb8b4"));
            tv_hasComplete.setTextColor(Color.parseColor("#ffffff"));
            tv_hasComplete.setBackgroundColor(Color.parseColor("#ed6a1a"));
        }
    }
}
