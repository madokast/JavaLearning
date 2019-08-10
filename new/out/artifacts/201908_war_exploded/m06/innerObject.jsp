<%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/8/8
  Time: 2:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>内置对象</title>
</head>
<body>
<% pageContext.getPage();
page.toString();
out.write("");
request.toString();
response.toString();
application.toString();
session.toString();
config.toString();
//exception

    %>

    </body>
</html>
