<%--
  Created by IntelliJ IDEA.
  User: Administrator
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script type="text/javascript" src="js/jquery-1.8.0.min.js"></script>
<script type="text/javascript">
    $(function(){
       
        $("#uid").blur(function(){
            //1.得到数据
            var userid=$(this).val();
            //2.ajax发送
           $.ajax({
               url:"/getuser",
               data:"uid="+userid,
               type:"post",
               dataType:"JSON",
               success:function (result) {
                 //  alert(result.userName);
                   $("#uname").val(result.userName);
               }
           })
        })
    })
</script>
<html>
<head>
    <title>Title</title>
</head>
<body>
<p>当光标离开userid的文本框后，自动查找对应的用户名，并填充到文本框</p>
    userid:<input type="text" id="uid"><br>
    username:<input type="text" id="uname">
</body>
</html>
