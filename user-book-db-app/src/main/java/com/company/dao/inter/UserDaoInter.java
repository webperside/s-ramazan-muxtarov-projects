package com.company.dao.inter;

import com.company.models.User;

import java.util.List;

public interface UserDaoInter {

    List<User> findAll();

    User findByEmailAndPassword(String email, String password);

    User findById(Integer id);

    boolean save(User user);

    boolean update(User user);

    boolean remove(Integer id);
}
