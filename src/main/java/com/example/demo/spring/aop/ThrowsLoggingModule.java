package com.example.demo.spring.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;

import java.lang.reflect.Method;

/**
 * Created by Hyunjin on 2017-07-18.
 */
public class ThrowsLoggingModule implements ThrowsAdvice {

    private static final Logger log =
            LoggerFactory.getLogger(ThrowsLoggingModule.class);

    public void afterThrowing(Method m, Object[] args, Object target, Exception ex) {
        if (log.isDebugEnabled()) {
            log.debug("@@@(THROWS) Method called: " + m.getName());
            if (args.length ==0)
                log.debug("@@@@(THROWS) No arguments passed.");
            for (Object arg:args)
                log.debug("@@@@(THROWS) Argument passed:" + arg);
            log.debug("@@@(THORWS) Error: " + ex.getMessage());
        }
    }

}
