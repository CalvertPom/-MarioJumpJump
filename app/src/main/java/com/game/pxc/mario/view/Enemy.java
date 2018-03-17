package com.game.pxc.mario.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/*敌人*/
public class Enemy   {
    //绘制的敌人位置纵坐标
    public int mEnemyY;
    public int mEnemyX;
    // 当前的障碍物图片



    private Bitmap bitEnemy;
    //当前的敌人类型
    public int  mEnemyT;



    //敌人的宽度
    private int mEWidth;
    //敌人的高度
    private int mEHeight;
    //屏幕的宽度
    private int mScreenWidth;

    private Paint mPaint;
    public int getmEWidth() {
        return mEWidth;
    }

    public int getmEHeight() {
        return mEHeight;
    }

    //不同类型换图
    public void setBitEnemy(Bitmap bitEnemy) {
        this.bitEnemy = bitEnemy;
    }
    public Enemy(int screenWidth, Paint paint, Bitmap bitmap) {
        this.mScreenWidth = screenWidth;
        this.mPaint = paint;
        this.mEWidth = mScreenWidth /16;
        this.bitEnemy = bitmap;
    }
    /**
     * 绘制一个黑色矩形
     */
    public void draw(Canvas canvas) {
        canvas.save();
        Path path = new Path();
        path.addRect(mEnemyX, mEnemyY, mEnemyX+ mEWidth , mEnemyY + mEHeight, Path.Direction.CCW);
        canvas.clipPath(path);
        canvas.drawBitmap(bitEnemy, null, new RectF(mEnemyX, mEnemyY, mEnemyX+ mEWidth , mEnemyY + mEHeight), mPaint);
        canvas.restore();
    }


    public void setHeight(int mHeight) {
        this.mEHeight = mHeight;
    }

    public int getWidth() {
        return this.mEWidth;
    }


}
