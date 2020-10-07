<%-- 
    Document   : home
    Created on : Oct 7, 2020, 11:18:32 AM
    Author     : 608787
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Home Page</h1>
        <br>
        <h3>Hello ${username}</h3>
        <form action="logout" method="get">
            <a href="login?logout" name="logout">Logout</a>
        </form>
        
    </body>
</html>
