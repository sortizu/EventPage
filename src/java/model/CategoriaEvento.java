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
    private int idCategoriaEvento;
    private String nombreCategoria;
    private boolean eliminado;

    public CategoriaEvento(int idCategoriaEvento, String nombreCategoria, boolean eliminado) {
        this.idCategoriaEvento = idCategoriaEvento;
        this.nombreCategoria = nombreCategoria;
        this.eliminado = eliminado;
    }

    public CategoriaEvento() {
    }

    public int getIdCategoriaEvento() {
        return idCategoriaEvento;
    }

    public void setIdCategoriaEvento(int idCategoriaEvento) {
        this.idCategoriaEvento = idCategoriaEvento;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    

    @Override
    public String toString() {
        return "'id_categoria_evento'='" + idCategoriaEvento +
                "'eliminado'='" + eliminado +
                "', 'nombreCategoria'='" + nombreCategoria + "'";
    }
   
    
}
