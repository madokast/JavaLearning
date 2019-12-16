package net.xdclass.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.Date;

/**
 * Description
 * pojo
 * <p>
 * Data
 * 2019/12/15 15:56
 *
 * @author zrx
 * @version 1.0
 */

public class User implements Serializable {
    @JsonInclude
    private String name;

    //别名 防止别人知道真实的数据库字段
    @JsonProperty("年龄")
    private int age;

    //忽略
    @JsonIgnore
    private String pwd;

    //格式化
    @JsonFormat(pattern = "yyyy年MM月dd日 hh时mm分ss秒" ,locale = "zh", timezone = "GMT+8")
    private Date createTime;


    public User() {
    }

    public User(String name, int age, String pwd) {
        this.name = name;
        this.age = age;
        this.pwd = pwd;
    }

    public User(String name, int age, String pwd, Date createTime) {
        this.name = name;
        this.age = age;
        this.pwd = pwd;
        this.createTime = createTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", pwd='" + pwd + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
