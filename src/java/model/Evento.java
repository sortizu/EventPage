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
    private int id;
    private String nombreEvento;
    private double costo;
    private LocalDateTime fecha;
    private int capacidad;
    private CategoriaEvento categoria;
    private String descripcion;
    private Invitado invitado;
    private boolean destacado;
    
    public Evento() {
    }
    
    public Evento(int id, String nombreEvento, double costo, LocalDateTime fecha, int capacidad, CategoriaEvento categoria, String descripcion) {
        this.id = id;
        this.nombreEvento = nombreEvento;
        this.costo = costo;
        this.fecha = fecha;
        this.capacidad = capacidad;
        this.categoria = categoria;
        this.descripcion = descripcion;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public CategoriaEvento getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaEvento categoria) {
        this.categoria = categoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Invitado getInvitado() {
        return invitado;
    }

    public void setInvitado(Invitado invitado) {
        this.invitado = invitado;
    }

    public boolean isDestacado() {
        return destacado;
    }

    public void setDestacado(boolean destacado) {
        this.destacado = destacado;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EE dd MMM '-' HH:mm a", new Locale("es", "ES"));
        return "'id_evento'='" + id 
           + "', 'nombreEvento'='" + nombreEvento 
           + "', 'costo'='" + costo 
           + "', 'fecha'='" + fecha.format(formatter)
           + "', 'capacidad'='" + capacidad 
           + "', " + categoria 
           + ", 'descripcion'='" + descripcion 
           + "', " + invitado 
           + ", 'destacado'='" + destacado + "'";
    }
    

}
