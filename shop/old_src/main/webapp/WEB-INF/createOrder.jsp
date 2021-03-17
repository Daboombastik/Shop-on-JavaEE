<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 33623
  Date: 12/24/2020
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Your order</title>
</head>
<body>
<%@include file="formOrder.jsp"%>

<div id="corps">
    <p class="info">${ requestScope.form.result }</p>
    <p>Nom : <c:out value="${ requestScope.client.surname }"/></p>
    <p>Prénom : <c:out value="${ requestScope.client.name }"/></p>
    <p>Adresse : <c:out value="${ requestScope.client.address }"/></p>
    <p>Numéro de téléphone : <c:out value="${ requestScope.client.phone}"/></p>
    <p>Email : <c:out value="${ requestScope.client.email }"/></p>
</div>

</body>
</html>
