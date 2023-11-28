/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import config.Conexion;
import debug.Console;
import interfaces.CRUD;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CategoriaEvento;
import model.Evento;
import model.Invitado;

/**
 *
 * @author sortizu
 */
public class EventoDAO implements CRUD {
    
    //Solucion temporal para probar interfaces
    private static ArrayList<Evento> listaEvento = new ArrayList<>();
    
    @Override
    public List listAll() {
        //Borrar el codigo de abajo
        ArrayList<Evento> eventos = new ArrayList<>();
        String consultaSQL = "SELECT * FROM evento e WHERE e.eliminado=0";
        
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(consultaSQL);
            rs.next();
            do{
                
                Evento newEvento = new Evento();
                newEvento.setIdEvento(rs.getInt("id_evento"));
                newEvento.setNombreEvento(rs.getString("nombre_evento"));
                newEvento.setCosto(rs.getDouble("costo"));
                newEvento.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                newEvento.setCapacidad(rs.getInt("capacidad"));
                newEvento.setDescripcion(rs.getString("descripcion"));
                newEvento.setDestacado(rs.getBoolean("destacado"));
                newEvento.setIdCategoriaEvento(rs.getInt("id_categoria_evento"));
                newEvento.setIdInvitado(rs.getInt("id_invitado"));
                newEvento.setImagenUrl(rs.getString("imagen_url"));
                eventos.add(newEvento);
            } while (rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return eventos;
    }
    
    
    public List listFeatured() {
        //Borrar el codigo de abajo
        ArrayList<Evento> eventos = new ArrayList<>();
        String consultaSQL = "SELECT * WHERE e.eliminado=0 AND e.destacado=1";
        
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(consultaSQL);
            rs.next();
            do{
                
                Evento newEvento = new Evento();
                newEvento.setIdEvento(rs.getInt("id_evento"));
                newEvento.setNombreEvento(rs.getString("nombre_evento"));
                newEvento.setCosto(rs.getDouble("costo"));
                newEvento.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                newEvento.setCapacidad(rs.getInt("capacidad"));
                newEvento.setDescripcion(rs.getString("descripcion"));
                newEvento.setDestacado(rs.getBoolean("destacado"));
                newEvento.setIdCategoriaEvento(rs.getInt("id_categoria_evento"));
                newEvento.setIdInvitado(rs.getInt("id_invitado"));
                newEvento.setImagenUrl(rs.getString("imagen_url"));
                eventos.add(newEvento);
                
            } while (rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return eventos;
    }

    @Override
    public Object list(int id) {
        //Borrar el codigo de abajo
        Evento evento = new Evento();
        String consultaSQL = "SELECT * WHERE e.eliminado=0 AND e.id_evento="+id;
        
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(consultaSQL);
            rs.next();
            do{
                evento.setIdEvento(rs.getInt("id_evento"));
                evento.setNombreEvento(rs.getString("nombre_evento"));
                evento.setCosto(rs.getDouble("costo"));
                evento.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                evento.setCapacidad(rs.getInt("capacidad"));
                evento.setDescripcion(rs.getString("descripcion"));
                evento.setDestacado(rs.getBoolean("destacado"));
                evento.setIdCategoriaEvento(rs.getInt("id_categoria_evento"));
                evento.setIdInvitado(rs.getInt("id_invitado"));
                evento.setImagenUrl(rs.getString("imagen_url"));
                return evento;
            } while (rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return null;
    }

    @Override
    public boolean add(Object o) {
        //Borrar el codigo de abajo
        Evento nuevoEvento = (Evento)o;
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate("INSERT INTO event_page.evento(nombre_evento, costo, fecha, capacidad, id_categoria_evento, descripcion, eliminado,id_invitado,imagen_url,destacado) VALUES "
                    + "('" + nuevoEvento.getNombreEvento()+ "', '" 
                    + nuevoEvento.getCosto()+ "', '"
                    + nuevoEvento.getFecha()+ "', '"
                    + nuevoEvento.getCapacidad()+ "', '"
                    + nuevoEvento.getIdCategoriaEvento()+ "', '"
                    + nuevoEvento.getDescripcion()+ "', "
                    + 0 + ","
                    + nuevoEvento.getIdInvitado()+ ","
                    + nuevoEvento.getImagenUrl()+ ","
                    + (nuevoEvento.isDestacado()?1:0)+ ")");
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean edit(Object o) {
        //Borrar el codigo de abajo
        Evento nuevoEvento = (Evento)o;
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate("UPDATE event_page.evento SET "
                    + "nombre_evento = '" + nuevoEvento.getNombreEvento()+ "', " 
                    + "costo = '" +nuevoEvento.getCosto()+ "', "
                    + "fecha = '" + nuevoEvento.getFecha()+ "', "
                    + "capacidad = '" + nuevoEvento.getCapacidad()+ "', "
                    + "id_categoria_evento = '" + nuevoEvento.getIdCategoriaEvento()+ "', "
                    + "descripcion = '" + nuevoEvento.getDescripcion()+ "', "
                    + "id_invitado = '" + nuevoEvento.getIdInvitado()+ "', "
                    + "destacado= '" + (nuevoEvento.isDestacado()?1:0)+"', "
                    + "imagen_url= '" + nuevoEvento.getImagenUrl()+
                    "' WHERE id_evento = '" + nuevoEvento.getIdEvento()+ "'");
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try {
            String query=String.format(
              "UPDATE event_page.evento SET eliminado=1 WHERE id_evento=%d",id);
            
            Statement stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(InvitadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public String getEventImageUUID(int id){
    String consultaSQL = "SELECT imagen_url FROM evento WHERE id_evento="+id;
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(consultaSQL);
            rs.next();
            String[] urlSplitted = rs.getString("imagen_url").split("/");
            String uuid=urlSplitted[urlSplitted.length-1];
            uuid = uuid.substring(0, uuid.length()-4);
            return uuid;
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }
    
}
