<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Books</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.2/css/all.min.css"
          integrity="sha512-HK5fgLBL+xu6dm/Ii3z4xhlSUyZgTT9tuc/hSrtw6uzJOvgRr2a9jyxxT1ely+B+xFAmJKVSTbpM/CuL7qxO8w=="
          crossorigin="anonymous"/>
</head>

<body>
<div class="container">
    <c:if test = "${userLoggedIn != null}">
        <h2>Welcome, <c:out value = "${userLoggedIn}"/></h2>
    </c:if>
    <c:if test = "${error != null}">
        <h3>Error during operation : <c:out value = "${error}"/></h3>
    </c:if>
    <c:if test = "${msg != null}">
        <h3>Message : <c:out value = "${msg}"/></h3>
    </c:if>
    <form action="books" method="GET">
        <div class="mb-3">
            <label for="bookName" class="form-label">Key</label>
            <input type="text" class="form-control" id="bookName" name="search">
        </div>
        <button type="submit" class="btn btn-primary">Search</button>
    </form>
    <table class="table table-striped">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Author</th>
            <th scope="col">Price</th>
            <th scope="col">Operation</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${books}" var="book">
            <tr>
                <td scope="row">${book.name}</td>
                <td>${book.author}</td>
                <td>${book.price}</td>
                <td>
                    <c:if test = "${isAdmin}">
                        <a href="/book-edit?id=<c:out value="${book.id}"/>" class="btn btn-warning" role="button"
                        >
                            <i class="fas fa-edit"></i>
                        </a>
                        <a href="/book-delete?id=<c:out value="${book.id}"/>" class="btn btn-danger" role="button"
                        >
                            <i class="fas fa-trash"></i>
                        </a>
                    </c:if>
                    <a href="/buy-book?id=<c:out value="${book.id}"/>" class="btn btn-info" role="button"
                    >
                        <i class="fas fa-shopping-cart"></i>
                    </a>
                </td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>


</body>
</html>
