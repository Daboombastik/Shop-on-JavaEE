<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 33623
  Date: 12/23/2020
  Time: 9:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Your info</title>
</head>
<body>

<%@ include file="formClientSimple.jsp" %>
<ul>
    <li>
        <c:out value="${requestScope.client.name}"/>
    </li>
    <li>
        <c:out value="${requestScope.client.address}"/>
    </li>
    <li>
        <c:out value="${requestScope.client.phone}"/>
    </li>
    <li>
        <c:out value="${requestScope.client.email}"/>
    </li>

</ul>
</body>
</html>
