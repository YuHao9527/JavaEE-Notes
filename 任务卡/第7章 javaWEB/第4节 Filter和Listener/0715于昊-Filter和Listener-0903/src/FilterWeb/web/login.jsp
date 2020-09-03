<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 11276
  Date: 2020/9/3
  Time: 15:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>登录</title>
    <style>
        body {
            background: skyblue;
        }

        .login-box {
            position: absolute;
            top: 50%;
            left: 50%;
            width: 520px;
            height: 326px;
            margin-top: -163px;
            margin-left: -260px;
            background-color: #fff;
        }

        .login-title {
            background-color: #2a4b7f;
            height: 40px;
            padding-top: 20px;
            background-image: url(img/kaikeba.png);
            background-repeat: no-repeat;
            background-size:35% 80%;
            background-position: 15px center;
            text-align: right;
            line-height: 40px;
        }

        .login-title a {
            margin-right: 10px;
            color: #6988b7;
            font-size: 14px;
            text-decoration: none;
        }

        .login-box ul {
            padding: 36px 110px 0;
        }

        .login-box ul li {
            border-bottom: 1px solid #d4d4d4;
            overflow: hidden;
            padding-top: 15px;
        }

        .input-title {
            float: left;
            margin-top: 20px;
        }

        .input-box{
            border:none;
        }

        input {
            border: 0 none;
            color: #666;
            font-size: 13px;
            height: 30px;
            line-height: 30px;
            width: 100%;
        }

        input::-webkit-input-placeholder {
            color: red;
        }

        .login-btn {
            width: 168px;
            margin-top: 50px;
            margin-left: 55px;
            display: inline-block;
        }

        .login-btn input{
            background-color: #85c034;
            border-radius: 20px;
            height: 40px;
            font-size: 18px;
            color: #FFFFFF;
        }

    </style>
    <script src="jquery-3.5.1.min.js" type="text/javascript"></script>
    <script>
        $(function () {
            // 忘记密码链接，鼠标移入移除事件
            $(".login-title a").mousemove(function () {
                $(this).css({"color": "red"});
            }).mouseout(function () {
                $(this).css({"color": "#6988b7"});
            });

            $("#iName").focusout(function () {
                //判断用户名是否为空
                if($(this).val().trim() === ""){
                    $(this).prop("placeholder","用户名不能为空");
                }
            });

            $("#iPass").focusout(function () {
                //判断密码是否为空
                if($(this).val().trim() === ""){
                    $(this).prop("placeholder","密码不能为空！");
                }
            });

            $("#sign").click(function () {
                $(window).prop('location',"signUp.jsp");
            });
        })
    </script>
</head>
<body>
    <div class="login-box">
        <div class="login-title">
            <a href="/findBack">忘记密码?</a>
        </div>
        <form action="/login" method="post">
            <ul>
                <span class="input-title">
                    用户名:
                </span>
                <li>
                    <div class="input-box">
                        <input id="iName" name="uname" type="text" value="${sessionScope.uName}">
                    </div>
                </li>
                <span class="input-title">
                    密&nbsp;&nbsp;&nbsp;码:
                </span>
                <li>
                    <div class="input-box">
                        <input id="iPass" name="upass" type="password" value="${sessionScope.uPass}">
                    </div>
                </li>
            </ul>
            <div class="login-btn">
                <input type="submit" value="登录">
            </div>
            <div class="login-btn">
                <input type="button" value="注册" id="sign">
            </div>
        </form>
    </div>

</body>
</html>