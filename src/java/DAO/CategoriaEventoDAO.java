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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CategoriaEvento;

/**
 *
 * @author sortizu
 */
public class CategoriaEventoDAO implements CRUD {

    private static ArrayList<CategoriaEvento> listaCategoriaEventos = new ArrayList<>();
    
    @Override
    public List listAll() {
        //Borrar el codigo de abajo
        ArrayList<CategoriaEvento> categorias = new ArrayList<>();
  
        
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM event_page.categoria_evento WHERE eliminado=0");
            while(rs.next()){
                CategoriaEvento newCategoria = new CategoriaEvento();
                newCategoria.setIdCategoriaEvento(rs.getInt("id_categoria_evento"));
                newCategoria.setNombreCategoria(rs.getString("nombre_catevento"));
                categorias.add(newCategoria);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaEventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return categorias;
    }

    @Override
    public Object list(int id) {
      
        
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(
            String.format(
                    "SELECT * FROM event_page.categoria_evento WHERE id_categoria_evento = %d AND eliminado=0"
                    ,id)
            );
            rs.next();
            
            CategoriaEvento newCategoria = new CategoriaEvento();
            newCategoria.setIdCategoriaEvento(rs.getInt("id_categoria_evento"));
            newCategoria.setNombreCategoria(rs.getString("nombre_catevento"));
            
            return newCategoria;

        } catch (SQLException ex) {
            Logger.getLogger(CategoriaEventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public boolean add(Object o) {
        //Borrar el codigo de abajo
        CategoriaEvento nuevaCategoria = (CategoriaEvento)o;
     
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate("INSERT INTO event_page.categoria_evento(nombre_catevento,eliminado) VALUES "
                    + "('" + nuevaCategoria.getNombreCategoria() + "',"+0+")");
        } catch (SQLException ex) {
            Logger.getLogger(InvitadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean edit(Object o) {
        CategoriaEvento categoriaEventoEditar = (CategoriaEvento)o;
        try {
            String query=String.format(
              "UPDATE event_page.categoria_evento SET nombre_catevento='%s' WHERE id_categoria_evento=%d",
            categoriaEventoEditar.getNombreCategoria(),
            categoriaEventoEditar.getIdCategoriaEvento());
            
            Statement stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(InvitadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try {
            String query=String.format(
              "UPDATE event_page.categoria_evento SET eliminado=1 WHERE id_categoria_evento=%d",id);
            
            Statement stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(InvitadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public boolean delete(int id, boolean deleteDependentEvents) {
        try {
            String query=String.format(
              "UPDATE event_page.categoria_evento SET eliminado=1 WHERE id_categoria_evento=%d",id);
            
            Statement stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate(query);
            if (deleteDependentEvents) {
                query=String.format(
              "UPDATE event_page.evento SET eliminado=1 WHERE id_categoria_evento=%d",id);
            stmt.executeUpdate(query);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvitadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public List getDependentEventsId(int categoryID){
        try {
            String query=String.format(
              "SELECT * FROM event_page.evento WHERE eliminado=0 AND id_categoria_evento=%d",categoryID);
            
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<Integer> eventsID = new ArrayList<>();
            while (rs.next()){
                eventsID.add(rs.getInt("id_evento"));
            }
            return eventsID;
        } catch (SQLException ex) {
            Logger.getLogger(InvitadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public String obtenerGananciaPorCategoriaJson() {
        
        try {
            String jsonResponse="";
            String query=
                    "SELECT SUM(costo) as ganancia, ce.nombre_catevento as nombre_categoria "+
                    "FROM event_page.detalle_compra dc "+
                    "INNER JOIN event_page.evento e "+
                    "ON dc.id_evento=e.id_evento "+
                    "INNER JOIN event_page.categoria_evento ce "+
                    "ON e.id_categoria_evento=ce.id_categoria_evento "+
                    "GROUP BY e.id_categoria_evento "+
                    "ORDER BY SUM(costo) DESC";
            
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<String> listaDeRespuestas=new ArrayList<>();
            while(rs.next()){
            String respuesta = String.format(
                    "{\"nombre_categoria\":\"%s\",\"ganancia\":\"%s\"}"
                    , rs.getString("nombre_categoria")
                    ,rs.getString("ganancia"));
            listaDeRespuestas.add(respuesta);
            }
            jsonResponse="[";
            for(int i=0;i<listaDeRespuestas.size();i++){
            jsonResponse+=listaDeRespuestas.get(i);
            if(i<listaDeRespuestas.size()-1){
            jsonResponse+=",";
            }
            }
            jsonResponse+="]";
            return jsonResponse;
        } catch (SQLException ex) {
            Logger.getLogger(InvitadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }   
}
