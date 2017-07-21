package com.example.demo;

import com.example.demo.java.model.Document;
import com.example.demo.java.model.Type;
import com.example.demo.java.service.SearchEngine;
import com.example.demo.spring.amqp.RabbitMQProducer;
import com.example.demo.spring.jms.JMSProducer;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Hyunjin on 2017-07-14.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-context.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class MyDocumentsTest {

    private static final Logger log = LoggerFactory.getLogger(MyDocumentsTest.class);
    //Based on the META-INF/data/jms.txt - only one record
    private static final int MAX_ALL_DOCS = 5;
    private static final int MAX_WEB_DOCS = 2;
    private static final String DOCUMENT_ID = "df569fa4-a513-4252-9810-818cade184ca";
    @Autowired
    private SearchEngine engine;

//    @Test
//    @Ignore
//    public void testXmlUtils() {
//        log.debug("Testing XML Utils...");
//        Type type = new Type();
//        type.setTypeId("4980d2e4-a424-4ff4-a0b2-476039682f43");
//        type.setName("WEB");
//        type.setDesc("Web Link");
//        type.setExtension(".url");
//
//        Document document = new Document();
//        document.setDocumentId(UUID.randomUUID().toString());
//        document.setName("Apress Books");
//        document.setLocation("http://www.apress.com");
//        document.setDescription("Apress Books");
//        document.setType(type);
//        document.setCreated(new Date());
//        document.setModified(new Date());
//
//        String string = XmlUtils.toXML(document);
//        log.debug("\n" + string);
//
//        Document other = XmlUtils.fromXML(string,Document.class);
//        assertNotNull(other);
//    }

    @Autowired
    JMSProducer jmsProducer;

    @Test
    public void testSpringJMS_1() {
        log.debug("Testing Spring JMS Producer...");
        jmsProducer.send();
    }

    @Test
    public void testSpringJMS_2() throws InterruptedException {
        log.debug("Testing Spring JMS Listener/Insert...");
        assertNotNull(engine);

        //Waiting a least 5 seconds so the message is consumed.
        Thread.sleep(5000);
        //After the JMS message and insert, must be 5 Documents
        assertEquals(MAX_ALL_DOCS, engine.listAll().size());

        Type documentType = new Type("WEB", ".url");
        assertEquals(MAX_WEB_DOCS, engine.findByType(documentType).size());
    }

    @Autowired
    RabbitMQProducer rabbitmqProducer;

    @Test
    public void testSpringRabbitMQ_1() {
        log.debug("Testing RabbitMQ producer...");
        assertNotNull(rabbitmqProducer);

        Document document = engine.findById(DOCUMENT_ID);
        assertNotNull(document);
        rabbitmqProducer.send(document);
    }

    @Test
    public void testSpringRabbitMQ_2() throws InterruptedException {
        log.debug("Testing RabbitMQ Consumer...");
        //Just wait for the RabbitMQ consumer...
        Thread.sleep(5000);
    }

}

//public class MyDocumentsTest {
//
//    private ClassPathXmlApplicationContext context;
//    private SearchEngine engine;
//    private Type webType;
//
//    @Before
//    public void setup() {
//        context = new ClassPathXmlApplicationContext(
//                "META-INF/spring/mydocuments-context.xml");
//    }
//
//    @Test
//    public void testAll() {
//        engine = context.getBean(SearchEngine.class);
//        webType = context.getBean("webType", Type.class);
//
//        List<Document> documents = engine.findByType(webType);
//        assertNotNull(documents);
//        assertTrue(documents.size() == 1);
//        assertEquals(webType.getName(), documents.get(0).getType().getName());
//        assertEquals(webType.getDesc(), documents.get(0).getType().getDesc());
//        assertEquals(webType.getExtension(),
//                documents.get(0).getType().getExtension());
//
//        engine = context.getBean(SearchEngine.class);
//
//        documents = engine.listAll();
//        assertNotNull(documents);
//        assertTrue(documents.size() == 4);
//    }
//
//}

//public class MyDocumentsTest {
//
//    private static final Logger log =
//            LoggerFactory.getLogger(MyDocumentsTest.class);
//    private ClassPathXmlApplicationContext context;
//
//    @Before
//    public void setup() {
//        context = new ClassPathXmlApplicationContext(
//                "META-INF/spring/mydocuments-context.xml");
//    }
//
//    @Test
//    public void testMenu() {
//        log.debug("About to read the Resource file: menu.txt ");
//        //Resource resource = context.getResource("url:http://localhost/~username/menu.txt");
//        //Resource resource = context.getResource("file:/Users/username/Sites/menu.txt");
//        Resource resource = context.getResource("classpath:META-INF/data/menu.txt");
//
//        try {
//            InputStream stream = resource.getInputStream();
//            Scanner scanner = new Scanner(stream);
//            while (scanner.hasNext()) {
//                System.out.println(scanner.nextLine());
//            }
//            scanner.close();
//            stream.close();
//        }catch(IOException e){
//            e.printStackTrace();
//        }
//    }
//
//}


////////////////// before Chapter 11
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:META-INF/spring/mydocuments-context.xml")
//public class MyDocumentsTest {
//
//    private static final Logger log =
//            LoggerFactory.getLogger(MyDocumentsTest.class);
//
//    @Autowired
//    private SearchEngine engine;
//    @Autowired
//    private Type webType;
//
//    @Test
//    public void testUsingSpringTest() {
//        log.debug("Using Spring Test fixtures:");
//
//        List<Document> documents = engine.findByType(webType);
//        assertNotNull(documents);
//        assertTrue(documents.size() == 1);
//        assertEquals(webType.getName(), documents.get(0).getType().getName());
//        assertEquals(webType.getDesc(), documents.get(0).getType().getDesc());
//        assertEquals(webType.getExtension(),
//                documents.get(0).getType().getExtension());
//
//        documents = engine.listAll();
//        assertNotNull(documents);
//        assertTrue(documents.size() == 4);
//    }
//
//}
