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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Compra;
import model.Tarjeta;
import model.Ticket;
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
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean add(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean edit(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
}
