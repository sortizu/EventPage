/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 *
 * @author sortizu
 */
public class Evento {
    private int idEvento;
    private String nombreEvento;
    private double costo;
    private LocalDateTime fecha;
    private int capacidad;
    private int idCategoriaEvento;
    private String descripcion;
    private int idInvitado;
    private boolean destacado;
    private boolean eliminado;
    private String imagenUrl;

    public Evento(int idEvento, String nombreEvento, double costo, LocalDateTime fecha, int capacidad, int idCategoriaEvento, String descripcion, int idInvitado, boolean destacado, boolean eliminado, String imagenUrl) {
        this.idEvento = idEvento;
        this.nombreEvento = nombreEvento;
        this.costo = costo;
        this.fecha = fecha;
        this.capacidad = capacidad;
        this.idCategoriaEvento = idCategoriaEvento;
        this.descripcion = descripcion;
        this.idInvitado = idInvitado;
        this.destacado = destacado;
        this.eliminado = eliminado;
        this.imagenUrl = imagenUrl;
    }

    public Evento() {
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public String getNombreEvento() {
        return nombreEvento;
    }

    public void setNombreEvento(String nombreEvento) {
        this.nombreEvento = nombreEvento;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

    public int getIdCategoriaEvento() {
        return idCategoriaEvento;
    }

    public void setIdCategoriaEvento(int idCategoriaEvento) {
        this.idCategoriaEvento = idCategoriaEvento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getIdInvitado() {
        return idInvitado;
    }

    public void setIdInvitado(int idInvitado) {
        this.idInvitado = idInvitado;
    }

    public boolean isDestacado() {
        return destacado;
    }

    public void setDestacado(boolean destacado) {
        this.destacado = destacado;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }

    

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EE dd MMM '-' HH:mm a", new Locale("es", "ES"));
        return "{\"id_evento\":\"" + idEvento 
           + "\", \"nombre_evento\":\"" + nombreEvento 
           + "\", \"costo\":\"" + costo 
           + "\", \"fecha\":\"" + fecha.format(formatter)
           + "\", \"capacidad\":\"" + capacidad 
           + "\", \"id_categoria_evento\":\"" + idCategoriaEvento 
           + "\", \"descripcion\":\"" + descripcion 
           + "\", \"id_invitado\":\"" + idInvitado
           + "\", \"imagen_url\":\"" + imagenUrl
           + "\", \"destacado\":\"" + destacado + "\"}";
    }
    

}
