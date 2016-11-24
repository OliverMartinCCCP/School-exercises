/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.omartin.model;

/**
 *
 * @author frederic
 */
public class Genre
{
    private int id;
    private String name;
    
    public Genre(int id, String name)
    {
        this.setId(id);
        this.setName(name);
    }

    public Genre(String name)
    {
        this(0, name);
    }
   
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    
    @Override
    public String toString()
    {
        return this.getName();
    }
    
}
