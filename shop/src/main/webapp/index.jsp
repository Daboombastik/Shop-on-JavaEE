<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1><%= "Hello World!" %>
</h1>
<br/>

<a href="<c:url value="/client"/>">Go to Client page</a>
<br/>
<a href="<c:url value="/order" />">Go to Order page</a>
<br/>
<a href="<c:url value="/formClientCountry" />">Go to Countries page</a>
<br/>
<a href="<c:url value="/vehicules" />">Go to Vehicules page</a>

<c:if test="${ !empty requestScope.uploadFile.file }">
    <p><c:out value="File ${ requestScope.uploadFile.file } (${ requestScope.uploadFile.description }) was uploaded !" /></p>
</c:if>

<form method="post" action="<c:url value="/uploadFile"/>" enctype="multipart/form-data">
    <p>
        <label for="description">File description : </label>
        <input type="text" name="description" id="description" />
    </p>
    <p>
        <label for="file">File to upload : </label>
        <input type="file" name="file" id="file" />
    </p>
    <input type="submit" />
</form>

</body>
</html>
