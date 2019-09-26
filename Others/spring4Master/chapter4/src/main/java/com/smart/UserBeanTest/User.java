package com.smart.UserBeanTest;

public class User {
    private String usename;
    private String password;

    public void sayHello(){
        System.out.println(toString());
    }

    @Override
    public String toString() {
        return "User{" +
                "usename='" + usename + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
