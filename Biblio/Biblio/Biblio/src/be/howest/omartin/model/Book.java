package be.howest.omartin.model;

import java.util.Objects;

/**
 *
 * @author frederic
 */
public class Book
{
    private String isbn;
    private String title;
    private int genreId;

    public Book(String isbn, String title, int genreId)
    {
        this.setIsbn(isbn);
        this.setTitle(title);
        this.setGenreId(genreId);
    }
    
    public String getIsbn()
    {
        return isbn;
    }

    public void setIsbn(String isbn)
    {
        this.isbn = isbn;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
    
    public int getGenreId()
    {
        return this.genreId;
    }
    
    public void setGenreId(int genreId)
    {
        this.genreId = genreId;
    }
    
    @Override
    public String toString()
    {
        return this.getTitle() + " [" + this.getIsbn() + "]";
    }

}
