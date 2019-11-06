<%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/10/25
  Time: 17:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.4.1.js"></script>
</head>
<body>
<h2>Hello World!</h2>
<a href="success/test">成功</a><br/>
<a href="account/findAll">findAll</a><br/>
<form action="account/saveAccount" method="post">
    name<input type="text" name="name"><br/>
    money<input type="text" name="money"><br/>
    <input type="submit" value="tijiao">
</form>
</body>
</html>
