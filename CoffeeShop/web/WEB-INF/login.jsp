<%-- 
    Document   : login
    Created on : Nov 22, 2016, 11:00:43 AM
    Author     : oliver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CoffeeShop</title>
    </head>
    <body>
        <h1>Login</h1>
        <form method='post' action='login.do'>
            <p>
                Login:
                <input type='text' name='login'>
            </p>
            <p>
                Password:
                <input type='password' name='password'>
            </p>
            <p>
                <input type='submit' value='Login.now'>
            </p>
        </form>
    </body>
</html>
