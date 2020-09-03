<%--
  Created by IntelliJ IDEA.
  User: 11276
  Date: 2020/9/2
  Time: 11:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品展示</title>
    <style>
        .list-box {
            position: absolute;
            left: 5%;
            width: 90%;
            height: 100%;
        }

        .phone-box {
            background: #fff;
            width: 220px;
            margin: 0;
            padding: 12px 9px;
            border: #fff 1px solid;
            display: inline-block;
        }

        .phone-box:hover {
            border: gray 1px solid;
        }

        .phone-img {
            margin: 0;
            position: relative;
            height: 220px;
            padding: 0;
            overflow: hidden;
        }

        .phone-info {
            height: 60px;
            margin-bottom: 8px;
            overflow: hidden;
            padding: 0;
        }

        .phone-price {
            position: relative;
            line-height: 22px;
            height: 22px;
            overflow: hidden;
            width: 100%;
            margin: 0 0 8px;
            padding: 0;
        }

        a:hover {
            color: red;
        }
    </style>
</head>
<body>
    <div class="list-box">
        <h1>精选手机</h1>
        <c:forEach items="${phoneList}" var="phone">
            <div class="phone-box">
                <div class="phone-img">
                    <img src="${phone.pimg}" alt="${phone.pname}" width="220px";
            height="220px">
                </div>
                <div class="phone-info">
                    <a href="" style="text-decoration:none">${phone.info}</a>
                </div>
                <div class="phone-price">
                    <span style="color: #ff0000">¥${phone.price}</span>
                </div>
            </div>
        </c:forEach>
    </div>
</body>
</html>
