<%--
  Created by IntelliJ IDEA.
  User: doch
  Date: 2018/12/26
  Time: 9:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/login" method="post">
username:<input type="text" name="userName"><br/>
password:<input type="password" name="userPassword" value="${id}"><br/>
<input type="submit" value="login">
    <%--加上这个隐藏域就不会报403--%>
    <input type="hidden" name="_csrf" value="${_csrf.token}">
    </form>
<h1 style="color: red">${msg}</h1>
<h2 style="color: red">${sss}</h2>
${SPRING_SECURITY_LAST_EXCEPTION}
${errorMsg}
</body>
</html>
