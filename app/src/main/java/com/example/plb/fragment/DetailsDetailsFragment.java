package com.example.plb.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.plb.R;

/**
 * Created by 陈 on 2019/1/2.
 */

public class DetailsDetailsFragment extends Fragment {
    private View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate ( R.layout.fragment_details_details,null );
        return view;
    }
}
