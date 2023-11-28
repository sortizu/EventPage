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
    private String idConfiguracion;
    private String parametro;
    private String valor;

    public Configuracion(String id_configuracion, String parametro, String valor) {
        this.idConfiguracion = id_configuracion;
        this.parametro = parametro;
        this.valor = valor;
    }

    public Configuracion() {
    }

    public String getIdConfiguracion() {
        return idConfiguracion;
    }

    public void setIdConfiguracion(String idConfiguracion) {
        this.idConfiguracion = idConfiguracion;
    }

    public String getParametro() {
        return parametro;
    }

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    

    @Override
    public String toString() {
        return "'id_configuracion'='" + idConfiguracion + 
               "', 'parametro'='" + parametro + 
               "', 'valor'='" + valor + "'";
    }
    
    
}
