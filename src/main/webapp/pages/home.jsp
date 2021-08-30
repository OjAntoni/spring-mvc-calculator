<%--
  Created by IntelliJ IDEA.
  User: antek
  Date: 27.08.2021
  Time: 12:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
</head>
<%@include file="_header.jsp"%>
<body>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-sm-4">
            <p class="fw-bolder">
            <h1>Hello ${sessionScope.user.username}</h1>
            </p>
        </div>
    </div>
    <div class="row justify-content-center">
        <div class="col-sm-4">
            <p class="fw-light">
                We are welcoming you at our website for those
                who aren't acquainted with simple-dimple multiplication table.
            </p>
            <p class="fst-italic">
                We hope weather you are a student, worker or
                coach potato
                this site will provide you with needed knowledge. Good luck!
            </p>
            <div class="row justify-content-center">
                <div class="col-sm-4">
                    <i class="bi bi-calculator-fill" style="width: 3em"></i>
                    <i class="bi bi-calculator-fill" style="width: 3em"></i>
                    <i class="bi bi-calculator-fill" style="width: 3em"></i>
                </div>
            </div>
        </div>


    </div>
</div>
</body>
</html>
