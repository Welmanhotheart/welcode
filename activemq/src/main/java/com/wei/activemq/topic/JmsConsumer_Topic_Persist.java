package com.wei.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;

public class JmsConsumer_Topic_Persist {
    private static final String ACTIVEMQ_URL = "tcp://192.168.73.130:61616";
    private static final String TOPIC_NAME  = "jdbc-topic-producer";
    public static void main(String[] args) throws JMSException, IOException {

        System.out.println("I am the first  consumer");
        // create connection factory
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);

        // through connection factory, get connection and 'start'
        Connection connection = factory.createConnection();
        connection.setClientID("z4");

        // create session andfirst

        //parameter1: 1.transaction  2.check in
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // create destination , theme or queue
        Topic topic = session.createTopic(TOPIC_NAME);


        //创建订阅者
        TopicSubscriber topicSubscriber = session.createDurableSubscriber(topic, "jdbc-remark");
        connection.start();


        Message message = topicSubscriber.receive();
         while(null != message) {
             TextMessage textMessage = (TextMessage) message;
             System.out.println("receive durable message :" + textMessage.getText());
             message = topicSubscriber.receive();
         }
        session.close();
        connection.close();

        /**
         * 1. You must excute the consumer at least once, which means
         * that I subscribed the topic
         *
         * 2.Then execute the producer, now at this moment
         *
         * 3.Whether the consumer is on or off, it will receive the message
         *
         * if it is off, it will receive the preexisting and unreceived messsage once
         * linked to MQ server next time
         */
    }
}
