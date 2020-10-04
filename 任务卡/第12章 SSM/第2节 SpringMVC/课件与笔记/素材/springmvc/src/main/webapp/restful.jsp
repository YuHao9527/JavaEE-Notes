<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-06-08
  Time: 15:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/testrest/张三/12" method="get">
        <input type="submit" value="get"></input>
    </form>
    <form action="/testrest/张三/13" method="post">
        <input type="submit" value="post"></input>
    </form>
    <form action="/testrest/张三/14" method="post">
        <input type="hidden" name="_method" value="put" >
        <input type="submit" value="put"></input>
    </form>
    <form action="/testrest/张三/15" method="post">
        <input type="hidden" name="_method" value="delete" >
        <input type="submit" value="delete"></input>
    </form>

</body>
</html>
