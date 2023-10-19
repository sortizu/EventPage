/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import interfaces.MetodoPago;
import java.util.ArrayList;

/**
 *
 * @author sortizu
 */
public class Usuario extends Persona{
    private String email;
    private String password;
    private long dni;
    private boolean admin;
    private ArrayList<Ticket> tickets;
    private ArrayList<MetodoPago> metodosPago;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public ArrayList<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }

    public ArrayList<MetodoPago> getMetodosPago() {
        return metodosPago;
    }

    public void setMetodosPago(ArrayList<MetodoPago> metodosPago) {
        this.metodosPago = metodosPago;
    }

    public boolean isAdmin() {
        return admin;
    }

    public void setAdmin(boolean admin) {
        this.admin = admin;
    }
    
}
