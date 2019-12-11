package com.maven.welcode.bootmq.topic.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class Topic_consumer {

    @JmsListener(destination = "${myTopic}")
    public void receiverMsg(TextMessage message) throws JMSException {
        try {
            System.out.println("consumer receive topic message:" + message.getText());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
