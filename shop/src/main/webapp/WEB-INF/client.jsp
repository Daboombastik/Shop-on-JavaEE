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
    <link type="text/css" rel="stylesheet" href="stylesheet/style.css" />
</head>
<body>
<div>
    <form method="get" action="creationClient">
        <fieldset>
            <legend>Informations client</legend>

            <label for="clientName">Nom <span class="requested">*</span></label>
            <input type="text" id="clientName" name="clientName" value="" size="20" maxlength="20" />
            <br />

            <label for="clientSurname">Prénom </label>
            <input type="text" id="clientSurname" name="clientSurname" value="" size="20" maxlength="20" />
            <br />

            <label for="clientAddress">Adresse de livraison <span class="requested">*</span></label>
            <input type="text" id="clientAddress" name="clientAddress" value="" size="20" maxlength="20" />
            <br />

            <label for="clientPhoneNumber">Numéro de téléphone <span class="requested">*</span></label>
            <input type="text" id="clientPhoneNumber" name="clientPhoneNumber" value="" size="20" maxlength="20" />
            <br />

            <label for="clientEmail">Adresse email</label>
            <input type="email" id="clientEmail" name="clientEmail" value="" size="20" maxlength="60" />
            <br />
        </fieldset>
        <input type="submit" value="Sign up"  />
        <input type="reset" value="Clear" /> <br />
    </form>
</div>
</body>
</html>
