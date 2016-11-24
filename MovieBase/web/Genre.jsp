<%-- 
    Document   : Genre
    Created on : Nov 17, 2016, 8:36:29 AM
    Author     : oliver
--%>

<%@page import="be.howest.omartin.moviebase.model.Genre"%>
<%@page import="be.howest.omartin.moviebase.data.MovieDA"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Genre</title>
    </head>
    <body>
        
        <ul>
            <% 
                for(Genre genre : MovieDA.getInstance().getGenres()){
                    out.println("<li><a href='Movies.jsp?id="+genre.getId()+"'>"+genre.getName()+"</a></li>");
                }
            %>
        </ul>
    </body>
</html>
