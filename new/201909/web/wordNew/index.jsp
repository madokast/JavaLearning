<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/9/6
  Time: 8:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新敏感词过滤</title>
</head>
<body>
<p>采用动态代理的方法</p>
<h1>用户发言记录</h1>
<table>
    <tr>
        <td>时间</td>
        <td>内容</td>
    </tr>
    <c:forEach items="${applicationScope.words}" var="word">
        <tr>
            <td>${word.time}</td>
            <td>${word.body}</td>
        </tr>
    </c:forEach>
</table>
<form action="${pageContext.request.contextPath}/wordNew/servlet" method="post">
    <input type="text" name="body" placeholder="。。。">
    <input type="submit" value="提交">
</form>
</body>
</html>
