package com.company.dao.inter;

import com.company.models.Book;

import java.util.List;

public interface BookDaoInter {

    List<Book> findAll();

    Book findById(Integer id);

    boolean save(Book book);

    boolean update(Book book);

    boolean remove(Integer id);
}
