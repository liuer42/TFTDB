<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 12/4/2019
  Time: 7:19 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>TFT Classes</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>

<header class="header">
    <h1>
        <img src="../resources/img/logo.png" width="100px">
        Teamfight Tactics Guide
    </h1>
</header>

<div class="wrapper">
        <div class="navigation">
            <div class="nav-item"><a href="${pageContext.request.contextPath}/">Home</a></div>
            <div class="nav-item"><a href="${pageContext.request.contextPath}/champions/list">Champions</a></div>
            <div class="nav-item"><a href="${pageContext.request.contextPath}/classes/list">Classes</a></div>
        </div>
</div>
<body>
<div id="container">

    <div id="content" style="text-align: center;">
<table>
    <tr>
        <th>Name</th>
        <th>Description</th>
    </tr>
    <c:forEach var="tempClass" items="${Classes}">
        <c:url var="updateLink" value="/champions/updateChampion">
            <c:param name="classId" value="${tempClass.classId}"/>
        </c:url>
        <c:url var="deleteLink" value="/champions/delete">
            <c:param name="classId" value="${tempChamp.champId}"/>
        </c:url>
        <tr>
            <td>${tempClass.name}</td>
            <td>${tempClass.description}</td>
            <td>
                <a href="${updateLink}">Update</a>
                &nbsp;|&nbsp;
                <a href="${deleteLink}"
                   onclick="if (!confirm('Are you sure?')) return false">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
    </div>
</div>
</body>
</html>
