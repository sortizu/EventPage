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
import java.io.PrintWriter;
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
        response.setContentType("application/json");
        switch (request.getParameter("form-mode")) {
            case "add":
                addEventLabelRequest(request, response);
                break;
            case "edit":
                editEventLabelRequest(request, response);
                break;
            case "delete":
                deleteEventLabelRequest(request, response);
                break;
            case "warning-delete":
                warningDeleteLabelRequest(request, response);
                break;
            case "dependency-delete":
                dependencyDeleteLabelRequest(request, response);
                break;
            default:
                throw new AssertionError();
        }
    }

    private void addEventLabelRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoriaEvento nuevaCategoriaEventoAgregar = new CategoriaEvento();
        nuevaCategoriaEventoAgregar.setNombreCategoria(request.getParameter("event-label-name"));
        categoriaEventoDAO.add(nuevaCategoriaEventoAgregar);
        response.sendRedirect("event_labels.jsp");
    }

    private void editEventLabelRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CategoriaEvento nuevaCategoriaEventoEditar = new CategoriaEvento();
        nuevaCategoriaEventoEditar.setIdCategoriaEvento(Integer.parseInt(request.getParameter("id-row")));
        nuevaCategoriaEventoEditar.setNombreCategoria(request.getParameter("event-label-name"));
        categoriaEventoDAO.edit(nuevaCategoriaEventoEditar);
        response.sendRedirect("event_labels.jsp");
    }

    private void deleteEventLabelRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idArrayDelete = request.getParameter("json[]");
        for (String id : idArrayDelete.split(",")) {
            categoriaEventoDAO.delete(Integer.parseInt(id));
        }
        response.setCharacterEncoding("UTF-8");
        response.getWriter().print("success");
    }

    private void warningDeleteLabelRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idArrayEvaluateDelete = request.getParameter("json[]");
        boolean dependencyFound = false;
        for (String id : idArrayEvaluateDelete.split(",")) {
            if(!categoriaEventoDAO.getDependentEventsId(Integer.parseInt(id)).isEmpty()){
            dependencyFound=true;
            break;
            }
        }

        if (dependencyFound) {
            PrintWriter out = response.getWriter();
            out.println("trigger");
            out.close();
        }
    }

    private void dependencyDeleteLabelRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String idArrayDeleteDependency = request.getParameter("json[]");
        for (String id : idArrayDeleteDependency.split(",")) {
            categoriaEventoDAO.delete(Integer.parseInt(id), true);
        }

        response.getWriter().print("success");
    }
}
