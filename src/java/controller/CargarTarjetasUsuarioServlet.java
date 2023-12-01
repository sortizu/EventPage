/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.TarjetaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import model.Tarjeta;

/**
 *
 * @author sortizu
 */
public class CargarTarjetasUsuarioServlet extends HttpServlet {

    TarjetaDAO tarjetaDAO = new TarjetaDAO();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        
        
        int idUsuario = (Integer)request.getSession().getAttribute("id_user");
        
        ArrayList<Tarjeta> tarjetasDeUsuario = tarjetaDAO.cargarTarjetasDeUsuario(idUsuario);
        
        String creditCardListJson = "";
        for (int i = 0; i<tarjetasDeUsuario.size();i++){
        Tarjeta tarjeta=tarjetasDeUsuario.get(i);
        creditCardListJson+=tarjeta;
        if(i<tarjetasDeUsuario.size()-1){
        creditCardListJson+=",";
        }
        }
        
        String jsonFormattedResponse = String.format(
                "[%s]", 
                creditCardListJson);
        out.print(jsonFormattedResponse);
        out.flush();
    }

}
