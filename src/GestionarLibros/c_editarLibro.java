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
public class c_editarLibro {
    i_editarLibro iel;
    i_gestionarLibros igl;
    Autor  au;
    ResultSet rs;
    Libro lib;
    public c_editarLibro(){
         iel = new i_editarLibro();
        au = new Autor();
        lib = new Libro();
    }
     public void setInterfazGestionarLibro(i_gestionarLibros libro) {
        //le asigno a mi variable de tipo personal 
        //el objeto que recibo de la clase gestionar personal
        this.igl = libro;
    }
       public void setInterfazEditarLibro(i_editarLibro editarlibro) {
        //le asigno a mi variable de tipo personal 
        //el objeto que recibo de la clase gestionar personal
        this.iel = editarlibro;
    }
    public void prepararInterfazEditarLibro()
    {
        
        ResultSet listaAutores = au.getListaAutores(); 
        iel.setInterfazGestionarLibro(igl);
        iel.cargarAutores(listaAutores);
        iel.cargarDatosLibro(rs);
        iel.setVisible(true);
    }
    public void buscarDatosLibro(String ID){
        
        lib.setID(ID);
        rs = lib.getDatosLibro();
    }
    public void actualizarLibro(String id,String clave, String coleccion, String signatura, String titulo, String subtitulo, String ejemplares,String autor,
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
            JOptionPane.showConfirmDialog(null,"¿Deseas actualizar los datos del libro?", "Seleccione una opcion...",con);
            
            if(con == JOptionPane.YES_OPTION)
            {
                lib.setID(id);
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

                if (lib.actualizarLibro()) {
                    this.igl.mostrarListaLibros(lib.getListaLibros());
                    this.igl.banderaDeUsoEditarLibro = true;
                    JOptionPane.showMessageDialog(null, "Datos del libro actualizado");
                    this.iel.dispose();

                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo completar, vuelva a intentar");
                }


            }
        
        }

       
    }
}
