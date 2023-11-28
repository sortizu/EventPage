/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.ConfiguracionDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import model.Configuracion;

/**
 *
 * @author sortizu
 */
@MultipartConfig(
  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
  maxFileSize = 1024 * 1024 * 10,      // 10 MB
  maxRequestSize = 1024 * 1024 * 100   // 100 MB
)
public class ConfiguracionServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Configuracion configuracion = new Configuracion();
        ConfiguracionDAO configuracionDAO = new ConfiguracionDAO();
        configuracionDAO.editarValorDeParametro("nombre_pagina", request.getParameter("page-name"));
        configuracionDAO.editarValorDeParametro("descripcion_pagina", request.getParameter("page-description"));
        configuracionDAO.editarValorDeParametro("eslogan", request.getParameter("slogan"));
        configuracionDAO.edit(configuracion);
        try {
         Part filePart = request.getPart("page-logo");
       for (Part part : request.getParts()) {
      part.write(this.getServletContext().getRealPath("")+"\\img\\logo\\flavicon.svg");
        }   
        } catch (Exception e) {
            System.out.println(e);
        }
       response.sendRedirect("configuration.jsp");
    }

}
