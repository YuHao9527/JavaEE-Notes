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
    <title>首页</title>
    <style>
        .main-body {
            position: absolute;
            left: 5%;
            width: 80%;
            height: 100%;
        }

        .title {
            width: 380px;
            height: 160px;
        }

        .point {
            position: absolute;
            right: 20px;
            top: 10px;
            width: 500px;
            height: 80px;
            color: #85c034;
            text-align: right;
        }

        .download {
            margin-bottom: 10px;
            width: 100px;
            height: 40px;
        }

        .charge {
            margin-bottom: 10px;
            width: 100px;
            height: 40px;
        }

        .quit {
            margin-bottom: 10px;
            width: 100px;
            height: 40px;
        }

        .quit a {
            font-size: 20px;
            text-decoration:none;
        }

        .change::-webkit-input-placeholder {
            color: red;
        }

    </style>

    <script src="jquery-3.5.1.min.js" type="text/javascript"></script>
    <script>
        $(function () {
            $("#iCharge").focusout(function () {
                if ($(this).val().match(/[0-9]/) == null) {
                    $(this).val("");
                    $(this).prop("placeholder","你的输入不合法");
                    $(this).addClass("change");
                }
            }).focus(function () {
                if($(this).val().trim() === ""){
                    $(this).prop("placeholder","请输入你要充值的积分");
                    $(this).removeClass("change");
                }
            })
        })
    </script>
</head>
<body>
<div class="main-body">
    <div class="title">
        <h1>欢迎用户:${sessionScope.loginName}</h1>
        <span style="font-size: 28px;color: skyblue">如需下载，请单击下载按钮</span><br>
        <span style="font-size: 28px;color: skyblue">如需充值，请单击充值按钮</span>
    </div>
    <div class="point">
        <h1>积分:${sessionScope.points}</h1>
    </div>
    <div class="charge">
        <form action="/charge" method="post">
            <input id="iCharge" type="text" placeholder="请输入你要充值的积分" name="point">
            <input type="submit" value="充值">
        </form>
    </div>
    <div class="download">
        <input type="button" value="下载" onclick="window.location.href='/download'">
    </div>
    <div class="quit">
        <input type="button" value="退出登录" onclick="window.location.href='/loginOut'">
    </div>
</div>
</body>
</html>