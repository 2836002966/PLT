package com.example.plb.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.plb.activity.StoreCertificationActivity;
import com.example.plb.activity.LoginPageActivity;
import com.example.plb.activity.OrderActivity;
import com.example.plb.R;
import com.example.plb.activity.SettingActivity;

/**
 * Created by zhc on 2018/12/27.
 * 个人中心
 */
public class PersonalFragment extends Fragment implements View.OnClickListener{

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_personal,null);
        init();
        return view;
    }

    //初始化控件
    private void init() {
        RelativeLayout rl_myOrder = view.findViewById(R.id.rl_myOrder);
        RelativeLayout rl_setting = view.findViewById(R.id.rl_setting);
        RelativeLayout rl_subscription = view.findViewById(R.id.rl_subscription);
        RelativeLayout rl_collection = view.findViewById(R.id.rl_collection);
        rl_myOrder.setOnClickListener(this);
        rl_setting.setOnClickListener(this);
        rl_subscription.setOnClickListener(this);
        rl_collection.setOnClickListener(this);
    }

    /**
     * 设置监听
     * @param v
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.rl_myOrder:
                startActivity(new Intent(getActivity(), OrderActivity.class));
                break;
            case R.id.rl_setting:
                startActivity(new Intent(getActivity(), SettingActivity.class));
                break;
            case R.id.rl_subscription:
                startActivity(new Intent(getActivity(), LoginPageActivity.class));
                break;
            case R.id.rl_collection:
                startActivity(new Intent(getActivity(), StoreCertificationActivity.class));
                break;
                default:
                    break;
        }
    }
}
