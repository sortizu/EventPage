/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.EventoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Evento;

/**
 *
 * @author sortizu
 */
public class AplicarFiltrosServlet extends HttpServlet {
    EventoDAO eventoDAO = new EventoDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String jsonFormattedResponse="";

        String nombre=request.getParameter("search_query");
        String fecha = request.getParameter("event_date");
        String categoria = request.getParameter("event_label");
        String costoMinimo = request.getParameter("event_price_min");
        String costoMaximo = request.getParameter("event_price_max");
        
        ArrayList<Evento> listaDeEventos = eventoDAO.cargarEventosSegunFiltro(nombre, fecha,categoria, costoMinimo, costoMaximo);
        
        String listaDeEventosJson = "";
        for (int i = 0; i<listaDeEventos.size();i++){
        listaDeEventosJson+=listaDeEventos.get(i);
        if(i<listaDeEventos.size()-1){
        listaDeEventosJson+=",";
        }
        }
        jsonFormattedResponse = String.format(
                "[%s]",
                listaDeEventosJson);
        out.print(jsonFormattedResponse);
        
        out.flush();
    }

}
