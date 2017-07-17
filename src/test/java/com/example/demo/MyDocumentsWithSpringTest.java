//package com.example.demo;
//
//import com.example.demo.java.model.Document;
//import com.example.demo.java.model.Type;
//import com.example.demo.java.service.SearchEngine;
//import org.junit.Before;
//import org.junit.Test;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.util.List;
//
//import static org.junit.Assert.*;
//
///**
// * Created by Hyunjin on 2017-07-14.
// */
//public class MyDocumentsWithSpringTest {
//    private ClassPathXmlApplicationContext context;
//    private SearchEngine engine;
//    private Type documentType;
//
//    @Before
//    public void setup() {
//        context = new ClassPathXmlApplicationContext("META-INT/spring/mydocuments-context.xml");
//        engine = context.getBean(SearchEngine.class);
//        documentType = context.getBean(Type.class);
//    }
//
//    @Test
//    public void testWithSpringFindByType() {
//        List<Document> documents = engine.findByType(documentType);
//        assertNotNull(documents);
//        assertTrue(documents.size() == 1);
//        assertEquals(documentType.getName(), documents.get(0).getType().getName());
//        assertEquals(documentType.getDesc(), documents.get(0).getType().getDesc());
//        assertEquals(documentType.getExtension(), documents.get(0).getType().getExtension());
//    }
//
//    @Test
//    public void testWithSpringListAll() {
//        List<Document> documents = engine.listAll();
//        assertNotNull(documents);
//        assertTrue(documents.size() == 4);
//    }
//}
