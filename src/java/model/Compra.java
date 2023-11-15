/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalDateTime;

/**
 *
 * @author sortizu
 */
public class Compra {
    private int id;
    private Ticket ticket;
    private Tarjeta tarjeta;
    private LocalDateTime fechaDeCompra;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public LocalDateTime getFechaDeCompra() {
        return fechaDeCompra;
    }

    public void setFechaDeCompra(LocalDateTime fechaDeCompra) {
        this.fechaDeCompra = fechaDeCompra;
    }

    public Compra(int id,  Ticket ticket, Tarjeta tarjeta, LocalDateTime fechaDeCompra) {
        this.id = id;
        this.ticket = ticket;
        this.tarjeta = tarjeta;
        this.fechaDeCompra = fechaDeCompra;
    }

    public Compra() {
    }

    @Override
    public String toString() {
        return "Compra{" + "id=" + id +" ticket=" + ticket + ", tarjeta=" + tarjeta + ", fechaDeCompra=" + fechaDeCompra + '}';
    }
    
}
