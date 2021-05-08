package com.company.dao.impl;

import com.company.dao.AbstractDao;
import com.company.dao.inter.UserDaoInter;
import com.company.models.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class UserDaoImpl extends AbstractDao implements UserDaoInter {

    @Override
    public List<User> findAll() {
        EntityManager em = em();
        String jpql = "select u from User u"; // Java Persistence Query Language
        Query query = em.createQuery(jpql);
        List<User> users = (List<User>) query.getResultList();
        close(em);
        return users;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        EntityManager em = em();
        String jpql = "select u from User u where u.email = :e and u.password = :p";
        Query query = em.createQuery(jpql);

        query.setParameter("e",email);
        query.setParameter("p",password);

        List<User> users =(List<User>) query.getResultList();

        close(em);

        if(users.size() == 1) return users.get(0);
        else return null;
    }

    @Override
    public User findByEmailAndPassword2(String email, String password) {
        EntityManager em = em();
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class); // select * from ?;
        Root<User> from = cq.from(User.class); // select * from user;

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(from.get("email"), email));
        predicates.add(cb.equal(from.get("password"), password));

        cq.where(predicates.toArray(new Predicate[0])); // select * from user where email = ? and password = ?

        Query query = em.createQuery(cq);

        List<User> users =(List<User>) query.getResultList();

        close(em);

        if(users.size() == 1) return users.get(0);
        else return null;
    }

    @Override
    public User findById(Integer id) {
        EntityManager em = em();
        User user = em.find(User.class,id);
        close(em);
        return user;
    }

    @Override
    public boolean save(User user) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        close(em);
        return true;
    }

    @Override
    public boolean update(User user) {
        EntityManager em = em();
        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        close(em);
        return true;
    }

    @Override
    public boolean remove(Integer id) {
        EntityManager em = em();
        User user = em.find(User.class,id);

        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();

        close(em);
        return true;
    }
}
