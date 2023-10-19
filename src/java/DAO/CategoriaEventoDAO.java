/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import interfaces.CRUD;
import java.util.ArrayList;
import java.util.List;
import model.CategoriaEvento;

/**
 *
 * @author sortizu
 */
public class CategoriaEventoDAO implements CRUD {

    private static ArrayList<CategoriaEvento> listaCategoriaEventos = new ArrayList<>();
    
    @Override
    public List listAll() {
        //Borrar el codigo de abajo
        return listaCategoriaEventos;
    }

    @Override
    public Object list(int id) {
        for(int i = 0; i<listaCategoriaEventos.size();i++){
            if(listaCategoriaEventos.get(i).getId()==id){
             return listaCategoriaEventos.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean add(Object o) {
        //Borrar el codigo de abajo
        CategoriaEvento nuevaCategoriaEvento = (CategoriaEvento)o;
        if(listaCategoriaEventos.size()>0){
            nuevaCategoriaEvento.setId(listaCategoriaEventos.get(listaCategoriaEventos.size()-1).getId()+1);
        }
        listaCategoriaEventos.add(nuevaCategoriaEvento);
        return true;
    }

    @Override
    public boolean edit(Object o) {
        //Borrar el codigo de abajo
        for(int i = 0; i<listaCategoriaEventos.size();i++){
            if(listaCategoriaEventos.get(i).getId()==((CategoriaEvento)o).getId()){
            listaCategoriaEventos.set(i, (CategoriaEvento)o);
            return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        //Borrar el codigo de abajo
        for(int i = 0; i<listaCategoriaEventos.size();i++){
            if(listaCategoriaEventos.get(i).getId()==id){
            listaCategoriaEventos.remove(i);
            return true;
            }
        }
        return false;
    }
    
}
