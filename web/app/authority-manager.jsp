<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sunmac
  Date: 2020/3/15
  Time: 13:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="<%=request.getContextPath()%>/authorityServlet?method=getAuthorities" method="post">
    Name<input type="text" name="userName"/>
    <input type="submit" value="submit"/>
</form>
<c:if test="${requestScope.user!=null}">
    ${requestScope.user.userName}的权限是:
    <br><br>
    <form action="<%=request.getContextPath()%>/authorityServlet?method=updateAuthority" method="post">

        <input type="hidden" name="userName" value="${requestScope.user.userName}">

        <c:forEach items="${authorities}" var="auth">

            <c:set var="flag" value="false"></c:set>
            
            <c:forEach items="${user.authorities}" var="ua">

                <c:if test="${ua.url == auth.url}">

                    <c:set var="flag" value="true"></c:set>

                </c:if>

            </c:forEach>

            <c:if test="${flag==true}">

                <input type="checkbox" name="authority" value="${auth.url}" checked="checked"/>${auth.displayName}
                <br><br>

            </c:if>

            <c:if test="${flag==false}">

                <input type="checkbox" name="authority" value="${auth.url}"/>${auth.displayName}<br><br>

            </c:if>

        </c:forEach>

        <input type="submit" value="update">
    </form>
</c:if>
</body>
</html>
