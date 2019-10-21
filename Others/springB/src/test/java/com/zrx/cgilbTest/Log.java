package com.zrx.cgilbTest;

import java.util.Date;

public class Log {
    public void log(String info){
        System.out.println(new Date()+": " + info);
    }
}
