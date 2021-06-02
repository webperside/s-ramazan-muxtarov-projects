package com.company.librarywebappspring.repository;

import com.company.librarywebappspring.models.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserBookRepository extends JpaRepository<UserBook, Integer> {

    List<UserBook> findAllByUserId(Integer userId);
}
