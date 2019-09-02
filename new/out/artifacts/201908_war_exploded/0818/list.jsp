<%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/8/18
  Time: 23:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户信息列表</title>
    <style type="text/css">
        bod{
            text-align: center;
        }
        div.table{
            border: yellow 1px solid;
            margin:0 auto;
            width: 500px;
            height: 500px;
        }
        table{
            margin: 0 auto;
            width: 300px;
            text-align: center;
        }
    </style>
</head>
<body>
<h1>用户信息列表</h1>
<div class="table">
    <table border="1">
        <tr bgcolor="aqua">
            <td>id</td>
            <td>姓名</td>
            <td>性别</td>
            <td>操作</td>
        </tr>
        <tr>
            <td colspan="4">
                添加联系人
            </td>
        </tr>
    </table>
</div>


</body>
</html>
