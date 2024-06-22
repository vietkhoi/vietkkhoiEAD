package com.example.exam.sevice;

import com.example.exam.dao.StudentScoreDAO;
import com.example.exam.entity.StudentScore;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class StudentScoreService {
    @Inject
    private StudentScoreDAO studentScoreDAO;

    public void createStudentScore(StudentScore studentScore) {
        studentScoreDAO.save(studentScore);
    }

    public StudentScore getStudentScore(int id) {
        return studentScoreDAO.find(id);
    }

    public List<StudentScore> getAllStudentScores() {
        return studentScoreDAO.findAll();
    }

    public void updateStudentScore(StudentScore studentScore) {
        studentScoreDAO.update(studentScore);
    }

    public void deleteStudentScore(int id) {
        studentScoreDAO.delete(id);
    }
}