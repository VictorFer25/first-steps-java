/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionarLibros;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Yovii
 */
public class Autor {

    public String ID,nombre, primer_apellido, segundo_apellido;
 
    public ResultSet rs;
    CRUDAutores au;

    public Autor() {
        au = new CRUDAutores();
    }

    public void setID(String id) {
        this.ID = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrimerApellido(String primer) {
        this.primer_apellido = primer;
    }

    public void setSegundoApellido(String segundo) {
        this.segundo_apellido = segundo;
    }

    public String getID() {
        return ID;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrimerApellido() {
        return primer_apellido;
    }

    public String getSegundoApellido() {
        return segundo_apellido;
    }

    public ResultSet getListaAutores() {

        rs = au.selectXtodas();
        return rs;

    }

    public void cambiarMayuscula() {

        this.nombre = nombre.toUpperCase();
        this.primer_apellido = primer_apellido.toUpperCase();
        this.segundo_apellido = segundo_apellido.toUpperCase();

    }

    public boolean agregarAutor() {

        if (au.agregar(this.getNombre(), this.getPrimerApellido(), this.getSegundoApellido())) {
            return true;
        }

        return false;
    }

    public boolean actualizarAutor() {

        if (au.actualizarAutor(this.getID(), this.getNombre(), this.getPrimerApellido(), this.getSegundoApellido())) {
            return true;
        }

        return false;
    }

    public boolean verficarAutor() {

        rs = au.verificar(this.getNombre(), this.getPrimerApellido());
        boolean resultado = false;
        try {
            resultado = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return resultado;

    }

    public boolean eliminarAutor() {
        boolean resultado = false;
        resultado = au.eliminarAutor(this.getID());
        return resultado;
    }

    public boolean verificarRelacionLibro() {

        rs = au.verificarRelacionLibro(this.getID());
        boolean resultado = false;
        try {
            resultado = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return resultado;
    }

    public ResultSet buscarPorID() {
        
        rs = au.buscarPorID(this.getID());
        return rs;
    }

    public ResultSet buscarPorNombre() {
       
        rs = au.buscarPorNombre(this.getNombre());
        return rs;
    }

    public ResultSet buscarPorPrimerApellido() {
      
        rs = au.buscarPorPrimerApellido(this.getPrimerApellido());
        return rs;
    }
  public ResultSet buscarPorNombreEnLibro() {
       
        rs = au.buscarPorNombreEnLibro(this.getNombre());
        return rs;
    }
}
