<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Edit Student</title>
</head>
<body>
<h1>Edit Student</h1>
<form action="students" method="post">
    <input type="hidden" name="action" value="update"/>
    <input type="hidden" name="id" value="${student.studentId}"/>
    <label>Code:</label>
    <input type="text" name="studentCode" value="${student.studentCode}"/><br/>
    <label>Name:</label>
    <input type="text" name="fullName" value="${student.fullName}"/><br/>
    <label>Address:</label>
    <input type="text" name="address" value="${student.address}"/><br/>
    <input type="submit" value="Update"/>
</form>
</body>
</html>