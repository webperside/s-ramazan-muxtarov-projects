package com.company.springbootdemo.dao.impl;

import com.company.springbootdemo.dao.inter.UserDaoInter;
import com.company.springbootdemo.models.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDaoInter {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<User> findAll() {
        String jpql = "select u from User u"; // Java Persistence Query Language
        Query query = em.createQuery(jpql);
        List<User> users = (List<User>) query.getResultList();
        return users;
    }

    @Override
    public User findByEmailAndPassword(String email, String password) {
        String jpql = "select u from User u where u.email = :e and u.password = :p";
        Query query = em.createQuery(jpql);

        query.setParameter("e",email);
        query.setParameter("p",password);

        List<User> users =(List<User>) query.getResultList();

        if(users.size() == 1) return users.get(0);
        else return null;
    }

    @Override
    public User findByEmailAndPassword2(String email, String password) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class); // select * from ?;
        Root<User> from = cq.from(User.class); // select * from user;

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(cb.equal(from.get("email"), email));
        predicates.add(cb.equal(from.get("password"), password));

        cq.where(predicates.toArray(new Predicate[0])); // select * from user where email = ? and password = ?

        Query query = em.createQuery(cq);

        List<User> users =(List<User>) query.getResultList();

        if(users.size() == 1) return users.get(0);
        else return null;
    }

    @Override
    public User findById(Integer id) {
        User user = em.find(User.class,id);
        return user;
    }

    @Override
    public boolean save(User user) {
        em.persist(user);
        return true;
    }

    @Override
    public boolean update(User user) {
        em.merge(user);
        return true;
    }

    @Override
    public boolean remove(Integer id) {
        User user = em.find(User.class,id);
        em.remove(user);
        return true;
    }
}
