package net.xdclass.demo.controller.activemq;

import net.xdclass.demo.domain.JsonData;
import net.xdclass.demo.service.MessageProduceService;
import net.xdclass.demo.service.NewsPublishService;
import org.checkerframework.checker.units.qual.A;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Description
 * activemq.ActivemqTestController
 * <p>
 * Data
 * 2019/12/23 15:29
 *
 * @author zrx
 * @version 1.0
 */

@RestController
public class ActivemqTestController {

    private final MessageProduceService messageProduceServiceImpl;
    private final NewsPublishService newsPublishServiceImpl;

    @Autowired
    public ActivemqTestController(
            @Qualifier("messageProduceServiceImpl") MessageProduceService messageProduceServiceImpl,
            @Qualifier("newsPublishServiceImpl") NewsPublishService newsPublishServiceImpl
    ) {
        this.messageProduceServiceImpl = messageProduceServiceImpl;
        this.newsPublishServiceImpl = newsPublishServiceImpl;
    }

    /**
     * 发部消息p2p
     * @param msg 消息
     * @return 立即返回
     */
    @GetMapping("/mq/send")
    public Object send(@RequestParam String msg){
        messageProduceServiceImpl.sendMsg(msg);

        final JsonData jsonData = new JsonData();
        jsonData.setMsg(msg+" sent successfully");
        jsonData.setCode(1);

        jsonData.setData(new Date());
        return jsonData;
    }

    private final Logger LOG= LoggerFactory.getLogger(ActivemqTestController.class);

    /**
     * 队列 comment.queue 中受到消息后
     * 会自动调用这个方法，把消息送到这里
     * @param msg 消息
     */
    @JmsListener(destination = "comment.queue")
    public void receiveMsg(String msg)throws Exception{
        LOG.info("receive msg " + msg);
        Thread.sleep(1000*5);
        //太好玩了
    }


    /**
     * 发部订阅模式
     * @param msg 消息
     * @return 立即返回
     */
    @GetMapping("/mq/sendNews")
    public Object sendNews(@RequestParam String msg){
        newsPublishServiceImpl.publish(msg);

        final JsonData jsonData = new JsonData();
        jsonData.setMsg(msg+" published successfully");
        jsonData.setCode(1);

        jsonData.setData(new Date());
        return jsonData;
    }

    /**
     * topic的订阅者 01
     *
     * containerFactory = "jmsListenerContainerFactory"
     * 同时支持p2p 和pub.sub
     *
     * @param msg 消息
     * @throws Exception inter
     */
    @JmsListener(destination = "news.topic",containerFactory = "myJmsListenerContainerFactory")
    public void receiveNews01(String msg)throws Exception{
        Thread.sleep(1000);
        LOG.info("receiveNews01 receives msg " + msg);
        //太好玩了
    }

    /**
     * topic的订阅者 02
     * @param msg 消息
     * @throws Exception inter
     */
    @JmsListener(destination = "news.topic")
    public void receiveNews02(String msg)throws Exception{
        Thread.sleep(1500);
        LOG.info("receiveNews02 receives msg " + msg);
        //太好玩了
    }
}
