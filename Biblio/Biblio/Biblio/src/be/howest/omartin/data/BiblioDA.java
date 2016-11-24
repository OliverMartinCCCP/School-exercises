package be.howest.omartin.data;

import be.howest.omartin.model.Book;
import be.howest.omartin.model.Genre;
import be.howest.omartin.util.BiblioException;
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
public class BiblioDA
{

    private static final String URL = "jdbc:mysql://localhost/lesDB";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    
    private static BiblioDA instance;
    private Connection connection;
    
    private BiblioDA()
    { 
       this.registerDriver();
        this.openConnection();
    }
    
    private void registerDriver()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        }
        catch (ClassNotFoundException ex)
        {
            throw new BiblioException("Unable to load MySQL driver.", ex);
        }
    }
    
    private void openConnection()
    {
        try
        {
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }
        catch (SQLException ex)
        {
            throw new BiblioException("Unable to open connection.", ex);
        }
    }
    
    public static BiblioDA getInstance()
    {
        if (instance == null)
        {
            instance = new BiblioDA();
        }
        
        return instance;
    }
    
    public List<Book> getBooks()
    {
        try
        {
            List<Book> books = new ArrayList<>();

            String sql = "select * from book order by title";

            PreparedStatement prep = this.connection.prepareStatement(sql);
            
            ResultSet rs = prep.executeQuery();
            
            while (rs.next())
            {
                Book book = new Book(rs.getString("isbn"), rs.getString("title"), rs.getInt("genre_id"));
                books.add(book);
            }

            rs.close();
            prep.close();
            
            return books;
        }
        catch (SQLException ex)
        {
            throw new BiblioException("Unable to retrieve books.", ex);
        }
    }
    
    public List<Book> getBooks(int genreId)
    {
        try
        {
            List<Book> books = new ArrayList<>();

            String sql = "select * from book where genre_id = ? order by title";

            PreparedStatement prep = this.connection.prepareStatement(sql);
            prep.setInt(1, genreId);
            
            ResultSet rs = prep.executeQuery();
            
            while (rs.next())
            {
                Book book = new Book(rs.getString("isbn"), rs.getString("title"), rs.getInt("genre_id"));
                books.add(book);
            }

            rs.close();
            prep.close();
            
            return books;
        }
        catch (SQLException ex)
        {
            throw new BiblioException("Unable to retrieve books.", ex);
        }
    }
    
    public Book getBook(String isbn)
    {
        try
        {
            String sql = "select * from book where isbn = ?";

            PreparedStatement prep = this.connection.prepareStatement(sql);
            
            prep.setString(1, isbn);
            
            ResultSet rs = prep.executeQuery();
            
            Book book = null;
            
            if (rs.next())
            {
                book = new Book(rs.getString("isbn"), rs.getString("title"), rs.getInt("genre_id")); 
            }
            
            rs.close();
            prep.close();
            
            return book;
        }
        catch (SQLException ex)
        {
            throw new BiblioException("Unable to retrieve book.", ex);
        }
    }
    
    public void addBook(Book book)
    {
        try
        {
            String sql = "insert into book(isbn, title, genre_id) values(?, ?, ?)";
        
            PreparedStatement prep = this.connection.prepareStatement(sql);
            
            prep.setString(1, book.getIsbn());
            prep.setString(2, book.getTitle());
            prep.setInt(3, book.getGenreId());
            
            prep.executeUpdate();
            
            prep.close();
        }
        catch (SQLException ex)
        {
            throw new BiblioException("Unable to add book. Possible cause: another book with the specified ISBN already exists.", ex);
        }
    }
    
    public void deleteBook(Book book)
    {
        try
        {
            String sql = "delete from book where isbn = ?";
            
            PreparedStatement prep = this.connection.prepareStatement(sql);
            
            prep.setString(1, book.getIsbn());
            
            prep.executeUpdate();
            
            prep.close();
        }
        catch (SQLException ex)
        {
            throw new BiblioException("Unable to delete book.", ex);
        }
    }
    
    public void deleteAllBooks()
    {
        try
        {
            String sql = "delete from book";
            
            PreparedStatement prep = this.connection.prepareStatement(sql);
            
            prep.executeUpdate();
            
            prep.close();
        }
        catch (SQLException ex)
        {
            throw new BiblioException("Unable to delete all existing books.", ex);
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
                Genre genre = new Genre(rs.getInt("id"), rs.getString("name"));
                genres.add(genre);
            }
            
            rs.close();
            prep.close();

            return genres;
        }
        catch (SQLException ex)
        {
            throw new BiblioException("Unable to retrieve genres.", ex);
        }
    }

    public void addGenre(Genre genre)
    {
        try
        {
            String sql = "insert into genre(name) values(?)";

            PreparedStatement prep = this.connection.prepareStatement(sql);
            prep.setString(1, genre.getName());
            
            prep.executeUpdate();
            
            prep.close();
        }
        catch (SQLException ex)
        {
            throw new BiblioException("Unable to add genre.", ex);
        }
    }

    public void deleteGenre(Genre genre)
    {
        try
        {
            String sql = "delete from genre where id = ?";
            
            PreparedStatement prep = this.connection.prepareStatement(sql);
            
            prep.setInt(1, genre.getId());
            
            prep.executeUpdate();
            
            prep.close();
        }
        catch (SQLException ex)
        {
            throw new BiblioException("Unable to delete genre. Possible cause: there are one or more books belonging to this genre.", ex);
        }
    }
    
}