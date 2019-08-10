<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.HashMap" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/8/8
  Time: 3:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<% List list = new ArrayList();
list.add("aaa");
list.add("bbb");
list.add("ccc");
pageContext.setAttribute("list",list);
Map map = new HashMap<>();
map.put("a","312");
pageContext.setAttribute("map",map);%>

${list[0]}
<br>
${map.a}
${map["a"]}

${pageContext.request.contextPath}
</body>
</html>
