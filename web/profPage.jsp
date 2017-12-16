<%--
  Created by IntelliJ IDEA.
  User: nader
  Date: 12/12/2017
  Time: 9:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<html>
<head>
    <title>Professors</title>
</head>
<body>
<%
    if (session != null) {
        if (session.getAttribute("user") != null) {
            String name = (String) session.getAttribute("user");
            out.print("Hello, " + name + "  Welcome to ur Profile");
        } else {
            response.sendRedirect("index.jsp");
        }
    } else
        response.sendRedirect("index.jsp");
%>
<br>
<br>
<form action="professors" method="post" name="form">
    <table>
        <tr>
            <td> id :</td>
            <td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td> name :</td>
            <td><input type="text" name="name"></td>
        </tr>
        <tr>
            <td> address :</td>
            <td><input type="text" name="address"></td>
        </tr>
    </table>
    <input type="submit" name="button" value="Add">
    <input type="submit" name="button" value="Load">
    <input type="submit" name="button" value="Delete">
    <input type="submit" name="button" value="Edit">
</form>
<br>
<button onclick="document.location.href='studentPage.jsp'">Go To Student page</button>

<br> 
<br><form action="LogoutController" method="post">
    <input type="submit" value="Logout">
</form>

</body>
</html>
