<%--
  Created by IntelliJ IDEA.
  User: Administrator
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  pageEncoding="UTF-8" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
     <%! String a="测试"; %>
    <%! public String geta(){ return  a;}%>
    a的值是:<%=a+"abc"%>
     <!-- html注释内容,查看源码时能看到 -->
     <%-- jsp注释,查看页面源码时看不到 --%>
  </body>
</html>
