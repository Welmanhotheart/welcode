package com.wei.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProduce_Redeliver {
    private static final String ACTIVEMQ_URL = "tcp://192.168.73.130:61616";
//    private static final String ACTIVEMQ_URL = "failover:(tcp://192.168.73.130:61616,tcp://192.168.73.130:61617,tcp://192.168.73.130:61618)";
    //private static final String ACTIVEMQ_URL = "tcp://localhost:61616"; // local broker
    private static final String QUEUE_NAME  = "queue-redeliver";
    public static void main(String[] args) throws JMSException {

        // create connection factory
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);


        // through connection factory, get connection and 'start'
        Connection connection = factory.createConnection();
        connection.start();

        // create session and

        //parameter1: 1.transaction  2.check in
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // create destination , theme or queue
        Queue queue = session.createQueue(QUEUE_NAME);

        MessageProducer producer = session.createProducer(queue);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);//这里只有设置为持久化，才会在数据库中存储
        //这里队列，默认是开启的持久化
//        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        for(int i = 0; i < 3; i++) {
            TextMessage textMessage = session.createTextMessage("cluster-message-" + i);
            producer.send(textMessage);
        }
        System.out.println("message sent over");
        producer.close();
        session.close();
        connection.close();
    }
}
