package net.xdclass.demo.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Description
 * TODO
 * <p>
 * Data
 * 2019/12/18 21:00
 *
 * @author zrx
 * @version 1.0
 */

@WebListener
public class MyListener implements ServletContextListener {
    private final Logger LOG = LoggerFactory.getLogger(MyListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        LOG.info("监听器启动");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        LOG.info("监听器销毁");
    }
}
