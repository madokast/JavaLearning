<%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/9/19
  Time: 20:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>小春论坛登陆</title>
</head>
<body>
<div id="error" style="color: red">
    <c:if test="${! empty error}">
        <span>
            <c:out value="${error}" />
        </span>
    </c:if>
</div>
<div id="form">
    <form action="<c:url value="/loginCheck.html" />" method="post">
        <label for="input_userName">用户名：</label>
        <input id="input_userName" type="text" name="userName">
        <label for="input_password">密码：</label>
        <input id="input_password" type="text" name="password">
        <input type="submit" value="登陆">
        <input type="reset" value="重置">
    </form>
</div>
</body>
</html>
