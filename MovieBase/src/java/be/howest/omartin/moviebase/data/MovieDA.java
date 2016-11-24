/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.omartin.moviebase.data;

import be.howest.omartin.moviebase.model.Genre;
import be.howest.omartin.moviebase.model.Movie;
import be.howest.omartin.moviebase.util.MovieException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author frederic
 */
public class MovieDA
{
    
    private static MovieDA instance;
    
    private static final String URL = "jdbc:mysql://localhost/moviebase";
    private static final String UID = "root";
    private static final String PWD = "";
    
    private Connection connection;
    
    public static MovieDA getInstance()
    {
        if (instance == null)
        {
            instance = new MovieDA();
        }
        
        return instance;
    }
    
    private MovieDA()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, UID, PWD);
        }
        catch (ClassNotFoundException ex)
        {
            throw new MovieException("Unable to load database driver.", ex);
        }
        catch (SQLException ex)
        {
            throw new MovieException("Unable to connect to database.", ex);
        }
    }
    
    public List<Genre> getGenres()
    {
        try
        {
            List<Genre> genres = new ArrayList<>();

            String sql = "select * from genre order by name";

            PreparedStatement prep = this.connection.prepareStatement(sql);

            ResultSet rs = prep.executeQuery();

            while (rs.next())
            {
                Genre g = new Genre(rs.getInt("id"), rs.getString("name"));
                genres.add(g);
            }
            
            rs.close();
            prep.close();

            return genres;
        }
        catch (SQLException ex)
        {
            throw new MovieException("Unable to retrieve genres.", ex);
        }
    }
    
    public Genre getGenre(int id)
    {
        try
        {
            String sql = "select * from genre where id = ?";

            PreparedStatement prep = this.connection.prepareStatement(sql);
            prep.setInt(1, id);

            ResultSet rs = prep.executeQuery();

            Genre genre = null;

            if (rs.next())
            {
                 genre = new Genre(rs.getInt("id"), rs.getString("name"));
            }

            rs.close();
            prep.close();

            return genre;
        }
        catch (SQLException ex)
        {
            throw new MovieException("Unable to retrieve genre.", ex);
        }
    }
    
    public List<Movie> getMovies(int genreId)
    {
        try
        {
            List<Movie> movies = new ArrayList<>();
            
            String sql = "select * from movie where genre_id = ? order by title";
            
            PreparedStatement prep = this.connection.prepareStatement(sql);
            prep.setInt(1, genreId);
            
            ResultSet rs = prep.executeQuery();
            
            while (rs.next())
            {
                Movie movie = new Movie(rs.getInt("id"), rs.getString("title"), rs.getInt("genre_id"),
                        rs.getInt("year"), rs.getInt("stars"));
                
                movies.add(movie);
            }
            
            rs.close();
            prep.close();
            
            return movies;
        }
        catch (SQLException ex)
        {
            throw new MovieException("Unable to retrieve movies in genre.", ex);
        }
        
    }
    
    public void addMovie(Movie movie)
    {
        try
        {
            String sql = "insert into movie(title, genre_id, year, stars) values(?, ?, ?, ?)";

            PreparedStatement prep = this.connection.prepareStatement(sql);
            prep.setString(1, movie.getTitle());
            prep.setInt(2, movie.getGenreId());
            prep.setInt(3, movie.getYear());
            prep.setInt(4, movie.getStars());

            prep.executeUpdate();
            
            prep.close();
        }
        catch (SQLException ex)
        {
            throw new MovieException("Unable to add movie.", ex);
        }
    }
    
}
