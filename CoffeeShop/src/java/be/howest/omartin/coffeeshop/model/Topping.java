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
public class Topping
{
    
    private int id;
    private String name;
    private double price;
    
    public Topping(int id, String name, double price)
    {
        this.setId(id);
        this.setName(name);
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

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
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
