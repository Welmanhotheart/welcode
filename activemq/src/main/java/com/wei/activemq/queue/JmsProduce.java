package com.wei.activemq.queue;

import com.wei.activemq.beans.Department;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class JmsProduce {
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
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // create destination , theme or queue
        Queue queue = session.createQueue(QUEUE_NAME);

        MessageProducer producer = session.createProducer(queue);
        //这里队列，默认是开启的持久化
//        producer.setDeliveryMode(DeliveryMode.PERSISTENT);
        for(int i = 0; i < 3; i++) {
            TextMessage textMessage = session.createTextMessage("message-" + i);
            producer.send(textMessage);

            MapMessage mapMessage = session.createMapMessage();
            mapMessage.setString("k1","v1");
            producer.send(mapMessage);

            BytesMessage bytesMessage = session.createBytesMessage();
            bytesMessage.writeBytes("hello, friend".getBytes());
            producer.send(bytesMessage);

            StreamMessage streamMessage = session.createStreamMessage();
            streamMessage.writeLong(45);
            producer.send(streamMessage);

            Department department = new Department("1", "测试部");
            ObjectMessage objectMessage = session.createObjectMessage();
            objectMessage.setObject(department);
            producer.send(objectMessage);

            session.createObjectMessage();

        }
        System.out.println("message sent over");
        producer.close();
        session.close();
        connection.close();
    }
}
