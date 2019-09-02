<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/8/16
  Time: 11:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>taglib测试</title>
</head>
<body>
<%--
<c:if test=""></c:if>
test属性用于接受Boolean值
如果test为true，则显示标签体内容，否则不显示

结合el表达式，就能完成很多事情

注意if标签没有else
--%>

<% List list = new ArrayList();
list.add("aa");
request.setAttribute("list00",list);
request.setAttribute("number",3);
request.setAttribute("week",3);
%>


<c:if test="${not empty requestScope.list00}">
        <h1>直接写html标签</h1>
</c:if>

<br>

    <c:if test="true">我是假..</c:if>
<br>
<hr>
<c:if test="${requestScope.number % 2 == 1}">
    ${requestScope.number}是奇数
</c:if>

<hr>
<h1>choose标签 类似于switch</h1>
<p>数字编号对应星期</p>
<c:choose>
    <c:when test="${requestScope.week == 2}">二</c:when>
    <c:otherwise>输入错误</c:otherwise>
</c:choose>

<hr>
<h1>foreach标签</h1>
<p>相当于for循环 begin end 开始结束值，都包含 var 临时变量 step 步长 varStatus 循环状态 </p>
<p>varStatus 的两个属性 index count 指数 次数 </p>
<h3>打印1-10</h3>
<table border="1">
    <tr>
        <td>i</td>
        <td>index</td>
        <td>count</td>
    </tr>
    <c:forEach begin="1" end="10" var="i" step="2" varStatus="s">
        <tr>
            <td>${i}</td>
            <td>${s.index}</td>
            <td>${s.count}</td>
        </tr>
    </c:forEach>
</table>
<h3>遍历容器</h3>
<% List<String> list1 = new ArrayList<>();
list1.add("abc");
list1.add("def");
list1.add("ghi");
request.setAttribute("strings",list1);
%>

<table border="1">
    <tr>
        <td>i</td>
        <td>index</td>
        <td>count</td>
    </tr>
    <c:forEach items="${requestScope.strings}" var="i" step="1" varStatus="s">
        <tr>
            <td>${i}</td>
            <td>${s.index}</td>
            <td>${s.count}</td>
        </tr>
    </c:forEach>
</table>
<hr>




</body>
</html>
