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
import model.Invitado;

/**
 *
 * @author sortizu
 */
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 10, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class InvitadoServlet extends HttpServlet {
    
    InvitadoDAO invitadoDAO = new InvitadoDAO();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                response.setContentType("application/json");
        switch (request.getParameter("form-mode")) {
            case "add":
                Invitado nuevoInvitadoAgregar = new Invitado();
                nuevoInvitadoAgregar.setNombres(request.getParameter("guest-name"));
                nuevoInvitadoAgregar.setApellidos(request.getParameter("guest-last-name"));
                nuevoInvitadoAgregar.setBiografia(request.getParameter("guest-biography"));
                invitadoDAO.add(nuevoInvitadoAgregar);
                try {
                     ArrayList<Invitado> invitados =(ArrayList<Invitado>)invitadoDAO.listAll();
                   int id=invitados.get(invitados.size()-1).getId();
                    Part filePart = request.getPart("guest-photo");
                    filePart.write(this.getServletContext().getRealPath("")+"\\img\\guests_images\\"+id+".jpg");
                   } catch (Exception e) {
                       System.out.println(e);
                   }
                response.sendRedirect("guest.jsp");
                break;
            case "edit":
                Invitado nuevoInvitadoEditar = new Invitado();
                nuevoInvitadoEditar.setId(Integer.parseInt(request.getParameter("id-row")));
                nuevoInvitadoEditar.setNombres(request.getParameter("guest-name"));
                nuevoInvitadoEditar.setApellidos(request.getParameter("guest-last-name"));
                nuevoInvitadoEditar.setBiografia(request.getParameter("guest-biography"));
                invitadoDAO.edit(nuevoInvitadoEditar);
                try {
                    Part filePart = request.getPart("guest-photo");
                    filePart.write(this.getServletContext().getRealPath("")+"\\img\\guests_images\\"+nuevoInvitadoEditar.getId()+".jpg");   
                   } catch (Exception e) {
                       System.out.println(e);
                   }
                response.sendRedirect("guest.jsp");
                break;
            case "delete":
                String idArray = request.getParameter("json[]");
                for(String id:idArray.split(",")){
                    invitadoDAO.delete(Integer.parseInt(id));
                }
response.getWriter().print("success");
                break;
            case "warning-delete":
                String idArrayEvaluateDelete = request.getParameter("json[]");
        boolean dependencyFound=false;
        for(String id:idArrayEvaluateDelete.split(",")){
            dependencyFound = !invitadoDAO.getDependentEventsId(Integer.parseInt(id)).isEmpty();
        }

        if (dependencyFound){
            PrintWriter out = response.getWriter();
        out.println("trigger");
        out.close();
        }
                break;
            case "dependency-delete":
                String idArrayDeleteDependency = request.getParameter("json[]");
                for(String id:idArrayDeleteDependency.split(",")){
                    invitadoDAO.delete(Integer.parseInt(id),true);
                }

response.getWriter().print("success");
                break;
            default:
                PrintWriter out = response.getWriter();
                out.close();
                throw new AssertionError();
        }
    }

}
