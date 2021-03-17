<%--
  Created by IntelliJ IDEA.
  User: 33623
  Date: 12/29/2020
  Time: 11:34 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>
        Countries
    </title>
</head>
<body>
<form method="post" action="initProcess">
    <p>
        <label for="lName">Your last name:</label><br/>
        <input type="text" name="lName" id="lName" tabindex="10" />
    </p>
    <p>
        <label for="fName">Your first name:</label><br/>
        <input type="text" name="fName" id="fName" tabindex="20" />
    </p>
    <p>
<%--        <label for="country">What countries have you visited recently ?</label><br />--%>
<%--        <select name="country" id="country" multiple="multiple" tabindex="30">--%>
<%--            <option value="France">France</option>--%>
<%--            <option value="Spain">Spain</option>--%>
<%--            <option value="Italy">Italy</option>--%>
<%--            <option value="Great-Britain">Great-Britain</option>--%>
<%--            <option value="Canada">Canada</option>--%>
<%--            <option value="United States">United States</option>--%>
<%--            <option value="China">China</option>--%>
<%--            <option value="Japan">Japan</option>--%>
<%--        </select>--%>
<%--    </p>--%>
<%--    <p>--%>
<%--        <label for="other">Enter the countries (separate them with ","):</label><br />--%>
<%--        <textarea id="other" name="other" rows="2" cols="40" tabindex="40" placeholder="Ex: Norway, Chili, New-Zeland"></textarea>--%>
<%--    </p>--%>
    <p>
        <input type="submit" value="Save" />
        <input type="reset" value="Clear" />
    </p>
</form>
</body>
</html>
