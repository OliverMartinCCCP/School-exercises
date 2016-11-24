/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package be.howest.model;

import be.howest.data.PartimsDA;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author oliver
 */
@WebServlet(name = "DoLogin", urlPatterns = {"/DoLogin"})
public class DoLogin extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
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
        response.setContentType("text/html; charset=UTF-8");
        
        String un = request.getParameter("username");
        String pw = request.getParameter("password");
        
        Boolean isUserNameFound = false;
        Boolean isPasswordFound = false;

        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DoLogin</title>");            
            out.println("</head>");
            out.println("<body>");
            
            if ((PartimsDA.DB.getStudent(un) != null) && (PartimsDA.DB.getStudent(un).getPassword().equals(pw))){
                Student st = PartimsDA.DB.getStudent(un);
                request.getSession().setAttribute("student", st);
                
                out.println("<h1>" + PartimsDA.DB.getStudent(un).getName() + "</h1>");
                out.println("<h1>" + PartimsDA.DB.getStudent(un).getPassword() + "</h1>");
            }
            else{
                response.sendRedirect("login.html");
            }

            out.println("</body>");
            out.println("</html>");
        }
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
