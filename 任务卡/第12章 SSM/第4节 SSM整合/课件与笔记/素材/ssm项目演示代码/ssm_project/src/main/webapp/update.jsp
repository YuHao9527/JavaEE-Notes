<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-06-11
  Time: 19:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <h1>更新</h1>
   <form action="updateBill" method="post">
       <input type="hidden" name="id" value="${bills.id}">
       <p>类型:
           <c:forEach items="${types}" var="ty">
               <input type="radio" value="${ty.id}"  ${ty.id==bills.typeid?'checked':''}   name="typeid">${ty.bname}
           </c:forEach>
       </p>
       <p>标题:<input type="text" style="width: 500px" name="title" value="${bills.title}" > </p>
       <p>日期：<input type="text" name="billtime" value="<fmt:formatDate value="${bills.billtime}" pattern="yyyy/MM/dd"></fmt:formatDate>">
           金额:<input type="text" name="price" value="${bills.price}"> </p>
       <p>说明:<textarea cols="50" rows="4" name="explains">${bills.explains}</textarea></p>
       <input type="reset" value="重置">
       <input type="submit" value="保存">
   </form>
</body>
</html>
