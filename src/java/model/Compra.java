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
public class Compra {
    private int idCompra;
    private int idTarjeta;
    private int idUsuario;
    private LocalDateTime fechaDeCompra;
    private boolean pendiente;

    public Compra(int idCompra, int idTarjeta, int idUsuario, LocalDateTime fechaDeCompra, boolean pendiente) {
        this.idCompra = idCompra;
        this.idTarjeta = idTarjeta;
        this.idUsuario = idUsuario;
        this.fechaDeCompra = fechaDeCompra;
        this.pendiente = pendiente;
    }

    public Compra() {
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdTarjeta() {
        return idTarjeta;
    }

    public void setIdTarjeta(int idTarjeta) {
        this.idTarjeta = idTarjeta;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public LocalDateTime getFechaDeCompra() {
        return fechaDeCompra;
    }

    public void setFechaDeCompra(LocalDateTime fechaDeCompra) {
        this.fechaDeCompra = fechaDeCompra;
    }

    public boolean isPendiente() {
        return pendiente;
    }

    public void setPendiente(boolean pendiente) {
        this.pendiente = pendiente;
    }

    @Override
    public String toString() {
        return "{\"id_compra\":\"" + idCompra+
               "\", \"id_tarjeta\":\"" + idTarjeta + 
               "\", \"id_usuario\":\"" + idUsuario + 
                "\", \"pendiente\":\"" + pendiente + 
               "\", \"fecha_compra\":\"" + fechaDeCompra + "\"}";
    }
    
}
