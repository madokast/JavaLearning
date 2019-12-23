package net.xdclass.demo.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LoggerFactoryBinder;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Description
 * 定时任务
 * <p>
 * Data
 * 2019/12/21 17:06
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class Task {

    private final Logger LOG = LoggerFactory.getLogger(Task.class);

    /**
     * 需要在main类设置开启定时任务
     * @ EnableScheduling
     *
     * @ Scheduled(fixedRate = 2000)
     * 每隔2s执行一次
     *
     * @ Scheduled(cron = "")
     * cron 格式的定时计划
     *
     *
     */
    @Scheduled(fixedRate = 1000*60*60)
    public void test(){
        LOG.info("定时任务执行");
    }
}
