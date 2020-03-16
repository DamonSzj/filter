<%--
  Created by IntelliJ IDEA.
  User: sunmac
  Date: 2020/3/16
  Time: 09:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <font color="red">
            ${message}
    </font>
    <br>
<form action="<%=request.getContextPath()%>/filter/hello.jsp" method="post">
    username:<input type="text" name="username" value="${param.username}"/>
    <br>
    password:<input type="password" name="password" value="${param.password}"/>
    <br>
    <br>
    <input type="submit" value="submit"/>
</form>
</body>
</html>
