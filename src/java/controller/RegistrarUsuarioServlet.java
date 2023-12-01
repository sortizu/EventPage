/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;

import DAO.UsuarioDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;

/**
 *
 * @author sortizu
 */
public class RegistrarUsuarioServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario nuevoUsuarioAgregar = new Usuario();
        nuevoUsuarioAgregar.setNombres(request.getParameter("register-user-name"));
        nuevoUsuarioAgregar.setApellidos(request.getParameter("register-user-last-name"));
        nuevoUsuarioAgregar.setAdmin(false);
        nuevoUsuarioAgregar.setEmail(request.getParameter("register-user-email"));
        nuevoUsuarioAgregar.setPassword(request.getParameter("register-user-password"));
        nuevoUsuarioAgregar.setDni(Integer.parseInt(request.getParameter("register-user-dni")));
nuevoUsuarioAgregar.setFechaCreacion(LocalDate.now());
        usuarioDAO.add(nuevoUsuarioAgregar);
        response.sendRedirect("index.jsp");
    }

}
