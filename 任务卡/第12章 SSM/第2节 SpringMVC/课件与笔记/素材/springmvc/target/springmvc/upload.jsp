<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2020-06-08
  Time: 17:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <h1>上传</h1>
<form action="/upload" method="post" enctype="multipart/form-data">
      文件:<input type="file" name="myfile">
    <input type="submit" value="上传">

</form>
</body>
</html>
