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

<ul>
    <li>
        <c:out value="${requestScope.order.date}"/>
    </li>
    <li>
        <c:out value="${requestScope.order.total}"/>
    </li>
    <li>
        <c:out value="${requestScope.order.payMode}"/>
    </li>
    <li>
        <c:out value="${requestScope.order.payStatus}"/>
    </li>
    <li>
        <c:out value="${requestScope.order.deliveryMode}"/>
    </li>
    <li>
        <c:out value="${requestScope.order.payStatus}"/>
    </li>
    <li>
        <c:out value="${requestScope.order.deliveryStatus}"/>
    </li>
</ul>
</body>
</html>
