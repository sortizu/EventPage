/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.CompraDAO;
import DAO.DetalleCompraDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DetalleCompra;

/**
 *
 * @author sortizu
 */
public class AgregarACarritoServlet extends HttpServlet {
    
    CompraDAO compraDao = new CompraDAO();
    DetalleCompraDAO detalleCompraDAO = new DetalleCompraDAO();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        int id_evento = Integer.parseInt(request.getParameter("id"));
        int id_usuario = (Integer)request.getSession().getAttribute("id_user");
        
        int idCompraPendiente=compraDao.obtenerIdCompraPendiente(id_usuario);
        if(idCompraPendiente<0){
           compraDao.agregarCompraPendiente(id_usuario);
           idCompraPendiente=compraDao.obtenerIdCompraPendiente(id_usuario);
        }
        DetalleCompra detalleCompra = new DetalleCompra(0,idCompraPendiente,id_evento);
        detalleCompraDAO.add(detalleCompra);
        PrintWriter out = response.getWriter();
        out.print("Exito");
        out.close();
    }
}
