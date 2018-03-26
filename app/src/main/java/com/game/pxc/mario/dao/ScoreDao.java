package com.game.pxc.mario.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.game.pxc.mario.model.Tb_score;

import java.util.ArrayList;
import java.util.List;

/**
 * 对分数信息进行管理
 */

public class ScoreDao {
    private DBOpenHelper helper;//创建DBOpenHelper对象
    private SQLiteDatabase db;//创建SQLiteDatebase对象

    public ScoreDao(Context context) {
        helper = new DBOpenHelper(context);
    }

    /*添加操作*/
    public void add(Tb_score tb_score) {
        db = helper.getWritableDatabase();//初始化SQLiteDatabase对象
        //执行添加操作
        db.execSQL("insert into tb_score(_id,score) values (?,?)", new Object[]{tb_score.get_id(), tb_score.getScore()});
    }

    /*更新信息*/
    public void update(Tb_score tb_score) {
        db = helper.getWritableDatabase();//初始化SQLiteDatabase对象
        //执行修改操作
        db.execSQL("upadate  tb_score set score=? where _id=?", new Object[]{tb_score.getScore(), tb_score.get_id()});
    }

    /*查找信息*/
    public Tb_score find(int id) {
        db = helper.getWritableDatabase();//初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select _id,score from tb_score where _id=?", new String[]{
                String.valueOf(id)});//根据编号查找收入信息，并存储到Cursor类中
        if (cursor.moveToNext())//便历查找到的
        {
            //将便历到的信息存储到Tb_score类中
            return new Tb_score(cursor.getInt(cursor.getColumnIndex("_id")), cursor.getInt(cursor.getColumnIndex("score")));
        }
        return null;//如果没有信息。返回null
    }

    /*删除信息*/
    public void delete(Integer... ids) {
        if (ids.length > 0)//判断是否存在要删除的id
        {
            StringBuffer sb = new StringBuffer();//创建StringBuffer对象
            for (int i = 0; i < ids.length; i++) {//便利要删除的id集合
                sb.append('?').append(',');//将删除条件添加到StringBuffer对象中
            }
            sb.deleteCharAt(sb.length() - 1);//去掉最后一个","字符
            db = helper.getWritableDatabase();//初始化SQLiteDatabase对象
            //执行删除操作
            db.execSQL("delete from tb_score where _id in(" + sb + ")", (Object[]) ids);
        }
    }

    /*
    *从分数数据表的指定索引处获取指定数量的分数数据，
    *其中start表示要从此处开始获取数据的索引，
    *参数count表示要获取的数量，
    *返回值为List<Tb_score>对象
    * */
    public List<Tb_score> getScrollData(int start, int count) {
        List<Tb_score> tb_score = new ArrayList<Tb_score>();//创建集合对象
        db = helper.getWritableDatabase();//初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select * from tb_score limit ?,?", new String[]{String.valueOf(start), String.valueOf(count)});//获取所有收入信息
        while (cursor.moveToNext())//遍历所有的分数信息
        {
            tb_score.add(new Tb_score(cursor.getInt(cursor.getColumnIndex("_id")), cursor.getInt(cursor.getColumnIndex("score"))));//将遍历到的分数信息添加到集合中
        }
        return tb_score;//返回集合
    }

    /*获取数据表的总计录数，返回值为获取到的总记录数*/
    public long getCount() {
        db = helper.getWritableDatabase();//初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select count(_id)from tb_score", null);//获取分数信息的记录数
        if (cursor.moveToNext()) {
            return cursor.getLong(0);//返回总记录数
        }
        return 0;//如果没有数据，则返回0
    }

    /*获取最高分*/
    public int getMaxScore() {
        db = helper.getWritableDatabase();//初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select max(score)from tb_score", null);//获取信息表中最大分数值
        while (cursor.moveToLast()) {//访问Cursor中的最后一条数据
            return cursor.getInt(0);//获取访问到的数据，即最大分数值
        }
        return 0;//如果没有数据，则返回0
    }

    /**
     * 获取收入最大编号
     */
    public int getMaxId() {
        db = helper.getWritableDatabase();// 初始化SQLiteDatabase对象
        Cursor cursor = db.rawQuery("select max(_id) from tb_score", null);// 获取收入信息表中的最大编号
        while (cursor.moveToLast()) {// 访问Cursor中的最后一条数据
            return cursor.getInt(0);// 获取访问到的数据，即最大编号
        }
        return 0;// 如果没有数据，则返回0
    }

}
