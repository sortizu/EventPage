/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 *
 * @author sortizu
 */
public class Tarjeta {
    private int id;
    private String nombrePropietario;
    private String numeroTarjeta;
    private LocalDate fechaDeVencimiento;
    private Usuario usuario;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public LocalDate getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public void setFechaDeVencimiento(LocalDate fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tarjeta(int id, String nombrePropietario, String numeroTarjeta, LocalDate fechaDeVencimiento, Usuario usuario) {
        this.id = id;
        this.nombrePropietario = nombrePropietario;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.usuario = usuario;
    }

    public Tarjeta() {
    }

    @Override
    public String toString() {
        return "Tarjeta{" + "id=" + id + ", nombrePropietario=" + nombrePropietario + ", numeroTarjeta=" + numeroTarjeta + ", fechaDeVencimiento=" + fechaDeVencimiento + ", usuario=" + usuario + '}';
    }
    
}
