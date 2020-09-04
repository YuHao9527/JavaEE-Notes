<%--
  Created by IntelliJ IDEA.
  User: Administrator
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript">
       function test1() {
           //1.创建XMLHttpRequest对象
           var xmlHttp;
           if (window.XMLHttpRequest) {
               //非IE
               xmlHttp = new XMLHttpRequest();
           } else if (window.ActiveXObject) {
               //IE
               xmlHttp = new ActiveXObject("Microsoft.XMLHTTP")
           }
           //2.打开连接
           var username=document.getElementById("username").value;
        //   xmlHttp.open("get","/testuname?uname="+username,true);
           xmlHttp.open("post","/testuname",true);
           //3.指定回调函数
           xmlHttp.onreadystatechange=function(){
               //3.1 判断状态
               if(xmlHttp.readyState==4){
                  //3.2 接受返回的内容
                   var text = xmlHttp.responseText;
                   document.getElementById("rs").innerText=text;
               }
           }
           //4.发送
        //  xmlHttp.send(null);
           xmlHttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded;charset=UTF-8");
           xmlHttp.send("uname="+username)
       }
    </script>
  </head>
  <body>
  <h1>注册</h1>
  用户名:<input type="text" id="username" name="uname"onblur="test1()"><span id="rs"></span>
  </body>
</html>
