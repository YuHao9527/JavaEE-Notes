<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-06-08
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<html>
<head>
    <title>success</title>
   <link href="css/a.css" type="text/css" rel="stylesheet">
</head>
<body>
    <img src="img/照片4.jpg" width="300px" height="300px">
   <h1>this is  success.jsp</h1>
   <h1>post-uname=${uname}</h1>
   <h1>HttpSesssion:${usession}  <a href="/out">out</a></h1>
   <h1>sessionmap:${sessionScope.sessionmap} <a href="/out2">out</a></h1>
   <h1>date:${birth}</h1>
   <h1>modelmapkey:${modelmapkey}</h1>
   <h1>modelkey:${modelkey}</h1>
   <h1>mvkey:${mvkey}</h1>
</body>
</html>
