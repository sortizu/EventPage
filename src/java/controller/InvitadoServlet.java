/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.InvitadoDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.UUID;
import model.Invitado;

/**
 *
 * @author sortizu
 */
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 10, // 1 MB
        maxFileSize = 1024 * 1024 * 10, // 10 MB
        maxRequestSize = 1024 * 1024 * 100 // 100 MB
)
public class InvitadoServlet extends HttpServlet {

    InvitadoDAO invitadoDAO = new InvitadoDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        switch (request.getParameter("form-mode")) {
            case "add":
                addGuestRequest(request, response);
                break;
            case "edit":
                editGuestRequest(request, response);
                break;
            case "delete":
                deleteGuestRequest(request, response);
                break;
            case "warning-delete":
                warningDeleteGuestRequest(request, response);
                break;
            case "dependency-delete":
                depedencyDeleteGuestRequest(request, response);
                break;
            default:
                PrintWriter out = response.getWriter();
                out.close();
                throw new AssertionError();
        }
    }

    private void addGuestRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Invitado nuevoInvitadoAgregar = new Invitado();
        nuevoInvitadoAgregar.setNombres(request.getParameter("guest-name"));
        nuevoInvitadoAgregar.setApellidos(request.getParameter("guest-last-name"));
        nuevoInvitadoAgregar.setBiografia(request.getParameter("guest-biography"));
        Part filePart = request.getPart("guest-photo");
        if (filePart.getSize()>0) {
        try {
            UUID uuid = UUID.randomUUID();
            String urlParaGuardar = this.getServletContext().getRealPath("") + "img\\guests_images\\" + uuid + ".jpg";

            String urlBD = request.getContextPath() + "/img/guests_images/" + uuid + ".jpg";
            filePart.write(urlParaGuardar);
            nuevoInvitadoAgregar.setImagenUrl(urlBD);
        } catch (Exception e) {
            System.out.println(e);
        }
        }
        invitadoDAO.add(nuevoInvitadoAgregar);
        response.sendRedirect("guest.jsp");
    }

    private void editGuestRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Invitado nuevoInvitadoEditar = new Invitado();
        nuevoInvitadoEditar.setIdInvitado(Integer.parseInt(request.getParameter("id-row")));
        nuevoInvitadoEditar.setNombres(request.getParameter("guest-name"));
        nuevoInvitadoEditar.setApellidos(request.getParameter("guest-last-name"));
        nuevoInvitadoEditar.setBiografia(request.getParameter("guest-biography"));
        Part filePart = request.getPart("guest-photo");
        try {
            //Guardando nueva imagen
            String uuid = invitadoDAO.getGuestImageUUID(nuevoInvitadoEditar.getIdInvitado());
            if(uuid==null || uuid.isEmpty()){
                uuid=UUID.randomUUID().toString();
            }
            String urlParaGuardar = this.getServletContext().getRealPath("") + "img\\guests_images\\" + uuid + ".jpg";
            
            String urlBD = request.getContextPath() + "/img/guests_images/" + uuid + ".jpg";
            nuevoInvitadoEditar.setImagenUrl(urlBD);
            if (filePart.getSize()>0) {
                filePart.write(urlParaGuardar);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        invitadoDAO.edit(nuevoInvitadoEditar);
        response.sendRedirect("guest.jsp");
    }

    private void deleteGuestRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idArray = request.getParameter("json[]");
        for (String id : idArray.split(",")) {
            invitadoDAO.delete(Integer.parseInt(id));
        }
        response.getWriter().print("success");
    }

    private void warningDeleteGuestRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idArrayEvaluateDelete = request.getParameter("json[]");
        boolean dependencyFound = false;
        for (String id : idArrayEvaluateDelete.split(",")) {
            dependencyFound = !invitadoDAO.getDependentEventsId(Integer.parseInt(id)).isEmpty();
        }

        if (dependencyFound) {
            PrintWriter out = response.getWriter();
            out.println("trigger");
            out.close();
        }
    }

    private void depedencyDeleteGuestRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idArrayDeleteDependency = request.getParameter("json[]");
        for (String id : idArrayDeleteDependency.split(",")) {
            invitadoDAO.delete(Integer.parseInt(id), true);
        }

        response.getWriter().print("success");
    }

}
