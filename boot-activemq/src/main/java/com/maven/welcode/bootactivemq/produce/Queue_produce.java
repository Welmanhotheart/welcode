package com.maven.welcode.bootactivemq.produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;
import java.util.UUID;

@Component
public class Queue_produce {

    @Autowired
    private JmsMessagingTemplate template;

    @Autowired
    private Queue queue;


    public void produceMsg() {
        template.convertAndSend(queue, "*****" + UUID.randomUUID().toString().substring(0,6));
    }

    @Scheduled(fixedDelay = 3000L)
    public void produceMsgSchedule() {
        template.convertAndSend(queue, "schedule*****" + UUID.randomUUID().toString().substring(0,6));
        System.out.println("*********produceMsgSchedule ok");
    }

}
