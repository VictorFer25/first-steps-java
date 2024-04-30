/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionarLibros;

import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Yovii
 */
public class c_editarAutor {
    i_gestionarLibros igl;
    i_editarAutor iea;
    Autor a;
    
    public c_editarAutor(){
         iea = new i_editarAutor();
         a = new Autor();
    }
    public void prepararInterfazEditarAutor(String id, String nombre, String primero, String segundo)
    {
       
        iea.setInterfazGestionarLibro(igl);
        iea.cargarDatos(id, nombre, primero, segundo);
        iea.setVisible(true);
    }
    public void setInterfazEditarAutor(i_editarAutor editar)
    {
        this.iea = editar;
    }
    public void setInterfazGestionarLibro(i_gestionarLibros libro) {
      
        this.igl = libro;
    }
    public void actualizarAutor(String ID, String nombre, String primero, String segundo) {
       
        int con = JOptionPane.YES_NO_OPTION;
        JOptionPane.showConfirmDialog(null, "¿Deseas actualizar los datos del autor?", "Seleccione una opcion...", con);
        if (con == JOptionPane.YES_OPTION) {
            
          
            a.setID(ID);
            a.setNombre(nombre);
            a.setPrimerApellido(primero);
            a.setSegundoApellido(segundo);
            a.cambiarMayuscula();

            if (a.actualizarAutor()) {
                this.igl.mostrarListaAutores(a.getListaAutores());
                this.igl.banderaDeUsoEditarAutor = true;
                iea.dispose();
                igl.reiniciarColores();
                JOptionPane.showMessageDialog(null, "Datos del autor actualizados");

            } else {
                JOptionPane.showMessageDialog(null, "No se pudo completar, vuelva a intentar");
            }

        }


        
    }
    
}
