package com.zrx.domain;

import java.io.Serializable;
import java.util.Date;

public class UserX implements Serializable {
    //    id       int(11)     not null auto_increment,
    //    username varchar(32) not null comment '用户名称',
    //    birthday datetime     default null comment '生日',
    //    sex      char(1)      default null comment '性别',
    //    address  varchar(256) default null comment '地址',

    private Integer userId;
    private String userName;
    private Date userBirthday;
    private String userSex;
    private String userAddress;


    @Override
    public String toString() {
        return "UserX{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userBirthday=" + userBirthday +
                ", userSex='" + userSex + '\'' +
                ", userAddress='" + userAddress + '\'' +
                '}';
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
}
