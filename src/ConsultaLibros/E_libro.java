package ConsultaLibros;

import java.sql.ResultSet;

public class E_libro {

    private String titulo, subtitulo, autor, editorial, coleccion, lugar, isbn, año,
            serie, copryght, edicion, claveLibro, materia, estadoLibro, ejemplares;
    private ResultSet rs;
    private CRUDLibros cl;
    /**
     * @return the ejemplares
     */
    
    public E_libro(){
       this.cl = new CRUDLibros();
    }
    
    
    
    
    
    public String getEjemplares() {
        return ejemplares;
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
    public String getCopryght() {
        return copryght;
    }

    /**
     * @param copryght the copryght to set
     */
    public void setCopryght(String copryght) {
        this.copryght = copryght;
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

    public void eliminarLibro() {
    }

    public void modificarLibro() {
    }

    public ResultSet consultarLibroPorTitulo() {
        String titu = this.getTitulo();
        this.rs = cl.consultarPorTitulo(titu);
        return this.rs;

    }

    public ResultSet consultarLibroPorMateria() {
        String mate = this.getMateria();
        this.rs = cl.consultarPorMateria(mate);
        return this.rs;

    }

    public ResultSet consultarLibroPorAutor() {
        String au = this.getAutor();
        this.rs = cl.consultarPorAutor(au);
        return this.rs;

    }
    
    
    public ResultSet consularLibroPorSubtitulo(){
        this.rs = this.cl.consultarPorSubtitulo(subtitulo);
        return this.rs;
    }

    public ResultSet getListaLibros() {
        rs = this.cl.selectXtodas();
        return rs;
    }

}
