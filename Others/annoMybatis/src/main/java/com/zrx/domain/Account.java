package com.zrx.domain;

import java.io.Serializable;

public class Account implements Serializable {
    //create table account(
    //    ID int(11) not null comment '编号',
    //    UID int(11) default null comment '用户编号',
    //    MONEY double default null comment '金额',
    //    PRIMARY KEY (ID),
    //    CONSTRAINT fk_a_u foreign key (UID) references user(id)
    //)engine = InnoDB default charset =utf8;

    private Integer id;
    private Integer uid;
    private Double money;

    // 从表对象 包含 主表对象的引用
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", uid=" + uid +
                ", money=" + money +
                ", user=" + user +
                '}';
    }
}
