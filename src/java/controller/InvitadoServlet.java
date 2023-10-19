/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.InvitadoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Invitado;

/**
 *
 * @author sortizu
 */
public class InvitadoServlet extends HttpServlet {
    
    InvitadoDAO invitadoDAO = new InvitadoDAO();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        switch (request.getParameter("form-mode")) {
            case "add":
                Invitado nuevoInvitadoAgregar = new Invitado();
                nuevoInvitadoAgregar.setNombres(request.getParameter("guest-name"));
                nuevoInvitadoAgregar.setApellidos(request.getParameter("guest-last-name"));
                nuevoInvitadoAgregar.setBiografia(request.getParameter("guest-biography"));
                invitadoDAO.add(nuevoInvitadoAgregar);
                response.sendRedirect("guest.jsp");
                break;
            case "edit":
                Invitado nuevoInvitadoEditar = new Invitado();
                nuevoInvitadoEditar.setId(Integer.parseInt(request.getParameter("id-row")));
                nuevoInvitadoEditar.setNombres(request.getParameter("guest-name"));
                nuevoInvitadoEditar.setApellidos(request.getParameter("guest-last-name"));
                nuevoInvitadoEditar.setBiografia(request.getParameter("guest-biography"));
                invitadoDAO.edit(nuevoInvitadoEditar);
                response.sendRedirect("guest.jsp");
                break;
            case "delete":
                String[] idArray = request.getParameterValues("json[]");
                for(String id:idArray){
                    invitadoDAO.delete(Integer.parseInt(id));
                }
                response.setCharacterEncoding("UTF-8"); 
response.getWriter().print("success");
                break;
            default:
                throw new AssertionError();
        }
    }

}
