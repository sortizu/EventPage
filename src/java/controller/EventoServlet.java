/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.CategoriaEventoDAO;
import DAO.EventoDAO;
import DAO.InvitadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import debug.Console;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.CategoriaEvento;
import model.Evento;
import model.Invitado;
/**
 *
 * @author sortizu
 */
public class EventoServlet extends HttpServlet {

    EventoDAO eventoDAO = new EventoDAO();
    CategoriaEventoDAO categoriaEventoDAO = new CategoriaEventoDAO();
    InvitadoDAO invitadoDAO = new InvitadoDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getParameter("form-mode")) {
            case "add":
                Evento nuevoEventoAgregar = new Evento();
                nuevoEventoAgregar.setNombreEvento(request.getParameter("event-name"));
                nuevoEventoAgregar.setCosto(Double.parseDouble(request.getParameter("event-price")));
                nuevoEventoAgregar.setFecha(LocalDateTime.parse(request.getParameter("event-date"), DateTimeFormatter.ISO_DATE_TIME));
                nuevoEventoAgregar.setCapacidad(Integer.parseInt(request.getParameter("event-capacity")));
                nuevoEventoAgregar.setCategoria(
                        (CategoriaEvento)categoriaEventoDAO.list(Integer.parseInt(request.getParameter("event-label")))
                );
                nuevoEventoAgregar.setDescripcion(request.getParameter("event-description"));
                nuevoEventoAgregar.setInvitado(
                        (Invitado)invitadoDAO.list(Integer.parseInt(request.getParameter("event-guest")))
                );
                eventoDAO.add(nuevoEventoAgregar);
                response.sendRedirect("event.jsp");
                break;
            case "edit":
                Evento nuevoEventoEditar = new Evento();
                nuevoEventoEditar.setId(Integer.parseInt(request.getParameter("id-row")));
                nuevoEventoEditar.setNombreEvento(request.getParameter("event-name"));
                nuevoEventoEditar.setCosto(Double.parseDouble(request.getParameter("event-price")));
                nuevoEventoEditar.setFecha(LocalDateTime.parse(request.getParameter("event-date"), DateTimeFormatter.ISO_DATE_TIME));
                nuevoEventoEditar.setCapacidad(Integer.parseInt(request.getParameter("event-capacity")));
                nuevoEventoEditar.setCategoria(
                        (CategoriaEvento)categoriaEventoDAO.list(Integer.parseInt(request.getParameter("event-label")))
                );
                nuevoEventoEditar.setDescripcion(request.getParameter("event-description"));
                nuevoEventoEditar.setInvitado(
                        (Invitado)invitadoDAO.list(Integer.parseInt(request.getParameter("event-guest")))
                );
                eventoDAO.edit(nuevoEventoEditar);
                response.sendRedirect("event.jsp");
                break;
            case "delete":
                String[] idArray = request.getParameterValues("json[]");
                for(String id:idArray){
                    eventoDAO.delete(Integer.parseInt(id));
                }
                response.setCharacterEncoding("UTF-8"); 
response.getWriter().print("success");
                break;
            default:
                throw new AssertionError();
        }
        
    }

}
