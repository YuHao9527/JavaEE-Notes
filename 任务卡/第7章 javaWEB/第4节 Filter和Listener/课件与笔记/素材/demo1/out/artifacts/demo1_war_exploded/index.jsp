<%--
  Created by IntelliJ IDEA.
  User: Administrator
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
   <h1>index.jsp</h1>
  <a href="/testcookie">testcookie</a>
  <p>

   <%
      String val ="";
       Cookie[] cookies = request.getCookies();
       if(cookies!=null){
           for (Cookie cookie : cookies) {
               if(cookie.getName().equals("username")){
                   val = cookie.getValue();
                   break;
               }
           }
       }
      // request.setAttribute("val",val);
      %>

    <form method="post" action="/login">
     用户名:<input type="text" name="uname" value="<%=val%>"><input type="submit" value="登录">
   </form></p>
  </body>
</html>
