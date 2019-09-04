<%--
  Created by IntelliJ IDEA.
  User: madokast
  Date: 2019/8/21
  Time: 21:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>一万小时计划汇总</title>
    <style type="text/css">
        h1, div {
            text-align: center;
        }

        div, table, #add {
            width: 80%;
            margin: 0 auto;
        }

        table {
            border: 1px solid grey;

        }

        #thead {
            background-color: #daa520;
        }

        tr, td {
            border: 1px solid grey;
        }

        #info {
            color: red;
        }
    </style>
</head>
<body>
<form action="${pageContext.request.contextPath}/handOutServlet" method="post">

    <!--||||||||||||||||||||||||标题||||||||||||||||||||||||-->

    <h1>ICHIWAN</h1>

    <!--||||||||||||||||||||||||错误信息||||||||||||||||||||||||-->

    <div id="info">
        <c:forEach items="${requestScope.errors}" var="error">
            <span>${error}</span><br>
        </c:forEach>
    </div>

    <!--||||||||||||||||||||||||添加||||||||||||||||||||||||-->


    <div id="addAndSelectEntries">
        <label for="dateDone_input">时间</label><input id="dateDone_input" type="text" name="dateDone"
                                                     value="${requestScope.today}">
        <label for="name_input">项目</label><input id="name_input" type="text" name="name" placeholder="Java">
        <label for="lengthMinute_input">时长/min</label><input id="lengthMinute_input" type="text" name="lengthMinute"
                                                             placeholder="60">
        <label for="describing_input">描述</label><input id="describing_input" type="text" name="describing"
                                                       placeholder="JavaWeb">
        <input type="submit" name="addEntry" value="提交">
        <input type="submit" name="selectEntry" value="查询">
    </div>


    <!--||||||||||||||||||||||||数据||||||||||||||||||||||||-->

    <div class="table">
        <table>
            <tr id="thead">
                <td>编号</td>
                <td>时间</td>
                <td>项目</td>
                <td>说明</td>
                <td>时长/min</td>
                <td>总时长/h</td>
                <td>日均时长/min</td>
            </tr>
            <c:forEach items="${requestScope.pageBean.list}" var="entryTail">
                <tr>
                    <td>${entryTail.id}</td>
                    <td>${entryTail.dateDone}</td>
                    <td>${entryTail.name}</td>
                    <td>${entryTail.describing}</td>
                    <td>${entryTail.lengthMinute}</td>
                    <td>${entryTail.totalHourMinute}</td>
                    <td>${entryTail.averageMinute}</td>
                </tr>
            </c:forEach>
        </table>
    </div>

    <!--||||||||||||||||||||||||分页||||||||||||||||||||||||-->

    <div id="page" style="float: right">
        <input type="hidden" name="currentPage" value="${requestScope.pageBean.currentPage}">
        <input type="hidden" name="rows" value="${requestScope.pageBean.rows}"><!--每页显示页数-->
        <input type="hidden" name="totalPage" value="${requestScope.pageBean.totalPage}">
        <input type="hidden" name="totalCount" value="${requestScope.pageBean.totalCount}">

        <input type="submit" name="pageFirst" value="首页">
        <input type="submit" name="pagePrevious" value="上一页"
        <c:if test="${requestScope.pageBean.currentPage == 1}">
               disabled="disabled"
        </c:if>>
        <input type="submit" name="pageNext" value="下一页"
        <c:if test="${requestScope.pageBean.currentPage == requestScope.pageBean.totalPage}">
               disabled="disabled"
        </c:if>>
        <input type="submit" name="pageLast" value="末页">
        <input type="submit" name="pageAll" value="全部">
        <span>当前第${requestScope.pageBean.currentPage}页，共${requestScope.pageBean.totalPage}页。共有${requestScope.pageBean.totalCount}条记录，每页显示${requestScope.pageBean.rows}条&nbsp;&nbsp;</span>
    </div>

    <!--||||||||||||||||||||||||删除||||||||||||||||||||||||-->

    <hr style="clear: both">
    <div id="delete">
        <input type="submit" name="deleteLast" value="删除最后一个">
        <input type="submit" name="statistics" value="统计">
    </div>
</form>
</body>
</html>
