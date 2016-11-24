<%-- 
    Document   : checkout
    Created on : Nov 22, 2016, 12:44:52 PM
    Author     : oliver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CoffeeShop</title>
    </head>
    <body>
        <h1>Checkout</h1>
        <p>
            <b>Bought beverage</b>:
            <%
            out.println(request.getParameter("beverage"));
            %>
        </p>
        <p>
            <b>Selected toppings</b>:
            </br>
            <%
            for(int i=1; i<4; i++){
                if (request.getParameter("topping"+i) != null){
                    out.println(request.getParameter("topping"+i)+"</br>");
                }
            }
            %>
        </p>
            
    </body>
</html>
