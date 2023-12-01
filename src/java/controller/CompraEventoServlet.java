/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.CompraDAO;
import DAO.DetalleCompraDAO;
import DAO.EventoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import model.Compra;
import model.DetalleCompra;
import model.Evento;

/**
 *
 * @author sortizu
 */
public class CompraEventoServlet extends HttpServlet {

    CompraDAO compraDao = new CompraDAO();
    DetalleCompraDAO detalleCompraDAO = new DetalleCompraDAO();
    EventoDAO eventoDAO = new EventoDAO();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        int idTarjeta = Integer.parseInt(request.getParameter("id_tarjeta"));
        int idUsuario = (Integer)request.getSession().getAttribute("id_user");
        //int ccv = Integer.parseInt(request.getParameter("ccv"));
        Compra nuevaCompra = new Compra();
        nuevaCompra.setIdTarjeta(idTarjeta);
        nuevaCompra.setIdUsuario(idUsuario);
        nuevaCompra.setFechaDeCompra(LocalDateTime.now());
        nuevaCompra.setPendiente(false);
        compraDao.add(nuevaCompra);
        
        int idCompra = compraDao.obtenerIdUltimaCompra(idUsuario);
        nuevaCompra.setIdCompra(idCompra);
        
        DetalleCompra detalleCompra = new DetalleCompra();
        detalleCompra.setIdCompra(idCompra);
        detalleCompra.setIdEvento(id);
        detalleCompraDAO.add(detalleCompra);
        
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String jsonFormattedResponse = String.format(
                "{\"compra\":%s}", 
                nuevaCompra);
        out.print(jsonFormattedResponse);
        out.flush();
    }

}
