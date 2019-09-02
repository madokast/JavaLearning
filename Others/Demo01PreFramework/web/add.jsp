<%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/8/21
  Time: 20:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加联系人</title>
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
    <h1>添加联系人页面</h1>
    <form action="submit" method="get">
        <table>
            <tr>
                <td><label for="input_name">姓名:</label></td>
                <td><input id="input_name" type="text" name="name" placeholder="请输入姓名"></td>
            </tr>
            <tr>
                <td><label for="input_gender">性别:</label></td>
                <td>
                    <input id="input_gender" type="radio" name="gender" value="M" checked="checked">男
                    <input type="radio" name="gender" value="F">女
                </td>
            </tr>
            <tr>
                <td><label for="input_age">年龄:</label></td>
                <td><input id="input_age" type="text" name="age" placeholder="请输入年龄"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="提交">
                </td>
            </tr>
        </table>

    </form>
</div>
</body>
</html>
