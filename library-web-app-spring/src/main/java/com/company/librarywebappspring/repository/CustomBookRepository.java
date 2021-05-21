package com.company.librarywebappspring.repository;

import com.company.librarywebappspring.models.Book;

import java.util.List;

public interface CustomBookRepository {

    List<Book> findAllByParam(String search);

}
