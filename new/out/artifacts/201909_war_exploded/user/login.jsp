<%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/9/5
  Time: 18:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>请登录</title>
</head>
<body>
<h1>用户登录</h1>
<div style="color: red">
    <c:forEach items="${errors}" var="error">
        ${error}<br>
    </c:forEach>
</div>
<div>
    <form action="${pageContext.request.contextPath}/user/loginServlet" method="post">
        <label for="input_username">用户名：</label><input id="input_username" type="text" name="username" value="ztx">
        <label for="input_password">密&nbsp;码：</label><input id="input_password" type="text" name="password" value="123456">
        <input type="submit" value="提交">
    </form>
</div>

</body>
</html>
