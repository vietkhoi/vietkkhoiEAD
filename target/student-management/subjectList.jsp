<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Subject List</title>
</head>
<body>
<h1>Subject List</h1>
<a href="subjects?action=new">Add New Subject</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Code</th>
        <th>Name</th>
        <th>Credit</th>
        <th>Actions</th>
    </tr>
    <c:forEach var="subject" items="${subjects}">
        <tr>
            <td>${subject.subjectId}</td>
            <td>${subject.subjectCode}</td>
            <td>${subject.subjectName}</td>
            <td>${subject.credit}</td>
            <td>
                <a href="subjects?action=edit&id=${subject.subjectId}">Edit</a>
                <a href="subjects?action=delete&id=${subject.subjectId}">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>