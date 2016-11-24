<%-- 
    Document   : Login
    Created on : Nov 17, 2016, 10:06:40 AM
    Author     : oliver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>MovieBase | Login</h1>
        
        <form action='login' method='post'>
        <p>
            Username:
            <input type='text' name='username'>
        </p>
        <p>
            Password:
            <input type='password' name='password'>
        </p>
        <p>
            <input type='submit' value='login'>
        </p>
        </form>
    </body>
</html>
