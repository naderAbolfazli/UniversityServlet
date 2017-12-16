<%--
  Created by IntelliJ IDEA.
  User: nader
  Date: 12/12/2017
  Time: 7:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Students</title>
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
<form action="students" method="post" name="form">
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
            <td> dept :</td>
            <td><input type="text" name="dept"></td>
        </tr>
        <tr>
            <td> profID :</td>
            <td><input type="text" name="profid"></td>
        </tr>
    </table>
    <input type="submit" name="button" value="Add">
    <input type="submit" name="button" value="Load">
    <input type="submit" name="button" value="Delete">
    <input type="submit" name="button" value="Edit">

</form>
<br>
<button onclick="document.location.href='profPage.jsp'">Go To Professor page</button>

<br>
<br><form acti  on="LogoutController" method="post">
    <input type="submit" value="Logout">
</form>

</body>
</html>