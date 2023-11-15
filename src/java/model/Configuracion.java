/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sortizu
 */
public class Configuracion {
    private String nombrePagina;
    private String descripcionPagina;
    private String eslogan;

    public Configuracion(String nombrePagina, String descripcionPagina, String eslogan) {
        this.nombrePagina = nombrePagina;
        this.descripcionPagina = descripcionPagina;
        this.eslogan = eslogan;
    }

    public Configuracion() {
    }
    
    public String getNombrePagina() {
        return nombrePagina;
    }

    public void setNombrePagina(String nombrePagina) {
        this.nombrePagina = nombrePagina;
    }

    public String getDescripcionPagina() {
        return descripcionPagina;
    }

    public void setDescripcionPagina(String descripcionPagina) {
        this.descripcionPagina = descripcionPagina;
    }

    public String getEslogan() {
        return eslogan;
    }

    public void setEslogan(String eslogan) {
        this.eslogan = eslogan;
    }

    @Override
    public String toString() {
        return "Configuracion{" + "nombrePagina=" + nombrePagina + ", descripcionPagina=" + descripcionPagina + ", eslogan=" + eslogan + '}';
    }
    
}
