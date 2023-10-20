/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import config.Conexion;
import static config.Conexion.con;
import static config.Conexion.stmt;
import interfaces.CRUD;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.CategoriaEvento;
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
            Conexion.rs = Conexion.stmt.executeQuery("SELECT * FROM event_page.usuario");
            Conexion.rs.next();
            do{
                //System.out.println(Conexion.rs.getString("id")+" "+Conexion.rs.getString("nombre"));
                Usuario newUsuario = new Usuario();
                newUsuario.setId(Conexion.rs.getInt("id_usuario"));
                newUsuario.setNombres(Conexion.rs.getString("nombres"));
                newUsuario.setApellidos(Conexion.rs.getString("apellidos"));
                newUsuario.setEmail(Conexion.rs.getString("correo"));
                newUsuario.setPassword(Conexion.rs.getString("contraseña"));
                newUsuario.setDni(Conexion.rs.getInt("dni"));
                newUsuario.setAdmin(Conexion.rs.getBoolean("admin"));
                usuarios.add(newUsuario);
                
            } while (Conexion.rs.next());
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
            Conexion.stmt = Conexion.con.createStatement();
            Conexion.stmt.executeUpdate("INSERT INTO event_page.usuario(nombres, apellidos, dni, correo, contraseña, admin) VALUES "
                    + "('" + nuevoUsuario.getNombres() + "', '" 
                    + nuevoUsuario.getApellidos() + "', '"
                    + nuevoUsuario.getDni() + "', '"
                    + nuevoUsuario.getEmail() + "', '"
                    + nuevoUsuario.getPassword() + "', '"
                    + (nuevoUsuario.isAdmin()?1:0) + "')");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean edit(Object o) {
        //Borrar el codigo de abajo
        for(int i = 0; i<listaUsuarios.size();i++){
            if(listaUsuarios.get(i).getId()==((Usuario)o).getId()){
            listaUsuarios.set(i, (Usuario)o);
            return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        //Borrar el codigo de abajo
        for(int i = 0; i<listaUsuarios.size();i++){
            if(listaUsuarios.get(i).getId()==id){
            listaUsuarios.remove(i);
            return true;
            }
        }
        return false;
    }
}
