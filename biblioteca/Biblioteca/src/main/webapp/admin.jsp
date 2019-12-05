<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 12/2/2016
  Time: 1:29 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>admin</title>
</head>
<body>
<h2>Panela admin</h2>

<table border="1">
    <tr>
        <td> Denumirea</td>
        <td>Autori</td>
        <td>Date publicarii</td>
        <td>Editura</td>
        <td>Locatia</td>
        <td>Descriere</td>
    </tr>
    <c:forEach items="${carte}" var="carte">
        <tr>
            <td>${carte.denumire}</td>
            <td>
                <c:forEach items="${carte.autor}" var="autor">
                    ${autor.nume}</br>
                </c:forEach>
            </td>
            <td>${carte.data}</td>
            <td>${carte.editura.nume}</br> director ${carte.editura.director} </br> adresa ${carte.editura.adresa}</td>
            <td>${carte.locatie.adresa} ${carte.locatie.denumirea}</td>
            <td><input type="submit" name="delete" value="delete" id="${carte.id}" onclick=window.location.href="Delete?id="+id; />
                <input type="submit" name="update" value="update" id="${carte.id}" onclick=window.location.href="Edit?id="+id; />
            </td>
        </tr>
    </c:forEach>
</table>
<form>
    <input type="submit" name="addCarte" value="addCarte"/>
</form>
</body>
</html>
