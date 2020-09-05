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
     <form action="/upload" method="post" enctype="multipart/form-data">
       名称:<input type="text" name="uname" ><br>
       文件:<input type="file" name="myfile"><br>
        <input type="submit" value="上传">
     </form>
  </body>
</html>
