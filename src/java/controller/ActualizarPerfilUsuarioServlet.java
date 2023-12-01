/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;

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
public class ActualizarPerfilUsuarioServlet extends HttpServlet {
    
    UsuarioDAO usuarioDAO = new UsuarioDAO();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("user-name");
        String apellidos = request.getParameter("user-last-name");
        String dni = request.getParameter("user-dni");
        String email = request.getParameter("user-email");
        String password = request.getParameter("user-password");
        int idUsuario = (Integer)request.getSession().getAttribute("id_user");
        Usuario usuario = new Usuario();
        usuario.setIdUsuario(idUsuario);
        usuario.setNombres(nombre);
        usuario.setApellidos(apellidos);
        usuario.setDni(Integer.parseInt(dni));
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuarioDAO.edit(usuario);
        response.sendRedirect("index.jsp");
    }

}
