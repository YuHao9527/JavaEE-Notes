<%--
  Created by IntelliJ IDEA.
  User: Administrator
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        //创建json对象
      //  var u1={"uname":"张三","age":18,"sex":"男"};
       // alert("用户名:"+u1.uname+",age="+u1.age);
        var users=[{"uname":"张三1","age":88},{"uname":"张三2","age":58},{"uname":"张三3","age":48},{"uname":"张三4","age":18}]
        for(var i=0;i<users.length;i++){
            var u2=users[i];
            alert("用户名:"+u2.uname+",age="+u2.age);
        }

    </script>
</head>
<body>

</body>
</html>
