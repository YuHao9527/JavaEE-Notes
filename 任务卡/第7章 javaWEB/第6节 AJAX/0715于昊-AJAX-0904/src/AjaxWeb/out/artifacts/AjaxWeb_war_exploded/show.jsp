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
    <script>
        $(function () {
            var flag = "<%= (String) session.getAttribute("flag")%>";
            if (flag !== "accessed") {
                location.href="/getAll";
            }
        })
    </script>
</head>
<body>
<div>
    <h1>请为你喜欢的同学点赞！！！</h1>
    <table border="1" cellspacing="0" width="800px">
        <tr>
            <td>学生姓名</td>
            <td>学生信息</td>
            <td>学生获赞数</td>
        </tr>
    <c:forEach items="${requestScope.stdents}" var="student">
        <tr>
            <td>${student.name}</td>
            <td>${student.info}</td>
            <td>${student.fansNum}</td>
        </tr>
    </c:forEach>
    </table>
</div>
</body>
</html>
