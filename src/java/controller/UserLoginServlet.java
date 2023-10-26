/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.UsuarioDAO;
import debug.Console;
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
public class UserLoginServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Console.println("Se solicito iniciar sesión");
        HttpSession session = request.getSession();
        String email = request.getParameter("login-email");
        String pass = request.getParameter("login-password");
        if(new UsuarioDAO().validarUsuario(email, pass)){
            session.setAttribute("email", email);
            session.setAttribute("password", pass);

        }else{
        session.setAttribute("email", null);
        session.setAttribute("password", null);

        }
        response.sendRedirect("index.jsp");
    }


}
