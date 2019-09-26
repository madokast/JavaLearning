package com.smart.AOP;

import org.springframework.beans.factory.annotation.Autowired;

public class Person implements Sayable{
    private String name;

    public void say(){
        System.out.println("I'm "+ name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
