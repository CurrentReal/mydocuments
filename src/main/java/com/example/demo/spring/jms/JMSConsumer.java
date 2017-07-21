package com.example.demo.spring.jms;

import com.example.demo.java.model.Document;
import com.example.demo.java.utils.XmlUtils;
import com.example.demo.spring.data.DocumentDAO;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.TextMessage;

/**
 * Created by Hyunjin on 2017-07-21.
 */
@Component
public class JMSConsumer implements MessageListener {

    @Autowired
    DocumentDAO documentDAO;

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage)message;
        try {
            Document document = XmlUtils.fromXML(textMessage.getText(), Document.class);
            documentDAO.save(document);
        } catch(JMSException ex) {
            ex.printStackTrace();
        }
    }

}