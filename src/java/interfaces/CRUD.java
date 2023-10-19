/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package interfaces;

import java.util.List;

/**
 *
 * @author sortizu
 */
public interface CRUD {
    public List listAll();
    public Object list(int id);
    public boolean add(Object o);
    public boolean edit(Object o);
    public boolean delete(int id);
}
