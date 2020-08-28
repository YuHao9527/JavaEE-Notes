<%--
  Created by IntelliJ IDEA.
  User: Administrator
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"  errorPage="test.jsp" language="java"  pageEncoding="UTF-8" %>
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

   <%
   request.setAttribute("req","request的值");
   session.setAttribute("sessionkey","session的值");
   application.setAttribute("app","application的值");
   pageContext.setAttribute("pa","pageContext的值");


    //   pageContext.setAttribute("k1","pageContext的值-k1");
       application.setAttribute("k1","application的值-k1");
       request.setAttribute("k1","request的值-k1");
       session.setAttribute("k1","session的值-k1");


   %>

<hr>
     小脚本方式获取:<br>
   request=  <%=request.getAttribute("req") %><br>
     session=  <%=session.getAttribute("sessionkey") %><br>
  application=<%=application.getAttribute("app")%><br>
     pageContext=<%=pageContext.getAttribute("pa")%>
  <%  out.print("<script>alert('aaaa');</script>"); %>
 url= <%=config.getServletContext().getRealPath("/image")  %>
<hr>
     <h1>el表达式获取的</h1>
     request= ${req}<br>
     session=${sessionkey}<br>
     application=${app}<br>
     pageContext=${pa}
    k1=${sessionScope.k1}
  <% /*System.out.println(7/0);*/%>
  <%@ include file="bottom.jsp"%>
  </body>
</html>
