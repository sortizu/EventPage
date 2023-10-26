/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sortizu
 */
public class CategoriaEvento {
    private int id;
    private String nombreCategoria;

    public CategoriaEvento(int id, String nombreCategoria) {
        this.id = id;
        this.nombreCategoria = nombreCategoria;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public CategoriaEvento() {
    }

    @Override
    public String toString() {
        return "CategoriaEvento{" + "id=" + id + ", nombreCategoria=" + nombreCategoria + '}';
    }
   
    
}
