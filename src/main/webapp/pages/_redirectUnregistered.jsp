<%--
  Created by IntelliJ IDEA.
  User: antek
  Date: 27.08.2021
  Time: 16:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title></title>
</head>
<body>
    <c:if test="${sessionScope.user==null}">
        <c:redirect url="/user/auth"/>
    </c:if>
</body>
</html>
