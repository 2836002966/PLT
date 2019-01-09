package com.example.plb.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.plb.R;

/**
 * 已完成
 * A simple {@link Fragment} subclass.
 */
public class HasCompleteFragment extends Fragment {


    public HasCompleteFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_has_complete, container, false);
        return view;
    }

}
