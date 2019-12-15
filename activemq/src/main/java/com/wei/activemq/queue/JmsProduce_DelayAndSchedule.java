package com.wei.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ScheduledMessage;

import javax.jms.*;

public class JmsProduce_DelayAndSchedule {
    private static final String ACTIVEMQ_URL = "tcp://192.168.73.130:61616";
//    private static final String ACTIVEMQ_URL = "failover:(tcp://192.168.73.130:61616,tcp://192.168.73.130:61617,tcp://192.168.73.130:61618)";
    //private static final String ACTIVEMQ_URL = "tcp://localhost:61616"; // local broker
    private static final String QUEUE_NAME  = "queue-delay-send";
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
//        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);//这里只有设置为持久化，才会在数据库中存储
        //这里队列，默认是开启的持久化
//        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        long delay = 3 * 1000;
        long period = 4 * 1000;
        int repeat = 5;
        for(int i = 0; i < 3; i++) {
            TextMessage textMessage = session.createTextMessage("delay-message-" + i);
            textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_DELAY, delay);
            textMessage.setLongProperty(ScheduledMessage.AMQ_SCHEDULED_PERIOD, period);
            textMessage.setIntProperty(ScheduledMessage.AMQ_SCHEDULED_REPEAT, repeat);
            producer.send(textMessage);
        }
        System.out.println("message sent over");
        producer.close();
        session.close();
        connection.close();
    }
}
