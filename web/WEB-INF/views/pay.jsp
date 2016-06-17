<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2016/6/14
  Time: 12:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/pay" method="post">
    <input type="hidden" name="token" value="${requestScope.token}">
    <input type="text" name="money">
    <button>支付</button>
</form>
</body>
</html>
