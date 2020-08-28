<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
     <%
      request.setAttribute("day",new Date());
      request.setAttribute("mydate","2000-1-1");
      request.setAttribute("num",123.4567);
     %>
<h1>日期:<fmt:formatDate value="${day}" pattern="yyyy-MM-dd"></fmt:formatDate></h1>
<h1>日期2：<fmt:parseDate value="${mydate}" pattern="yyyy-MM-dd"></fmt:parseDate></h1>
<h1>num=<fmt:formatNumber value="${num}" maxFractionDigits="1"></fmt:formatNumber> </h1>

</body>
</html>
