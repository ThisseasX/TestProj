<%--
  Created by IntelliJ IDEA.
  User: Theseus
  Date: 15/3/2018
  Time: 2:57 πμ
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Test</title>
</head>
<body>
<c:choose>
  <c:when test="${empty list}">
    ${user.id}
    ${user.username}
    ${user.password}
  </c:when>
  <c:otherwise>
    <c:forEach var="user" items="${list}">
      ${user.id}
      ${user.username}
      ${user.password}
    </c:forEach>
  </c:otherwise>
</c:choose>
</body>
</html>
