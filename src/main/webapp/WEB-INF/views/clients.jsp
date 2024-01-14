<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<table border="1">
    <thead>
    <tr>
        <th>Name</th>
        <th>Contact</th>
        <th>Address</th>
        <th>Tariff</th>
        <th>Provider</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="client" items="${clients}">
        <tr>
            <td><c:out value="${client.name}"/></td>
            <td><c:out value="${client.contact}"/></td>
            <td><c:out value="${client.address}"/></td>
            <td><c:out value="${client.tariff}"/></td>
            <td><c:out value="${client.nameProvider}"/></td>
        </tr>
    </c:forEach>
    </tbody>
</table>

