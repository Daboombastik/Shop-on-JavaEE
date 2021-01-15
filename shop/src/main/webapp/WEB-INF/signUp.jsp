<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Inscription</title>
    <link type="text/css" rel="stylesheet" href="<c:url value="/stylesheet/form.css"/>" />
</head>
<body>
<form method="post" action="authenticate">
    <fieldset>
        <legend>Sign up</legend>
        <p>Sign up</p>

        <label for="email">Email <span class="required">*</span></label>
        <input type="email" id="email" name="email" value="" size="20" maxlength="60" />
        <br />

        <label for="password">Password <span class="required">*</span></label>
        <input type="password" id="password" name="password" value="" size="20" maxlength="20" />
        <br />

        <label for="confirmation">Confirmation <span class="required">*</span></label>
        <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
        <br />

        <label for="name">User name</label>
        <input type="text" id="name" name="name" value="" size="20" maxlength="20" />
        <br />

        <input type="submit" value="Sign up" class="sansLabel" />
        <br />
    </fieldset>
</form>
</body>
</html>
