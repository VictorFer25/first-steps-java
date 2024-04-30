/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsultaLibros;

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
    
    public ResultSet verificarFolio(){
        int prestamo_id = Integer.parseInt(this.getFolio());
        ResultSet rs = this.Crud.verificarFolio(prestamo_id);
        return rs;
    }
}
