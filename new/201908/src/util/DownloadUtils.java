package util;


//import sun.misc.BASE64Encoder;
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Objects;

public class DownloadUtils {
    public static String getFilename(String agent,String filename)throws UnsupportedEncodingException {
        Objects.requireNonNull(agent);
        Objects.requireNonNull(filename);
        if(agent.contains("MSIE")){
            //IE 浏览器
            filename = URLEncoder.encode(filename,"utf-8");
            filename = filename.replace("+"," ");
        }else if(agent.contains("Firefox")){
            //火狐浏览器
            filename = "=?utf-8?B?" + Base64.encodeBase64String(filename.getBytes("utf-8")) + "?=";
        }else {
            //其他浏览器
            filename = URLEncoder.encode(filename,"utf-8");
        }

        return filename;

    }
}
