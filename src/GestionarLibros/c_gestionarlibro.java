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
 * @author Yoviicttoorr
 */
public class c_gestionarlibro {
    
    public ResultSet listalibros;
    public ResultSet listaautores;
    private i_gestionarLibros igl;
    Libro lib;
    Autor au; 
    public c_gestionarlibro()
    {   
        lib = new Libro();      
        this.listalibros = lib.getListaLibros();
        au = new Autor();
        this.listaautores = au.getListaAutores();
    }
    public void prepararInterfazGestionarLibro()
    {
        igl = new i_gestionarLibros();
       igl.mostrarListaLibros(listalibros);
       igl.mostrarListaAutores(listaautores);
       igl.setVisible(true);
          
    }
    public void recargarListaAutores(){
         this.listaautores = au.getListaAutores();
         igl.mostrarListaAutores(listaautores);
    }
     public void recargarListaLibros(){
         this.listalibros = lib.getListaLibros();
         igl.mostrarListaLibros(listalibros);
    }
     public void setGestionarLibro(i_gestionarLibros libro) {
        this.igl = libro;
    }
     public void eliminarAutor(String ID){
        
         au.setID(ID);
        int con = JOptionPane.showConfirmDialog(null,"¿Deseas eliminar el autor?", "Seleccione una opcion...",JOptionPane.YES_NO_OPTION);
      
         if (con == JOptionPane.YES_OPTION) {
             if (au.verificarRelacionLibro() == false) {
                 if (au.eliminarAutor() == true) {
                     igl.mostrarListaAutores(au.getListaAutores());
                     JOptionPane.showMessageDialog(null, "Autor eliminado");
                     igl.reiniciarColores();
                 }
             } else {
                 igl.reiniciarColores();
                 JOptionPane.showMessageDialog(null, "No se pudo eliminar,el autor esta registrado con un libro o mas");
             }

         }

     }
         public void eliminarLibro(String ID){
     
      
         lib.setID(ID);
         int con =  JOptionPane.showConfirmDialog(null, "¿Deseas eliminar el libro?", "Seleccione una opcion...", JOptionPane.YES_NO_OPTION);

             if (con == JOptionPane.YES_OPTION) {
                 if (lib.verificarPrestamosLibro() == false) {
                     if (lib.eliminarLibro() == true) {
                         igl.mostrarListaLibros(lib.getListaLibros());
                         JOptionPane.showMessageDialog(null, "Libro eliminado");
                         igl.reiniciarColores();
                     }
                 } else {
                     JOptionPane.showMessageDialog(null, "No se puede eliminar, el libro se encuentra en proceso de prestamo");
                     igl.reiniciarColores();
                 }

             }

     }
     public void buscarIDAutor(String id){
         ResultSet rs;
         au.setID(id);
         rs = au.buscarPorID();
        try {
            if(rs.next())
            {
                rs = au.buscarPorID();
                igl.mostrarListaAutores(rs);
            }
        
        } catch (SQLException ex) {
            
            Logger.getLogger(c_gestionarlibro.class.getName()).log(Level.SEVERE, null, ex);
        }
          
     }
       public void buscarNombreAutor(String nombre){
         ResultSet rs;
         au.setNombre(nombre); 
        
         rs = au.buscarPorNombre();
        try {
            if(rs.next())
            {
               
                rs = au.buscarPorNombre();
                igl.mostrarListaAutores(rs);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(c_gestionarlibro.class.getName()).log(Level.SEVERE, null, ex);
        }
          
     }
        public void buscarPrimerApellidoAutor(String primer){
         ResultSet rs;
         au.setPrimerApellido(primer);
         rs = au.buscarPorPrimerApellido();
        
        try {
            if(rs.next())
            {
               
                rs = au.buscarPorPrimerApellido();
                igl.mostrarListaAutores(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(c_gestionarlibro.class.getName()).log(Level.SEVERE, null, ex);
        }
          
     }
        
        //Los siguientes codigos no estan terminados
        public void buscarIDLibro(String id){
         ResultSet rs;
         lib.setID(id);
         rs = lib.buscarPorID();
        try {
            if(rs.next())
            {
                rs = lib.buscarPorID();
                igl.mostrarListaLibros(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(c_gestionarlibro.class.getName()).log(Level.SEVERE, null, ex);
        }
          
     }
        //Este no funciona llamar el tecnico
       public void buscarTituloLibro(String titulo){
         ResultSet rs;
         lib.setTitulo(titulo);     
         rs = lib.buscarPorTitulo();
        try {
            if(rs.next())
            {
                rs = lib.buscarPorTitulo();
                
                /*while(rs.next()){
                    System.out.println(rs.getInt("libro_id"));
                    System.out.println(rs.getString("libro_titulo"));
                }*/
                igl.mostrarListaLibros(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(c_gestionarlibro.class.getName()).log(Level.SEVERE, null, ex);
        }
          
     }
        public void buscarSubtituloLibro(String subtitulo){
         ResultSet rs;
         lib.setSubtitulo(subtitulo);
         rs = lib.buscarPorSubtitulo();
        try {
            if(rs.next())
            {
                rs = lib.buscarPorSubtitulo();
                igl.mostrarListaLibros(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(c_gestionarlibro.class.getName()).log(Level.SEVERE, null, ex);
        }
          
     }
        public void buscarNombreAutorLibro(String nombre){
         ResultSet rs;
         au.setNombre(nombre); 
        
         rs = au.buscarPorNombreEnLibro();
        try {
            if(rs.next())
            {
               
                rs = au.buscarPorNombreEnLibro();
                igl.mostrarListaLibros(rs);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(c_gestionarlibro.class.getName()).log(Level.SEVERE, null, ex);
        }
          
     }
         public void buscarEditorialLibro(String editorial){
         ResultSet rs;
         lib.setEditorial(editorial);
         rs = lib.buscarPorEditorial();
        try {
            if(rs.next())
            {
                rs = lib.buscarPorEditorial();
                igl.mostrarListaLibros(rs);
            }
        } catch (SQLException ex) {
            Logger.getLogger(c_gestionarlibro.class.getName()).log(Level.SEVERE, null, ex);
        }
          
     }
     
     
}
