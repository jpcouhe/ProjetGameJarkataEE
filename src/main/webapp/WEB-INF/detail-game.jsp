<%--
  Created by IntelliJ IDEA.
  User: soj
  Date: 01/12/2022
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="<c:url value="/css/style.css" />" rel="stylesheet" type="text/css">

</head>
<body>
<%@ include file="menu.jsp"%>

<section class="container-card">
    <h1><c:out value="${game.name}"/></h1>
    <p><c:out value="${game.description}"/></p>
</section>
</body>
</html>
