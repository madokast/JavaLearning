<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/8/6
  Time: 23:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示最后登录时间</title>
    <style type="text/css">
        #p01{
            text-align: center;
        }
        #div01{
            text-align: right;
        }
    </style>
</head>
<body>
<%
    final Cookie[] cookies = request.getCookies();
    Cookie lastLoginTime = null;
    for (Cookie cookie : cookies) {
        if(cookie.getName().equals("lastLoginTimeCookie")){
            lastLoginTime = cookie;
        }
    }

    final long time = System.currentTimeMillis();

    if(lastLoginTime==null){
        out.write("<div id=\"div01\">");
        out.write("欢迎萌新");
        out.write("</div>");
        lastLoginTime = new Cookie("lastLoginTimeCookie",String.valueOf(time));
        response.addCookie(lastLoginTime);
    }else {
        out.write("<div id=\"div01\">");
        out.write("欢饮回来，您上次登录时间是: "+new Date(Long.valueOf(lastLoginTime.getValue())));
        out.write("</div>");
        lastLoginTime.setValue(String.valueOf(time));
    }

    response.addCookie(lastLoginTime);
    %>


<h1 id="p01">...内容...</h1>
</body>
</html>
