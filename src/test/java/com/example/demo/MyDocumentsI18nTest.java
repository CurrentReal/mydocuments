package com.example.demo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

/**
 * Created by Hyunjin on 2017-07-17.
 */
public class MyDocumentsI18nTest {

    private static final Logger log =
            LoggerFactory.getLogger(MyDocumentsI18nTest.class);
    private ClassPathXmlApplicationContext context;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext(
                "META-INF/spring/mydocuments-i18n-context.xml");
    }

    @Test
    public void testMenu() {
        log.debug("About to Translate...");

        String english = context.getMessage("main.title", null, Locale.ENGLISH);
        String spanish = context.getMessage("main.title", null, new Locale("es"));
        System.out.println("English: " + english);
        System.out.println("Spanish: " + spanish);
    }

}
