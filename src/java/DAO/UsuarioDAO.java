/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import interfaces.CRUD;
import java.util.ArrayList;
import java.util.List;
import model.CategoriaEvento;
import model.Usuario;

/**
 *
 * @author sortizu
 */
public class UsuarioDAO implements CRUD {
    private static ArrayList<Usuario> listaUsuarios = new ArrayList<>();
    
    @Override
    public List listAll() {
        //Borrar el codigo de abajo
        return listaUsuarios;
    }

    @Override
    public Object list(int id) {
        for(int i = 0; i<listaUsuarios.size();i++){
            if(listaUsuarios.get(i).getId()==id){
             return listaUsuarios.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean add(Object o) {
        //Borrar el codigo de abajo
        Usuario nuevoUsuario = (Usuario)o;
        if(listaUsuarios.size()>0){
            nuevoUsuario.setId(listaUsuarios.get(listaUsuarios.size()-1).getId()+1);
        }
        listaUsuarios.add(nuevoUsuario);
        return true;
    }

    @Override
    public boolean edit(Object o) {
        //Borrar el codigo de abajo
        for(int i = 0; i<listaUsuarios.size();i++){
            if(listaUsuarios.get(i).getId()==((Usuario)o).getId()){
            listaUsuarios.set(i, (Usuario)o);
            return true;
            }
        }
        return false;
    }

    @Override
    public boolean delete(int id) {
        //Borrar el codigo de abajo
        for(int i = 0; i<listaUsuarios.size();i++){
            if(listaUsuarios.get(i).getId()==id){
            listaUsuarios.remove(i);
            return true;
            }
        }
        return false;
    }
}
