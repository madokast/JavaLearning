package net.xdclass.demo.domain;

import java.io.Serializable;

/**
 * Description
 * 文件上传状态
 * <p>
 * Data
 * 2019/12/15 20:49
 *
 * @author zrx
 * @version 1.0
 */

public class FileUploadState implements Serializable {
    private int code;
    private String info;
    private String otherInfo;

    @Override
    public String toString() {
        return "FileUploadState{" +
                "code=" + code +
                ", info='" + info + '\'' +
                ", otherInfo='" + otherInfo + '\'' +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getOtherInfo() {
        return otherInfo;
    }

    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }
}
