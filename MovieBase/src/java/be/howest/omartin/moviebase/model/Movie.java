/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.omartin.moviebase.model;

/**
 *
 * @author frederic
 */
public class Movie
{
    
    private int id;
    private String title;
    private int genreId;
    private int year;
    private int stars;

    public Movie(String title, int genreId, int year, int stars)
    {
        this.setTitle(title);
        this.setGenreId(genreId);
        this.setYear(year);
        this.setStars(stars);
    }
    
    public Movie(int id, String title, int genreId, int year, int stars)
    {
        this.setId(id);
        this.setTitle(title);
        this.setGenreId(genreId);
        this.setYear(year);
        this.setStars(stars);
    }
    
    public int getId()
    {
        return id;
    }
    
    public void setId(int id)
    {
        this.id = id;
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
        return genreId;
    }

    public void setGenreId(int genreId)
    {
        this.genreId = genreId;
    }
    
    public int getYear()
    {
        return year;
    }
    
    public void setYear(int year)
    {
        this.year = year;
    }
    
    public int getStars()
    {
        return stars;
    }
    
    public void setStars(int stars)
    {
        this.stars = stars;
    }
    
}
