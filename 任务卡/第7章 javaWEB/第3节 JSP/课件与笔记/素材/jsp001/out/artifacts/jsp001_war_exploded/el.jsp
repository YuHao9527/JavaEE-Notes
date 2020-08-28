<%@ page import="com.yhp.bean.Users" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%  int k=20;
request.setAttribute("k1",k);
    Users users = new Users();
    users.setUserId(101);
    users.setUserName("里能");
    request.setAttribute("u1",users);
%>
   单个表量:${k1+20>100?111:222}<br>
   uid=${u1.userId}<br>
   uname=${u1.userName}<br>
  ${10+20<50 and 200<100}
<br>
</body>
</html>
