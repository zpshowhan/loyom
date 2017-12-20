package com.loyom.rank.data.request;

import com.loyom.rank.data.Base;

public class Rank extends Base {

    //==主要属性===============
    private String uid;         //标识玩家的唯一ID
    private String nick;        //玩家昵称,用于展示
    private Long point;        //玩家需要进行排名的分数

    //==扩展属性===============
    private String area;        //玩家所属区域,Global,CN,US等等
    private String category;    //分数所属类别,如:等级,战力,工会排行,积分,连续斩杀等
    private String belong;      //玩家所属? **工会? **家族? **门派?

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public Long getPoint() {
        return point;
    }

    public void setPoint(Long point) {
        this.point = point;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBelong() {
        return belong;
    }

    public void setBelong(String belong) {
        this.belong = belong;
    }
}
