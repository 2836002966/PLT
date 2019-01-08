package com.example.plb.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.plb.R;

/**
 * 已付款
 * A simple {@link Fragment} subclass.
 */
public class HasPaymentFragment extends Fragment {


    public HasPaymentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_has_payment, container, false);
        return view;
    }

}
