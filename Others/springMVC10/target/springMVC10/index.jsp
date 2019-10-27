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
<%--    出现大问题，这个资源也被前端控制器拦截了--%>
    
    <script>
        $(function () {
            $("#button01").click(
                function () {
                    $.ajax({
                        // json
                        url:"request/testAjax",
                        contentType:"application/json;charset=UTF-8",
                        data:'{"name":"zrx","age":20}',
                        dataType:"json",
                        type:"POST",
                        success:function (data) {
                            $("#div01").html(data);
                        }
                    });



                }
            );
        });
        
    </script>
</head>
<body>
<h3>入门程序</h3>
<a href="hello">入门</a><br/>
<a href="getparams">拿到请求参数</a><br/>
<form action="getparams" method="post">
    username:<input type="text" name="username"><br/>
    password:<input type="password" name="password"><br/>
    birthday:<input type="text" name="birthday"><br/>
    <input type="submit" name="submit">
</form>
<br>
<a href="rest/get/233">入门</a><br/>
<br>
<a href="request/returnString">返回字符串</a><br/>
<br>
<a href="request/returnVoid">返回void</a><br/>
</body>
<a href="request/returnModelAndView">返回ModelAndView</a><br/>
<hr/>
<button id="button01">发送ajax异步请求</button>
<div id="div01"></div>
<hr>
<form action="file/test3" method="post" enctype="multipart/form-data">
    选择文件<input type="file" name="upload21">
    <input type="submit" value="上传">
</form>
<hr>
<a href="exception/test1">异常学习</a>
</body>
</html>
