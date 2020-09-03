<%--
  Created by IntelliJ IDEA.
  User: 11276
  Date: 2020/9/3
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<body>
<h1>欢迎${sessionScope.loginName}登录</h1>
<h2>积分:${sessionScope.points}</h2>
</body>
</html>
