<%--
  Created by IntelliJ IDEA.
  User: soj
  Date: 01/12/2022
  Time: 11:44
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
<section class="container">
    <form action="/games/edit?id=${game.id}" method="post">
        <label for="gameName">Name</label>
        <input type="text" id="gameName" name="gameName" value="${game.name}">

        <label for="gameDescription">Description : </label>
        <textarea id="gameDescription" name="gameDescription">${game.description}</textarea>

        <button>Add</button>
    </form>
</section>
</body>
</html>
