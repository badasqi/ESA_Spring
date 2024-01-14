<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Providers</title>
</head>
<body>
<h1>List of Providers</h1>
<table border="1">
    <thead>
    <tr>
        <th>ID</th>
        <th>Name</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="provider" items="${providers}">
        <tr>
            <td><c:out value="${provider.name}" /></td>
            <td>
                <c:choose>
                    <c:when test="${not empty provider.clients}">
                        <!-- Если у провайдера есть клиенты -->
                        <c:forEach items="${provider.clients}" var="client">
                            <!-- Вывод информации о клиентах -->
                            <c:out value="${client.name}"/>, <c:out value="${client.contact}"/>, <c:out value="${client.tariff}"/><br>
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        <!-- Если у провайдера нет клиентов -->
                        No clients
                    </c:otherwise>
                </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
