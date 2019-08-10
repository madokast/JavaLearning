<%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/8/7
  Time: 0:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>JS 和 JSP</title>
    <script type="text/javascript">
        <%String eng = "abc";
        String zh = "中文测试";%>

        var eng = "<%=eng%>";
        var zh = "<%=zh%>";

        document.write(eng);
        document.write("<br>");
        document.write(zh);

    </script>
</head>
<body>

</body>
</html>
