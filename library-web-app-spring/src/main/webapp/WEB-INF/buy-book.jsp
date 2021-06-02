<%@ page import="com.company.librarywebappspring.models.Book" %><%--
  Created by IntelliJ IDEA.
  User: hamid
  Date: 03.05.21
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buy book</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</head>
<body>
<%
    Book book =(Book) request.getAttribute("book");
%>
<div class="container">
    <form method="post" action="buy-book">
        <h3>Do you want to buy this book ? (<%=book.getName()%>)</h3>
        <input name="id" value="<%=book.getId()%>" hidden>
        <button type="submit" class="btn btn-primary">Submit</button>
        <a href="/books" class="btn btn-danger" role="button" >Cancel</a>
    </form>
</div>
</body>
</html>
