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
    private int id ;
    private String nombres;
    private String apellidos;
    private String biografia;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public Invitado(int id, String nombres, String apellidos, String biografia) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.biografia = biografia;
    }

    public Invitado() {
    }

    @Override
    public String toString() {
        return "'id_invitado'='" + id + "', 'nombres'='" + nombres + "', 'apellidos'='" + apellidos + "', 'biografia'='" + biografia+"'";
    }

    
}
