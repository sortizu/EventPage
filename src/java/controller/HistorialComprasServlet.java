/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.CompraDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Compra;

/**
 *
 * @author sortizu
 */
public class HistorialComprasServlet extends HttpServlet {
    CompraDAO compraDao = new CompraDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        
        int idUsuario = (Integer)request.getSession().getAttribute("id_user");
        ArrayList<Compra> historialDeCompras = compraDao.cargarComprasDeUsuario(idUsuario);
        String listaDeComprasJson = "";
        for (int i = 0; i<historialDeCompras.size();i++){
        listaDeComprasJson+=historialDeCompras.get(i);
        if(i<historialDeCompras.size()-1){
        listaDeComprasJson+=",";
        }
        }
        String jsonFormattedResponse = String.format(
                "{\"compras\":[%s]}",
                listaDeComprasJson);
        out.print(jsonFormattedResponse);
        out.flush();
    }

}
