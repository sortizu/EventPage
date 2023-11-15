/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sortizu
 */
public class Carrito {
    private int id;
    private Usuario usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Carrito(int id, Usuario usuario) {
        this.id = id;
        this.usuario = usuario;
    }

    public Carrito() {
    }

    @Override
    public String toString() {
        return "Carrito{" + "id=" + id + ", usuario=" + usuario + '}';
    }
    
}
