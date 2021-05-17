<%--
  Created by IntelliJ IDEA.
  User: hamid
  Date: 03.05.21
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Book add</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js" integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <form method="post" action="book-add">
        <div class="mb-3">
            <label for="bookName" class="form-label">Name</label>
            <input type="text" class="form-control" id="bookName" name="name">
        </div>
        <div class="mb-3">
            <label for="bookDescription" class="form-label">Description</label>
            <input type="text" class="form-control" id="bookDescription" name="description">
        </div>
        <div class="mb-3">
            <label for="bookAuthor" class="form-label">Author</label>
            <input type="text" class="form-control" id="bookAuthor" name="author">
        </div>
        <div class="mb-3">
            <label for="bookPrice" class="form-label">Price</label>
            <input type="text" class="form-control" id="bookPrice" name="price">
        </div>
        <div class="mb-3">
            <label for="bookStockCount" class="form-label">Stock Count</label>
            <input type="text" class="form-control" id="bookStockCount" name="stockCount">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>
</body>
</html>
