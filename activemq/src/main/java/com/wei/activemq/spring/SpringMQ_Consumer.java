package com.wei.activemq.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class SpringMQ_Consumer {
    @Autowired
    private JmsTemplate template;

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "applicationContext.xml");

        SpringMQ_Consumer consumer = (SpringMQ_Consumer) context.getBean("springMQ_Consumer");
        String returnValue = (String) consumer.template.receiveAndConvert();
        System.out.println("*****consumer receive :" + returnValue);

    }
}
