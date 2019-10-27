package com.zrx.exception;

import java.util.concurrent.Executors;

/**
 * 自动逸异常类
 */

public class SysException extends Exception {
    private String message;

    public SysException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
