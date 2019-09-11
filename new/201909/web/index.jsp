<%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/9/5
  Time: 8:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script src="JQuery/js/jquery-3.4.1.js"></script>
    <script>
      $(
              function () {
                $.get("provinceServlet",{},function (data) {

                  var province = $("#province");

                  $(data).each(function () {

                    var option = "<option value=\""+this.id+"\">"+this.name+"</option>"

                    province.append(option);
                  })

                })

              }
      );
    </script>
  </head>
  <body>
  $END$
<div>

  <select name="province" id="province">
    <option value="null">--请选择省份--</option>
  </select>
</div>
  </body>
</html>
