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
public class AdminServlet extends HttpServlet {

    UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        switch (request.getParameter("form-mode")) {
            case "add":
                addAdminRequest(request, response);
                break;
            case "edit":
                editAdminRequest(request, response);
                break;
            case "delete":
                deleteAdminRequest(request, response);
                break;
            default:
                PrintWriter out = response.getWriter();
                out.close();
                throw new AssertionError();
        }
    }

    private void addAdminRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario nuevoUsuarioAgregar = new Usuario();
        nuevoUsuarioAgregar.setNombres(request.getParameter("admin-name"));
        nuevoUsuarioAgregar.setApellidos(request.getParameter("admin-last-name"));
        nuevoUsuarioAgregar.setAdmin(true);
        nuevoUsuarioAgregar.setEmail(request.getParameter("admin-email"));
        nuevoUsuarioAgregar.setPassword(request.getParameter("admin-password"));
        nuevoUsuarioAgregar.setDni(Integer.parseInt(request.getParameter("admin-dni")));

        usuarioDAO.add(nuevoUsuarioAgregar);
        response.sendRedirect("admins.jsp");
    }

    private void editAdminRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Usuario nuevoUsuarioEditar = new Usuario();
        nuevoUsuarioEditar.setIdUsuario(Integer.parseInt(request.getParameter("id-row")));
        nuevoUsuarioEditar.setNombres(request.getParameter("admin-name"));
        nuevoUsuarioEditar.setApellidos(request.getParameter("admin-last-name"));
        nuevoUsuarioEditar.setAdmin(true);
        nuevoUsuarioEditar.setEmail(request.getParameter("admin-email"));
        nuevoUsuarioEditar.setPassword(request.getParameter("admin-password"));
        nuevoUsuarioEditar.setDni(Integer.parseInt(request.getParameter("admin-dni")));

        usuarioDAO.edit(nuevoUsuarioEditar);
        response.sendRedirect("admins.jsp");
    }

    private void deleteAdminRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idList = request.getParameterValues("json[]")[0];
        for (String id : idList.split(",")) {
            usuarioDAO.delete(Integer.parseInt(id));
        }
        response.getWriter().print("success");
    }

}
