package net.xdclass.demo.utils;

import org.slf4j.Logger;

/**
 * Description
 * 日志工具类
 * <p>
 * Data
 * 2019/12/22 16:28
 *
 * @author zrx
 * @version 1.0
 */

public class LoggerFactory {

    public static Logger getLogger(Class klass){
        return org.slf4j.LoggerFactory.getLogger(klass);
    }
}
