package ichiwan.util;

import java.util.Date;

public class Tools {
    public static String addOnString(String number, int add) throws NumberFormatException {
        return String.valueOf(Integer.valueOf(number) + add);
    }

    /**
     * 计算两天间隔天数
     *
     * @param start 开始日期
     * @param end   结束日期
     * @return 间隔天数
     */
    public static int dateInterval(Date start, Date end) {
        return (int) (
                (end.getTime() - start.getTime()) / (1000 * 3600 * 24)
        );
    }

    public static void forceExit(){
        System.exit(-1);
    }
}
