<%--
  Created by IntelliJ IDEA.
  User: nader
  Date: 12/11/2017
  Time: 12:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page session="true" %>
<html>
  <head>
    <title>University</title>
  </head>
  <body>
  <h1>Sample program using Http Session </h1>
  <form action="ControllerServlet" method="post">
    User name : <input type="text" name="uname"><br><br>
    Password  : <input type="password" name="pass"><br><br>
    <input type="submit" value="Login">
  </form>
  </body>
</html>
