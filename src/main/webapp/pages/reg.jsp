<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: antek
  Date: 26.08.2021
  Time: 21:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<%@include file="_header.jsp"%>
<%@include file="_redirectAuthorized.jsp"%>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-3">
            <form action="${pageContext.request.contextPath}/user/reg" method="post">
                <div class="mb-3">
                    <label for="exampleInputEmail0" class="form-label" >Name</label>
                    <input type="text" class="form-control" name="name" id="exampleInputEmail0" required>
                </div>
                <div class="mb-3">
                    <label for="exampleInputEmail1" class="form-label" >Username</label>
                    <input type="text" class="form-control" name="username" id="exampleInputEmail1" required>
                </div>
                <div class="mb-3">
                    <label for="exampleInputPassword1" class="form-label">Password</label>
                    <input type="password" class="form-control" name="password" id="exampleInputPassword1" required>
                </div>
                <button type="submit" class="btn btn-primary">Submit</button>
            </form>
            Already have an account?<a href="<c:url value = "/user/auth"/>" style="text-decoration: none">Log in</a>
            <c:if test="${valid==false}">
                <div class="alert alert-danger" role="alert">
                    Invalid username or password, try again.
                </div>
            </c:if>
        </div>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>
