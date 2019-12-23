package net.xdclass.demo.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Null;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Description
 * 异步任务
 * <p>
 * Data
 * 2019/12/21 17:28
 *
 * @author zrx
 * @version 1.0
 */

@Component
public class AsyncTask {

    private final Logger LOG = LoggerFactory.getLogger(AsyncTask.class);

    @Async
    public Future<Null> task01(Map<String,Object> map){
        Random random = ThreadLocalRandom.current();
        int sleepTime = random.nextInt(500);


        try {
            Thread.sleep(sleepTime);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        map.put(Thread.currentThread().getName()+"执行完",sleepTime);
        LOG.info(map.toString());

        return new AsyncResult<>(null);
    }

    @Async
    public Future<Null> task02(Map<String,Object> map){
        Random random = ThreadLocalRandom.current();
        int sleepTime = random.nextInt(500);


        try {
            Thread.sleep(sleepTime);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        map.put(Thread.currentThread().getName()+"执行完",sleepTime);
        LOG.info(map.toString());

        return new AsyncResult<>(null);
    }

    @Async
    public Future<Null> task03(Map<String,Object> map){
        Random random = ThreadLocalRandom.current();
        int sleepTime = random.nextInt(500);


        try {
            Thread.sleep(sleepTime);
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        map.put(Thread.currentThread().getName()+"执行完",sleepTime);
        LOG.info(map.toString());

        return new AsyncResult<>(null);
    }

}
