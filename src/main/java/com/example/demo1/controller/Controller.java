package com.example.demo1.controller;

import com.example.demo1.annotation.AuthCheck;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    @GetMapping("/accessWithoutAuth")
    public String accessWithoutAuth(  String param){
        logger.info("--------accessWithoutAuth ---------"+param);
        return "access successful";
    }
    @GetMapping("/accessWithAuth")
    @AuthCheck
    public String accessWithAuth(  String param){
        logger.info("--------accessWithoutAuth ---------"+param);
        return "access successful";

    }
}