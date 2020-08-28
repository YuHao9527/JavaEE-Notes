<%--
  Created by IntelliJ IDEA.
  User: Administrator
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" isErrorPage="true" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <h1>test.jsp</h1>

   request=  <%=request.getAttribute("req") %><br>
   session=  <%=session.getAttribute("sessionkey") %><br>
   application=<%=application.getAttribute("app")%>

<%=exception.getMessage()  %>
</body>
</html>
