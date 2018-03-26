package com.game.pxc.mario.model;
/**
 * 分数实体类
 */

public class Tb_score {
    private int _id;//存储分数编号
    private int score;//存储获得分数值


    public  Tb_score() {
        super();
    }
    public Tb_score(int id,int score ){
        super();
        this._id=id;
        this.score=score;
    }
    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }


}
