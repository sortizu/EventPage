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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Compra;
import model.Tarjeta;
import model.DetalleCompra;
import model.Usuario;

/**
 *
 * @author sortizu
 */
public class CompraDAO implements CRUD {

    @Override
    public List listAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object list(int id) {
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM event_page.compra WHERE id_compra=" + id);
            rs.next();
            Compra nuevaCompra = new Compra();
                nuevaCompra.setIdCompra(rs.getInt("id_compra"));
                nuevaCompra.setFechaDeCompra(rs.getTimestamp("fecha_compra").toLocalDateTime());
                nuevaCompra.setIdTarjeta(rs.getInt("id_tarjeta"));
                nuevaCompra.setIdUsuario(rs.getInt("id_usuario"));
            return nuevaCompra;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public boolean add(Object o) {
        try {
            Compra nuevaCompra = (Compra) o;
            Statement stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate(
                    String.format(
                            "INSERT INTO event_page.compra(id_usuario,id_tarjeta,fecha_compra,pendiente) VALUES (%d,%d,'%s',%d)",
                            nuevaCompra.getIdUsuario(),
                            nuevaCompra.getIdTarjeta(),
                            nuevaCompra.getFechaDeCompra(),
                            (nuevaCompra.isPendiente() ? 1 : 0)
                    )
            );
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean edit(Object o) {
        Compra compra = (Compra)o;
        try {
            String query = String.format(
                    "UPDATE event_page.compra SET "+
                    "id_tarjeta=%d,"+
                    "fecha_compra='%s',"+
                    "pendiente=%d,"+
                    "id_usuario=%d"+
                    " WHERE id_compra=%d",
                    compra.getIdTarjeta(),
                    compra.getFechaDeCompra(),
                    compra.isPendiente()?1:0,
                    compra.getIdUsuario(),
                    compra.getIdCompra());
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
            Statement stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate("DROP FROM compra WHERE id_compra= " + id);
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public double obtenerIngresosPorFecha() {
        double ingresos = 0;
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            //ResultSet rs = stmt.executeQuery("SELECT * FROM compras WHERE fecha_compra = '" + fecha + "'");
        } catch (Exception e) {
        }
        return ingresos;
    }

    /*
    public List<Compra> obtenerComprasPorFecha(LocalDateTime fecha){
        try {
            List<Compra> comprasDeFecha = new ArrayList<Compra>();
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM compras WHERE fecha_compra = '" + fecha + "'");
            TicketDAO ticketDAO = new TicketDAO();
            TarjetaDAO tarjetaDAO = new TarjetaDAO();
            while (rs.next()) {
                Compra nuevaCompra = new Compra();
                nuevaCompra.setId(rs.getInt("id_compra"));
                nuevaCompra.setFechaDeCompra(rs.getTimestamp("fecha_compra").toLocalDateTime());
                nuevaCompra.setTicket((Ticket)ticketDAO.list(rs.getInt("id_ticket")));
                nuevaCompra.setTarjeta((Tarjeta)tarjetaDAO.list(rs.getInt("id_tarjeta")));
                comprasDeFecha.add(nuevaCompra);
            }
            return comprasDeFecha;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }*/

    //Agrega un registro de compra sin fecha ni tarjeta que funciona como un carrito compras
    public boolean agregarCompraPendiente(int idUsuario) {
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate(
                    String.format("INSERT INTO event_page.compra(id_usuario,pendiente) VALUES ('%d',1)", idUsuario));
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    public int obtenerIdCompraPendiente(int idUsuario) {
        int id = -1;
        try {
            String query = String.format("SELECT id_compra FROM compra WHERE id_usuario= %d AND pendiente = 1", idUsuario);
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            id = rs.getInt("id_compra");
        } catch (Exception e) {
            System.out.println(e);
        }
        return id;
    }

    public int obtenerIdUltimaCompra(int idUsuario) {
        int id = -1;
        try {
            String query = String.format("SELECT id_compra FROM compra WHERE id_usuario= %d ORDER BY id_compra DESC", idUsuario);
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(query);
            rs.next();
            id = rs.getInt("id_compra");
        } catch (Exception e) {
            System.out.println(e);
        }
        return id;
    }
    
    public ArrayList<Compra> cargarComprasDeUsuario(int idUsuario){
    try {
            ArrayList<Compra> comprasDeUsuario = new ArrayList<Compra>();
            Statement stmt = Conexion.getConnection().createStatement();
            String query = String.format(
            "SELECT * FROM event_page.compra WHERE id_usuario =%d AND pendiente=0",
            idUsuario
            );
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Compra nuevaCompra = new Compra();
                nuevaCompra.setIdCompra(rs.getInt("id_compra"));
                nuevaCompra.setFechaDeCompra(rs.getTimestamp("fecha_compra").toLocalDateTime());
                nuevaCompra.setIdTarjeta(rs.getInt("id_tarjeta"));
                nuevaCompra.setIdUsuario(rs.getInt("id_usuario"));
                comprasDeUsuario.add(nuevaCompra);
            }
            return comprasDeUsuario;
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
