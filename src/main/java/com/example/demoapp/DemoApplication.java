package com.example.demoapp;

import com.example.demoapp.service.AccountService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoApplication {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/context.xml");
        AccountService accountService = context.getBean(AccountService.class);

    }

}
