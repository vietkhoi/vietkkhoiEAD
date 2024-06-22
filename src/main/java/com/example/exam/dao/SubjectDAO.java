package com.example.exam.dao;

import com.example.exam.entity.Subject;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

public class SubjectDAO {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(Subject subject) {
        em.persist(subject);
    }

    public Subject find(int id) {
        return em.find(Subject.class, id);
    }

    public List<Subject> findAll() {
        return em.createQuery("SELECT s FROM Subject s", Subject.class).getResultList();
    }

    @Transactional
    public void update(Subject subject) {
        em.merge(subject);
    }

    @Transactional
    public void delete(int id) {
        Subject subject = find(id);
        if (subject != null) {
            em.remove(subject);
        }
    }
}