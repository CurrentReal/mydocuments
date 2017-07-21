package com.example.demo.spring.amqp;

import com.example.demo.java.model.Document;
import com.example.demo.java.utils.XmlUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

/**
 * Created by Hyunjin on 2017-07-21.
 */
@Component("rabbitmqConsumer")
public class RabbitMQConsumer implements MessageListener {

    private static final Logger log = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @Override
    public void onMessage(Message message) {
        Document document = XmlUtils.fromXML(new String(message.getBody()),Document.class);
        log.debug("Document received: " + document);
    }

}
