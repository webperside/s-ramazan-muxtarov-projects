package com.company.springbootdemo.dao.impl;

import com.company.springbootdemo.dao.inter.BookDaoInter;
import com.company.springbootdemo.models.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class BookDaoImpl implements BookDaoInter {

    @PersistenceContext // PersistenceUnit
    private EntityManager em;

    @Override
    public List<Book> findAll() {
        String jpql = "select b from Book b"; // Java Persistence Query Language
        Query query = em.createQuery(jpql);
        List<Book> books = (List<Book>) query.getResultList();
        return books;
    }

    @Override
    public Book findById(Integer id) {
        Book book = em.find(Book.class, id);
        return book;
    }

    @Override
    @Transactional
    public boolean save(Book book) {
        em.persist(book);
        return true;
    }

    @Override
    @Transactional
    public boolean update(Book book) {
        em.merge(book);
        return true;
    }

    @Override
    @Transactional
    public boolean remove(Integer id) {
        Book book = em.find(Book.class, id);
        em.remove(book);
        return true;
    }
}
