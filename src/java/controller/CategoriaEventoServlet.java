/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.CategoriaEventoDAO;
import debug.Console;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CategoriaEvento;

/**
 *
 * @author sortizu
 */
public class CategoriaEventoServlet extends HttpServlet {

  CategoriaEventoDAO categoriaEventoDAO = new CategoriaEventoDAO();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getParameter("form-mode")) {
            case "add":
                CategoriaEvento nuevaCategoriaEventoAgregar = new CategoriaEvento();
                nuevaCategoriaEventoAgregar.setNombreCategoria(request.getParameter("event-label-name"));
                categoriaEventoDAO.add(nuevaCategoriaEventoAgregar);
                response.sendRedirect("event_labels.jsp");
                break;
            case "edit":
                CategoriaEvento nuevaCategoriaEventoEditar = new CategoriaEvento();
                nuevaCategoriaEventoEditar.setId(Integer.parseInt(request.getParameter("id-row")));
                nuevaCategoriaEventoEditar.setNombreCategoria(request.getParameter("event-label-name"));
                categoriaEventoDAO.edit(nuevaCategoriaEventoEditar);
                response.sendRedirect("event_labels.jsp");
                break;
            case "delete":
                String[] idArray = request.getParameterValues("json[]");
                for(String id:idArray){
                    categoriaEventoDAO.delete(Integer.parseInt(id));
                }
                response.setCharacterEncoding("UTF-8"); 
response.getWriter().print("success");
                break;
            default:
                throw new AssertionError();
        }
    }

}
