<%@ page import="com.company.models.Book" %><%--
  Created by IntelliJ IDEA.
  User: hamid
  Date: 03.05.21
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    Book book =(Book) request.getAttribute("book");
%>
<div class="container">
    <form method="post" action="book-delete"> http://localhost:8080/library/books
        <h3>Do you want to delete this book ?</h3>
        <input name="id" value="<%=book.getId()%>" hidden>
        <button type="submit" class="btn btn-primary">Submit</button>
        <a href="/library/books" class="btn btn-danger" role="button" data-bs-toggle="button">Cancel</a>
    </form>
</div>
</body>
</html>
