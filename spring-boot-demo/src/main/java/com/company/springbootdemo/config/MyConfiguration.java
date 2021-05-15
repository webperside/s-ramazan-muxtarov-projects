package com.company.springbootdemo.config;

import com.company.springbootdemo.models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

    @Bean
    public User userBean(){
        User user = new User();
        user.setName("Ramazan");
        return user;
    }
}
