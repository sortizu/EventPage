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
    private int idTarjeta;
    private String nombrePropietario;
    private String numeroTarjeta;
    private LocalDate fechaDeVencimiento;
    private int idUsuario;
    private boolean eliminado;

    public Tarjeta(int idTarjeta, String nombrePropietario, String numeroTarjeta, LocalDate fechaDeVencimiento, int idUsuario, boolean eliminado) {
        this.idTarjeta = idTarjeta;
        this.nombrePropietario = nombrePropietario;
        this.numeroTarjeta = numeroTarjeta;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.idUsuario = idUsuario;
        this.eliminado = eliminado;
    }

    public Tarjeta() {
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
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

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public boolean isEliminado() {
        return eliminado;
    }

    public void setEliminado(boolean eliminado) {
        this.eliminado = eliminado;
    }


    @Override
    public String toString() {
        return "{\"id_tarjeta\":\"" + idTarjeta + 
               "\", \"nombre_propietario\":\"" + nombrePropietario + 
               "\", \"numero_tarjeta\":\"" + numeroTarjeta + 
               "\", \"fecha_vencimiento\":\"" + fechaDeVencimiento + 
                "\", \"eliminado\":\"" + eliminado + 
               "\", \"id_usuario\":\"" + idUsuario+"\"}";
    }
    
}
