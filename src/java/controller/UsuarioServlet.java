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
import model.Usuario;

/**
 *
 * @author sortizu
 */
public class UsuarioServlet extends HttpServlet {

    UsuarioDAO usuarioDAO = new UsuarioDAO();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getParameter("form-mode")) {
            case "add":
                Usuario nuevoUsuarioAgregar = new Usuario();
                nuevoUsuarioAgregar.setNombres(request.getParameter("user-name"));
                nuevoUsuarioAgregar.setApellidos(request.getParameter("user-last-name"));
                nuevoUsuarioAgregar.setAdmin(false);
                nuevoUsuarioAgregar.setEmail(request.getParameter("user-email"));
                nuevoUsuarioAgregar.setPassword(request.getParameter("user-password"));
                nuevoUsuarioAgregar.setDni(Integer.parseInt(request.getParameter("user-dni")));
                
                usuarioDAO.add(nuevoUsuarioAgregar);
                response.sendRedirect("users.jsp");
                break;
            case "edit":
                Usuario nuevoUsuarioEditar = new Usuario();
                nuevoUsuarioEditar.setId(Integer.parseInt(request.getParameter("id-row")));
                nuevoUsuarioEditar.setNombres(request.getParameter("user-name"));
                nuevoUsuarioEditar.setApellidos(request.getParameter("user-last-name"));
                nuevoUsuarioEditar.setAdmin(false);
                nuevoUsuarioEditar.setEmail(request.getParameter("user-email"));
                nuevoUsuarioEditar.setPassword(request.getParameter("user-password"));
                nuevoUsuarioEditar.setDni(Integer.parseInt(request.getParameter("user-dni")));
                
                usuarioDAO.edit(nuevoUsuarioEditar);
                response.sendRedirect("users.jsp");
                break;
            case "delete":
                String[] idArray = request.getParameterValues("json[]");
                for(String id:idArray){
                    usuarioDAO.delete(Integer.parseInt(id));
                }
                response.setCharacterEncoding("UTF-8"); 
response.getWriter().print("success");
                break;
            default:
                throw new AssertionError();
        }
    }
}
