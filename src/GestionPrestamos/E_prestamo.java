package GestionPrestamos;

import java.sql.ResultSet;

public class E_prestamo {
    
    private ResultSet rs = null;
    private String prestamoId, usuarioId, libroId, personalIdSalida, fechaPrestamo, fechaDevolucion, estadoPrestamo, personalIdEntrada, PrestamoTipo;
    CRUDPrestamo Crud = new CRUDPrestamo();
    
    //funciones set almacena los vaores
    public void setUsuarioId(String usuarioId){
        this.usuarioId = usuarioId;
    }
    
    public void setLibroId(String libroId){
        this.libroId = libroId;
    }
    
    public void setPersonalIdSalida(String personalIdSalida){
        this.personalIdSalida = personalIdSalida;
    }
    
    public void setFechaPrestamo(String fechaPrestamo){
        this.fechaPrestamo = fechaPrestamo;
    }
    
    public void setFechaDevolucion(String fechaDevolucion){
        this.fechaDevolucion = fechaDevolucion;
    }
    
    public void setEstadoPrestamo(String estadoPrestamo){
        this.estadoPrestamo = estadoPrestamo;
    }
    
    public void setPersonalIdEntrada(String personalIdEntrada){
        this.personalIdEntrada = personalIdSalida;
    }
    
    public void setPrestamoTipo(String PrestamoTipo){
        this.PrestamoTipo = PrestamoTipo;
    }
    
    public void setFolio(String folio){
        this.prestamoId = folio;
    }
    
    //funciones get los metodos get retorna los valores,
    public String getFolio(){
        return this.prestamoId;
    }
    
    public String getUsuarioId(){
        return this.usuarioId;
    }
    
    public String getLibroId(){
        return this.libroId;
    }
    
    public String getPersonalIdSalida(){
        return this.personalIdSalida;
    }
    
    public String getFechaPrestamo(){
        return this.fechaPrestamo;
    }
    
    public String getFechaDevolucion(){
        return this.fechaDevolucion;
    }
    
    public String getEstadoPrestamo(){
        return this.estadoPrestamo;
    }
    
    public String getPersonalIdEntrada(){
        return this.personalIdEntrada;
    }
    
    public String getPrestamoTipo(){
        return this.PrestamoTipo;
    }
    
    //------------------------------------------------
    // funciones
    
    //me devuelve la lista en la tabla principal de gesionar registro
    public ResultSet getListaPrestamo() {
        rs = this.Crud.selectXtodas();
        return this.rs;
    }
    
    // me permite buscar los libros por medio del folio para el registro
    public ResultSet getListaFolio (String folio){
        this.rs = this.Crud.tablaXfolio(folio);
        return this.rs;
    }
    
    // Devuelve la lista de libros para la actualizacion
    public ResultSet getPrestamos(String prestamo){
        this.rs = this.Crud.tablaXprestamo(prestamo);
        return this.rs;
    }
    
    // Permite verificar que un prestamo no se encuentre registrado
    public ResultSet VerificaPrestamo(String prestamo){
        
        try{
            this.rs = this.Crud.verificarPrestamo(prestamo);
            return rs;
        }catch(Exception e){
            return null;
        }
        
    }
    
    // aun no lo he usado, dentre que seguir en viendo
    public boolean eliminaRegistro(String prestamo){
        if(this.Crud.eliminarRegistro(prestamo)){
            return true;
        }else{
            return false;
        }
    }
    
    // metodo principal de la interfaz editar
    public boolean actualizaRegistro(){
        if(this.Crud.actualizaPrestamo(this.estadoPrestamo, this.libroId)){
            return true;
        }else{
            return false;
        }
    }
    
    // devuelve los datos del alumno.
    public ResultSet obtenerNombre(String folio){
        this.rs = this.Crud.busquedaAlumno(folio);
        return this.rs;
    }
    
    // Devuelve los datos del personal
    public ResultSet datosPersonal(String personal_id){
        this.rs = this.Crud.datosPersonal(personal_id);
        return this.rs;
    }
    
    public void actualizaCantidadLibro(int cantidad, int libro_id){
        this.Crud.actualizaCantidadLibro(cantidad, libro_id);
    }
    
    // metod principa de la interfaz registrar,
    // para la tabla detallePrestamo en la db
    public boolean agregarDetallePrestamo(){
        Object[] datosPrestamo = new Object[4];
        
        datosPrestamo[0] = this.getFolio();
        datosPrestamo[1] = this.getLibroId();
        datosPrestamo[2] = this.getEstadoPrestamo();
        datosPrestamo[3] = this.getPrestamoTipo();
        
        if(this.Crud.registroDetallePrestamo(datosPrestamo)){
            return true;
        }else{
            return false;
        }
    }
    
    // metod principa de la interfaz registrar,
    // para la tabla Prestamo en la db
    public boolean AgregarPrestamo(){
        Object[] datosPrestamo = new Object[5];
        
        datosPrestamo[0] = this.getFolio();
        datosPrestamo[1] = this.getUsuarioId();
        datosPrestamo[2] = this.getPersonalIdSalida();
        datosPrestamo[3] = this.getFechaPrestamo();
        datosPrestamo[4] = this.getFechaDevolucion();
       
        if(this.Crud.registroPrestamo(datosPrestamo)){
            return true;
        }else{
            return false;
        }
    }
}
