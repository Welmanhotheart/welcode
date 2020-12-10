package com.wei.activemq.listner;

import org.springframework.stereotype.Service;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;



@Service("myMessageListner")
public class MyMessageListener implements MessageListener {
    public void onMessage(Message message) {
        if (null != message && message instanceof TextMessage) {
            TextMessage textMessage = (TextMessage) message;
            try {
                System.out.println(textMessage.getText());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
