<%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/8/6
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JSP Test</title>
</head>
<body>
<p>JSP 测试</p>
<%
    System.out.println("测试");
    int i = 5;
    myPrint();

%>

<%!
    int i = 3;
    void myPrint(){
        System.out.println(i);
    }
%>

<%=
    i
%>
</body>
</html>
