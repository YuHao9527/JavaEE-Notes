<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2020/9/3
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>下载</title>
    <style>
        #iComment {
            width: 300px;
        }

        table {
            border-collapse:collapse;
            width: 100%;
        }

        table th {
            font-size: 20px;
            padding: 10px;
            border: 1px solid black;
            background: #666666;
            text-align: center;
            vertical-align: center;
        }

        table, th, td {
            border: 1px solid black;
            height: 60px;
            font-size: 16px;
            padding: 10px;
            text-align: left;
            vertical-align: center;

        }
    </style>
</head>
<body>
<div>
    <div>
        <h1>下载中，请等待......</h1>
    </div>
    <div>
        <form action="/comment" method="post">
            <label>
                <input type="text" name="comment" id="iComment">
            </label>
            <input type="submit" value="评论">
        </form>
    </div>
    <div>
        <table>
            <tr>
                <th>用户</th>
                <th>评论</th>
            </tr>
            <c:forEach items="${sessionScope.comments}" var="comments">
                <tr>
                    <td>${comments.username}</td>
                    <td>${comments.info}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>
</html>
