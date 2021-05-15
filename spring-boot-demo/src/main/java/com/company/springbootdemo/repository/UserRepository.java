package com.company.springbootdemo.repository;

import com.company.springbootdemo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmailAndPassword(String email, String password);
    // select * from user where email = e and password = p

    @Query(value = "select u from User u")
    List<User> findAll2();

}
