<%@ page import="domain.User" %><%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/8/8
  Time: 3:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% User user = new User();
user.setId(1);
user.setPassword("123");
        user.setUsername("zrx");
        pageContext.setAttribute("user",user);
        %>
        ${user.id}
        ${user.username}
        ${user.password}
</body>
</html>
