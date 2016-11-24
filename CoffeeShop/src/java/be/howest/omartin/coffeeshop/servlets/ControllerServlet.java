/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.omartin.coffeeshop.servlets;

import be.howest.omartin.coffeeshop.data.CoffeeShopDA;
import be.howest.omartin.coffeeshop.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oliver
 */
@WebServlet(name = "ControllerServlet", urlPatterns = {"*.do"})
public class ControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            switch(request.getRequestURI())
            {
                case "/CoffeeShop/authenticate.do":
                    request.getRequestDispatcher("WEB-INF/login.jsp")
                            .forward(request, response);
                    break;
                case "/CoffeeShop/login.do":
                    this.doLogin(request, response);
                    break;
                case "/CoffeeShop/buy.do":
                    request.getRequestDispatcher("WEB-INF/checkout.jsp")
                            .forward(request, response);
                    break;
            }
            
        }
    }
    
    private void doLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        User user = CoffeeShopDA.getInstance().getUser(login);
        
        if(user != null && user.getPassword().equals(password)){
            //add user object to session
            request.getSession().setAttribute("user", user);
            
            //redirect to product selection screen
            request.getRequestDispatcher("WEB-INF/coffee.jsp")
                            .forward(request, response);
            
            
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
