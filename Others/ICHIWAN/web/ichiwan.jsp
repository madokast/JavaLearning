<%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/8/21
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>一万小时计划汇总</title>
    <style type="text/css">
        h1,div{
            text-align: center;
        }
        div,table,#add{
            width: 80%;
            margin:0 auto;
        }
        table{
            border: 1px solid grey;

        }
        #thead{
            background-color: #daa520;
        }
        tr,td{
            border: 1px solid grey;
        }
        #info{
            color: red;
        }
    </style>
</head>
<body>
<h1>ICHIWAN</h1>
<div id="info">
    <c:forEach items="${requestScope.errors}" var="error">
        <span>${error}</span><br>
    </c:forEach>
</div>
<div id="add">
    <form action="${pageContext.request.contextPath}/addUserServlet" method="post">
        <label for="dateDone_input">时间</label><input id="dateDone_input" type="text" name="dateDone" value="${requestScope.today}">
        <label for="name_input">项目</label><input id="name_input" type="text" name="name" placeholder="Java">
        <label for="lengthMinute_input">时长/min</label><input id="lengthMinute_input" type="text" name="lengthMinute" placeholder="60">
        <label for="describing_input">描述</label><input id="describing_input" type="text" name="describing" placeholder="JavaWeb">
        <input type="submit" value="提交">
    </form>
</div>
<div class="table">
    <table>
        <tr id="thead">
            <td>编号</td>
            <td>时间</td>
            <td>项目</td>
            <td>说明</td>
            <td>时长/min</td>
            <td>总时长/h</td>
            <td>日均时长/min</td>
        </tr>
        <c:forEach items="${requestScope.entryTails}" var="entryTail">
            <tr>
                <td>${entryTail.id}</td>
                <td>${entryTail.dateDone}</td>
                <td>${entryTail.name}</td>
                <td>${entryTail.describing}</td>
                <td>${entryTail.lengthMinute}</td>
                <td>${entryTail.totalHourMinute}</td>
                <td>${entryTail.averageMinute}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<div id="page">
    <form action="${pageContext.request.contextPath}/findUserByPageServlet" method="get">
        <label for="page_input">页数</label><input id="page_input" type="text" name="currentPage" value="${requestScope.totalPage}">
        <input type="hidden" name="rows" value="10"><!--每页显示页数-->
        <input type="submit" value="跳转">
        <span>当前第${requestScope.currentPage}页，共${requestScope.totalPage}页。共有${requestScope.totalCount}条记录</span>
    </form>
</div>
<hr>
<div id="delete">
    <form action="${pageContext.request.contextPath}/deleteEntryServlet" method="post">
        <label for="delete_input">编号</label><input id="delete_input" type="text" name="id" value="${requestScope.lastId}">
        <input type="submit" value="删除">
    </form>
</div>
</body>
</html>
