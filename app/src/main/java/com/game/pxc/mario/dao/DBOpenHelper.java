package com.game.pxc.mario.dao;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.content.Context;

/**
 * 实现创建数据库，数据表等功能
 */

public class DBOpenHelper extends  SQLiteOpenHelper{
    private static final int VERSION = 1;//定义数据库版本号
    private static final String DBNAME = "score.db";//定义数据库名

    public DBOpenHelper(Context context)//定义构造函数
    {
        super(context, DBNAME, null, VERSION);//重写基类的构造函数
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table tb_score(_id integer primary key,score integer)");
    }

    //覆写基类的onUpgrade方法，以便数据库版本更新
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
