package com.company.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AbstractDao {

    private static EntityManagerFactory emf = null;

    public static EntityManager em() {
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("user-book-db-jpa");
        }
        return emf.createEntityManager();
    }

    public static void close(EntityManager em){
        em.close();
    }
}
