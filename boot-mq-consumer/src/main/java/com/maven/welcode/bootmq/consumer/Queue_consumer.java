package com.maven.welcode.bootmq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

@Component
public class Queue_consumer {


    @JmsListener(destination = "${myqueue}")
    public void receiverMsg(TextMessage message) throws JMSException {
        System.out.println("consumer receive message:" + message.getText());
    }
}
