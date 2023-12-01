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
public class BuscarEventosServlet extends HttpServlet {
    EventoDAO eventoDAO = new EventoDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        String jsonFormattedResponse="";

        String searchQuery=request.getParameter("search_query");
        
        ArrayList<Evento> listaDeEventos = eventoDAO.cargarEventosSegunNombre(searchQuery);
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
