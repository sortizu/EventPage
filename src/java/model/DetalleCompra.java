/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author sortizu
 */
public class DetalleCompra {
    private int idDetalleCompra;
    private int idCompra;
    private int idEvento;

    public DetalleCompra(int idDetalleCompra, int idCompra, int idEvento) {
        this.idDetalleCompra = idDetalleCompra;
        this.idCompra = idCompra;
        this.idEvento = idEvento;
    }

    public DetalleCompra() {
    }

    public int getIdDetalleCompra() {
        return idDetalleCompra;
    }

    public void setIdDetalleCompra(int idDetalleCompra) {
        this.idDetalleCompra = idDetalleCompra;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    @Override
    public String toString() {
        return "{\"id_detalle_compra\":\"" + idDetalleCompra + 
               "\", \"id_compra\":\"" + idCompra + 
               "\", \"id_evento\":\"" + idEvento + "\"}";
    }

    
    
}
