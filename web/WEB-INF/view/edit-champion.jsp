<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %><%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a Champion</title>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <h2>Edit Champion</h2>
    </div>
</div>

<form:form action="saveChampion" modelAttribute="aChampion" enctype="multipart/form-data">
    <form:hidden path="champId" value="${aChampion.champId}"/>
    <table>


        <tr>
            <td><label>Name</label></td>
            <td><form:input path="champName" itemValue="${aChampion.champName}"/>
                <form:errors path="champName" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label>Class</label></td>
            <td><form:select items="${classes}" path="className"
                             itemLabel="name" itemValue="classId">
            </form:select></td>
        </tr>
        <tr>
            <td><label>Origin</label></td>
            <td><form:input path="origin" itemValue="${aChampion.origin}"/>
                <form:errors path="origin" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label>Cost</label></td>
            <td><form:input path="cost" itemValue="${aChampion.cost}"/>
                <form:errors path="cost" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label>Health</label></td>
            <td><form:input path="health" itemValue="${aChampion.health}"/>
                <form:errors path="health" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label>Armor</label></td>
            <td><form:input path="armor" itemValue="${aChampion.armor}"/>
                <form:errors path="armor" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label>Magic Resist</label></td>
            <td><form:input path="magicResist" itemValue="${aChampion.magicResist}"/>
                <form:errors path="magicResist" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label>Range</label></td>
            <td><form:input path="range" itemValue="${aChampion.range}"/>
                <form:errors path="range" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label>Ability Name</label></td>
            <td><form:input path="abilityName" itemValue="${aChampion.abilityName}"/>
                <form:errors path="abilityName" cssClass="error"/></td>
        </tr>
        <tr>
            <td><label>Ability Description</label></td>
            <td><form:input path="abilityDesc" itemValue="${aChampion.abilityDesc}"/>
                <form:errors path="abilityDesc" cssClass="error"/></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="submit" value="Save" class="save"></td>
        </tr>
    </table>
</form:form>
</body>
</html>
