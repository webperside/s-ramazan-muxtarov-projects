package com.company;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("SpringBeans.xml");

//        DatabaseConfig db = (DatabaseConfig) context.getBean("databaseConfig");

        // DI - Dependency Injection
        // IoC - Inversion of Control

//        System.out.println(db.getUrl());

        UserDao userDao = context.getBean("userDao",UserDao.class);

        System.out.println(userDao.getDatabaseConfig().getUrl());
    }
    /*

     */
}
