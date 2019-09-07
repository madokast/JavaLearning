<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/9/5
  Time: 20:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>记录</title>
    <style type="text/css">
        div,table{
            margin:0 auto;
        }
    </style>
</head>
<body>
<div style="text-align: center">
    <h1>大家的发言</h1>
    <table>
        <tr>
            <td>时间</td>
            <td>内容</td>
        </tr>
        <tr>
            <td>2019-09-05 20:28</td>
            <td>大家好</td>
        </tr>
        <c:forEach items="${applicationScope.list}" var="word">
            <tr>
                <td>${word.time}</td>
                <td>${word.body}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div>
    <form action="${pageContext.request.contextPath}/word/servlet" method="post">
        <input type="text" name="body" placeholder="...">
        <input type="submit" value="提交">
    </form>
</div>
</body>
</html>
