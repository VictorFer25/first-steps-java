/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionarLibros;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Yoviicttoorr
 */
public class Libro {

    private String ID,titulo, subtitulo, autor, editorial, coleccion, lugar, isbn, año,
            serie, copyrigh, edicion, claveLibro, materia, estadoLibro, ejemplares, pagVol, signatura;

    public ResultSet rs;
    private CRUDLibros cl;

    public Libro() {
        cl = new CRUDLibros();
    }

    /**
     * @return the ejemplares
     */
    public void setID(String id) {
        this.ID = id;
    }

    public String getID() {
        return ID;
    }

    public String getEjemplares() {
        return ejemplares;
    }

    public void setpagVol(String pagvol) {
        this.pagVol = pagvol;
    }

    public String getpagVol() {
        return pagVol;
    }

    public void setSignatura(String Signatura) {
        this.signatura = Signatura;
    }

    public String getSignatura() {
        return signatura;
    }

    /**
     * @param ejemplares the ejemplares to set
     */
    public void setEjemplares(String ejemplares) {
        this.ejemplares = ejemplares;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the subtitulo
     */
    public String getSubtitulo() {
        return subtitulo;
    }

    /**
     * @param subtitulo the subtitulo to set
     */
    public void setSubtitulo(String subtitulo) {
        this.subtitulo = subtitulo;
    }

    /**
     * @return the autor
     */
    public String getAutor() {
        return autor;
    }

    /**
     * @param autor the autor to set
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * @return the editorial
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * @param editorial the editorial to set
     */
    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    /**
     * @return the coleccion
     */
    public String getColeccion() {
        return coleccion;
    }

    /**
     * @param coleccion the coleccion to set
     */
    public void setColeccion(String coleccion) {
        this.coleccion = coleccion;
    }

    /**
     * @return the lugar
     */
    public String getLugar() {
        return lugar;
    }

    /**
     * @param lugar the lugar to set
     */
    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    /**
     * @return the isbn
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * @param isbn the isbn to set
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    /**
     * @return the año
     */
    public String getAño() {
        return año;
    }

    /**
     * @param año the año to set
     */
    public void setAño(String año) {
        this.año = año;
    }

    /**
     * @return the serie
     */
    public String getSerie() {
        return serie;
    }

    /**
     * @param serie the serie to set
     */
    public void setSerie(String serie) {
        this.serie = serie;
    }

    /**
     * @return the copryght
     */
    public String getCopyrigh() {
        return copyrigh;
    }

    /**
     * @param copryght the copryght to set
     */
    public void setCopyrigh(String Copyrigh) {
        this.copyrigh = Copyrigh;
    }

    /**
     * @return the edicion
     */
    public String getEdicion() {
        return edicion;
    }

    /**
     * @param edicion the edicion to set
     */
    public void setEdicion(String edicion) {
        this.edicion = edicion;
    }

    /**
     * @return the claveLibro
     */
    public String getClaveLibro() {
        return claveLibro;
    }

    /**
     * @param claveLibro the claveLibro to set
     */
    public void setClaveLibro(String claveLibro) {
        this.claveLibro = claveLibro;
    }

    /**
     * @return the materia
     */
    public String getMateria() {
        return materia;
    }

    /**
     * @param materia the materia to set
     */
    public void setMateria(String materia) {
        this.materia = materia;
    }

    /**
     * @return the estadoLibro
     */
    public String getEstadoLibro() {
        return estadoLibro;
    }

    /**
     * @param estadoLibro the estadoLibro to set
     */
    public void setEstadoLibro(String estadoLibro) {
        this.estadoLibro = estadoLibro;
    }

    public boolean eliminarLibro() {
        boolean resultado = false;
        resultado = cl.eliminarLibro(this.getID());
        return resultado;
    }

    public boolean verificarPrestamosLibro() {

        rs = cl.verificarPrestamosLibro(this.getID());
        boolean resultado = false;
        try {
            resultado = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return resultado;
    }

    public void cambiarMayuscula() {

        this.titulo = titulo.toUpperCase();
        this.subtitulo = subtitulo.toUpperCase();
        this.editorial = editorial.toUpperCase();

    }

    public boolean agregarLibro() {
        if (cl.agregar(this.getTitulo(), this.getSubtitulo(), this.getEditorial(), this.getAutor(), this.getColeccion(),
                this.getLugar(), this.getIsbn(), this.getAño(), this.getSerie(), this.getEjemplares(), this.getEdicion(), this.getMateria(),
                "Disponible", this.getClaveLibro(), this.getSignatura(), this.getCopyrigh(), this.getpagVol())) {
            return true;
        }

        return false;
    }

    public boolean actualizarLibro() {
        if (cl.actualizar(this.getID(), this.getTitulo(), this.getSubtitulo(), this.getEditorial(), this.getAutor(), this.getColeccion(),
                this.getLugar(), this.getIsbn(), this.getAño(), this.getSerie(), this.getEjemplares(), this.getEdicion(), this.getMateria(),
                "Disponible", this.getClaveLibro(), this.getSignatura(), this.getCopyrigh(), this.getpagVol())) {
            return true;
        }

        return false;
    }

    public ResultSet getListaLibros() {
        rs = cl.selectXtodas();
        return rs;

    }

    public ResultSet getDatosLibro() {
        rs = cl.getDatosLibro(this.getID());
        return rs;

    }

    public ResultSet buscarPorID() {
        rs = cl.buscarPorID(this.getID());
        return rs;
    }
    public ResultSet buscarPorTitulo() {
        rs = cl.buscarPorTitulo(this.getTitulo());
        return rs;
    }
    public ResultSet buscarPorSubtitulo() {
        rs = cl.buscarPorSubtitulo(this.getSubtitulo());
        return rs;
    }
       public ResultSet buscarPorEditorial() {
        rs = cl.buscarPorEditorial(this.getEditorial());
        return rs;
    }

    public boolean verificarLibro() {
        rs = cl.verificarLibro(this.getTitulo(), this.getSubtitulo(), this.getIsbn());
        boolean resultado = false;
        try {
            resultado = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return resultado;

    }

}
