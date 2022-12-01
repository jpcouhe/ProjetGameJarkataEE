<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Jeux</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css" type="text/css">
</head>
<body>
<div class="nav">salut</div>
<%--<h1>Salut</h1>--%>
<%@ include file="WEB-INF/menu.jsp"%>

<p class="nav">

<c:forEach items="${games}" var="game">
    ${game.name}, ${game.description} <button>Supprimer</button><br />
</c:forEach>

</p>

</body>
</html>
