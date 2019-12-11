package com.maven.welcode.bootmq.topic.produce;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Topic;
import java.util.UUID;

@Component
public class Topic_Produce {


    @Autowired
    private JmsMessagingTemplate template;

    @Autowired
    private Topic topic;

    @Scheduled(fixedDelay = 3000l)
    public void produceTopic() {
        template.convertAndSend(topic, "topic message :" + UUID.randomUUID().toString().substring(0,6));
    }
}
