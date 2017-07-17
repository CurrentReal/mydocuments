package com.example.demo;

import com.example.demo.java.model.Document;
import com.example.demo.java.model.Type;
import com.example.demo.java.service.SearchEngine;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

/**
 * Created by Hyunjin on 2017-07-17.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:META-INF/spring/mydocuments-profiles-context.xml")
//@ActiveProfiles("dev")
@ActiveProfiles("qa")
public class MyDocumentsWithProfilesTest {

    private static final Logger log =
            LoggerFactory.getLogger(MyDocumentsWithProfilesTest.class);

    @Autowired
    private SearchEngine engine;
    @Autowired
    private Type webType;

    @Test
    public void testUsingSpringTestWithProfiles() {
        try {
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
        } catch(Exception ex) {
            log.error(ex.getMessage());
        }
    }

}
