/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.omartin.coffeeshop.data;

import be.howest.omartin.coffeeshop.model.Beverage;
import be.howest.omartin.coffeeshop.model.Topping;
import be.howest.omartin.coffeeshop.model.User;
import java.util.Map;

/**
 *
 * @author frederic
 */
public abstract class CoffeeShopDA
{
    
    public abstract Map<Integer,Beverage> getBeverages();
    public abstract Map<Integer, Topping> getToppings();
    public abstract User getUser(String login);
    
    private static CoffeeShopDA instance;
    
    public static CoffeeShopDA getInstance()
    {
        if (instance == null)
        {
            instance = new InMemoryCoffeeShopDA();
        }
        
        return instance;
    }
    
}
