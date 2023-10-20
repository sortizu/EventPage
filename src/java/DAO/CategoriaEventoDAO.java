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
            Conexion.rs = Conexion.stmt.executeQuery("SELECT * FROM event_page.categoriaevento");
            Conexion.rs.next();
            do{
                CategoriaEvento newCategoria = new CategoriaEvento();
                newCategoria.setId(Conexion.rs.getInt("id_catevento"));
                newCategoria.setNombreCategoria(Conexion.rs.getString("nombre_catevento"));
                categorias.add(newCategoria);
                
            } while (Conexion.rs.next());
        } catch (SQLException ex) {
            Logger.getLogger(CategoriaEventoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return categorias;
    }

    @Override
    public Object list(int id) {
      
        
        try {
            Statement stmt = Conexion.con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM event_page.categoriaevento WHERE id_catevento = " + id);
            rs.next();
            
            CategoriaEvento newCategoria = new CategoriaEvento();
            newCategoria.setId(rs.getInt("id_catevento"));
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
            Conexion.stmt = Conexion.con.createStatement();
            Conexion.stmt.executeUpdate("INSERT INTO event_page.categoriaevento(nombre_catevento) VALUES "
                    + "('" + nuevaCategoria.getNombreCategoria() + "')");
        } catch (SQLException ex) {
            Logger.getLogger(InvitadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean edit(Object o) {
        //Borrar el codigo de abajo
        for(int i = 0; i<listaCategoriaEventos.size();i++){
            if(listaCategoriaEventos.get(i).getId()==((CategoriaEvento)o).getId()){
            listaCategoriaEventos.set(i, (CategoriaEvento)o);
            return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        //Borrar el codigo de abajo
        for(int i = 0; i<listaCategoriaEventos.size();i++){
            if(listaCategoriaEventos.get(i).getId()==id){
            listaCategoriaEventos.remove(i);
            return true;
            }
        }
        return false;
    }
    
}
