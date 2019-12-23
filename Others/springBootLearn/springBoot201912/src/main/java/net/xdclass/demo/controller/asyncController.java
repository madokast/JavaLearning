package net.xdclass.demo.controller;

import net.xdclass.demo.async.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.Null;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * Description
 * TODO
 * <p>
 * Data
 * 2019/12/21 17:37
 *
 * @author zrx
 * @version 1.0
 */

@RestController
public class asyncController {

    private final AsyncTask task;

    @Autowired
    public asyncController(AsyncTask task) {
        this.task = task;
    }

    @GetMapping("/async")
    public Object async(){
        Map<String,Object> map = new ConcurrentHashMap<>();

        long begin = System.currentTimeMillis();
        map.put("开始执行异步任务",new Date());


        final Future<Null> nullFuture = task.task01(map);
        final Future<Null> nullFuture1 = task.task02(map);
        final Future<Null> nullFuture2 = task.task03(map);

        Future[] futures = new Future[]{nullFuture,nullFuture1,nullFuture2};

        for(;;){
            boolean allDown = true;
            for (Future future : futures) {
                if(!future.isDone()){
                    allDown = false;
                }
            }

            if(allDown)
                break;
        }


        map.put("异步任务执行结束",new Date());

        map.put("总用时",System.currentTimeMillis()-begin);

        return map;
    }

}
