package com.example.demoapp.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

@Configuration
public class AppConfig {

    @Bean
    PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

//    @Bean
//    AccountDao accountDao() {
//        return new AccountDaoImpl();
//    }

//    @Bean
//    AccountService accountService(AccountDao simpleAccountDao) {
//        return new AccountServiceImpl(simpleAccountDao);
//    }
}
