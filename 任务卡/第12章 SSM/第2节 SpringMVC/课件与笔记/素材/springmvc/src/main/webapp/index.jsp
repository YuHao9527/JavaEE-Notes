<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<body>
<h2>Hello World!</h2>
<a href="/test?username=abc&age=20">test</a>
<form action="/test2" method="post">
    uname:<input type="text" name="uname">
    date:<input type="text" name="birthday">
    <input type="submit" value="post">
</form>
</body>
</html>
