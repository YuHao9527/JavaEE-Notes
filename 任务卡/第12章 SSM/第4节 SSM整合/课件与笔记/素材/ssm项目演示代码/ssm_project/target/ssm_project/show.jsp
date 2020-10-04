<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-06-11
  Time: 14:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <h1>记账管理</h1>
<p>
    <form action="/getAllBills" method="post">
    类型:
    <select name="typeid">
        <option value="-1">不限</option>
        <c:forEach items="${types}" var="tp">
            <option value="${tp.id}"  ${tid==tp.id?'selected':''} >${tp.bname}</option>
        </c:forEach>
    </select>
   时间:
    从<input type="text" name="begin" value="${begintime}">到<input type="text" name="end" value="${endtime}" >
    <input type="submit" value="搜索">
   </form>
    <input type="button" value="记账" onclick="javascript:location.href='/getBillType'">
</p>
<table border="1" width="500">
    <tr>
        <td>标题</td>
        <td>时间</td>
        <td>类别</td>
        <td>金额</td>
        <td>说明</td>
        <td>操作</td>
    </tr>
   <c:if test="${info.list.size()>0}">
       <c:forEach items="${info.list}" var="bill">
           <tr>
               <td>${bill.title}</td>
               <td><fmt:formatDate value="${bill.billtime}" pattern="yyyy-MM-dd"></fmt:formatDate> </td>
               <td>${bill.billtype.bname}</td>
               <td>
                   <c:choose>
                       <c:when test="${bill.billtype.bname=='支出'||bill.billtype.bname=='借出'||bill.billtype.bname=='还出'}">
                           -${bill.price}
                       </c:when>
                       <c:when test="${bill.billtype.bname=='收入'||bill.billtype.bname=='借入'||bill.billtype.bname=='还入'}">
                           +${bill.price}
                       </c:when>
                       <c:otherwise>
                           ${bill.price}
                       </c:otherwise>
                   </c:choose>

               </td>
               <td>${bill.explains}</td>
               <td>
                   <a href="/deleteById?bid=${bill.id}">删除</a>
                   <a href="/findById?bid=${bill.id}">修改</a>
               </td>
           </tr>
       </c:forEach>
   </c:if>
    <c:if test="${info.list.size()==0}">
        <tr>
            <td colspan="6"> <h3>没有找到任何数据</h3>  </td>
        </tr>
    </c:if>
   <tr>
       <td colspan="6">
           <a href="/getAllBills?typeid=${tid}&begin=${begintime}&end=${endtime}">首页</a>

           <a href="/getAllBills?index=${info.prePage==0?1:info.prePage}&typeid=${tid}&begin=${begintime}&end=${endtime}">上一页</a>

           <a href="/getAllBills?index=${info.nextPage==0?info.pages:info.nextPage}&typeid=${tid}&begin=${begintime}&end=${endtime}">下一页</a>

           <a href="/getAllBills?index=${info.pages}&typeid=${tid}&begin=${begintime}&end=${endtime}">尾页</a>

           总页数:${info.pages}

           总条数:${info.total}

       </td>
   </tr>
</table>
</body>
</html>
