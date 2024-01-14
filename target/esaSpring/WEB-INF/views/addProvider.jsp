<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Provider</title>
</head>
<body>
<h1>Add Provider</h1>
<form action="/esaSpring_war/providers" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br><br>
    <!-- Другие поля объекта Provider могут быть добавлены здесь -->
    <input type="submit" value="Add Provider">
</form>
</body>
</html>
