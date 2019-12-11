package com.maven.welcode.bootactivemq.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

@Component
public class Queue_consumer {

    @Autowired
    private JmsMessagingTemplate template;

    @Autowired
    private Queue queue;


    public void receiverMsg() {
        String message = template.receiveAndConvert(queue,String.class);
        System.out.println(message);
    }
}
