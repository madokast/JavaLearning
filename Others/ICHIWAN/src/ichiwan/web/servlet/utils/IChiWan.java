package ichiwan.web.servlet.utils;

import ichiwan.domain.deprecated.IChiWanBean;
import org.apache.commons.beanutils.BeanUtils;

import java.util.Properties;

public class IChiWan {
    private static IChiWanBean iChiWanBean = null;

    static {
        Properties properties = new Properties();
        try {
            properties.load(IChiWan.class.getClassLoader().getResourceAsStream("ichiwan.properties"));
            BeanUtils.populate(iChiWanBean, properties);

        } catch (Exception ee) {
            ee.printStackTrace();
        }
    }

    public static void loadProperties(){
        System.out.println("ichiwan.properties加载完毕");
        System.out.println(iChiWanBean);
    }


}
