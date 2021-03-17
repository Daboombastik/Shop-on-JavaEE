<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <title>Inscription</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/stylesheet/form.css" />
</head>
<body>
<form method="post" action="inscription">
    <fieldset>
        <legend>Inscription</legend>
        <p>Vous pouvez vous inscrire via ce formulaire.</p>

        <label for="email">Adresse email <span class="requis">*</span></label>
        <input type="email" id="email" name="email" value="<c:out value="${param.email}"/>" size="20" maxlength="60" />
        <span class="error">${requestScope.form.errors['email']}</span>
        <br />

        <label for="motdepasse">Mot de passe <span class="requis">*</span></label>
        <input type="password" id="motdepasse" name="motdepasse" value="" size="20" maxlength="20" />
        <span class="error">${requestScope.form.errors['password']}</span>
        <br />

        <label for="confirmation">Confirmation du mot de passe <span class="requis">*</span></label>
        <input type="password" id="confirmation" name="confirmation" value="" size="20" maxlength="20" />
        <span class="error">${requestScope.form.errors['confirmation']}</span>
        <br />

        <label for="name">Nom d'utilisateur</label>
        <input type="text" id="name" name="name" value="<c:out value="${param.name}"/>" size="20" maxlength="20" />
        <span class="error">${requestScope.form.errors['name']}</span>
        <br />

        <input type="submit" value="Inscription" class="sansLabel" />
        <br />

        <p class="${empty requestScope.form.errors ? 'succes' : 'erreur'}">${requestScope.form.result}</p>
    </fieldset>
</form>
</body>
</html>