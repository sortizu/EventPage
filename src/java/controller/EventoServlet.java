/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.CategoriaEventoDAO;
import DAO.EventoDAO;
import DAO.InvitadoDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Evento;
import java.util.UUID;

/**
 *
 * @author sortizu
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class EventoServlet extends HttpServlet {

    EventoDAO eventoDAO = new EventoDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        switch (request.getParameter("form-mode")) {
            case "add":
                addEventRequest(request, response);
                break;
            case "edit":
                editEventRequest(request, response);
                break;
            case "delete":
                deleteEventRequest(request, response);
                break;
            default:
                PrintWriter out = response.getWriter();
                out.close();
                throw new AssertionError();
        }

    }

    private void addEventRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Evento nuevoEventoAgregar = new Evento();
        nuevoEventoAgregar.setNombreEvento(request.getParameter("event-name"));
        nuevoEventoAgregar.setCosto(Double.parseDouble(request.getParameter("event-price")));
        nuevoEventoAgregar.setFecha(LocalDateTime.parse(request.getParameter("event-date"), DateTimeFormatter.ISO_DATE_TIME));
        nuevoEventoAgregar.setCapacidad(Integer.parseInt(request.getParameter("event-capacity")));
        nuevoEventoAgregar.setIdCategoriaEvento(Integer.parseInt(request.getParameter("event-label")));
        nuevoEventoAgregar.setDescripcion(request.getParameter("event-description"));
        nuevoEventoAgregar.setIdInvitado(Integer.parseInt(request.getParameter("event-guest")));
        if (request.getParameterMap().containsKey("featured")) {
            nuevoEventoAgregar.setDestacado(true);
        }
        Part filePart = request.getPart("event-image");
        if (filePart.getSize()>0) {
        try {
            UUID uuid = UUID.randomUUID();
            String urlParaGuardar = this.getServletContext().getRealPath("") + "img\\events_images\\" + uuid + ".jpg";

            String urlBD = request.getContextPath() + "/img/events_images/" + uuid + ".jpg";
            filePart.write(urlParaGuardar);
            nuevoEventoAgregar.setImagenUrl(urlBD);
        } catch (Exception e) {
            System.out.println(e);
        }
        }
        eventoDAO.add(nuevoEventoAgregar);
        response.sendRedirect("event.jsp");
    }

    private void editEventRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Evento eventoEditar = new Evento();
        eventoEditar.setIdEvento(Integer.parseInt(request.getParameter("id-row")));
        eventoEditar.setNombreEvento(request.getParameter("event-name"));
        eventoEditar.setCosto(Double.parseDouble(request.getParameter("event-price")));
        eventoEditar.setFecha(LocalDateTime.parse(request.getParameter("event-date"), DateTimeFormatter.ISO_DATE_TIME));
        eventoEditar.setCapacidad(Integer.parseInt(request.getParameter("event-capacity")));
        eventoEditar.setIdCategoriaEvento(Integer.parseInt(request.getParameter("event-label")));
        eventoEditar.setDescripcion(request.getParameter("event-description"));
        eventoEditar.setIdInvitado(Integer.parseInt(request.getParameter("event-guest")));
        if (request.getParameterMap().containsKey("featured")) {
            eventoEditar.setDestacado(true);
        }
        
        Part filePart = request.getPart("event-image");
       
        try {
            //Guardando nueva imagen
            String uuid = eventoDAO.getEventImageUUID(eventoEditar.getIdEvento());
            if(uuid==null || uuid.isEmpty()){
                uuid=UUID.randomUUID().toString();
            }
            String urlParaGuardar = this.getServletContext().getRealPath("") + "img\\events_images\\" + uuid + ".jpg";
            
            String urlBD = request.getContextPath() + "/img/events_images/" + uuid + ".jpg";
            eventoEditar.setImagenUrl(urlBD);
            if (filePart.getSize()>0) {
                filePart.write(urlParaGuardar);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        eventoDAO.edit(eventoEditar);
        response.sendRedirect("event.jsp");
    }

    private void deleteEventRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idList = request.getParameterValues("json[]")[0];
        for (String id : idList.split(",")) {
            eventoDAO.delete(Integer.parseInt(id));
        }
        response.getWriter().print("success");
    }
}
