<%--
  Created by IntelliJ IDEA.
  User: student
  Date: 12/2/2016
  Time: 2:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>AddCarte</title>
</head>
<body>
<h2>Adaugarea unei carti noi</h2>
<form>
    <table>
        <tr>
            <td>Denumirea</td>
            <td><input type="text" name="denumirea" value=""></td>
        </tr>
        <tr>
            <td>Autor</td>
            <td><input type="text" name="autor" value=""></td>
        </tr>
        <tr>
            <td>Data</td>
            <td><input type="text" name="data" value=""></td>
        </tr>
        <tr>
        <td>Editura</td>
        <td>
            <table>
                <tr>
                    <td>Denumirea</td>
                    <td><input type="text" name="denumirea2" value=""></td>
                </tr>
                <tr>
                    <td>Director</td>
                    <td><input type="text" name="director" value=""></td>
                </tr>
                <tr>
                    <td>adresa</td>
                    <td><input type="text" name="adresa" value=""></td>
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
                        <td><input type="text" name="adresa1" value=""></td>
                    </tr>
                    <tr>
                        <td>denumirea</td>
                        <td><input type="text" name="denumirea1" value=""></td>
                    </tr>
                </table>
            </td>
        </tr>
        <tr>
            <td>Cuvint Cheie</td>
            <td><input type="text" name="cuvint" value=""></td>
        </tr>
    </table>
    <input type="submit" name="adauga" value="adauga">
</form>
</body>
</html>
