<%@ page import="com.java.web.StudentServlet" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/9/4
  Time: 22:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>首页</title>
    <script src="jquery-3.5.1.min.js" type="text/javascript"></script>
    <style>
        table td {
            text-align: left;
            vertical-align: center;
        }

        .like-icon {
            font-size: 20px;
            text-align: center;
            vertical-align: center;
        }

        .icon:hover {
            content: url("images/like.png");
        }
    </style>
    <script>
        $(function () {
            var flag = "<%= (String) session.getAttribute("flag")%>";
            if (flag !== "accessed") {
                location.href="/getAll";
            }

            $(".icon").click(function () {
                var td = $(this).parent().parent();
                var name = td.parent().find(":eq(0)").html();
                $.post("/like","name="+name,function (result) {
                    td.find("span").text(result);
                })
            })
        })
    </script>
</head>
<body>
<div>
    <h1>请为你喜欢的同学点赞！！！</h1>
    <table border="1" cellspacing="0" width="800px">
        <tr>
            <th>学生姓名</th>
            <th>自我介绍</th>
            <th>学生获赞数</th>
        </tr>
    <c:forEach items="${requestScope.stdents}" var="student">
        <tr>
            <td>${student.name}</td>
            <td>${student.info}</td>
            <td>
                <div class="like-icon">
                    <img src="images/like_1.png" width="20px" height="20px" class="icon">
                    <span style="margin-left: 20px" class="fansNum">${student.fansNum}</span>
                </div>
            </td>
        </tr>
    </c:forEach>
    </table>
</div>
</body>
</html>
