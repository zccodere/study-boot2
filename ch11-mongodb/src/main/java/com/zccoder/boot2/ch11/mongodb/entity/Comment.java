package com.zccoder.boot2.ch11.mongodb.entity;

/**
 * <br>
 * 标题: 评论<br>
 * 描述: 评论<br>
 * 时间: 2018/09/28<br>
 *
 * @author zc
 */
public class Comment {
    private int good;
    private int bad;

    public int getGood() {
        return good;
    }

    public void setGood(int good) {
        this.good = good;
    }

    public int getBad() {
        return bad;
    }

    public void setBad(int bad) {
        this.bad = bad;
    }

}
