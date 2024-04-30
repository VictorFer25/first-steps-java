/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionarUsuarios;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Yoviicttoorr
 */
public class CRUDUsuarios {

    private conexionBD conexion = new conexionBD();
    private Connection con;
    private Statement st;
    private ResultSet rs;

    //constructor
    public CRUDUsuarios() {
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
            String query = "SELECT usuario_id ,usuario_nombre, usuario_primer_apellido , usuario_segundo_apellido FROM usuario";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //Metodo para agregar un usuario en la base de datos
    public boolean altaUsuario(String tipo, String matricula, String nombre, String ap, String am,Date fecha,String correo ,String calle,String cruzamiento1,String cruzamiento2, String colonia, String telefono, String numcasa, String lugar, String puesto) {
        try {
            System.out.println(fecha);
            String query = "INSERT INTO usuario (usuario_tipo, usuario_nombre, usuario_primer_apellido, usuario_segundo_apellido, usuario_fecha,usuario_correo, usuario_calle, usuario_cruzamiento1, usuario_cruzamiento2, usuario_telefono,"
                    + "usuario_colonia , usuario_id, usuario_numcasa, usuario_puesto, usuario_trabajo  )"
                    + " VALUES('" +tipo+ "','"+ nombre + "','" + ap + "','"
                    + am + "','" + fecha + "','" +correo+ "','" + calle + "','" + cruzamiento1 + "','" + cruzamiento2 + "','"
                    + telefono + "','"+ colonia + "','" + matricula + "','" + numcasa + "','" + puesto + "','" + lugar +  "');";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error en el crud");
            return false;
        }
    }

    //hace una busqueda por nombre.
    public ResultSet selectXnombre(String Nombre) {
        try {
            String query = "SELECT usuario_id ,usuario_nombre, usuario_primer_apellido , usuario_segundo_apellido FROM usuario WHERE "
                    + "usuario_nombre ILIKE '%" + Nombre + "%'";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //hace una busqueda por apellido
    public ResultSet selectXapellido(String Apellido) {
        try {
            String query = "SELECT usuario_id ,usuario_nombre, usuario_primer_apellido , usuario_segundo_apellido FROM usuario WHERE "
                    + "usuario_primer_apellido ILIKE '%" + Apellido + "%'";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    //hace una busqueda por matricula
    public ResultSet selectXmatricula(String Matricula) {
        try {
            String query = "SELECT usuario_id ,usuario_nombre, usuario_primer_apellido , usuario_segundo_apellido FROM usuario WHERE "
                    + "usuario_id = " + Matricula + "";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
    
    //esta consulta la llamo para la edicion de datos
    public ResultSet selectMatriculaTodos(String Matricula) {
        try {
            String query = "SELECT * FROM usuario WHERE "
                    + "usuario_id = " + Matricula + "";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    //Elimina un usuario
    public boolean deleteUser(String matricula) {
        try {
            String sql = "DELETE FROM usuario WHERE usuario_id = '" + matricula + "';";
            st.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
