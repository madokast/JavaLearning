<%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/8/8
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <title>标题</title>
    <style type="text/css">
        div{
            font-weight: lighter;
        }
        div.out{
            border: 4px black solid;
            width: 100%;
            /*margin: 5% 5% 5% 5%;*/
            float: left;
            /*clear: both;*/
        }
        div.in{
            border: 1px black solid;
            margin: 2px 2px 2px 2px;
            float: left;
            /*clear: both;*/
        }
        .contentZRX ,.titleZRX{
            clear: left;
            /*background-color: yellow;*/
        }
        .re{
            /*文字旋转*/
            transform:rotate(-90deg);
            -ms-transform:rotate(-90deg); /* Internet Explorer 9*/
            -moz-transform:rotate(-90deg); /* Firefox */
            -webkit-transform:rotate(-90deg); /* Safari 和 Chrome */
            -o-transform:rotate(-90deg); /* Opera */
            filter: progid:DXImageTransform.Microsoft.BasicImage(rotation=1);
            float: left;
            font-size: 24px;
            /*border-left: 1px black solid;*/
            /*border-right: 1px black solid;*/
            margin:0 auto;
            padding: 0 0 0 0;
            /*width: 30px;*/
            /*height: 30px;*/
        }
        .empty{
            color: white;
        }
    </style>
    <script type="text/javascript">
        window.onload = function (ev) {
            var insertDiv = document.getElementById("insertDiv");
            var title = "國語魯語上";
            var content = "莊公如齊觀社。曹劌諫曰：「不可。夫禮，所以正民也。是故先王制諸侯，使五年四王、一相朝。終則講于會，以正班爵之義，帥長幼之序，訓上下之則，制財用之節，其間無由荒怠。夫齊棄太公之法而觀民于社，君為是舉而往之，非故業也，何以訓民？土發而社，助時也。收捃而蒸，納要也。今齊社而往觀旅，非先王之訓也。天子祀上帝，諸侯會之受命焉。諸侯祀先王、先公，卿大夫佐之受事焉。臣不聞諸侯相會祀也，祀又不法。君舉必書，書而不法，後嗣何觀？」公不聽，遂如齊。";

            var mapDot = new Map();
            mapDot.set("。",true);
            mapDot.set("，",true);
            mapDot.set("、",true);
            mapDot.set("？",true);
            mapDot.set("：",true);
            mapDot.set("「",true);
            mapDot.set("」",true);


            //標題擡頭
            insertDiv.innerHTML = "<div class=\"re titleZRX\">〇</div>";
            //標題
            for (var i = 0; i < title.length; i++) {
                var div = document.createElement("div");
                div.className  = "re";
                div.innerText = title.charAt(i);
                insertDiv.appendChild(div);
                // insertDiv.innerHTML = insertDiv.innerHTML + "<div class=\"re titleZRX\">"+title.charAt(i)+"</div>";
            }

            //正文換行
            insertDiv.innerHTML = insertDiv.innerHTML + "<div class=\"re contentZRX\">"+content.charAt(0)+"</div>";
            //正文
            for (var j = 1; j < content.length; j++) {
                if(mapDot.get(content.charAt(j))){
                    continue;
                }

                var div2 = document.createElement("div");
                div2.className  = "re";
                div2.innerText = content.charAt(j);
                insertDiv.appendChild(div2);

                // insertDiv.innerHTML = insertDiv.innerHTML + "<div class=\"re\">"+content.charAt(j)+"</div>";
            }
        };
    </script>
</head>
<body id="body">
<div class="out" >
    <div class="in" id="insertDiv">

<%--        <div class="re titleZRX">　</div>--%>
<%--        <div class="re" >题</div><div class="re">目</div>--%>


<%--        <div class="re contentZRX">题</div><div class="re">目</div>--%>
<%--        <div class="re">题</div><div class="re">目</div>--%>
<%--        <div class="re">题</div><div class="re">目</div>--%>
    </div>
</div>
<div class="empty">空白字符</div>
<br>
<br>
<br>
</body>
</html>
