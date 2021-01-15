
<%--
  Created by IntelliJ IDEA.
  User: 33623
  Date: 12/29/2020
  Time: 11:35 AM
  To change this template use File | Settings | File Templates.
--%>
<html>
<head>
    <title>Title</title>
</head>
<body>

<tr>
    <td>
        <c:out value="${requestScope.lName}"/>
    </td>
    <td>
        <c:out value="${requestScope.fName}"/> <br>
    </td>
</tr>

<c:forEach var="country" items="${requestScope.countriesForm1}">
    <ul>
        <li>
            <c:out value="${country}"/> <br>
        </li>
    </ul>
</c:forEach>

<c:choose>
    <c:when test="${!empty requestScope.countriesForm2}">
        <c:forTokens var="country" items="${requestScope.countriesForm2}" delims=",">
            <p>
                You have visited: <c:out value="${country}"/>

            </p>
        </c:forTokens>
    </c:when>
    <c:otherwise>
        <c:out value="---------"/>
    </c:otherwise>
</c:choose>

<ul class="
pagination
">
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
</ul>

</body>
</html>
