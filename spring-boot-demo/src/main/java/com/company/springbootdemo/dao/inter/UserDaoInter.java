package com.company.springbootdemo.dao.inter;

import com.company.springbootdemo.models.User;

import java.util.List;

public interface UserDaoInter {

    List<User> findAll();

    User findByEmailAndPassword(String email, String password);

    User findByEmailAndPassword2(String email, String password);

    User findById(Integer id);

    boolean save(User user);

    boolean update(User user);

    boolean remove(Integer id);
}
