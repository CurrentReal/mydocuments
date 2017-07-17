package com.example.demo.spring.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

/**
 * Created by Hyunjin on 2017-07-17.
 */
public class BeforeLoggingModule implements MethodBeforeAdvice {

    private static final Logger log =
            LoggerFactory.getLogger(BeforeLoggingModule.class);

    public void before(Method method, Object[] args, Object target) throws Throwable {
        if (log.isDebugEnabled()) {
            log.debug("@@@@(BEFORE) Method called: " + method.getName());
            if (args.length ==0 )
                log.debug("@@@@(BEFORE) No arguments passed.");
            for (Object arg:args)
                log.debug("@@@@(BEFORE) Argument passed:" + arg);
        }
    }

}
