package com.example.exam.dao;

import com.example.exam.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;

public class StudentDAO {
    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void save(Student student) {
        em.persist(student);
    }

    public Student find(int id) {
        return em.find(Student.class, id);
    }

    public List<Student> findAll() {
        return em.createQuery("SELECT s FROM Student s", Student.class).getResultList();
    }

    @Transactional
    public void update(Student student) {
        em.merge(student);
    }

    @Transactional
    public void delete(int id) {
        Student student = find(id);
        if (student != null) {
            em.remove(student);
        }
    }
}