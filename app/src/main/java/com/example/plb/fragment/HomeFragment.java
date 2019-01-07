package com.example.plb.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.plb.R;
import com.example.plb.XiangxiProductInfo;
import com.example.plb.bean.ProductInfo;
import com.example.plb.adapter.MyAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhc on 2018/12/27.
 * 首页
 */
public class HomeFragment extends Fragment implements View.OnClickListener{
    private View view;
    private ViewPager viewPager;
    private ViewPager viewPager_hot;
    private MyAdapter adapter;
    private MyAdapter adapter_hot;
    private List<Fragment> fragments;
    private List<Fragment> fragments_hot;
    private ImageView dot1,dot2,dot3,dot4;
    private FragmentManager manager;
    int i=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,null);
        init(view);
        manager = getActivity().getSupportFragmentManager();
        return view;
    }

    private void init(View view) {
        viewPager = view.findViewById(R.id.viewPager1);
        viewPager_hot=view.findViewById(R.id.viewPager2);
        fragments = new ArrayList<>();
        fragments.add(new HomeFragment_1());
        fragments.add(new HomeFragment_2());
        fragments.add(new HomeFragment_3());
        fragments.add(new HomeFragment_4());

        fragments_hot = new ArrayList<>();
        fragments_hot.add(new HomeFragment_hot_1());
        fragments_hot.add(new HomeFragment_hot_2());

        dot1 = view.findViewById(R.id.dot1);
        dot2 = view.findViewById(R.id.dot2);
        dot3 = view.findViewById(R.id.dot3);
        dot4 = view.findViewById(R.id.dot4);
        dot1.setOnClickListener(this);
        dot2.setOnClickListener(this);
        dot3.setOnClickListener(this);
        dot4.setOnClickListener(this);
        adapter = new MyAdapter(getActivity().getSupportFragmentManager(),fragments);
        adapter_hot=new MyAdapter(getActivity().getSupportFragmentManager(),fragments_hot);
        viewPager.setAdapter(adapter);
        viewPager_hot.setAdapter(adapter_hot);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int j) {
                switchImage(j);
               i=j;
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }
    private void initImg(int...index){
        dot1.setImageResource(index[0]);
        dot2.setImageResource(index[1]);
        dot3.setImageResource(index[2]);
        dot4.setImageResource(index[3]);
    }
    private void switchImage(int position) {
        switch (position) {
            case 0:
                initImg(R.mipmap.dot_1, R.mipmap.dot_2,
                        R.mipmap.dot_2, R.mipmap.dot_2);
                break;
            case 1:
                initImg(R.mipmap.dot_2, R.mipmap.dot_1,
                        R.mipmap.dot_2, R.mipmap.dot_2);
                break;
            case 2:
                initImg(R.mipmap.dot_2, R.mipmap.dot_2,
                        R.mipmap.dot_1, R.mipmap.dot_2);
                break;
            case 3:
                initImg(R.mipmap.dot_2, R.mipmap.dot_2,
                        R.mipmap.dot_2, R.mipmap.dot_1);
                break;

            default:
                break;
        }
    }

    @Override
    public void onClick(View v) {
        FragmentTransaction transaction = manager.beginTransaction();
        switch (v.getId()){
            case R.id.dot1:
                viewPager.setCurrentItem(0);
                i=0;
                break;
            case R.id.dot2:
                viewPager.setCurrentItem(1);
                i=1;
                break;
            case R.id.dot3:
                viewPager.setCurrentItem(2);
                i=2;
                break;
            case R.id.dot4:
                viewPager.setCurrentItem(3);
                i=3;
                break;
        }
        transaction.commit();
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            if (msg.what==0){
                if (i>3){
                    i=0;
                }
               viewPager.setCurrentItem(i);
                i++;
                handler.sendEmptyMessageDelayed(0,2000);
            }
        }
    };

    @Override
    public void onStop() {
        super.onStop();
        handler.removeMessages(0);
    }

    @Override
    public void onStart() {
        super.onStart();
        handler.sendEmptyMessage(0);
    }
}
