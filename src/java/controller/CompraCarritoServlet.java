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
import java.util.ArrayList;
import model.Compra;
import model.DetalleCompra;
import model.Evento;

/**
 *
 * @author sortizu
 */
public class CompraCarritoServlet extends HttpServlet {
    
    CompraDAO compraDao = new CompraDAO();
    DetalleCompraDAO detalleCompraDAO = new DetalleCompraDAO();
    EventoDAO eventoDAO = new EventoDAO();
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String jsonFormattedResponse="";
        
        int idTarjeta = Integer.parseInt(request.getParameter("id_tarjeta"));
        int idUsuario = (Integer)request.getSession().getAttribute("id_user");
        
        int idCompra = compraDao.obtenerIdCompraPendiente(idUsuario);
        Compra compraPendiente = new Compra();
        compraPendiente.setIdCompra(idCompra);
        compraPendiente.setIdTarjeta(idTarjeta);
        compraPendiente.setIdUsuario(idUsuario);
        compraPendiente.setFechaDeCompra(LocalDateTime.now());
        compraPendiente.setPendiente(false);
        compraDao.edit(compraPendiente);
        
        ArrayList<Evento> eventosComprados = eventoDAO.cargarEventosDeCompra(idCompra);
        
        String listaDeEventos = "";
        for (int i = 0; i<eventosComprados.size();i++){
        Evento eventoComprado=eventosComprados.get(i);
        listaDeEventos+=eventoComprado;
        if(i<eventosComprados.size()-1){
        listaDeEventos+=",";
        }
        }
        jsonFormattedResponse = String.format(
                "{\"compra\":%s,\"eventos\":[%s]}", 
                compraPendiente,
                listaDeEventos);
        out.print(jsonFormattedResponse);
        out.flush();
    }

}
