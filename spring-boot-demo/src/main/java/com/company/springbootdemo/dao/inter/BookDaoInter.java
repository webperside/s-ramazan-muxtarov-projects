package com.company.springbootdemo.dao.inter;

import com.company.springbootdemo.models.Book;

import java.util.List;

public interface BookDaoInter {

    List<Book> findAll();

    Book findById(Integer id);

    boolean save(Book book);

    boolean update(Book book);

    boolean remove(Integer id);
}
