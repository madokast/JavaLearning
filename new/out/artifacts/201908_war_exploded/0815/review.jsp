<%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/8/15
  Time: 15:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>复习</title>
</head>
<body>
<%application.setAttribute("app","最大域");
session.setAttribute("sess","次大域");
request.setAttribute("req","次小域");
pageContext.setAttribute("pag","最小域");%>

<%=application.getAttribute("app")%><hr>
<%=session.getAttribute("sess")%><hr>
<%=request.getAttribute("req")%><hr>
<%=pageContext.getAttribute("pag")%><hr>

${applicationScope.app}<hr>
${sessionScope.sess}<hr>
${requestScope.req}<hr>
${pageScope.pag}<hr>
</body>
</html>
