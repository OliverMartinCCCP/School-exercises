<%-- 
    Document   : add
    Created on : Oct 25, 2016, 12:58:16 PM
    Author     : oliver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>add</title>
    </head>
    <body>
        <h1>What genre do you want to add?</h1>
        <form action="genres" method="GET">
            <label for="genre">Genre: </label>
            <input type="text" name="genre" id="genre" required="required">
            <input type="submit" id="addGenre" value="add genre">
        </form>
        <button type="button" onclick="location.href='genres'">Back</button>
    </body>
</html>
