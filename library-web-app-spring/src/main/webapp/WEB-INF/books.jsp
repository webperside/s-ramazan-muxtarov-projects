<%@ page import="com.company.librarywebappspring.models.Book" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
    <title>Books</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</head>
<body>
<%
    List<Book> books =(List<Book>) request.getAttribute("books");
%>
<div class="container">
    <table class="table">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Author</th>
            <th scope="col">Price</th>
            <th scope="col">Operation</th>
        </tr>
        </thead>
        <tbody>
<%--        <%--%>
<%--            for(Book book : books){--%>
<%--        %>--%>
        <c:forEach items="${books}" var="book">
        <tr>
            <td scope="row">${book.name}</td>
            <td>${book.author}</td>
            <td>${book.price}</td>
            <td>
                <a href="/book-edit?id=<c:out value="${book.id}"/>" >Edit</a>
                <a href="/book-delete?id=<c:out value="${book.id}"/>" >Delete</a>
            </td>
        </tr>
        </c:forEach>
<%--        <%--%>
<%--            }--%>
<%--        %>--%>

        </tbody>
    </table>
</div>


</body>
</html>
