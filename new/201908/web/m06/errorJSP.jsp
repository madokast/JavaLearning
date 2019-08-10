<%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/8/8
  Time: 2:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isErrorPage="true" %>
<html>
<head>
    <title>服务器正忙</title>
</head>
<body>
<h1>服务器正忙</h1>
<% final String message = exception.getMessage();
    out.write(message); %>
</body>
</html>
