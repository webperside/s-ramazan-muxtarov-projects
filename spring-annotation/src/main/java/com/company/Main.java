package com.company;

import com.company.services.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringAutoScan.xml");

        UserService userService = context.getBean("userService",UserService.class);

        System.out.println(userService.getUserDao());

    }
}
