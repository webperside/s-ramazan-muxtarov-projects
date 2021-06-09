package com.company.librarywebappspring.service.inter;

import com.company.librarywebappspring.models.UserBook;

import java.util.List;

public interface UserBookService {

    List<UserBook> findAllByUserId(Integer userId);
}
