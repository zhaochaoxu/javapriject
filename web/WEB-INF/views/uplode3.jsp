<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2016/6/16
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Document</title>
    <link rel="stylesheet" href="/static/css/bootstrap.min.css">
</head>
<body>
    <div class="container">

        <div class="col-xs-6">

            <form action="/uplodfile" method="post" enctype="multipart/form-data">

                <div class="form-group">

                    <label>文件描述</label>
                    <input type="text" name="filedpc" class="form-control">
                    <label>选择文件</label>
                    <input type="file" name="doc" class="form-control">
                    <button class="">保存</button>

                </div>
            </form>
        </div>
    </div>
</body>
</html>
