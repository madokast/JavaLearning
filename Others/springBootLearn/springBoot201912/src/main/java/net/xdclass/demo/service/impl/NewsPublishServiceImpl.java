package net.xdclass.demo.service.impl;

import net.xdclass.demo.service.NewsPublishService;
import org.apache.activemq.command.ActiveMQTempTopic;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Service;

import javax.jms.Topic;

/**
 * Description
 * NewsPublishService
 * <p>
 * Data
 * 2019/12/23 21:20
 *
 * @author zrx
 * @version 1.0
 */

@Service(value = "newsPublishServiceImpl")
public class NewsPublishServiceImpl implements NewsPublishService {

    private final Topic topic = new ActiveMQTopic("news.topic");

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Override
    public void publish(String news) {
        jmsMessagingTemplate.convertAndSend(this.topic,news);
    }
}
