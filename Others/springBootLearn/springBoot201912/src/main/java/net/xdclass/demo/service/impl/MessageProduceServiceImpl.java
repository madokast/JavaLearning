package net.xdclass.demo.service.impl;

import net.xdclass.demo.service.MessageProduceService;
import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Destination;
import javax.jms.Queue;

/**
 * Description
 * TODO
 * <p>
 * Data
 * 2019/12/23 20:40
 *
 * @author zrx
 * @version 1.0
 */

@Service(value = "messageProduceServiceImpl")
public class MessageProduceServiceImpl implements MessageProduceService {

    // 队列
    private Queue queue = new ActiveMQQueue("comment.queue");

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate; //发送消息的模板

    @Override
    public void sendMsg(Destination destination, String msg) {
        jmsMessagingTemplate.convertAndSend(destination,msg);
    }

    @Override
    public void sendMsg(String msg) {
        jmsMessagingTemplate.convertAndSend(queue,msg);
    }
}
