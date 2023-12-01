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
import java.util.ArrayList;
import model.DetalleCompra;
import model.Evento;

/**
 *
 * @author sortizu
 */
public class ObtenerCarritoServlet extends HttpServlet {
    CompraDAO compraDao = new CompraDAO();
    EventoDAO eventoDAO = new EventoDAO();
    DetalleCompraDAO detalleCompraDAO = new DetalleCompraDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String jsonFormattedResponse="";
        
        int id_usuario = (Integer)request.getSession().getAttribute("id_user");
        int idCompraPendiente=compraDao.obtenerIdCompraPendiente(id_usuario);
        ArrayList<DetalleCompra> listaDetallesCompra = detalleCompraDAO.cargarDetallesDeCompra(idCompraPendiente);
        String listaDeEventosJson = "";
        String listaDetalleCompraJson = "";
        for (int i = 0; i<listaDetallesCompra.size();i++){
        Evento eventoComprado=
                (Evento)eventoDAO.list(listaDetallesCompra.get(i).getIdEvento());
        listaDeEventosJson+=eventoComprado;
        listaDetalleCompraJson+=listaDetallesCompra.get(i);
        if(i<listaDetallesCompra.size()-1){
        listaDeEventosJson+=",";
        listaDetalleCompraJson+=",";
        }
        }
        jsonFormattedResponse = String.format(
                "{\"eventos\":[%s],\"detalles_compra\":[%s]}",
                listaDeEventosJson,
                listaDetalleCompraJson);
        out.print(jsonFormattedResponse);
        out.flush();
    }
}
