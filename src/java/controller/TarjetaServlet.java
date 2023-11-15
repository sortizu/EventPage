/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.TarjetaDAO;
import DAO.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import model.Tarjeta;
import model.Usuario;
import java.sql.Date;
/**
 *
 * @author sortizu
 */
public class TarjetaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        TarjetaDAO tarjetaDAO = new TarjetaDAO();
        Tarjeta nuevaTarjeta = new Tarjeta();
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuarioDeTarjeta=new Usuario();
        
        nuevaTarjeta.setNombrePropietario(request.getParameter("card-owner"));
        nuevaTarjeta.setNumeroTarjeta(request.getParameter("card-number"));
        
        String fecha = request.getParameter("expiration-date")+"-01";
        LocalDate fechaVencimiento = LocalDate.parse(fecha);
        nuevaTarjeta.setFechaDeVencimiento(fechaVencimiento);
        
        usuarioDeTarjeta.setId((Integer)request.getSession().getAttribute("id_user"));
        nuevaTarjeta.setUsuario(usuarioDeTarjeta);

        tarjetaDAO.add(nuevaTarjeta);
        response.sendRedirect("index.jsp");
    }

}
