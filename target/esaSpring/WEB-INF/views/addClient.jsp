<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Add Client</title>
</head>
<body>
<h1>Add Client</h1>
<form action="/esaSpring_war/clients" method="post">
    <%--@declare id="provider"--%><label for="name">Name:</label>
    <input type="text" id="name" name="name" required><br><br>

    <label for="contact">Contact:</label>
    <input type="text" id="contact" name="contact" required><br><br>

    <label for="address">Address:</label>
    <input type="text" id="address" name="address" required><br><br>

    <label for="tariff">Tariff:</label>
    <input type="text" id="tariff" name="tariff" required><br><br>

    <label for="provider">Select Provider:</label>
        <select name="providerId">
            <c:forEach items="${providers}" var="provider">
                <option value="<c:out value="${provider.id}"/>"><c:out value="${provider.name}"/></option>
            </c:forEach>
        </select><br><br>


    <input type="submit" value="Add Client">
</form>
</body>
</html>
