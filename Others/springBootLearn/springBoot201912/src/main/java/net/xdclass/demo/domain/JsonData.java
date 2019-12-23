package net.xdclass.demo.domain;

import java.io.Serializable;

/**
 * Description
 * json data
 * 相应结果类
 * <p>
 * Data
 * 2019/12/21 16:18
 *
 * @author zrx
 * @version 1.0
 */

public class JsonData implements Serializable {
    private Integer code;
    private Object data;
    private String msg;

    @Override
    public String toString() {
        return "JsonData{" +
                "code=" + code +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }

    public static JsonData bulidSuccess(Object data){
        final JsonData jsonData = new JsonData();
        jsonData.setCode(1);
        jsonData.setData(data);
        jsonData.setMsg("success");

        return jsonData;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
