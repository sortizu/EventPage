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
            Conexion.rs = Conexion.stmt.executeQuery("SELECT * FROM event_page.invitado");
            Conexion.rs.next();
            do{
                Invitado newInvitado = new Invitado();
                newInvitado.setId(Conexion.rs.getInt("id_invitado"));
                newInvitado.setNombres(Conexion.rs.getString("nombres"));
                newInvitado.setApellidos(Conexion.rs.getString("apellidos"));
                newInvitado.setBiografia(Conexion.rs.getString("biografia"));
                invitados.add(newInvitado);
                
            } while (Conexion.rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(InvitadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return invitados;
    }

    @Override
    public Object list(int id) {

        
        try {
            Conexion.rs = Conexion.stmt.executeQuery("SELECT * FROM event_page.invitado WHERE id_invitado = " + id);
            Conexion.rs.next();
            
            Invitado newInvitado = new Invitado();
            newInvitado.setId(Conexion.rs.getInt("id_invitado"));
            newInvitado.setNombres(Conexion.rs.getString("nombres"));
            newInvitado.setApellidos(Conexion.rs.getString("apellidos"));  
            newInvitado.setBiografia(Conexion.rs.getString("biografia"));  
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
            Conexion.stmt = Conexion.con.createStatement();
            Conexion.stmt.executeUpdate("INSERT INTO event_page.invitado(nombres, apellidos, biografia) VALUES "
                    + "('" + nuevoInvitado.getNombres() + "', '" 
                    + nuevoInvitado.getApellidos() + "', '"
                    + nuevoInvitado.getBiografia() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(InvitadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean edit(Object o) {
        //Borrar el codigo de abajo
        for(int i = 0; i<listaInvitado.size();i++){
            if(listaInvitado.get(i).getId()==((Invitado)o).getId()){
            listaInvitado.set(i, (Invitado)o);
            return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        //Borrar el codigo de abajo
        for(int i = 0; i<listaInvitado.size();i++){
            if(listaInvitado.get(i).getId()==id){
            listaInvitado.remove(i);
            return true;
            }
        }
        return false;
    }
}
