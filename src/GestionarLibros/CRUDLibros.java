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
 * @author Yoviicttoorr
 */
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
            String query = "SELECT l.libro_id,l.libro_titulo,l.libro_subtitulo,au.autor_nombre,au.autor_primer_apellido,l.libro_editorial,l.libro_asignatura\n"
                    + "FROM libro l, autor au\n"
                    + "WHERE l.autor_id = au.autor_id ";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean agregar(String titulo, String subtitulo, String editorial, String autor, String coleccion, String lugar, String isbn, String año,
            String serie, String ejemplares, String edicion, String materia, String estado, String clave, String signatura, String copyrigh, String pagvol) {
        try {
            String query = "INSERT INTO libro(libro_titulo,libro_subtitulo,autor_id,libro_coleccion,"
                    + "libro_isbn,libro_año,libro_serie,libro_ejemplares,libro_edicion,libro_materia,libro_estado,"
                    + "libro_clave,libro_asignatura,libro_copyright,libro_pagvol,libro_cantidad,libro_editorial,libro_lugar) "
                    + "VALUES( '" + titulo + "','" + subtitulo + "','" + autor + "','" + coleccion + "','" + isbn + "',"
                    + "'" + año + "','" + serie + "','" + ejemplares + "','" + edicion + "','" + materia + "','" + estado + "','" + clave + "','" + signatura + "',"
                    + "'" + copyrigh + "','" + pagvol + "','" + ejemplares + "','" + editorial + "','" + lugar + "');";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet verificarLibro(String titulo, String subtitulo, String isbn) {
        try {
            String query = "SELECT * FROM libro WHERE libro_titulo ='" + titulo + "' AND libro_subtitulo = '" + subtitulo + "' AND libro_isbn = '" + isbn + "'";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet getDatosLibro(String id) {
        try {
            String query = "SELECT * FROM libro WHERE libro_id ='" + id + "'";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet buscarPorID(String id) {
        try {
            String query = "SELECT l.libro_id,l.libro_titulo,l.libro_subtitulo,au.autor_nombre,au.autor_primer_apellido,l.libro_editorial,l.libro_asignatura"
                    + " FROM libro l, autor au WHERE l.libro_id ='" + id + "' AND l.autor_id = au.autor_id";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet buscarPorTitulo(String titulo) {
        try {
            String query = "SELECT l.libro_id,l.libro_titulo,l.libro_subtitulo,au.autor_nombre,au.autor_primer_apellido,l.libro_editorial,l.libro_asignatura"
                    + " FROM libro l, autor au WHERE l.libro_titulo ILIKE 'a%' AND l.autor_id = au.autor_id";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet buscarPorSubtitulo(String subtitulo) {
        try {
            String query = "SELECT l.libro_id,l.libro_titulo,l.libro_subtitulo,au.autor_nombre,au.autor_primer_apellido,l.libro_editorial,l.libro_asignatura"
                    + " FROM libro l, autor au WHERE l.libro_subtitulo ILIKE '" + subtitulo + "%' AND l.autor_id = au.autor_id";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet buscarPorEditorial(String editorial) {
        try {
            String query = "SELECT l.libro_id,l.libro_titulo,l.libro_subtitulo,au.autor_nombre,au.autor_primer_apellido,l.libro_editorial,l.libro_asignatura"
                    + " FROM libro l, autor au WHERE l.libro_editorial ILIKE '" + editorial + "%' AND l.autor_id = au.autor_id";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean eliminarLibro(String id) {
        try {
            String query = "DELETE FROM libro WHERE libro_id =  '" + id + "';";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet verificarPrestamosLibro(String id) {
        try {
            String query = "Select * FROM detalleprestamo  WHERE libro_id =  '" + id + "';";
            rs = st.executeQuery(query);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean actualizar(String id, String titulo, String subtitulo, String editorial, String autor, String coleccion, String lugar, String isbn, String año,
            String serie, String ejemplares, String edicion, String materia, String estado, String clave, String signatura, String copyrigh, String pagvol) {
        try {
            String query = "UPDATE libro SET libro_titulo ='" + titulo + "' ,libro_subtitulo = '" + subtitulo + "' ,autor_id= '" + autor + "',libro_coleccion= '" + coleccion + "',"
                    + "libro_isbn = '" + isbn + "',libro_año = '" + año + "' ,libro_serie = '" + serie + "',libro_ejemplares = '" + ejemplares + "',"
                    + "libro_edicion = '" + edicion + "',libro_materia = '" + materia + "',libro_estado = '" + estado + "',"
                    + "libro_clave= '" + clave + "',libro_asignatura = '" + signatura + "',libro_copyright = '" + copyrigh + "',libro_pagvol = '" + pagvol + "',"
                    + "libro_cantidad = '" + ejemplares + "',libro_editorial = '" + editorial + "',libro_lugar= '" + lugar + "'"
                    + "WHERE libro_id = '" + id + "' ";

            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
