<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 8/28/2019
  Time: 8:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <meta charset="utf-8">
    <title>TFT Guide by Eric L</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="../resources/css/style.css" type="text/css">
  </head>
  <body>
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
    <div class="indexLayout">

      Teamfight Tactics is a round-based strategy game made by Riot Games that pits you against seven opponents where you build teams to fight on your behalf. The goal in mind is to be the last one standing. This website was made to cover some information about the champions, items, and compositions found in the game.
      <div class="tft">
        <img src="../resources/img/tft.jpg" width="155%">
      </div>
    </div>
    <footer><a href="mailto:eliu@my.wctc.edu">Eric Liu</a> &copy 2019</footer>
    <script src="" async defer></script>
  </body>
</html>
