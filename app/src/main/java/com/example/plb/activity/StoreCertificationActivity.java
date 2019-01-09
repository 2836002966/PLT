package com.example.plb.activity;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.plb.R;

public class StoreCertificationActivity extends AppCompatActivity implements View.OnClickListener{
   private ImageView iv_exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_store_certification);
        ActionBarTitle();
        init();
    }

    private void init(){
        iv_exit = findViewById(R.id.iv_exit);
        iv_exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_exit:
                finish();
                break;
                default:
                    break;
        }

    }
    private void ActionBarTitle(){
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.hide();
        }
    }
}
