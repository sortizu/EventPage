/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sortizu
 */
public class Ticket {
    private int id;
    private Evento evento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public Ticket(int id, Evento evento) {
        this.id = id;
        this.evento = evento;
    }

    public Ticket() {
    }

    @Override
    public String toString() {
        return "Ticket{" + "id=" + id + ", evento=" + evento + '}';
    }
    
    
}
