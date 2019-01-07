package com.example.plb.activity;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.plb.R;
//确认订单
public class FirmOrder extends Activity implements View.OnClickListener{
    ImageView back;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firm_order);
        initView();
    }
    private void initView(){
        back=findViewById(R.id.order_back);
        back.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.order_back:
                finish();
                break;
        }
    }
}
