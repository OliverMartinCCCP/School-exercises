<%-- 
    Document   : addMovie
    Created on : Nov 17, 2016, 9:18:09 AM
    Author     : oliver
--%>

<%@page import="be.howest.omartin.moviebase.data.MovieDA"%>
<%@page import="be.howest.omartin.moviebase.model.Genre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add a movie</title>
    </head>
    <body>
        <h1>MovieBase | Add a Book</h1>
        
        <h2>Please enter movie details</h2>
        <form action='addMovie' method='post'>
            <p>
                Title:
                <input type='text' name='title' required="required">
            </p>
            <p>
                Genre:
                <select name='genre' required="required">
                    <%
                        for (Genre genre : MovieDA.getInstance().getGenres()){
                            out.println("<option value='"+genre.getId()+"'>"+genre.getName()+"</option>");
                        }
                    %>
                </select>
            </p>
            <p>
                Year:
                <input type='number' name='year' required="required" value='1900'>                
            </p>
            <p>
                Stars:
                <input type='number' name='stars' required="required">
            </p>
            <p>
                <input type='submit' value='Add'>
            </p>
        </form>
            
        <p><a href='Genre.jsp'>home</a></p>
    </body>
</html>
