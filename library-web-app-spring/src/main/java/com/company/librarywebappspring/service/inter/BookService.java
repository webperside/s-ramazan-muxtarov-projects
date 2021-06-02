package com.company.librarywebappspring.service.inter;

import com.company.librarywebappspring.models.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll(String search);

    boolean save(Book book);

    boolean update(Book book);

    Book findById(Integer id);

    boolean remove(Integer id);

    boolean buyBook(Integer id);
}
