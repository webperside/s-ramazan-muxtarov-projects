package com.company.springbootdemo.service.impl;

import com.company.springbootdemo.dao.inter.UserDaoInter;
import com.company.springbootdemo.models.User;
import com.company.springbootdemo.service.inter.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoInter userDaoInter;

    @Override
    @Transactional
    public boolean save(User user) {
        userDaoInter.save(user);   // 1
        userDaoInter.remove(1); // 2
        userDaoInter.update(user); // 3
        return true;
    }
}
