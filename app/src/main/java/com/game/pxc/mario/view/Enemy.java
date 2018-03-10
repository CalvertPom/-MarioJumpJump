package com.game.pxc.mario.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/*敌人*/
public class Enemy   {
    public static final int SPEED = 10;
    private int eHeaderRadius;
    private Paint mPaint;
    //下边缘坐标
    public int ePersonY;
    public int ePersonX;
    private Bitmap bitmap;

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }
    public Enemy(Paint paint, int radius, Bitmap bitmap) {
        this.mPaint = paint;
        this.eHeaderRadius = radius;
        this.bitmap = bitmap;
    }

    /**
     * 绘制一个圆形图片
     */
    public void draw(Canvas canvas) {

        canvas.save();
        Path path = new Path();
        path.addCircle(ePersonX + eHeaderRadius, ePersonY + eHeaderRadius, eHeaderRadius*3, Path.Direction.CCW);
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap, null, new RectF(ePersonX, ePersonY, ePersonX +   eHeaderRadius*7/6, ePersonY + eHeaderRadius * 5/3), mPaint);

        canvas.restore();
    }

}
