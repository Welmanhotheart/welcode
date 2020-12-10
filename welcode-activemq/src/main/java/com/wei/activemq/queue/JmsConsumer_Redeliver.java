package com.wei.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.RedeliveryPolicy;

import javax.jms.*;
import java.io.IOException;
import java.util.Arrays;

public class JmsConsumer_Redeliver {
    private static final String ACTIVEMQ_URL = "tcp://192.168.73.130:61616";
    //    private static final String ACTIVEMQ_URL = "failover:(tcp://192.168.73.130:61616,tcp://192.168.73.130:61617,tcp://192.168.73.130:61618)";
    //private static final String ACTIVEMQ_URL = "tcp://localhost:61616"; // local broker
    private static final String QUEUE_NAME  = "queue-redeliver";
    public static void main(String[] args) throws JMSException, IOException {

        System.out.println("I am the second consumer");
        // create connection factory
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);


        RedeliveryPolicy queuePolicy = new RedeliveryPolicy();
        queuePolicy.setMaximumRedeliveries(3);

        factory.setRedeliveryPolicy(queuePolicy);

        factory.setTrustedPackages(Arrays.asList("com.wei.activemq.beans"));
        // through connection factory, get connection and 'start'
        Connection connection = factory.createConnection();
        connection.start();

        // create session and

        //parameter1: 1.transaction  2.check in
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

        // create destination , theme or queue
        Queue queue = session.createQueue(QUEUE_NAME);


        // create consumer
        MessageConsumer consumer = session.createConsumer(queue);

        while(true) {
            Message message = consumer.receive(50l);
            if (message != null && message instanceof  TextMessage) {
                System.out.println(((TextMessage) message).getText());
            } else {
                break;
            }
        }
        consumer.close();
        session.close();
        connection.close();

        /**
         * 1.first comes producer, only starting the first consumer,then the second,
         * Question: can the first consumer still consume the messages? (Yes)
         *
         * 2.first comes producer and starting the first consumer,then the second,
         * Question: can the second consumer still consume the messages? (NO)
         *
         * 3.first comes two consumers and then produce six messages,how about now ?
         *   3.1 every consumer has six messages
         *   3.2 first arrive,first get all and left nothing to the others
         *   3.3 everyone has half   (Yes)
         *
         * 4.if MQ server is down, what will happend？ can the consumers still get the message
         */
    }
}
