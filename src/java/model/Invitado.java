/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sortizu
 */
public class Invitado{
    private int idInvitado;
    private String nombres;
    private String apellidos;
    private String biografia;
    private String imagenUrl;
    private boolean eliminado;

    public Invitado(int idInvitado, String nombres, String apellidos, String biografia, String imagenUrl, boolean eliminado) {
        this.idInvitado = idInvitado;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.biografia = biografia;
        this.imagenUrl = imagenUrl;
        this.eliminado = eliminado;
    }

    public Invitado() {
    }

    public int getIdInvitado() {
        return idInvitado;
    }

    public void setIdInvitado(int idInvitado) {
        this.idInvitado = idInvitado;
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

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    
    
    @Override
    public String toString() {
        return "'id_invitado'='" + idInvitado + 
               "', 'nombres'='" + nombres + 
               "', 'apellidos'='" + apellidos + 
                "', 'imagen_url'='" + imagenUrl + 
               "', 'biografia'='" + biografia+"'";
    }

    
}
