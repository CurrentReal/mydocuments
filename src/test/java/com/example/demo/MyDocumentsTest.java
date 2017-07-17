package com.example.demo;

import com.example.demo.java.model.Document;
import com.example.demo.java.model.Type;
import com.example.demo.java.service.SearchEngine;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-context.xml")
public class MyDocumentsTest {

    private static final Logger log =
            LoggerFactory.getLogger(MyDocumentsTest.class);

    @Autowired
    private SearchEngine engine;
    @Autowired
    private Type webType;

    @Test
    public void testUsingSpringTest() {
        log.debug("Using Spring Test fixtures:");

        List<Document> documents = engine.findByType(webType);
        assertNotNull(documents);
        assertTrue(documents.size() == 1);
        assertEquals(webType.getName(), documents.get(0).getType().getName());
        assertEquals(webType.getDesc(), documents.get(0).getType().getDesc());
        assertEquals(webType.getExtension(),
                documents.get(0).getType().getExtension());

        documents = engine.listAll();
        assertNotNull(documents);
        assertTrue(documents.size() == 4);
    }

}
