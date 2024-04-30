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
public class c_agregarAutor {
    i_gestionarLibros igl;
    
    Autor a;
    i_agregarAutor iaa;
    public c_agregarAutor(){
    iaa = new i_agregarAutor();
     a = new Autor();
     }
    public void prepararInterfazAgregarAutor()
    {
        
        iaa.setInterfazGestionarLibro(igl);
        iaa.setVisible(true);
    }
  
    public void setInterfazGestionarLibro(i_gestionarLibros libro) {
      
        this.igl = libro;
    }
    public void registrarAutor(String nombre, String primero, String segundo) {
        if (nombre.length() == 0 ) {
            JOptionPane.showMessageDialog(null, "Debe ingresar por lo menos un nombre");
        } else {

            int con = JOptionPane.showConfirmDialog(null, "¿Deseas registrar el autor?", "Seleccione una opcion...", JOptionPane.YES_NO_OPTION);
            
            if (con == JOptionPane.YES_OPTION) {
               
                a.setNombre(nombre);
                a.setPrimerApellido(primero);
                a.setSegundoApellido(segundo);
                a.cambiarMayuscula();
                if (!a.verficarAutor()) {
                    if (a.agregarAutor()) {
                        
                        JOptionPane.showMessageDialog(null, "Autor registrado");
                        this.igl.mostrarListaAutores(a.getListaAutores());
                        
                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo completar, vuelva a intentar");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "El autor ya se encuentra registrado");
                  
                }
            } 

        }
        
    }
    
}
