/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionarLibros;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author Yovii
 */
public class CRUDAutores {
    private conexionBD conexion = new conexionBD();
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public CRUDAutores() {
        try{
            if((con = conexion.obtenerConexion())==null){
                JOptionPane.showMessageDialog(null,"Error con la conexion a la BD");
                return;
            }
            st = con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public ResultSet selectXtodas(){
        try {
            String query = "SELECT autor_id,autor_nombre,autor_primer_apellido,autor_segundo_apellido FROM autor";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean agregar(String nombre,String primero, String segundo){
        try {
            String query = "INSERT INTO autor(autor_nombre,autor_primer_apellido,autor_segundo_apellido) "
                    + "VALUES( '"+nombre+"','"+primero+"','"+segundo+"');";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public ResultSet verificar(String nombre, String primero)
    {
        try {
            String query = "SELECT * FROM autor WHERE autor_nombre ='"+nombre+"'AND autor_primer_apellido = '"+primero+"'";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
     public boolean actualizarAutor(String id,String nombre,String primero, String segundo){
        try {
            String query = "UPDATE autor SET autor_nombre =  '"+nombre+"',autor_primer_apellido = '"+primero+"',autor_segundo_apellido = '"+segundo+"'"
                    + "WHERE autor_id =  '"+id+"';";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
     public boolean eliminarAutor(String id){
         try {
            String query = "DELETE FROM autor WHERE autor_id =  '"+id+"';";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
     }
      public ResultSet verificarRelacionLibro(String id){
         try {
            String query = "Select * FROM libro  WHERE autor_id =  '"+id+"';";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
     }
     public ResultSet buscarPorNombre(String nombre){
        try {
            String query = "SELECT autor_id,autor_nombre,autor_primer_apellido,autor_segundo_apellido FROM autor WHERE autor_nombre ILIKE  '"+nombre+"%'; ";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
      public ResultSet buscarPorPrimerApellido(String primer){
        try {
            String query = "SELECT autor_id,autor_nombre,autor_primer_apellido,autor_segundo_apellido FROM autor WHERE autor_primer_apellido ILIKE  '"+primer+"%';";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
       public ResultSet buscarPorID(String ID){
        try {
         
            String query = "SELECT autor_id,autor_nombre,autor_primer_apellido,autor_segundo_apellido FROM autor WHERE autor_id = '"+ID+"';";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        public ResultSet buscarPorNombreEnLibro(String nombre){
        try {
            String query = "SELECT l.libro_id,l.libro_titulo,l.libro_subtitulo,au.autor_nombre,au.autor_primer_apellido,l.libro_editorial,l.libro_asignatura"
                    + " FROM libro l, autor au WHERE au.autor_nombre ILIKE '"+nombre+"%' AND l.autor_id = au.autor_id ";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
