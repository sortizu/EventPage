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
import model.Compra;
import model.Tarjeta;
import model.Usuario;

/**
 *
 * @author sortizu
 */
public class TarjetaDAO implements CRUD {

    @Override
    public List listAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object list(int id) {
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM event_page.tarjeta WHERE id_tarjeta=" + id);
            rs.next();
            Tarjeta nuevaTarjeta = new Tarjeta();
            nuevaTarjeta.setIdTarjeta(rs.getInt("id_tarjeta"));
            nuevaTarjeta.setNombrePropietario(rs.getString("nombre_propietario"));
            nuevaTarjeta.setNumeroTarjeta(rs.getString("numero_tarjeta"));
            nuevaTarjeta.setFechaDeVencimiento(rs.getDate("fecha_vencimiento").toLocalDate());
            nuevaTarjeta.setIdUsuario(rs.getInt("id_usuario"));
            return nuevaTarjeta;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public boolean add(Object o) {
       Tarjeta nuevaTarjeta = (Tarjeta)o;
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate(
          String.format("INSERT INTO event_page.tarjeta(nombre_propietario,numero_tarjeta,id_usuario,fecha_vencimiento,eliminado) VALUES ('%s','%s','%d','%s','0')",
                  nuevaTarjeta.getNombrePropietario(),
                  nuevaTarjeta.getNumeroTarjeta(),
                  nuevaTarjeta.getIdUsuario(),
                  nuevaTarjeta.getFechaDeVencimiento()));
            
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false; 
    }

    @Override
    public boolean edit(Object o) {
        Tarjeta tarjeta = (Tarjeta)o;
        try {
            String query = String.format(
                    "UPDATE event_page.tarjeta SET "+
                    "nombre_propietario='%s',"+
                    "numero_tarjeta=%s,"+
                    "fecha_vencimiento='%s',"+
                    "eliminado=%d"+
                    " WHERE id_tarjeta=%d",
                    tarjeta.getNombrePropietario(),
                    tarjeta.getNumeroTarjeta(),
                    tarjeta.getFechaDeVencimiento(),
                    tarjeta.isEliminado()?1:0,
                    tarjeta.getIdTarjeta());
            Statement stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate(query);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
try {
            String query = String.format(
                    "UPDATE event_page.tarjeta SET "+
                    "eliminado=1"+
                    " WHERE id_tarjeta=%d",
                    id);
            Statement stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate(query);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }
    
    public ArrayList<Tarjeta> cargarTarjetasDeUsuario(int id){
        try {
            ArrayList<Tarjeta> tarjetasDeUsuario = new ArrayList<Tarjeta>();
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM event_page.tarjeta WHERE id_usuario=" + id+" AND eliminado=0");
            while(rs.next()){
            Tarjeta nuevaTarjeta = new Tarjeta();
            nuevaTarjeta.setIdTarjeta(rs.getInt("id_tarjeta"));
            nuevaTarjeta.setNombrePropietario(rs.getString("nombre_propietario"));
            nuevaTarjeta.setNumeroTarjeta(rs.getString("numero_tarjeta"));
            nuevaTarjeta.setFechaDeVencimiento(rs.getDate("fecha_vencimiento").toLocalDate());
            nuevaTarjeta.setIdUsuario(rs.getInt("id_usuario"));
            tarjetasDeUsuario.add(nuevaTarjeta);
            }
            return tarjetasDeUsuario;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
