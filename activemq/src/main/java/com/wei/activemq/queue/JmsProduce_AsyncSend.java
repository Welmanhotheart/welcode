package com.wei.activemq.queue;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.ActiveMQMessageProducer;
import org.apache.activemq.AsyncCallback;

import javax.jms.*;
import java.util.UUID;

public class JmsProduce_AsyncSend {
    private static final String ACTIVEMQ_URL = "tcp://192.168.73.130:61616";
//    private static final String ACTIVEMQ_URL = "failover:(tcp://192.168.73.130:61616,tcp://192.168.73.130:61617,tcp://192.168.73.130:61618)";
    //private static final String ACTIVEMQ_URL = "tcp://localhost:61616"; // local broker
    private static final String QUEUE_NAME  = "queue-01";
    public static void main(String[] args) throws JMSException {

        // create connection factory
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(ACTIVEMQ_URL);
        factory.setUseAsyncSend(true);

        // through connection factory, get connection and 'start'
        Connection connection = factory.createConnection();
        connection.start();

        // create session and

        //parameter1: 1.transaction  2.check in
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // create destination , theme or queue
        Queue queue = session.createQueue(QUEUE_NAME);

        ActiveMQMessageProducer producer = (ActiveMQMessageProducer) session.createProducer(queue);
//        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);//这里只有设置为持久化，才会在数据库中存储
        //这里队列，默认是开启的持久化
//        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        for(int i = 0; i < 3; i++) {
            final TextMessage textMessage = session.createTextMessage("message-" + i);
            textMessage.setJMSMessageID(UUID.randomUUID() + "---order");
            final String messageID = textMessage.getJMSMessageID();
            producer.send(textMessage, new AsyncCallback() {
                public void onSuccess() {
                    System.out.println(messageID + "has been successfully sent");
                }

                public void onException(JMSException exception) {
                    System.out.println(messageID + "has been unsuccessfully sent yet");
                }
            });

        }
        System.out.println("message sent over");
        producer.close();
        session.close();
        connection.close();
    }
}
