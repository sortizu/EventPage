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
public class EliminarEventoCarritoServlet extends HttpServlet {
    CompraDAO compraDao = new CompraDAO();
    DetalleCompraDAO detalleCompraDao = new DetalleCompraDAO();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        int idDetalleCompra = Integer.parseInt(request.getParameter("id_detalle_compra"));
        detalleCompraDao.delete(idDetalleCompra);
        out.print("{}");
        out.flush();
    }

}
