<%--
  Created by IntelliJ IDEA.
  User: 33623
  Date: 12/24/2020
  Time: 10:01 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Your order</title>
</head>
<body>
${requestScope.order.date}
<br>
${requestScope.order.total}
<br>
${requestScope.order.payMode}
<br>
${requestScope.order.payStatus}
<br>
${requestScope.order.deliveryMode}
<br>
${requestScope.order.deliveryStatus}
<br>

</body>
</html>
