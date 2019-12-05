<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 12/2/2016
  Time: 11:50 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Cartile disponibile din Biblioteca</h2>
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
            <td><input type="submit" name="carte"  id=${carte.descriere.descriere} onclick=alert(this.id) value="descriere"/></td>
        </tr>
        </c:forEach>
    </table>
    <br>
    <h2>Articole disponibile</h2>
    <table border="1">
        <tr>
            <td> Denumirea</td>
            <td>Autori</td>
            <td>Date publicarii</td>
            <td>Revista</td>
            <td>Locatia</td>
            <td>Descriere</td>
        </tr>
        <c:forEach items="${articol}" var="articol">
            <tr>
                <td>${articol.denumire}</td>
                <td>
                    <c:forEach items="${articol.autor}" var="autor">
                        ${autor.nume}</br>
                    </c:forEach>
                </td>
                <td>${articol.data}</td>
                <td>${articol.revista}</td>
                <td>${articol.locatie.adresa} ${articol.locatie.denumirea}</td>
                <td><input type="submit" name="articol"  id=${articol.descriere.descriere} onclick=alert(id)  value="descriere"/></td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
