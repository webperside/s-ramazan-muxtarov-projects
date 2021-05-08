package com.company;

import com.company.dao.Context;
import com.company.dao.inter.UserDaoInter;
import com.company.models.User;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        UserDaoInter userDao = Context.getUserDao();
        List<User> users = userDao.findAll();
        for(User user : users){
            System.out.println(user);
        }
    }
}
