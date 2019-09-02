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
            var title = "韓詩外傳〇卷二";
            var content = "楚昭王有士曰石奢，其為人也，公而好直，王使為理。於是道有殺人者，石奢追之，則父也，還返於廷，曰：「殺人者，臣之父也。以父成政，非孝也；不行君法，非忠也；弛罪廢法，而伏其辜，臣之所守也。」遂伏斧鑕，曰：「命在君。」君曰：「追而不及，庸有罪乎？子其治事矣。」石奢曰：「不然。不私其父，非孝也；不行君法、非忠也；以死罪生、不廉也。君欲赦之，上之惠也；臣不能失法，下之義也。」遂不去鈇鑕，刎頸而死乎廷。君子聞之曰：「貞夫法哉！石先生乎！」孔子曰：「子為父隱，父為子隱，直在其中矣。」《詩》曰：「彼已之子，邦之司直。」石先生之謂也。";

            var mapDot = new Map();
            mapDot.set("。",true);
            mapDot.set("，",true);
            mapDot.set("、",true);
            mapDot.set("？",true);
            mapDot.set("：",true);
            mapDot.set("「",true);
            mapDot.set("」",true);
            mapDot.set("；",true);
            mapDot.set("《",true);
            mapDot.set("》",true);


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
            var isDot = false;
            for (var j = 1; j < content.length; j++) {
                if(mapDot.get(content.charAt(j))){
                    if(isDot){
                        continue;
                    }
                    var div2 = document.createElement("div");
                    div2.className  = "re";
                    div2.innerText = "・";
                    insertDiv.appendChild(div2);
                    isDot=true;
                    continue;
                }

                isDot=false;

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
