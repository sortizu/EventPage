/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author sortizu
 */
public class AdminLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = request.getParameter("email");
        String pass = request.getParameter("password");
        int id=new UsuarioDAO().validarAdmin(email, pass);
        if(id>=0){
            session.setAttribute("email", email);
            session.setAttribute("password", pass);
            session.setAttribute("id_user", id);
        }else{
        session.setAttribute("email", null);
        session.setAttribute("password", null);
        session.setAttribute("id_user", null);
        }
        response.sendRedirect("dashboard.jsp");
    }

}
