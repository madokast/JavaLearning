<%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/9/5
  Time: 19:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>欢迎</title>
</head>
<body>
<div>
    <c:forEach items="${errors}" var="error">
        ${error}<br>
    </c:forEach>
</div>
<h1>欢迎${requestScope.user.username}访问</h1>
<div>
    <form action="${pageContext.request.contextPath}/user/logoutServlet" method="post">
        <input type="submit" value="登出">
    </form>
</div>
</body>
</html>
