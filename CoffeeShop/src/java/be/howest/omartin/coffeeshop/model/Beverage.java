/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.omartin.coffeeshop.model;

/**
 *
 * @author frederic
 */
public class Beverage
{
    
    private int id;
    private String description;
    private double price;
    
    public Beverage(int id, String description, double price)
    {
        this.setId(id);
        this.setDescription(description);
        this.setPrice(price);
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }
    
}
