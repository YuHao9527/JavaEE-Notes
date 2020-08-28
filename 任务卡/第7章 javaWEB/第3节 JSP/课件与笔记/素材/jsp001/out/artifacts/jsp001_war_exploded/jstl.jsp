<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="com.yhp.bean.Users" %><%--
  Created by IntelliJ IDEA.
  User: Administrator
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <h1>删除前</h1>
    <c:set value="c-set的值" var="str" scope="request"></c:set>
    str=${str}<br>
    str=<c:out value="${str}"></c:out>
   <c:remove var="str" scope="request"></c:remove>
    <h1>删除后</h1>
    str=${str}<br>
    str=<c:out value="${str}"></c:out>
  <h1>if</h1>
    <c:set var="age" value="23" scope="request"></c:set>
    <c:if test="${age>18 and age<30}">
        青年
    </c:if>
    <h1>c:choose</h1>
    <c:choose>
        <c:when test="${age<18}">
            未成年
        </c:when>
        <c:when test="${age<30}">
            青年人
        </c:when>
        <c:otherwise>其他人</c:otherwise>
    </c:choose>

    <%
       List list=new ArrayList();
       list.add("list内容");
       list.add(100);
       list.add(new Users());
       request.setAttribute("alist",list);
    %>
<h1>list</h1>
    <c:forEach items="${alist}" var="va" varStatus="sta">
       ${sta.count}---${sta.index}----》 ${va}<br>
    </c:forEach>

</head>
<body>
</body>
</html>
