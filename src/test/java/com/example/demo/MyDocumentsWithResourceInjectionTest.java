package com.example.demo;

import com.example.demo.spring.views.Menu;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.assertNotNull;

/**
 * Created by Hyunjin on 2017-07-16.
 */
public class MyDocumentsWithResourceInjectionTest {

    private static final Logger log =
            LoggerFactory.getLogger(MyDocumentsWithResourceInjectionTest.class);
    private ClassPathXmlApplicationContext context;

    @Before
    public void setup() {
        context = new ClassPathXmlApplicationContext(
                "META-INF/spring/mydocuments-resource-injection-context.xml");
    }

    @Test
    public void testMenu() {
        log.debug("Calling the Menu as Resource Injection:");
        Menu menu = context.getBean(Menu.class);
        assertNotNull(menu);
        menu.printMenu();
    }

}
