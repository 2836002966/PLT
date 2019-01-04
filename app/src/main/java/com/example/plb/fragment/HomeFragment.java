package com.example.plb.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.plb.R;
import com.example.plb.XiangxiProductInfo;
import com.example.plb.bean.ProductInfo;

/**
 * Created by zhc on 2018/12/27.
 * 首页
 */
public class HomeFragment extends Fragment {

    private View view;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home,null);
        Log.d("88888", "onCreateView: "+"进入Fragment");

        view.findViewById(R.id.btn_abc).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), XiangxiProductInfo.class));
            }
        });

        return view;
    }
}
