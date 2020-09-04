<%--
  Created by IntelliJ IDEA.
  User: Administrator
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
    <script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
    <script type="text/javascript">
        $(function(){
            $("#username").blur(function(){
                //1.接受参数
                var uname=$(this).val();
                //2.使用ajax发送请求
             /*   $.ajax({
                    url:"/testuname",
                    data:"uname="+uname,
                    type:"get",
                    dataType:"text",
                    success:function (result) {//通过参数来接受服务器返回的内容
                        $("#rs").html(result);
                    }
                });*/
/*
             $.post("/testuname","uname="+uname,function (result) {
                 $("#rs").html(result);
             });*/
                $.get("/testuname","uname="+uname,function (result) {
                    $("#rs").html(result);
                });
            });
        })
    </script>
  </head>
  <body>
  <h1>注册</h1>
  用户名:<input type="text" id="username" name="uname"><span id="rs"></span>
  </body>
</html>
