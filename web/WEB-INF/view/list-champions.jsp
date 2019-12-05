<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List Champions</title>
    <link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
<div id="container">

    <div id="content">





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
<div>
    <button class="add-button"
            onclick="window.location.href='AddChampion'; return false;">Add Champion</button>

    <form:form action="search" method="GET">
        <input type="search" name="searchTerm">
        <input type="submit" value="Search" class="add-button">
    </form:form>
    <table>
        <tr>
            <th>Name</th>
            <th>Class</th>
            <th>Origin</th>
            <th>Cost</th>
            <th>Health</th>
            <th>Armor</th>
            <th>Magic Resist</th>
            <th>Range</th>
            <th>Ability Name</th>
            <th>Ability Description</th>
        </tr>
        <c:forEach var="tempChamp" items="${Champions}">
            <c:url var="updateLink" value="/champions/updateChampion">
                <c:param name="champId" value="${tempChamp.champId}"/>
            </c:url>
            <c:url var="deleteLink" value="/champions/delete">
                <c:param name="champId" value="${tempChamp.champId}"/>
            </c:url>
            <tr>
                <td>${tempChamp.champName}</td>
                <td>${tempChamp.className.name}</td>
                <td>${tempChamp.origin}</td>
                <td>${tempChamp.cost}</td>
                <td>${tempChamp.health}</td>
                <td>${tempChamp.armor}</td>
                <td>${tempChamp.magicResist}</td>
                <td>${tempChamp.range}</td>
                <td>${tempChamp.abilityName}</td>
                <td>${tempChamp.abilityDesc}</td>
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
</div>
<footer><a href="mailto:eliu@my.wctc.edu">Eric Liu</a> &copy 2019</footer>
<script src="" async defer></script>
</body>
</html>
