/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import interfaces.CRUD;
import java.util.ArrayList;
import java.util.List;
import model.Evento;

/**
 *
 * @author sortizu
 */
public class EventoDAO implements CRUD {
    
    //Solucion temporal para probar interfaces
    private static ArrayList<Evento> listaEvento = new ArrayList<>();
    
    @Override
    public List listAll() {
        //Borrar el codigo de abajo
        return listaEvento;
    }

    @Override
    public Object list(int id) {
        //Borrar el codigo de abajo
        return null;
    }

    @Override
    public boolean add(Object o) {
        //Borrar el codigo de abajo
        Evento nuevoEvento = (Evento)o;
        if(listaEvento.size()>0){
            nuevoEvento.setId(listaEvento.get(listaEvento.size()-1).getId()+1);
        }
        listaEvento.add(nuevoEvento);
        return true;
    }

    @Override
    public boolean edit(Object o) {
        //Borrar el codigo de abajo
        for(int i = 0; i<listaEvento.size();i++){
            if(listaEvento.get(i).getId()==((Evento)o).getId()){
            listaEvento.set(i, (Evento)o);
            return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        //Borrar el codigo de abajo
        for(int i = 0; i<listaEvento.size();i++){
            if(listaEvento.get(i).getId()==id){
            listaEvento.remove(i);
            return true;
            }
        }
        return false;
    }
    
}
