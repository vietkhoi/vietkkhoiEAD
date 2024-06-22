package com.example.exam.sevice;

import com.example.exam.dao.SubjectDAO;
import com.example.exam.entity.Subject;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class SubjectService {
    @Inject
    private SubjectDAO subjectDAO;

    public void createSubject(Subject subject) {
        subjectDAO.save(subject);
    }

    public Subject getSubject(int id) {
        return subjectDAO.find(id);
    }

    public List<Subject> getAllSubjects() {
        return subjectDAO.findAll();
    }

    public void updateSubject(Subject subject) {
        subjectDAO.update(subject);
    }

    public void deleteSubject(int id) {
        subjectDAO.delete(id);
    }
}