/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsultaLibros;

import GestionarLibros.conexionBD;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CRUDLibros {

    private conexionBD conexion = new conexionBD();
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public CRUDLibros() {
        try {
            if ((con = conexion.obtenerConexion()) == null) {
                JOptionPane.showMessageDialog(null, "Error con la conexion a la BD");
                return;
            }
            st = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Metodo que trae todos los libros
    public ResultSet selectXtodas() {
        try {
            String query = "SELECT libro_id,libro_titulo,libro_subtitulo,autor_nombre"
                    + ",libro_materia,libro_estado,libro_cantidad "
                    + "FROM libro l "
                    + "INNER JOIN autor a ON l.autor_id = a.autor_id";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet consultarPorAutor(String autor) {
        try {
            String sql = "SELECT libro_id,libro_titulo,libro_subtitulo,autor_nombre,"
                    + "libro_materia,libro_estado,libro_cantidad FROM libro l "
                    + "INNER JOIN autor a ON a.autor_id = l.autor_id "
                    + "WHERE autor_nombre ILIKE  '" + autor + "%'";

            this.rs = this.st.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.rs;
    }

    public ResultSet consultarPorTitulo(String titulo) {
        try {
            String sql = "SELECT libro_id,libro_titulo,libro_subtitulo,autor_nombre,"
                    + "libro_materia,libro_estado,libro_cantidad FROM libro l "
                    + "INNER JOIN autor a ON a.autor_id = l.autor_id "
                    + "WHERE libro_titulo ILIKE '" + titulo + "%';";

            this.rs = this.st.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.rs;
    }

    public ResultSet consultarPorMateria(String materia) {
        try {
            String sql = "SELECT libro_id,libro_titulo,libro_subtitulo,autor_nombre,"
                    + "libro_materia,libro_estado,libro_cantidad FROM libro l "
                    + "INNER JOIN autor a ON a.autor_id = l.autor_id "
                    + "WHERE libro_materia ILIKE  '" + materia + "%'";

            this.rs = this.st.executeQuery(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.rs;
    }
    
    public ResultSet consultarPorSubtitulo(String subtitulo){
        try{
            String sql = "SELECT libro_id,libro_titulo,libro_subtitulo,autor_nombre,"
                    + "libro_materia,libro_estado,libro_cantidad FROM libro l "
                    + "INNER JOIN autor a ON a.autor_id = l.autor_id "
                    + "WHERE libro_subtitulo ILIKE  '" + subtitulo + "%'";
            
            this.rs = this.st.executeQuery(sql);
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return this.rs;
    }

}
