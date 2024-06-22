<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Student List</title>
</head>
<body>
<h1>Student List</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Student Code</th>
        <th>Full Name</th>
        <th>Address</th>
    </tr>
    <c:forEach var="student" items="${students}">
        <tr>
            <td>${student.studentId}</td>
            <td>${student.studentCode}</td>
            <td>${student.fullName}</td>
            <td>${student.address}</td>
        </tr>
    </c:forEach>
</table>
<h2>Add New Student</h2>
<form action="students" method="post">
    <label for="studentCode">Student Code:</label>
    <input type="text" id="studentCode" name="studentCode"><br>
    <label for="fullName">Full Name:</label>
    <input type="text" id="fullName" name="fullName"><br>
    <label for="address">Address:</label>
    <input type="text" id="address" name="address"><br>
    <input type="submit" value="Add Student">
</form>
</body>
</html>