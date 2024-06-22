package com.example.exam.servlet;

import com.example.exam.entity.Subject;
import com.example.exam.sevice.SubjectService;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/subjects")
public class SubjectServlet extends HttpServlet {
    @Inject
    private SubjectService subjectService;

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
                deleteSubject(request, response);
                break;
            default:
                listSubjects(request, response);
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
                insertSubject(request, response);
                break;
            case "update":
                updateSubject(request, response);
                break;
        }
    }

    private void listSubjects(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Subject> listSubjects = subjectService.getAllSubjects();
        request.setAttribute("subjects", listSubjects);
        request.getRequestDispatcher("subjectList.jsp").forward(request, response);
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("addSubject.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Subject existingSubject = subjectService.getSubject(id);
        request.setAttribute("subject", existingSubject);
        request.getRequestDispatcher("editSubject.jsp").forward(request, response);
    }

    private void insertSubject(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String subjectCode = request.getParameter("subjectCode");
        String subjectName = request.getParameter("subjectName");
        int credit = Integer.parseInt(request.getParameter("credit"));
        Subject newSubject = new Subject(subjectCode, subjectName, credit);
        subjectService.createSubject(newSubject);
        response.sendRedirect("subjects");
    }

    private void updateSubject(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String subjectCode = request.getParameter("subjectCode");
        String subjectName = request.getParameter("subjectName");
        int credit = Integer.parseInt(request.getParameter("credit"));

        Subject subject = subjectService.getSubject(id);
        subject.setSubjectCode(subjectCode);
        subject.setSubjectName(subjectName);
        subject.setCredit(credit);
        subjectService.updateSubject(subject);
        response.sendRedirect("subjects");
    }

    private void deleteSubject(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        subjectService.deleteSubject(id);
        response.sendRedirect("subjects");
    }
}