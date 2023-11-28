/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import config.Conexion;
import debug.Console;
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

    @Override
    public List listAll() {
        //Borrar el codigo de abajo
        ArrayList<Usuario> usuarios = new ArrayList<>();

        try {
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM event_page.usuario WHERE eliminado=0");

            while (rs.next()) {
                Usuario newUsuario = new Usuario();
                newUsuario.setIdUsuario(rs.getInt("id_usuario"));
                newUsuario.setNombres(rs.getString("nombres"));
                newUsuario.setApellidos(rs.getString("apellidos"));
                newUsuario.setEmail(rs.getString("email"));
                newUsuario.setPassword(rs.getString("password"));
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
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM event_page.usuario WHERE eliminado=0 AND id_usuario=" + id);
            rs.next();
            Usuario nuevoUsuario = new Usuario();
            nuevoUsuario.setIdUsuario(rs.getInt("id_usuario"));
            nuevoUsuario.setNombres(rs.getString("nombres"));
            nuevoUsuario.setApellidos(rs.getString("apellidos"));
            nuevoUsuario.setEmail(rs.getString("email"));
            nuevoUsuario.setPassword(rs.getString("password"));
            nuevoUsuario.setDni(rs.getInt("dni"));
            nuevoUsuario.setAdmin(rs.getBoolean("admin"));
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }

    @Override
    public boolean add(Object o) {
        //Borrar el codigo de abajo
        Usuario nuevoUsuario = (Usuario) o;
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate("INSERT INTO event_page.usuario(nombres, apellidos, dni, email, password, admin,eliminado) VALUES "
                    + "('" + nuevoUsuario.getNombres() + "', '"
                    + nuevoUsuario.getApellidos() + "', '"
                    + nuevoUsuario.getDni() + "', '"
                    + nuevoUsuario.getEmail() + "', '"
                    + nuevoUsuario.getPassword() + "',"
                    + (nuevoUsuario.isAdmin() ? 1 : 0) + ","
                    + 0 + ")");
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    @Override
    public boolean edit(Object o) {
        Usuario usuarioEditar = (Usuario) o;
        try {
            String query = String.format(
                    "UPDATE event_page.usuario SET nombres='%s',apellidos='%s',dni=%d,email='%s',password='%s',admin=%d WHERE id_usuario=%d",
                    usuarioEditar.getNombres(),
                    usuarioEditar.getApellidos(),
                    usuarioEditar.getDni(),
                    usuarioEditar.getEmail(),
                    usuarioEditar.getPassword(),
                    usuarioEditar.isAdmin() ? 1 : 0,
                    usuarioEditar.getIdUsuario());

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
            String query = String.format(
                    "UPDATE event_page.usuario SET eliminado=%d WHERE id_usuario=%d", 1, id);

            Statement stmt = Conexion.getConnection().createStatement();
            stmt.executeUpdate(query);
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    public int validarUsuario(String correo, String pass) {
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(
                    String.format("SELECT * FROM event_page.usuario WHERE email='%s' AND password='%s' AND eliminado=0", correo, pass)
            );
            int id = -1;
            while (rs.next()) {
                id = rs.getInt("id_usuario");
            }
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public int validarAdmin(String correo, String pass) {
        try {
            Statement stmt = Conexion.getConnection().createStatement();
            ResultSet rs = stmt.executeQuery(
                    String.format("SELECT * FROM event_page.usuario WHERE email='%s' AND password='%s' AND eliminado=0 AND admin=%d", correo, pass, 1)
            );
            int id = -1;
            while (rs.next()) {
                id = rs.getInt("id_usuario");
            }
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }
}
