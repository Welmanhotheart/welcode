package com.wei.activemq.queue.tx;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProduce_TX {
    private static final String ACTIVEMQ_URL = "tcp://192.168.73.130:61616";
    private static final String QUEUE_NAME  = "queue-producer";
    public static void main(String[] args) throws JMSException {

        // create connection factory
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);


        // through connection factory, get connection and 'start'
        Connection connection = factory.createConnection();
        connection.start();

        // create session and

        //parameter1: 1.transaction  2.check in
        /**
         * if transacted be set 'true', only if you first execute 'send' and then 'commit', will
         * the message be placed into the queue
         */
        Session session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);

        // create destination , theme or queue
        Queue queue = session.createQueue(QUEUE_NAME);

        MessageProducer producer = session.createProducer(queue);
        //这里队列，默认是开启的持久化
//        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        for(int i = 0; i < 3; i++) {
            TextMessage textMessage = session.createTextMessage("message-" + i);
            producer.send(textMessage);
        }
        System.out.println("message sent over");
        session.commit();//using transaction
        producer.close();
        session.close();
        connection.close();
    }
}
