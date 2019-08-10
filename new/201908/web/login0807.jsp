<%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/8/7
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆</title>
    <style type="text/css">
        div{
            width: 80%;
            float: right;
            text-align: left;
        }
        span{
            color: red;
        }
    </style>
    <script type="text/javascript">
        window.onload=function () { 
            var usernameInput = document.getElementById("usernameInput");
            var usernameTail = document.getElementById("usernameTail");

            var passwordInput = document.getElementById("passwordInput");
            var passwordTail = document.getElementById("passwordTail");

            var CAPTCHA_IMG = document.getElementById("CAPTCHA_IMG");
            var CAPTCHA_INPUT = document.getElementById("CAPTCHA_INPUT");
            var CAPTCHA_Tail = document.getElementById("CAPTCHA_Tail");


            var reload = document.getElementById("reload");
            var submit = document.getElementById("submit");
            var loginSpan = document.getElementById("loginSpan");

            //刷新验证码
            reload.onclick = function () {
                CAPTCHA_IMG.src = "CAPTCHAServlet0807?"+ new Date().getTime();
            };

            //提交
            submit.onclick = function () {
                //本地检查是否有空
                var isAllOk = true;
                if(usernameInput.value.length==0){
                    isAllOk = false;
                    usernameTail.innerText = "请输入用户名";
                }else {
                    usernameTail.innerText = "";
                }
                if(passwordInput.value.length==0){
                    isAllOk = false;
                    passwordTail.innerText = "请输入密码";
                }else{
                    passwordTail.innerText = "";
                }
                if(CAPTCHA_INPUT.value.length==0){
                    isAllOk = false;
                    CAPTCHA_Tail.innerText = "请输入验证码";
                }else {
                    CAPTCHA_Tail.innerText = "";
                }

                if(isAllOk){
                    //都写了，开始看看验证码
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
                            /////////////////////
                            if(xmlhttp.responseText=="OK"){
                                CAPTCHA_Tail.innerText = "验证码正确";
                                //进入登陆逻辑

                                var xmlhttp2;
                                if (window.XMLHttpRequest)
                                {
                                    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
                                    xmlhttp2=new XMLHttpRequest();
                                }
                                else
                                {
                                    // IE6, IE5 浏览器执行代码
                                    xmlhttp2=new ActiveXObject("Microsoft.XMLHTTP");
                                }
                                xmlhttp2.onreadystatechange=function()
                                {
                                    if (xmlhttp2.readyState==4 && xmlhttp2.status==200)
                                    {
                                        loginSpan.innerText = xmlhttp2.responseText;
                                        CAPTCHA_IMG.src = "CAPTCHAServlet0807?"+ new Date().getTime();
                                    }
                                };
                                xmlhttp2.open("GET","LoginServlet0807?username="+usernameInput.value+"&password="+passwordInput.value,true);
                                xmlhttp2.send();

                            }


                            ///////////////////
                            else{
                                CAPTCHA_Tail.innerText = "验证码错误，请重新输入";
                                CAPTCHA_IMG.src = "CAPTCHAServlet0807?"+ new Date().getTime();
                            }
                        }
                    };
                    xmlhttp.open("GET","CAPTCHAServlet0807?value="+CAPTCHA_INPUT.value,true);
                    xmlhttp.send();
                }


            };

        };
    </script>
</head>
<body>
<div>
    <h1>用户登录</h1>
    <form action="#" method="post">
        <label for="usernameInput">用户名：</label>
        <input id="usernameInput" type="text" name="username" placeholder="请输入用户名">
        <span id="usernameTail"></span>
        <br>

        <label for="passwordInput">密　码：</label>
        <input id="passwordInput" type="password" name="password" placeholder="请输入密码">
        <span id="passwordTail"></span>
        <br>

        <br>
        <img id="CAPTCHA_IMG" src="CAPTCHAServlet0807" alt="X验证码"><br>
        <label for="CAPTCHA_INPUT">验证码：</label><input id="CAPTCHA_INPUT" type="text" placeholder="请输入验证码">
        <span id="CAPTCHA_Tail"></span>
        <br>
        <br>
        <input id="reload" type="button" value="刷新">
        <input id="submit" type="button" value="提交">
        <spam id="loginSpan"></spam>
    </form>
</div>
</body>
</html>
