/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionarLibros;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Yovii
 */
public class c_agregarlibro {
    i_agregarlibro ial;
    i_gestionarLibros igl;
    Autor  au;
     Libro lib;
 public c_agregarlibro(){
      ial = new i_agregarlibro();
        au = new Autor();
        lib = new Libro();
 }
     public void setInterfazGestionarLibro(i_gestionarLibros libro) {
        //le asigno a mi variable de tipo personal 
        //el objeto que recibo de la clase gestionar personal
        this.igl = libro;
    }
       public void setInterfazAgregarLibro(i_agregarlibro agregarlibro) {
        //le asigno a mi variable de tipo personal 
        //el objeto que recibo de la clase gestionar personal
        this.ial = agregarlibro;
    }
    public void prepararInterfazAgregarLibro()
    {
        ResultSet listaAutores = au.getListaAutores();
        ial.setInterfazGestionarLibro(igl);
        ial.cargarAutores(listaAutores);
        ial.setVisible(true);
    }

    public void registrarLibro(String clave, String coleccion, String signatura, String titulo, String subtitulo, String ejemplares,String autor,
   String edicion, String editorial,String isbn,String copyrigh, String serie, String lugar, String año, String materia, String pagVol)
    {
        if(clave.length() == 0 || coleccion.length() == 0|| signatura.length() == 0 || materia.length() == 0 || titulo.length() == 0 
               ||editorial.length()==0 || lugar.length()== 0 ||ejemplares.length() == 0)     
        {
             JOptionPane.showMessageDialog(null, "No ha ingresado todos los datos necesarios del libro");
        }
        else
        {
            int con = JOptionPane.YES_NO_OPTION;
            JOptionPane.showConfirmDialog(null,"¿Deseas guardar el libro?", "Seleccione una opcion...",con);
            
            if(con == JOptionPane.YES_OPTION)
            {
                
                
                 
                lib.setAutor(autor);
                lib.setAño(año);
                lib.setColeccion(coleccion);
                lib.setEditorial(editorial);
                lib.setEjemplares(ejemplares);
                lib.setIsbn(isbn);
                lib.setLugar(lugar);
                lib.setMateria(materia);
                lib.setSubtitulo(subtitulo);
                lib.setTitulo(titulo);
                lib.setSerie(serie);
                lib.setClaveLibro(clave);
                lib.setpagVol(pagVol);
                lib.setSignatura(signatura);
                lib.setEdicion(edicion);
                lib.setCopyrigh(copyrigh);
                if (!lib.verificarLibro()) {
                    if (lib.agregarLibro()) {
                        this.igl.mostrarListaLibros(new Libro().getListaLibros());
                        
                        JOptionPane.showMessageDialog(null, "Libro registrado");
                        this.ial.limpiarCampos();

                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo completar, vuelva a intentar");
                    }
                }
                else{
                    JOptionPane.showMessageDialog(null, "El libro ya se encuentra registrado");
                }
                
            }
        
        }

       
    }
}
