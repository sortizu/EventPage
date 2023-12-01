/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import DAO.UsuarioDAO;

/**
 *
 * @author sortizu
 */
public class BorrarCuentaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idUsuario = (Integer)request.getSession().getAttribute("id_user");
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        usuarioDAO.delete(idUsuario);
        response.sendRedirect("index.jsp");
    }

}
