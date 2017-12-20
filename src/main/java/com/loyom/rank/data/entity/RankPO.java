package com.loyom.rank.data.entity;

import com.loyom.rank.data.Base;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tab_rank")
public class RankPO extends Base {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    //==主要属性===============
    @Column(name = "uid")
    private String uid;         //标识玩家的唯一ID
    @Column(name = "nick")
    private String nick;        //玩家昵称,用于展示
    @Column(name = "point")
    private Long point;        //玩家需要进行排名的分数

    //==扩展属性===============
    @Column(name = "area")
    private String area;        //玩家所属区域,Global,CN,US等等
    @Column(name = "category")
    private String category;    //分数所属类别,如:等级,战力,工会排行,积分,连续斩杀等
    @Column(name = "belong")
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
