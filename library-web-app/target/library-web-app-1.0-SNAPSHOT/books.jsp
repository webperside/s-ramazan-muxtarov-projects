<%@ page import="com.company.dao.inter.BookDaoInter" %>
<%@ page import="com.company.dao.Context" %>
<%@ page import="com.company.models.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: hamid
  Date: 03.05.21
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <%
            for(Book book : books){
        %>
        <tr>
            <td scope="row"><%=book.getName()%></td>
            <td><%=book.getAuthor()%></td>
            <td><%=book.getPrice()%></td>
            <td>
                <a href="/library/book-edit?id=<%=book.getId()%>" >Edit</a>
                <a href="/library/book-delete?id=<%=book.getId()%>" >Delete</a>
            </td>
        </tr>
        <%
            }
        %>

        </tbody>
    </table>
</div>


</body>
</html>
