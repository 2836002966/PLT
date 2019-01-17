package com.example.plb.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import com.example.plb.R;
import com.example.plb.adapter.PaymentAdapter;
import com.example.plb.bean.PaymentInformation;

import java.util.ArrayList;

/**
 * 待付款
 * A simple {@link Fragment} subclass.
 */
public class StayPaymentFragment extends Fragment {

    private PaymentAdapter adapter;
    private ListView lv_payment;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_stay_payment, container, false);
        //获取listview实例
        lv_payment = view.findViewById(R.id.lv_payment);
        adapter = new PaymentAdapter();
        //添加适配器
        lv_payment.setAdapter(adapter);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
    }
}
