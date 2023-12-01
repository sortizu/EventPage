/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import config.Conexion;
import interfaces.CRUD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Invitado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author sortizu
 */
public class InvitadoDAO implements CRUD {
    //Solucion temporal para probar interfaces
    private static ArrayList<Invitado> listaInvitado = new ArrayList<>();
    
    @Override
    public List listAll() {
        //Borrar el codigo de abajo
        ArrayList<Invitado> invitados = new ArrayList<>();
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM event_page.invitado WHERE eliminado=0");
            while(rs.next()){
                Invitado newInvitado = new Invitado();
                newInvitado.setIdInvitado(rs.getInt("id_invitado"));
                newInvitado.setNombres(rs.getString("nombres"));
                newInvitado.setApellidos(rs.getString("apellidos"));
                newInvitado.setBiografia(rs.getString("biografia"));
                newInvitado.setImagenUrl(rs.getString("imagen_url"));
                invitados.add(newInvitado);
                
            } 
        } catch (SQLException ex) {
            Logger.getLogger(InvitadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return invitados;
    }

    @Override
    public Object list(int id) {

        
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(
            String.format(
                    "SELECT * FROM event_page.invitado WHERE id_invitado = %d AND eliminado=0"
                    ,id)
            );
            rs.next();
            
            Invitado newInvitado = new Invitado();
            newInvitado.setIdInvitado(rs.getInt("id_invitado"));
            newInvitado.setNombres(rs.getString("nombres"));
            newInvitado.setApellidos(rs.getString("apellidos"));  
            newInvitado.setBiografia(rs.getString("biografia"));
            newInvitado.setImagenUrl(rs.getString("imagen_url"));
            return newInvitado;

        } catch (SQLException ex) {
            Logger.getLogger(InvitadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    @Override
    public boolean add(Object o) {
        //Borrar el codigo de abajo
        Invitado nuevoInvitado = (Invitado)o;
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate("INSERT INTO event_page.invitado(nombres, apellidos, biografia,imagen_url,eliminado) VALUES "
                    + "('" + nuevoInvitado.getNombres() + "', '" 
                    + nuevoInvitado.getApellidos() + "', '"
                    + nuevoInvitado.getBiografia() + "','"
                    + nuevoInvitado.getImagenUrl() + "',"
                    + 0+ ")");
        } catch (SQLException ex) {
            Logger.getLogger(InvitadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean edit(Object o) {
        Invitado invitadoEditar = (Invitado)o;
        try {
            String query=String.format(
              "UPDATE event_page.invitado SET nombres='%s',apellidos='%s',imagen_url='%s',biografia='%s' WHERE id_invitado=%d",
            invitadoEditar.getNombres(),
            invitadoEditar.getApellidos(),
                invitadoEditar.getImagenUrl(),
                invitadoEditar.getBiografia(),
            invitadoEditar.getIdInvitado());
            
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
              "UPDATE event_page.invitado SET eliminado=1 WHERE id_invitado=%d",id);
            
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
              "UPDATE event_page.invitado SET eliminado=1 WHERE id_invitado=%d",id);
            
            Statement stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate(query);
            if (deleteDependentEvents) {
                query=String.format(
              "UPDATE event_page.evento SET eliminado=1 WHERE id_invitado=%d",id);
            stmt.executeUpdate(query);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvitadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public List getDependentEventsId(int guestID){
        try {
            String query=String.format(
              "SELECT * FROM event_page.evento WHERE eliminado=0 AND id_invitado=%d",guestID);
            
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
    
    public String getGuestImageUUID(int id){
    String consultaSQL = "SELECT imagen_url FROM invitado WHERE id_invitado="+id;
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
    public String obtenerNumeroTicketsPorInvitadoJson() {
        try {
            String jsonResponse="";
            String query=
                    "SELECT COUNT(*) as numero_tickets, concat(i.nombres,' ',i.apellidos) as nombre_invitado "+
                    "FROM event_page.detalle_compra dc "+
                    "INNER JOIN event_page.evento e "+
                    "ON dc.id_evento=e.id_evento "+
                    "INNER JOIN event_page.invitado i "+
                    "ON i.id_invitado = e.id_invitado "+
                    "GROUP BY i.id_invitado "+
                    "ORDER BY COUNT(*) DESC ";
            
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            ArrayList<String> listaDeRespuestas=new ArrayList<>();
            while(rs.next()){
            String respuesta = String.format(
                    "{\"nombre_invitado\":\"%s\",\"numero_tickets\":\"%s\"}"
                    , rs.getString("nombre_invitado")
                    ,rs.getString("numero_tickets"));
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
