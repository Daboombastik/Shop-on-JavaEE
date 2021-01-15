<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Vehicules</title>
</head>
<body>
<ul>
<c:forEach items="${requestScope.vehicules}" var="vehicule">
    <c:choose>
        <c:when test="${vehicule.type == 'moto'}">
            <li>
                <c:out value="Moto: "/>
                <c:out value="${vehicule.moteur}"/>
                <c:out value="${vehicule.puissance}"/>
                <c:out value="${vehicule.immatriculation}"/>
            </li>
        </c:when>
        <c:otherwise>
            <li>
                <c:out value="Voiture: "/>
                <c:out value="${vehicule.moteur}"/>
                <c:out value="${vehicule.puissance}"/>
                <c:out value="${vehicule.immatriculation}"/>
            </li>
        </c:otherwise>

    </c:choose>

</c:forEach>
</ul>

</body>
</html>
