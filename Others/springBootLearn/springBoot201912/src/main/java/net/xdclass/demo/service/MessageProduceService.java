package net.xdclass.demo.service;

import javax.jms.Destination;

/**
 * Description
 * 消息发送服务
 * <p>
 * Data
 * 2019/12/23 20:38
 *
 * @author zrx
 * @version 1.0
 */


public interface MessageProduceService {

    void sendMsg(Destination destination,final String msg);

    void sendMsg(final String msg);
}
