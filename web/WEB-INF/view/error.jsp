<%--
  Created by IntelliJ IDEA.
  User: Eric
  Date: 12/4/2019
  Time: 7:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Oops! An error occurred</title>
    <link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css">
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h3>Oops! An error occurred</h3>
    </div>
</div>
<div id="container">
    <div id="content">
        <p>${errorMessage}</p>
    </div>
</div>
</body>
</html>
