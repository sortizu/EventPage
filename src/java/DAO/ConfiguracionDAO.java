/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import config.Conexion;
import interfaces.CRUD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Configuracion;

/**
 *
 * @author sortizu
 */
public class ConfiguracionDAO implements CRUD{

    @Override
    public List listAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object list(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean edit(Object o) {
        Configuracion configuracion = (Configuracion)o;
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate(
            String.format("UPDATE event_page.configuracion SET valor='%s' WHERE parametro='nombre_pagina'",configuracion.getNombrePagina())
            );
            stmt.executeUpdate(
            String.format("UPDATE event_page.configuracion SET valor='%s' WHERE parametro='descripcion_pagina'",configuracion.getDescripcionPagina())
            );
            stmt.executeUpdate(
            String.format("UPDATE event_page.configuracion SET valor='%s' WHERE parametro='eslogan'",configuracion.getEslogan())
            );
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public Configuracion cargarConfiguracion(){
        Configuracion configuracion = new Configuracion();
        String consultaSQL = "SELECT valor FROM event_page.configuracion";
        
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(consultaSQL);
            rs.next();
            configuracion.setNombrePagina(rs.getString(1));
            rs.next();
            configuracion.setDescripcionPagina(rs.getString(1));
            rs.next();
            configuracion.setEslogan(rs.getString(1));
            return configuracion;
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return null;
    }
}
