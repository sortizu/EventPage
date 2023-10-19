/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import interfaces.CRUD;
import java.util.ArrayList;
import java.util.List;
import model.Evento;
import model.Invitado;

/**
 *
 * @author sortizu
 */
public class InvitadoDAO implements CRUD {
    //Solucion temporal para probar interfaces
    private static ArrayList<Invitado> listaInvitado = new ArrayList<>();
    
    @Override
    public List listAll() {
        //Borrar el codigo de abajo
        return listaInvitado;
    }

    @Override
    public Object list(int id) {
        //Borrar el codigo de abajo
        for(int i = 0; i<listaInvitado.size();i++){
            if(listaInvitado.get(i).getId()==id){
             return listaInvitado.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean add(Object o) {
        //Borrar el codigo de abajo
        Invitado nuevoInvitado = (Invitado)o;
        if(listaInvitado.size()>0){
            nuevoInvitado.setId(listaInvitado.get(listaInvitado.size()-1).getId()+1);
        }
        listaInvitado.add(nuevoInvitado);
        return true;
    }

    @Override
    public boolean edit(Object o) {
        //Borrar el codigo de abajo
        for(int i = 0; i<listaInvitado.size();i++){
            if(listaInvitado.get(i).getId()==((Invitado)o).getId()){
            listaInvitado.set(i, (Invitado)o);
            return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        //Borrar el codigo de abajo
        for(int i = 0; i<listaInvitado.size();i++){
            if(listaInvitado.get(i).getId()==id){
            listaInvitado.remove(i);
            return true;
            }
        }
        return false;
    }
}
