package com.wei.activemq.queue.pullin;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;
import java.util.Arrays;

public class JmsConsumer_Pullin {
    private static final String ACTIVEMQ_URL = "tcp://192.168.73.130:61616";
    private static final String QUEUE_NAME  = "queue-producer";
    public static void main(String[] args) throws JMSException, IOException {

        System.out.println("I am the second consumer");
        // create connection factory
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);

        factory.setTrustedPackages(Arrays.asList("com.wei.activemq.beans"));
        // through connection factory, get connection and 'start'
        Connection connection = factory.createConnection();
        connection.start();

        // create session and

        //parameter1: 1.transaction  2.check in
        Session session = connection.createSession(true, Session.CLIENT_ACKNOWLEDGE);

        // create destination , theme or queue
        Queue queue = session.createQueue(QUEUE_NAME);


        // create consumer
        MessageConsumer consumer = session.createConsumer(queue);

        while(true) {
            Message message = consumer.receive(4000l);
            if (message != null && message instanceof  TextMessage) {
                System.out.println(((TextMessage) message).getText());
                message.acknowledge();
            } else {
                break;
            }
        }
        /**
        here using transaction and invocation of commit must be a pair,
         otherwise the message will be repeatedly consumed
          */
        session.commit();
       consumer.close();
        session.close();
        connection.close();
    }
}
