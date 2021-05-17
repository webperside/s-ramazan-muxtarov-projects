package com.company.librarywebappspring.service.inter;

import com.company.librarywebappspring.models.Book;

import java.util.List;

public interface BookService {

    List<Book> findAll();

    boolean save(Book book);

    Book findById(Integer id);

    boolean remove(Integer id);
}
