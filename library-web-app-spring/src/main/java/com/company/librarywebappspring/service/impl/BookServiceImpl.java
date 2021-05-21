package com.company.librarywebappspring.service.impl;

import com.company.librarywebappspring.models.Book;
import com.company.librarywebappspring.repository.BookRepository;
import com.company.librarywebappspring.service.inter.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;

    @Override
    public List<Book> findAll(String search) {
        return bookRepository.findAllByParam(search);
    }

    @Override
    public boolean save(Book book) {
        bookRepository.save(book);
        return true;
    }

    @Override
    public boolean update(Book book) {
        if(bookRepository.existsById(book.getId())){
            bookRepository.save(book);
            return true;
        }
        return false;
    }

    @Override
    public Book findById(Integer id) {
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public boolean remove(Integer id) {
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
