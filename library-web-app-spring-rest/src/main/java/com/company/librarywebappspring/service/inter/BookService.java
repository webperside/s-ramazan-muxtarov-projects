package com.company.librarywebappspring.service.inter;

import com.company.librarywebappspring.dto.books.BookByIdDto;
import com.company.librarywebappspring.dto.books.BookListDto;
import com.company.librarywebappspring.models.Book;

import java.util.List;

public interface BookService {

    List<BookListDto> findAll(String search);

    boolean save(Book book);

    boolean update(Book book);

    BookByIdDto findById(Integer id);

    boolean remove(Integer id);

    boolean buyBook(Integer id);
}
