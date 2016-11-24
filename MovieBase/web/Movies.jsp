<%-- 
    Document   : Action
    Created on : Nov 17, 2016, 8:52:31 AM
    Author     : oliver
--%>

<%@page import="be.howest.omartin.moviebase.model.Movie"%>
<%@page import="be.howest.omartin.moviebase.data.MovieDA"%>
<%@page import="be.howest.omartin.moviebase.model.Genre"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
   int id = Integer.parseInt(request.getParameter("id"));
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movies</title>
    </head>
    <body>
        <h1>Movies</h1>
        <table>
            <tr><th>Title</th><th>Year</th><th>Stars</th>
            <% 
                for(Movie movie : MovieDA.getInstance().getMovies(id)){
                    out.println("<tr><td>"+movie.getTitle()+"</td><td>"+movie.getYear()+"</td><td>"+movie.getStars()+"</td></tr>");
                }
            %>
        </table>
        <p><a href='addMovie.jsp'>Click here to add a movie</a></p>
        <p><a href='Genre.jsp'>home</a></p>
    </body>
</html>
