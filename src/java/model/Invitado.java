/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sortizu
 */
public class Invitado extends Persona {
    private String biografia;

    public String getBiografia() {
        return biografia;
    }

    public void setBiografia(String biografia) {
        this.biografia = biografia;
    }

    public Invitado(String biografia, int id, String nombres, String apellidos) {
        super(id, nombres, apellidos);
        this.biografia = biografia;
    }

    public Invitado() {
    }

    @Override
    public String toString() {
        return  "'id_invitado'='"+ getId()+
                "', 'nombre_invitado'='"+getNombres()+
                "', 'apellido_invitado'='"+getApellidos()+
                "', 'biografia'='" + biografia + "'";
    }

 
    
}
