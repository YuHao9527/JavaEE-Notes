<%--
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
  <h1>show.jsp</h1>
  <h1>欢迎您:${loginuname} 回来  <a href="/loginout">退出</a>  </h1>
<%

    Cookie[] cookies = request.getCookies();
    if(cookies!=null){
        for (int i = 0; i < cookies.length; i++) {
            out.print("cookieName="+cookies[i].getName()+",cookieValue="+cookies[i].getValue());
        }
    }

%>
</body>
</html>
