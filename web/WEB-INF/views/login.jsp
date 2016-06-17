<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
<div class="container">

    <c:choose>

        <c:when test="${param.code == 1001}">
            <div class="alert alert-danger">
                验证码错误
            </div>
        </c:when>

        <c:when test="${param.code==1002}">
            <div class="alert alert-danger">
                用户名或密码错误！
            </div>
        </c:when>

    </c:choose>

    <form action="login" method="post" id="loginForm">

        <div class="form-group">
            <label>账号</label>
            <input type="text" class="form-control" name="username">
        </div>

        <div class="form-group">
            <label>密码</label>
            <input type="password" class="form-control" name="password"id="password">
        </div>

        <div class="form-group">
            <label>验证码</label>
            <input type="text" class="form-control" name="captcha">
            <a href="javascript:; "id="changepic" src="/captcha" ><img id="captcha" src="/captcha" alt=""></a>
        </div>
        <button type="button">登录</button>
        <button class="btn btn-primary" type="button" id="submitBtn">登录</button>
    </form>
</div>

<script src="/static/js/jquery-1.11.3.min.js"></script>
<script>
    $(function(){

        $("#changepic").click(function(){
            $("#captcha").attr("src","/captcha?t="+new Date().getTime());//欺骗服务器提交重复地址
        });

        $("#submitBtn").click(function(){
            var pwd =$("#password").val();
            $("#loginForm").submit();
        });

    });
</script>

</body>
</html>
