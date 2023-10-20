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
        String consultaSQL = "SELECT e.*, ce.nombre_catevento, i.nombres AS invitado_nombres, i.apellidos AS invitado_apellidos, i.biografia AS invitado_biografia " +
                                 "FROM evento e " +
                                 "LEFT JOIN categoriaevento ce ON e.id_categoria = ce.id_catevento " +
                                 "LEFT JOIN invitado i ON e.id_invitado = i.id_invitado";
        
        try {
            Statement stmt = Conexion.geConnection().createStatement();
            ResultSet rs = stmt.executeQuery(consultaSQL);
            rs.next();
            do{
                //System.out.println(rs.getString("descripcion"));
                Evento newEvento = new Evento();
                newEvento.setId(rs.getInt("id_evento"));
                newEvento.setNombreEvento(rs.getString("nombre_evento"));
                newEvento.setCosto(rs.getDouble("costo"));
                newEvento.setFecha(rs.getTimestamp("fecha").toLocalDateTime());
                newEvento.setCapacidad(rs.getInt("capacidad"));
                newEvento.setDescripcion(rs.getString("descripcion"));
                
                
                newEvento.setCategoria(
                new CategoriaEvento(rs.getInt("id_categoria"), rs.getString("nombre_catevento"))
                );
            
                newEvento.setInvitado(
                new Invitado(rs.getString("invitado_biografia"), rs.getInt("id_invitado"),
                rs.getString("invitado_nombres"), rs.getString("invitado_apellidos"))
                );
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
        return null;
    }

    @Override
    public boolean add(Object o) {
        //Borrar el codigo de abajo
        Evento nuevoEvento = (Evento)o;
        try {
            Conexion.stmt = Conexion.con.createStatement();
            Conexion.stmt.executeUpdate("INSERT INTO event_page.evento(nombre_evento, costo, fecha, capacidad, id_categoria, descripcion, id_invitado) VALUES "
                    + "('" + nuevoEvento.getNombreEvento()+ "', '" 
                    + nuevoEvento.getCosto()+ "', '"
                    + nuevoEvento.getFecha()+ "', '"
                    + nuevoEvento.getCapacidad()+ "', '"
                    + nuevoEvento.getCategoria().getId()+ "', '"
                    + nuevoEvento.getDescripcion()+ "', '"
                    + nuevoEvento.getInvitado().getId()+ "')");
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
            Conexion.stmt = Conexion.con.createStatement();
            Conexion.stmt.executeUpdate("UPDATE event_page.evento SET "
                    + "nombre_evento = '" + nuevoEvento.getNombreEvento()+ "', " 
                    + "costo = '" +nuevoEvento.getCosto()+ "', "
                    + "fecha = '" + nuevoEvento.getFecha()+ "', "
                    + "capacidad = '" + nuevoEvento.getCapacidad()+ "', "
                    + "id_categoria = '" + nuevoEvento.getCategoria().getId()+ "', "
                    + "descripcion = '" + nuevoEvento.getDescripcion()+ "', "
                    + "id_invitado = '" + nuevoEvento.getInvitado().getId()+ "' WHERE id_evento = '" + nuevoEvento.getId() + "'");
        } catch (SQLException ex) {
            Logger.getLogger(EventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        //Borrar el codigo de abajo
        for(int i = 0; i<listaEvento.size();i++){
            if(listaEvento.get(i).getId()==id){
            listaEvento.remove(i);
            return true;
            }
        }
        return false;
    }
    
}
