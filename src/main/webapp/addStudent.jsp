<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Add Student</title>
</head>
<body>
<h1>Add Student</h1>
<form action="students" method="post">
    <input type="hidden" name="action" value="insert"/>
    <label>Code:</label>
    <input type="text" name="studentCode"/><br/>
    <label>Name:</label>
    <input type="text" name="fullName"/><br/>
    <label>Address:</label>
    <input type="text" name="address"/><br/>
    <input type="submit" value="Add"/>
</form>
</body>
</html>