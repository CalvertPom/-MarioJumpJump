package com.game.pxc.mario.util;
/*随机数工具*/
public class PositionUtil {
    public static int getRangeX(int screenWidth) {
        double rate = Math.random();
        //随机生成小于0.75的数值
        while (rate>=0.75){
            rate = Math.random();
        }
        return (int) (screenWidth * rate);
    }
    public  static int getRangeT(){
        double rate = Math.random();
        rate = Math.random();

        return (int) (rate*10);
    }
}