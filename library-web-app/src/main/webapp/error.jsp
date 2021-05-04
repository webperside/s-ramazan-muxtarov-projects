<%--
  Created by IntelliJ IDEA.
  User: hamid
  Date: 03.05.21
  Time: 21:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Error page</title>
</head>
<body>
<%
  String msg = request.getParameter("msg");
  out.println(msg);
%>
</body>
</html>
