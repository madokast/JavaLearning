<%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/7/31
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h1>
      hi jsp
    </h1>
    <%
  final String contextPath = request.getContextPath();
  out.write(contextPath);%>
    <% response.getWriter().write("response"); %>
  </body>
</html>
