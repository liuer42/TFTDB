<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>TFT Guide - Ashe</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../WEB-INF/resources/css/style.css" type="text/css">
</head>

<body>
<header class="header">
    <h1>
        <img src="../WEB-INF/resources/img/logo.png" width="100px">
        Teamfight Tactics Guide
    </h1>
</header>
<div class="wrapper">
    <div class="navigation">
        <div class="nav-item"><a href="../WEB-INF/view/home.html">Home</a></div>
        <div class="nav-item"><a href="../WEB-INF/view/champions.html">Champions</a></div>
        <div class="nav-item"><a href="../WEB-INF/view/classes.html">Classes/Origins</a></div>
        <div class="nav-item"><a href="../WEB-INF/view/items.html">Items</a></div>
    </div>

</div>
<center>
    <h2>Ashe, the Frost Archer</h2>
</center>
<div class="championWrapper">

    <div class="championInfo">

        <c:forEach var="tempChamp" items="${champions}">
            <c:url var="updateLink" value="/donut/showUpdateDonutForm">
                <c:param name="donutId" value="${tempDonut.id}"/>
            </c:url>
            <c:url var="deleteLink" value="/donut/delete">
                <c:param name="donutId" value="${tempDonut.id}"/>
            </c:url>
            <tr>
                <td>
                    <img src="${pageContext.request.contextPath}/resources/img/${tempDonut.imagePath}"
                         alt="${tempDonut.name}">
                </td>
                <td>${tempDonut.shop.name}</td>
                <td>${tempDonut.name}</td>
                <td>${tempDonut.calories}</td>
                <td>${tempDonut.formattedDate}</td>
                <td>
                    <a href="${updateLink}">Update</a>
                    &nbsp;|&nbsp;
                    <a href="${deleteLink}"
                       onclick="if (!confirm('Are you sure?')) return false">Delete</a>
                </td>
            </tr>
        </c:forEach>

        <p> Origin: Glacial<br>
            Class: Ranger<br><br>
            <label for="cost">Cost:</label>
            <input type="text" name="championCost" id="championCost" value="3 gold" required disabled>
            <br>
            <br>
            <label for="armor">Armor:</label>
            <input type="text" name="championArmor" id="championArmor" value="20" required disabled>
            <br>
            <br>
            <label for="cost">Magic Resist:</label>
            <input type="text" name="championMR" id="championMR" value="20" required disabled>
            <br>
            <br>
            <label for="cost">Mana:</label>
            <input type="text" name="championMana" id="championMana" value="100" required disabled>
            <br>
            <br>
            <label for="cost">Range:</label>
            <input type="text" name="championRange" id="championRange" value="4" required disabled>

        </p>
        <p> <br>Level: 1  /  2  /  3
            <br>
            <br>
            <label for="cost">Health:</label>
            <input type="text" name="championHP" id="championHP" value="550 / 990 / 1980" required disabled>
            <br>
            <br>
            <label for="cost">Damage:</label>
            <input type="text" name="championDmg" id="championDmg" value="65  / 117 / 234" required disabled>
            <br>
            <br>
            <label for="cost">Attack Speed:</label>
            <input type="text" name="championAS" id="championAS" value="0.7" required disabled>
            <br>
            <br>
            <label for="cost">DPS:</label>
            <input type="text" name="championDPS" id="championDPS" value="46  / 82  / 164" required disabled>
            <br>
            <br>
            <label for="cost">Crit Rate:</label>
            <input type="text" name="championCrit" id="championCrit" value="25%" required disabled>
        </p>
        <div class="abilityDesc">

            Ability: Enchanted Crystal Arrow<br>
            Type: Active<br>
            Mana cost: 100<br>

            Ashe fires an arrow that stuns and damages the farthest enemy. The stun duration is longer the farther away the enemy is.
        </div>
        <br>
        <input type="button" class="button" id="edit" value="Edit" style="width:100px; height:30px">
        <input type="button" class="button" id="save" value="Save" style="width:100px; height:30px" disabled>


    </div>
    <div class="championImage">
        <image src="../images/Ashe.jpg" height="50%"></image>
    </div>

</div>

<footer><a href="mailto:eliu@my.wctc.edu">Eric Liu</a> &copy 2019</footer>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="../WEB-INF/resources/js/main.js"></script>
</body>
</html>
