<%--
  Created by IntelliJ IDEA.
  User: FiatF
  Date: 4/12/2018
  Time: 7:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Plannings</title>
</head>
<body>
    <c:forEach var="planning" items="${requestScope.plannings}">
        <c:out value="${planning}"/><br/>
    </c:forEach>
</body>
</html>
