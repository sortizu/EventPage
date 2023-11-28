/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;

/**
 *
 * @author sortizu
 */
public class Usuario{
    private int idUsuario;
    private String nombres;
    private String apellidos;
    private String email;
    private String password;
    private long dni;
    private boolean admin;
    private boolean eliminado;
    private LocalDate fechaCreacion;

    public Usuario(int idUsuario, String nombres, String apellidos, String email, String password, long dni, boolean admin, boolean eliminado, LocalDate fechaCreacion) {
        this.idUsuario = idUsuario;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.email = email;
        this.password = password;
        this.dni = dni;
        this.admin = admin;
        this.eliminado = eliminado;
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario() {
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public LocalDate getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDate fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    

    

    @Override
    public String toString() {
        return "'id_usuario'='" + idUsuario + 
               "', 'nombres'='" + nombres + 
               "', 'apellidos'='" + apellidos + 
               "', 'email'='" + email + 
               "', 'password'='" + password + 
               "', 'dni'='" + dni + 
               "', 'admin'='" + admin +
                "', 'eliminado'='" + eliminado +
               "', 'fecha_creacion'='" + fechaCreacion  + "'";
    }

    
    
}
