/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.omartin.coffeeshop.data;

import be.howest.omartin.coffeeshop.model.Beverage;
import be.howest.omartin.coffeeshop.model.Topping;
import be.howest.omartin.coffeeshop.model.User;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author frederic
 */
public class InMemoryCoffeeShopDA
        extends CoffeeShopDA
{    
    
    public Map<Integer, Beverage> getBeverages()
    {
        Map<Integer, Beverage> bevs = new HashMap<>();
        
        bevs.put(1, new Beverage(1, "Espresso", 1.95));
        bevs.put(2, new Beverage(2, "Double Espresso", 2.25));
        bevs.put(3, new Beverage(3, "Hot Tea", 1.50));
        bevs.put(4, new Beverage(4, "Latte Macchiato", 2.10));
        
        return bevs;
    }
    
    public Beverage getBeverage(int id)
    {
        if (this.getBeverages().containsKey(id))
        {
            return this.getBeverages().get(id);
        }
        else
        {
            return null;
        }
    }
    
    public Map<Integer, Topping> getToppings()
    {
        Map<Integer, Topping> tops = new HashMap<>();
        
        tops.put(1, new Topping(1, "Cream", 0.50));
        tops.put(2, new Topping(2, "Chocolate sprinkles", 0.95));
        tops.put(3, new Topping(3, "Cinnamon", 0.25));
        
        return tops;
    }
    
    public Topping getTopping(int id)
    {
        if (this.getToppings().containsKey(id))
        {
            return this.getToppings().get(id);
        }
        else
        {
            return null;
        }
    }
    
    public User getUser(String login)
    {
        return new User(login, login.toUpperCase());
    }
}
