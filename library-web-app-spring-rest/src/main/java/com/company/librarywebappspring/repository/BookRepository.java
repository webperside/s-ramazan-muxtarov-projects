package com.company.librarywebappspring.repository;

import com.company.librarywebappspring.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>, CustomBookRepository {
}
