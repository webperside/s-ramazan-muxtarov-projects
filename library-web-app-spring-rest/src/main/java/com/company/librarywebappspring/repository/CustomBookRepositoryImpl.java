package com.company.librarywebappspring.repository;

import com.company.librarywebappspring.models.Book;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class CustomBookRepositoryImpl implements CustomBookRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Book> findAllByParam(String search) {
        String jpql = "select b from Book b";

        if (search != null && !search.isEmpty()) {
            jpql += " where name=:s" +
                    " or description=:s" +
                    " or author=:s" +
                    " or price=:s";
        }

        Query query = em.createQuery(jpql);

        if(search != null && !search.isEmpty()){
            query.setParameter("s",search);
        }

        return (List<Book>) query.getResultList();
    }
}
