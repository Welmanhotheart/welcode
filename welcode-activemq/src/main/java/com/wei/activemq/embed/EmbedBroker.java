package com.wei.activemq.embed;

import org.apache.activemq.broker.BrokerService;

public class EmbedBroker {
    private static final String ACTIVEMQ_URL = "tcp://localhost:61616";
    public static void main(String[] args) throws Exception {
        /**
         * activemq also supports communication in  virtual machine through embeded broker
         */
        BrokerService service = new BrokerService();
        service.setUseJmx(true);
        service.addConnector(ACTIVEMQ_URL);
        service.start();
    }
}
