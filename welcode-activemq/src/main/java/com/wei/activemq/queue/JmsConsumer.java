package com.wei.activemq.queue;

import com.wei.activemq.beans.Department;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.io.IOException;
import java.util.Arrays;

public class JmsConsumer {
    private static final String ACTIVEMQ_URL = "tcp://192.168.73.130:61616";
    //    private static final String ACTIVEMQ_URL = "failover:(tcp://192.168.73.130:61616,tcp://192.168.73.130:61617,tcp://192.168.73.130:61618)";
    //private static final String ACTIVEMQ_URL = "tcp://localhost:61616"; // local broker
    private static final String QUEUE_NAME  = "queue-01";
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
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

        // create destination , theme or queue
        Queue queue = session.createQueue(QUEUE_NAME);


        // create consumer
        MessageConsumer consumer = session.createConsumer(queue);


        int index = 0;
        /*
        synchronizing blocking method(receive())
        subscriber or receiver call the method 'receive()' of MessageConsumer to get message

        the calling will be blcoked util it receives the message
        while(true) {

            TextMessage message = (TextMessage) consumer.receive(10000);
            if (null != message) {
                System.out.println("收到第" + (++index) + "条消息：" + message.getText());
            } else {
                break;
            }
        }

        System.out.println("message received over");
        consumer.close();
        session.close();
        connection.close();
        */

        // through monitor to get message

        /**
         * Asynchronous non-blocking method 【onMessage(Message message)】
         *  subscriber or receiver call the method 'setMessageListener' of MessageConsumer
         *  register one message monitor , when message arrives, the system automatically
         *  call the 'onMessage' method of MessageListener
         *
         */
       consumer.setMessageListener(new MessageListener() {
           public void onMessage(Message message) {
               if (null != message && message instanceof  TextMessage) {
                   System.out.println("text message");
                   TextMessage textMessage = (TextMessage) message;
                   try {
                       System.out.println(textMessage.getText());
                   } catch (JMSException e) {
                       e.printStackTrace();
                   }
               }
               if (null != message && message instanceof  MapMessage) {
                   System.out.println("map message");
                   MapMessage mapMessage = (MapMessage) message;
                   try {
                       System.out.println(mapMessage.getString("k1"));
                   } catch (JMSException e) {
                       e.printStackTrace();
                   }
               }
               if (null != message && message instanceof  BytesMessage) {
                   System.out.println("byte message");
                   BytesMessage bytesMessage = (BytesMessage) message;
                   try {
                       byte[] dst = new byte[(int)bytesMessage.getBodyLength()];
                       bytesMessage.readBytes(dst);
                       System.out.println(new String(dst));
                   } catch (JMSException e) {
                       e.printStackTrace();
                   }
               }
               if (null != message && message instanceof  StreamMessage) {
                   System.out.println("stream message");
                   StreamMessage streamMessage = (StreamMessage) message;
                   try {

                       System.out.println(streamMessage.readLong());
                   } catch (JMSException e) {
                       e.printStackTrace();
                   }
               }

               if (null != message && message instanceof  ObjectMessage) {
                   System.out.println("object message");
                   ObjectMessage objectMessage = (ObjectMessage) message;
                   try {
                       Department object = (Department) objectMessage.getObject();
                       System.out.println(object);

                   } catch (JMSException e) {
                       e.printStackTrace();
                   }
               }
           }
       });
        System.in.read();
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
