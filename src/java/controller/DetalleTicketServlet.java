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
import model.Compra;
import model.Evento;

/**
 *
 * @author sortizu
 */
public class DetalleTicketServlet extends HttpServlet {
    CompraDAO compraDao = new CompraDAO();
    EventoDAO eventoDAO = new EventoDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String jsonFormattedResponse="";

        int idCompra =  Integer.parseInt(request.getParameter("id_compra"));
        Compra compra = (Compra)compraDao.list(idCompra);
        
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
                compra,
                listaDeEventos);
        out.print(jsonFormattedResponse);
        out.flush();
    }

}
