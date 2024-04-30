/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionarPersonal;

import GestionarLibros.*;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Yoviicttoorr
 */
public class c_gestionarPersonal {

    private ResultSet listaPersonal;
    private i_gestionarPersonal igp;
    private E_Personal per;

    public c_gestionarPersonal() {
        this.per = new E_Personal();
        this.listaPersonal = per.getListaPersonal();
    }

    public void setGestionarPersonal(i_gestionarPersonal personal) {
        this.igp = personal;
    }
    public ResultSet getListaPersonal(){
        this.listaPersonal = this.per.getListaPersonal();
        return this.listaPersonal;
    }

    public void prepararInterfaz() {
        this.igp = new i_gestionarPersonal();
        this.igp.mostrarListaPersonal(listaPersonal);
        this.igp.setVisible(true);
    }

    public void buscarxNombre(String nombre) {
        per.setPersonaNombre(nombre);
        //compruebo si existe el registro
        ResultSet rs = this.per.buscarPersonaxNombre();
        try {
            if (rs.next()) {
                //si existe lo vuelvo hacer para traer nuevamente los datos
                //y no saltarse
                rs = this.per.buscarPersonaxNombre();
                this.igp.mostrarListaPersonal(rs);
            } else {
                //si no existe rs pasara a ser nulo
                rs = null;
                this.igp.limpiarTabla();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void empiezaPorNombre(String nombre) {
        this.per.setPersonaNombre(nombre);
        ResultSet rs = this.per.PorFiltroNombre();
        try {
            if (rs.next()) {
                //si existe lo vuelvo hacer para traer nuevamente los datos
                //y no saltarse
                rs = this.per.PorFiltroNombre();
                this.igp.mostrarListaPersonal(rs);
            } else {
                //si no existe rs pasara a ser nulo
                this.igp.limpiarTabla();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void empiezaPorApellido(String apellido){
        this.per.setPersonaAp(apellido);
        ResultSet rs = this.per.PorFiltroApellido();
         try {
            if (rs.next()) {
                //si existe lo vuelvo hacer para traer nuevamente los datos
                //y no saltarse
                rs = this.per.PorFiltroApellido();
                this.igp.mostrarListaPersonal(rs);
            } else {
                //si no existe rs pasara a ser nulo
                this.igp.limpiarTabla();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void empiezaPorId(String persona_id){
        this.per.setPersonaId(persona_id);
        ResultSet rs = this.per.PorFiltroId();
         try {
            if (rs.next()) {
                //si existe lo vuelvo hacer para traer nuevamente los datos
                //y no saltarse
                rs = this.per.PorFiltroId();
                this.igp.mostrarListaPersonal(rs);
            } else {
                //si no existe rs pasara a ser nulo
                this.igp.limpiarTabla();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    public boolean eliminaPersonal(String personal_Id){
        this.per.setPersonaId(personal_Id);
        boolean confirmacion = this.per.eliminarPersonal();
        
        if(confirmacion){
             JOptionPane.showMessageDialog(null, "Personal Eliminado", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Error al eliminar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return confirmacion;
    }
}
