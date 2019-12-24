package net.xdclass.demo.application;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.ConnectionFactory;

/**
 * Description
 * 为了让spring boot 同时支持p2p和pub/sub
 * <p>
 * Data
 * 2019/12/23 21:37
 *
 * @author zrx
 * @version 1.0
 */

@SpringBootConfiguration
public class JmsListenerForTopicConfigBean {
    @Bean(value = "myJmsListenerContainerFactory")
    public JmsListenerContainerFactory<?> jmsListenerContainerFactory(
            ConnectionFactory connectionFactory){
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(connectionFactory);

        return bean;
    }
}
