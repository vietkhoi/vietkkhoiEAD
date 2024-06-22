package com.example.exam.dao;

import com.example.exam.entity.StudentScore;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

public class StudentScoreDAO {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(StudentScore studentScore) {
        em.persist(studentScore);
    }

    public StudentScore find(int id) {
        return em.find(StudentScore.class, id);
    }

    public List<StudentScore> findAll() {
        return em.createQuery("SELECT s FROM StudentScore s", StudentScore.class).getResultList();
    }

    @Transactional
    public void update(StudentScore studentScore) {
        em.merge(studentScore);
    }

    @Transactional
    public void delete(int id) {
        StudentScore studentScore = find(id);
        if (studentScore != null) {
            em.remove(studentScore);
        }
    }
}