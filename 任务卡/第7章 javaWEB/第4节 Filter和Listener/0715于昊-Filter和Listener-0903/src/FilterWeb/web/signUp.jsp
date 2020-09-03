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
    <title>注册</title>
    <style>
        body {
            background: skyblue;
        }

        .sign-box {
            position: absolute;
            top: 50%;
            left: 50%;
            width: 520px;
            height: 326px;
            margin-top: -163px;
            margin-left: -260px;
            background-color: #fff;
        }

        .sign-title {
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

        .sign-title span {
            margin-right: 10px;
            color: #FFFFFF;
            font-size: 35px;
            text-decoration: none;
        }

        .sign-box ul {
            padding: 36px 110px 0;
        }

        .sign-box ul li {
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

        .change::-webkit-input-placeholder {
            color: red;
        }

        .sign-btn {
            width: 168px;
            margin-top: 50px;
            margin-left: 55px;
            display: inline-block;
        }

        .sign-btn input{
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
            $("#iName").focusout(function () {
                //判断用户名是否为空
                if($(this).val().trim() === ""){
                    $(this).addClass("change");
                    $(this).prop("placeholder","用户名不能为空");
                }else{
                    //判断用户名是否合法
                    if ($(this).val().match(/^[0-9a-zA-Z_]{6,18}$/) == null) {
                        $(this).val("");
                        $(this).prop("placeholder","用户名不合法");
                        $(this).addClass("change");
                    }
                }
            }).focus(function () {
                if($(this).val().trim() === ""){
                    $(this).prop("placeholder","6到18位有效数字（字母、数字、下划线）");
                    $(this).removeClass("change");
                }
            });

            $("#iPass").focusout(function () {
                //判断密码是否为空
                if($(this).val().trim() === ""){
                    $(this).prop("placeholder","密码不能为空");
                    $(this).addClass("change");
                }else{
                    //判断密码是否合法
                    if ($(this).val().match(/^\w{6,18}$/) == null) {
                        $(this).val("");
                        $(this).prop("placeholder","密码不合法");
                        $(this).addClass("change");
                    }
                }
            }).focus(function () {
                $(this).prop("placeholder","6到18任意字符");
                $(this).removeClass("change");
            });
        })
    </script>
</head>
<body>
    <div class="sign-box">
        <div class="sign-title"></div>
        <form action="/signUp" method="post">
            <ul>
                <span class="input-title">
                    用户名:
                </span>
                <li>
                    <div class="input-box">
                        <input id="iName" name="uname" placeholder="6到18位有效数字（字母、数字、下划线）" type="text">
                    </div>
                </li>
                <span class="input-title">
                        密&nbsp;&nbsp;&nbsp;码:
                </span>
                <li>
                    <div class="input-box">
                        <input id="iPass" name="upass" placeholder="6到18位任意字符" type="password">
                    </div>
                </li>
            </ul>
            <div class="sign-btn">
                <input type="submit" value="注册">
            </div>
            <div class="sign-btn">
                <input type="reset" value="重置">
            </div>
        </form>
    </div>
</body>
</html>