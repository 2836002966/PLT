package com.example.plb.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by 陈 on 2019/1/15.
 */

public class ShopDatabase extends SQLiteOpenHelper{

    public ShopDatabase( Context context, int version) {
        super ( context, "shop.db", null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //建表
        String sql = "create table shop(_id integer primary key autoincrement,shop_img varchar,shop_title varchar,shop_money float,shop_Startselling int,shop_salablequantity int,shop_buyNum int,shop_totalprice flaot)";
        db.execSQL ( sql );
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
