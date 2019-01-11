<%--
  Created by IntelliJ IDEA.
  User: doch
  Date: 2018/12/24
  Time: 14:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
Hello com
<form action="/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file">
    <input  type="submit" value="文件上传">
</form>
<h1>admin</h1>
<h1>tomcat</h1>
<h1>user</h1>
<script src="/static/js/index.js"></script>
${success}
</body>
</html>
