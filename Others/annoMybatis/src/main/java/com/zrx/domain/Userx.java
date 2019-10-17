package com.zrx.domain;

//mybatis
//
//什么是框架？半应用 抽象构建和交互方法 半成品软件
//mybatis —— 解决持久层问题
//
//三层架构
// 表现层：SpringMVC
// 业务层：Spring
// 持久层：Mybatis
//
//持久层方案
// JDBC技术 —— 只是规范
// Spring的JdbcTemplate —— 只是工具类
//
//mybatis框架
//	内部封装JDBC
//
//ORM 思想 ？

//实体类

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Userx implements Serializable {
    //    id       int(11)     not null auto_increment,
    //    username varchar(32) not null comment '用户名称',
    //    birthday datetime     default null comment '生日',
    //    sex      char(1)      default null comment '性别',
    //    address  varchar(256) default null comment '地址',

    private Integer uid;
    private String userName;
    private Date birthday;
    private String sex;
    private String address;

    @Override
    public String toString() {
        return "Userx{" +
                "uid=" + uid +
                ", userName='" + userName + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
