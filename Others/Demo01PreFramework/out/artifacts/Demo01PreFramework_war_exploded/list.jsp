<%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/8/21
  Time: 20:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>用户列表</title>
    <style>
        div,table,h1{
            text-align: center;
            margin: 0 auto;
            width: 80%;
        }
    </style>
</head>
<body>
<div>
    <h1>
        用户信息列表
    </h1>
    <table border="1px">
        <tr bgcolor="#adff2f">
            <td>编号</td>
            <td>姓名</td>
            <td>性别</td>
            <td>年龄</td>
            <td>删除</td>
        </tr>

        <c:forEach items="${requestScope.users}" var="user" varStatus="s">


            <tr>
                <td>${s.count}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>
                    <form action="delete" method="post">
                        <input type="button" id="button_delete01" value="删除">
                        <input type="hidden" name="id" value="21">
                    </form>
                </td>
            </tr>

        </c:forEach>



        <tr>
            <td colspan="5">
                <form action="add.jsp" method="get">
                    <input type="submit" id="button_add" value="添加联系人">
                </form>
            </td>
        </tr>
    </table>
</div>
</body>
</html>
