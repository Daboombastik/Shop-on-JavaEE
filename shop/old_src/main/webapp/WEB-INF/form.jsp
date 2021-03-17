<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sshch
  Date: 1/15/2021
  Time: 2:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:if test ="${ !empty param.name}">
    <c:out value="Hello ${param.name}"/>
</c:if>
<br>
<%--<c:if test="${ !empty requestScope.cookie }">--%>
<%--    <c:out value="${requestScope.cookie}"/>--%>
<%--</c:if>--%>

<form action="${pageContext.request.contextPath}/servletTest" method="post">

    <label for="name">
        <input type="text" id="name" name="name" value="${ empty requestScope.cookieID ? "no cookie" : requestScope.cookieID}" tabindex="20" style="alignment: center; position: relative;"/>
    </label>

    <br>
    <input type="submit" value="Get My Cookie!" style="alignment: center; display: inline-block; padding: 0 1rem;"/>
</form>

</body>
</html>
