package com.company.librarywebappspring.service.impl;

import com.company.librarywebappspring.models.Book;
import com.company.librarywebappspring.models.User;
import com.company.librarywebappspring.models.UserBook;
import com.company.librarywebappspring.repository.BookRepository;
import com.company.librarywebappspring.repository.UserBookRepository;
import com.company.librarywebappspring.service.inter.BookService;
import com.company.librarywebappspring.util.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final UserBookRepository userBookRepository;

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
        return book.orElseThrow(() -> new EntityNotFoundException("Book not found"));
    }

    @Override
    public boolean remove(Integer id) {
        if(bookRepository.existsById(id)){
            bookRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public boolean buyBook(Integer id) {
        Book book = findById(id);

        if(book.getStockCount() > 0){
            User user = UserUtils.currentUser();

            Integer stockCount = book.getStockCount() - 1;
            book.setStockCount(stockCount);
            bookRepository.save(book);

            UserBook ub = UserBook.builder()
                    .user(user)
                    .book(book)
                    .build();

            userBookRepository.save(ub);

            return true;
        }

        return false;
    }
}
