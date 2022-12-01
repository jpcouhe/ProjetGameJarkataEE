<%--
  Created by IntelliJ IDEA.
  User: soj
  Date: 01/12/2022
  Time: 11:52
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

<section class="form-container">
<c:choose>
    <c:when test="${!empty game }">
            <form class="form-action"action="/games/edit?id=${game.id}" method="post">
                <label for="gameName">Name</label>
                <input class="action" type="text" id="gameNameEdit" name="gameName" value="${game.name}">

                <label for="gameDescription">Description : </label>
                <textarea id="gameDescriptionEdit" name="gameDescription">${game.description}</textarea>

                <button class="btn-edit" >Edit</button>
            </form>
    </c:when>
    <c:otherwise>
        <form class="form-action" action="/games/add" method="post">
            <label for="gameName">Name</label>
            <input class="action" type="text" id="gameName" name="gameName">
            <label for="gameDescription">Description : </label>
            <textarea id="gameDescription" name="gameDescription" ></textarea>
            <button >Add</button>
        </form>
    </c:otherwise>
    
</c:choose>
</section>


</body>
</html>
