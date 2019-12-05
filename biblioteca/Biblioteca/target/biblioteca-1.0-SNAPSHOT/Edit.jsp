<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 12/5/2016
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
<h2>Editare </h2>
<form action="/Edit1" method="get" >
    <table>
        <tr>
            <td>Denumirea</td>
            <td><input type="text" name="denumirea" value="${carte.denumire}"></td>
        </tr>
        <tr>
            <td>Autor</td>

            <c:forEach items="${carte.autor}" var="autor">
                <td>
                    <input type="text" name="autor" value="${autor.nume}"> <input type="hidden" name="ida" value="${autor.id}"></br>
                </td>
            </c:forEach>
        </tr>
        <tr>
            <td>Data</td>
            <td><input type="text" name="data" value="${carte.data}"></td>
        </tr>
        <tr>
            <td>Editura</td>
            <td>
                <table>
                    <tr>
                        <td></td>
                        <td><input type="hidden" name="id" value="${carte.id}"></td>
                    </tr>
                    <tr>
                        <td>Denumirea</td>
                        <td><input type="text" name="denumirea2" value="${carte.editura.nume}"></td>
                    </tr>
                    <tr>
                        <td>Director</td>
                        <td><input type="text" name="director" value="${carte.editura.director}"></td>
                    </tr>
                    <tr>
                        <td>adresa</td>
                        <td><input type="text" name="adresa" value="${carte.editura.adresa}"></td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td>locatie</td>
            <td>
                <table>
                    <tr>
                        <td>adresa</td>
                        <td><input type="text" name="adresa1" value="${carte.locatie.adresa}"></td>
                    </tr>
                    <tr>
                        <td>denumirea</td>
                        <td><input type="text" name="denumirea1" value="${carte.locatie.denumirea}"></td>
                    </tr>
                </table>
            </td>
        </tr>
    </table>
    <input type="submit" name="adauga" value="modifica">
</form>
<input type="submit" name="home" value="home" onclick="window.location.href='s'"/>
</body>
</html>
