package com.company.librarywebappspring.service.impl;

import com.company.librarywebappspring.dto.books.BookByIdDto;
import com.company.librarywebappspring.dto.books.BookCreateUpdateDto;
import com.company.librarywebappspring.dto.books.BookListDto;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final UserBookRepository userBookRepository;

    @Override
    public List<BookListDto> findAll(String search) {
        List<Book> books = bookRepository.findAllByParam(search);
        List<BookListDto> bookListDtos = new ArrayList<>();

        books.forEach(book -> {
            bookListDtos.add(BookListDto.builder()
                    .id(book.getId())
                    .name(book.getName())
                    .author(book.getAuthor())
                    .price(book.getPrice())
                    .build());
        });

        return bookListDtos;
    }

    @Override
    public boolean save(BookCreateUpdateDto bookDto) {
        Book book = Book.builder()
                .name(bookDto.getName())
                .description(bookDto.getDescription())
                .author(bookDto.getAuthor())
                .stockCount(bookDto.getStockCount())
                .price(bookDto.getPrice())
                .build();

        bookRepository.save(book);
        return true;
    }

    @Override
    public boolean update(Integer bookId, BookCreateUpdateDto bookDto) {
        Book book = retrieveBookById(bookId);

        book.setName(bookDto.getName());
        book.setStockCount(bookDto.getStockCount());
        book.setAuthor(bookDto.getAuthor());
        book.setDescription(bookDto.getDescription());
        book.setPrice(bookDto.getPrice());

        bookRepository.save(book);

        return true;
    }

    @Override
    public BookByIdDto findById(Integer id) {
        Book book = retrieveBookById(id);

        return BookByIdDto.fromEntity(book);
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
//        Book book = findById(id);
//
//        if(book.getStockCount() > 0){
//            User user = UserUtils.currentUser();
//
//            Integer stockCount = book.getStockCount() - 1;
//            book.setStockCount(stockCount);
//            bookRepository.save(book);
//
//            UserBook ub = UserBook.builder()
//                    .user(user)
//                    .book(book)
//                    .build();
//
//            userBookRepository.save(ub);

//            return true;
//        }

        return false;
    }

    private Book retrieveBookById(Integer id){
        Optional<Book> book = bookRepository.findById(id);
        return book.orElseThrow(() -> new EntityNotFoundException("Book not found"));
    }
}
