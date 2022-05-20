package com.example.demoapp.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class DataSourceConfig {
    @Bean
    DataSource dataSource(
            @Value("${db.url}") String url,
            @Value("${db.user}") String user,
            @Value("${db.password}") String password
    ) {
        return new DriverManagerDataSource(url, user, password);
    }
}
