<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: 33623
  Date: 12/23/2020
  Time: 6:01 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8" />
    <title>Client</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/stylesheet/style.css"/>" />
</head>
<body>
<div>
    <form method="get" action="<c:url value="/createClient"/>" >
        <fieldset>
            <legend>Client info</legend>

            <label for="clientFName">First Name <span class="requested">*</span></label>
            <input type="text" id="clientFName" name="clientFName" value="" size="20" maxlength="20" />
            <br />

            <label for="clientLName">Last Name </label>
            <input type="text" id="clientLName" name="clientLName" value="" size="20" maxlength="20" />
            <br />

            <label for="clientAddress">Delivery address <span class="requested">*</span></label>
            <input type="text" id="clientAddress" name="clientAddress" value="" size="20" maxlength="20" />
            <br />

            <label for="clientPhoneNumber">Phone number <span class="requested">*</span></label>
            <input type="text" id="clientPhoneNumber" name="clientPhoneNumber" value="" size="20" maxlength="20" />
            <br />

            <label for="clientEmail">Email</label>
            <input type="email" id="clientEmail" name="clientEmail" value="" size="20" maxlength="60" />
            <br />
        </fieldset>
        <input type="submit" value="Sign up"  />
        <input type="reset" value="Clear" /> <br />
    </form>
</div>
</body>
</html>
