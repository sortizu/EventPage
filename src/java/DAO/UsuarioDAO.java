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
import model.Usuario;

/**
 *
 * @author sortizu
 */
public class UsuarioDAO implements CRUD {
    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    
    @Override
    public List listAll() {
        //Borrar el codigo de abajo
        ArrayList<Usuario> usuarios = new ArrayList<>();
        
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM event_page.usuario WHERE eliminado=0");
            
            while (rs.next()) {
                Usuario newUsuario = new Usuario();
                newUsuario.setId(rs.getInt("id_usuario"));
                newUsuario.setNombres(rs.getString("nombres"));
                newUsuario.setApellidos(rs.getString("apellidos"));
                newUsuario.setEmail(rs.getString("correo"));
                newUsuario.setPassword(rs.getString("contraseña"));
                newUsuario.setDni(rs.getInt("dni"));
                newUsuario.setAdmin(rs.getBoolean("admin"));
                usuarios.add(newUsuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
            
        return usuarios;
    }

    @Override
    public Object list(int id) {
        for(int i = 0; i<listaUsuarios.size();i++){
            if(listaUsuarios.get(i).getId()==id){
             return listaUsuarios.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean add(Object o) {
        //Borrar el codigo de abajo
        Usuario nuevoUsuario = (Usuario)o;
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate("INSERT INTO event_page.usuario(nombres, apellidos, dni, correo, contraseña, admin,eliminado) VALUES "
                    + "('" + nuevoUsuario.getNombres() + "', '" 
                    + nuevoUsuario.getApellidos() + "', '"
                    + nuevoUsuario.getDni() + "', '"
                    + nuevoUsuario.getEmail() + "', '"
                    + nuevoUsuario.getPassword() + "',"
                    + (nuevoUsuario.isAdmin()?1:0) + ","
                    + 0 + ")");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean edit(Object o) {
        Usuario usuarioEditar = (Usuario)o;
        try {
            String query=String.format(
              "UPDATE event_page.usuario SET nombres='%s',apellidos='%s',dni=%d,correo='%s',contraseña='%s',admin=%d WHERE id_usuario=%d",
            usuarioEditar.getNombres(),
            usuarioEditar.getApellidos(),
            usuarioEditar.getDni(),
            usuarioEditar.getEmail(),
            usuarioEditar.getPassword(),
            usuarioEditar.isAdmin()?1:0,
            usuarioEditar.getId());
            
            Statement stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean delete(int id) {
        try {
            String query=String.format(
              "UPDATE event_page.usuario SET eliminado=%d WHERE id_usuario=%d",1,id);
            
            Statement stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }
}
