package com.example.exam.sevice;

import com.example.exam.dao.StudentDAO;
import com.example.exam.entity.Student;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import java.util.List;

@Stateless
public class StudentService {
    @Inject
    private StudentDAO studentDAO;

    public void createStudent(Student student) {
        studentDAO.save(student);
    }

    public Student getStudent(int id) {
        return studentDAO.find(id);
    }

    public List<Student> getAllStudents() {
        return studentDAO.findAll();
    }

    public void updateStudent(Student student) {
        studentDAO.update(student);
    }

    public void deleteStudent(int id) {
        studentDAO.delete(id);
    }
}