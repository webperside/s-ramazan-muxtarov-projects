package com.company.dao.impl;

import com.company.dao.AbstractDao;
import com.company.dao.inter.BookDaoInter;
import com.company.models.Book;
import com.company.models.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class BookDaoImpl extends AbstractDao implements BookDaoInter {
    @Override
    public List<Book> findAll() {
        EntityManager em = em();
        String jpql = "select b from Book b"; // Java Persistence Query Language
        Query query = em.createQuery(jpql);
        List<Book> books = (List<Book>) query.getResultList();
        close(em);
        return books;
    }

    @Override
    public Book findById(Integer id) {
        EntityManager em = em();
        Book book = em.find(Book.class, id);
        close(em);
        return book;
    }

    @Override
    public boolean save(Book book) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(book);
        em.getTransaction().commit();
        close(em);
        return true;
    }

    @Override
    public boolean update(Book book) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(book);
        em.getTransaction().commit();
        close(em);
        return true;
    }

    @Override
    public boolean remove(Integer id) {
        EntityManager em = em();

        Book book = em.find(Book.class, id);

        em.getTransaction().begin();
        em.remove(book);
        em.getTransaction().commit();
        close(em);
        return true;
    }
}
