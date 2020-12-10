package com.wei.activemq.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

@Service
public class SpringMQ_Produce {
    @Autowired
    private JmsTemplate template;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");


        SpringMQ_Produce produce = (SpringMQ_Produce) context.getBean("springMQ_Produce");
        produce.template.send(new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                TextMessage messag = session.createTextMessage("spring和activeMQ的整合case111 myMessageListner...");
                return messag;
            }
        });
        System.out.println("**********send task over");

    }
}
