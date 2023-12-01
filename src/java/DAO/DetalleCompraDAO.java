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
import model.Evento;
import model.DetalleCompra;

/**
 *
 * @author sortizu
 */
public class DetalleCompraDAO implements CRUD {

    @Override
    public List listAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object list(int id) {
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM event_page.detalle_compra WHERE id_detalle_compra=" + id);
            rs.next();
            DetalleCompra nuevoDetalleCompra = new DetalleCompra();
            nuevoDetalleCompra.setIdDetalleCompra(rs.getInt("id_detalle_compra"));
            nuevoDetalleCompra.setIdCompra(rs.getInt("id_compra"));
            nuevoDetalleCompra.setIdEvento(rs.getInt("id_evento"));
            return nuevoDetalleCompra;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public boolean add(Object o) {
        try {
            DetalleCompra detalleCompra = (DetalleCompra)o;
            Statement stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate(
          String.format("INSERT INTO event_page.detalle_compra(id_compra,id_evento) VALUES (%d,%d)",
                  detalleCompra.getIdCompra(),
                  detalleCompra.getIdEvento()));
            return true;
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

    @Override
    public boolean edit(Object o) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean delete(int id) {
        try {
            String query = String.format(
                    "DELETE FROM event_page.detalle_compra WHERE id_detalle_compra=%d", id);

            Statement stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(InvitadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
    
    public ArrayList<DetalleCompra> cargarDetallesDeCompra(int idCompra){
    try {
            ArrayList<DetalleCompra> listaDetalleCompras=new ArrayList<>();
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM event_page.detalle_compra WHERE id_compra=" + idCompra);
            while(rs.next()){
            DetalleCompra nuevoDetalleCompra = new DetalleCompra();
            nuevoDetalleCompra.setIdDetalleCompra(rs.getInt("id_detalle_compra"));
            nuevoDetalleCompra.setIdCompra(rs.getInt("id_compra"));
            nuevoDetalleCompra.setIdEvento(rs.getInt("id_evento"));
            listaDetalleCompras.add(nuevoDetalleCompra);
            }
            return listaDetalleCompras;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}
