package com.example.exam.servlet;

import com.example.exam.entity.StudentScore;
import com.example.exam.sevice.StudentScoreService;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/studentScores")
public class StudentScoreServlet extends HttpServlet {
    @Inject
    private StudentScoreService studentScoreService;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "list";
        }

        switch (action) {
            case "new":
                showNewForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "delete":
                deleteStudentScore(request, response);
                break;
            default:
                listStudentScores(request, response);
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "insert";
        }

        switch (action) {
            case "insert":
                insertStudentScore(request, response);
                break;
            case "update":
                updateStudentScore(request, response);
                break;
        }
    }

    private void listStudentScores(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<StudentScore> listStudentScores = studentScoreService.getAllStudentScores();
        request.setAttribute("studentScores", listStudentScores);
        request.getRequestDispatcher("studentScoreList.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addStudentScore.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        StudentScore existingStudentScore = studentScoreService.getStudentScore(id);
        request.setAttribute("studentScore", existingStudentScore);
        request.getRequestDispatcher("editStudentScore.jsp").forward(request, response);
    }

    private void insertStudentScore(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));
        double score1 = Double.parseDouble(request.getParameter("score1"));
        double score2 = Double.parseDouble(request.getParameter("score2"));
        StudentScore newStudentScore = new StudentScore(studentId, subjectId, score1, score2);
        studentScoreService.createStudentScore(newStudentScore);
        response.sendRedirect("studentScores");
    }

    private void updateStudentScore(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        int studentId = Integer.parseInt(request.getParameter("studentId"));
        int subjectId = Integer.parseInt(request.getParameter("subjectId"));
        double score1 = Double.parseDouble(request.getParameter("score1"));
        double score2 = Double.parseDouble(request.getParameter("score2"));

        StudentScore studentScore = studentScoreService.getStudentScore(id);
        studentScore.setStudentScoreId(studentId);
        studentScore.setStudentScoreId(subjectId);
        studentScore.setScore1(score1);
        studentScore.setScore2(score2);
        studentScoreService.updateStudentScore(studentScore);
        response.sendRedirect("studentScores");
    }

    private void deleteStudentScore(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentScoreService.deleteStudentScore(id);
        response.sendRedirect("studentScores");
    }
}
