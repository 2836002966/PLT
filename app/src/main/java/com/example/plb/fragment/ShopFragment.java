package com.example.plb.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.plb.DetailsActivity;
import com.example.plb.R;

/**
 * Created by zhc on 2018/12/27.
 * 店铺
 */
public class ShopFragment extends Fragment {

    private View view;
    private Button button;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_shop,null);
        button = view.findViewById ( R.id.btn_shop );
        button.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent ( getActivity (), DetailsActivity.class );
                startActivity ( intent );
            }
        } );
        return view;
    }
}
