package com.example.demoapp;

import com.example.demoapp.service.AccountService;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
@ComponentScan
public class DemoApplication {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoApplication.class);

        AccountService accountService = context.getBean(AccountService.class);
        System.out.println(accountService);
    }

}
