package com.wei.activemq.topic;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProduce_Topic_Persist {
    private static final String ACTIVEMQ_URL = "tcp://192.168.73.130:61616";
    private static final String TOPIC_NAME  = "jdbc-topic-producer";
    public static void main(String[] args) throws JMSException {
        // create connection factory
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        // through connection factory, get connection and 'start'
        Connection connection = factory.createConnection();

        // create session and
        //parameter1: 1.transaction  2.check in
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // create destination , theme or queue
        Topic topic = session.createTopic(TOPIC_NAME);

        MessageProducer producer = session.createProducer(topic);
        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        connection.start();
        for(int i = 0; i < 3; i++) {
            TextMessage textMessage = session.createTextMessage("message-" + i);
            producer.send(textMessage);
        }
        System.out.println("message sent over");
        producer.close();
        session.close();
        connection.close();
    }

}
