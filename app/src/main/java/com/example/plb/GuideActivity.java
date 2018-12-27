package com.example.plb;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class GuideActivity extends AppCompatActivity {

    private boolean isFirst;
    private Handler handler;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        handler = new Handler();
        sp = getSharedPreferences("guide",MODE_PRIVATE);
        editor = sp.edit();
        sp.getBoolean("isFirst",true);
        if (isFirst){
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    editor.putBoolean("isFirst",false).apply();
                    startActivity(new Intent(GuideActivity.this,MainActivity.class));
                }
            },3000);
        }else {
            startActivity(new Intent(GuideActivity.this,MainActivity.class));
        }

    }
}
