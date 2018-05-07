package com.example.demo2.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class Service2Impl {
    private Logger logger = LoggerFactory.getLogger(getClass());
    private Random random = new Random(System.currentTimeMillis());

    public int logMethod(String someParam) {
        logger.info("---Service2Impl: logMethod invoked---", someParam);
        return random.nextInt();
    }

    public void exceptionMethod() throws Exception {
        logger.info("---Service2Impl: exceptionMethod invoked---");
        throw new Exception("Something bad happened!");
    }
}