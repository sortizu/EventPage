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
import java.time.LocalDate;
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
        response.setContentType("application/json");
        switch (request.getParameter("form-mode")) {
            case "add":
                addUserRequest(request, response);
                break;
            case "edit":
                editUserRequest(request, response);
                break;
            case "delete":
                deleteUserRequest(request, response);
                break;
            default:
                PrintWriter out = response.getWriter();
                out.close();
                throw new AssertionError();
        }
    }

    private void addUserRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario nuevoUsuarioAgregar = new Usuario();
        nuevoUsuarioAgregar.setNombres(request.getParameter("user-name"));
        nuevoUsuarioAgregar.setApellidos(request.getParameter("user-last-name"));
        nuevoUsuarioAgregar.setAdmin(false);
        nuevoUsuarioAgregar.setEmail(request.getParameter("user-email"));
        nuevoUsuarioAgregar.setPassword(request.getParameter("user-password"));
        nuevoUsuarioAgregar.setDni(Integer.parseInt(request.getParameter("user-dni")));
nuevoUsuarioAgregar.setFechaCreacion(LocalDate.now());
        usuarioDAO.add(nuevoUsuarioAgregar);
        response.sendRedirect("users.jsp");
    }

    private void editUserRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario nuevoUsuarioEditar = new Usuario();
        nuevoUsuarioEditar.setIdUsuario(Integer.parseInt(request.getParameter("id-row")));
        nuevoUsuarioEditar.setNombres(request.getParameter("user-name"));
        nuevoUsuarioEditar.setApellidos(request.getParameter("user-last-name"));
        nuevoUsuarioEditar.setAdmin(false);
        nuevoUsuarioEditar.setEmail(request.getParameter("user-email"));
        nuevoUsuarioEditar.setPassword(request.getParameter("user-password"));
        nuevoUsuarioEditar.setDni(Integer.parseInt(request.getParameter("user-dni")));

        usuarioDAO.edit(nuevoUsuarioEditar);
        response.sendRedirect("users.jsp");
    }

    private void deleteUserRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idArray = request.getParameter("json[]");
        for (String id : idArray.split(",")) {
            usuarioDAO.delete(Integer.parseInt(id));
        }
        response.getWriter().print("success");
    }

}
