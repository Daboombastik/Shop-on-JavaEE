<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<c:forEach var="item" items="${requestScope.list}" >
    <c:out value="${item}" />
</c:forEach>


<br>
${requestScope.client.name}
<br>
${requestScope.client.surname}
<br>
${requestScope.client.address}
<br>
${requestScope.client.phone}
<br>
${requestScope.client.email}

</body>
</html>
