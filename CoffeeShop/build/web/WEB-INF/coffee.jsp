<%-- 
    Document   : products
    Created on : Nov 22, 2016, 11:43:11 AM
    Author     : oliver
--%>

<%@page import="be.howest.omartin.coffeeshop.model.Topping"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="be.howest.omartin.coffeeshop.data.CoffeeShopDA"%>
<%@page import="be.howest.omartin.coffeeshop.model.Beverage"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CoffeeShop</title>
    </head>
    <body>
        <h1>Welcome to the coffeeshop!</h1>
        <form method='post' action='buy.do'>
            <p>
                <b>Beverages</b>:
                </br>
                <select name='beverage'>
                    <% 
                        Map beverages = CoffeeShopDA.getInstance().getBeverages();
                        for(Object beverage: beverages.values()){
                            Beverage b = (Beverage) beverage;
                            out.println("<option value='"+ b.getDescription()+"'>" + b.getDescription() + "</option>");
                        }
                    %>
                </select>
            </p>
            </br>
            <p>
                <b>Toppings</b>:
                <br>
                 <%
                    Map toppings = CoffeeShopDA.getInstance().getToppings();
                    for ( Object topping : toppings.values() ){
                        Topping t = (Topping) topping;
                        out.print("<input type='checkbox' name='topping"+ t.getId() +"' value='"+ t.getName() +"'>" + t.getName() +"</br>");
                    }
                %>
            </p>
            <br/>
            <input type="submit" value="GO!"></input>
        </form>
    </body>
</html>
