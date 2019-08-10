<%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/8/7
  Time: 17:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AJAX练习</title>
    <script type="text/javascript">
        window.onload=function () {
            var loadTime = document.getElementById("loadTime");
            var timeDiv = document.getElementById("timeDiv");
            var buttonTime = document.getElementById("buttonTime");
            var span = document.getElementById("span");

            loadTime.innerText = "本页面打开时间为——" + new Date().toLocaleString();
            loadTime.style.textAlign = "right";

            buttonTime.onclick = function () {
                span.innerText = "正在获取数据，请稍后";
                span.style.color = "red";
                var waitTime = setInterval(function () {
                    span.innerText = span.innerText + ".";
                },100);
                setTimeout(function () {
                    clearInterval(waitTime);
                    span.innerText = "";
                },1000);

                var xmlhttp;
                if (window.XMLHttpRequest)
                {
                    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
                    xmlhttp=new XMLHttpRequest();
                }
                else
                {
                    // IE6, IE5 浏览器执行代码
                    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttp.onreadystatechange=function()
                {
                    if (xmlhttp.readyState==4 && xmlhttp.status==200)
                    {
                        timeDiv.innerText=xmlhttp.responseText;
                    }
                };
                xmlhttp.open("GET","timeServlet",true);
                xmlhttp.send();
            }
        }

    </script>
</head>
<body>
<div id="loadTime"></div>
<h1>AJAX练习</h1>
<p>利用AJAX访问servlet，在不刷新页面的情况下更新页面</p>
<div id="timeDiv">点击刷新按钮跟新日期</div>
<input id="buttonTime" type="button" value="刷新"><span id="span"></span>
</body>
</html>
