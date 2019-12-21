package net.xdclass.demo.domain;

/**
 * Description
 * 自定义异常
 * <p>
 * Data
 * 2019/12/18 16:58
 *
 * @author zrx
 * @version 1.0
 */

public class MyException extends RuntimeException {

    private String code;
    private String msg;

    public MyException(String code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
