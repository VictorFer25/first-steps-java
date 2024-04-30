
package GestionarUsuarios;

import java.sql.ResultSet;
import java.util.Date;

public class e_Persona {
   
   // la herencia siempre usa modificadores de acceso protected
   String Tipo;
   protected String Persona_Nombre;
   protected String Persona_Ap;
   protected String Persona_Am;
   protected Date Persona_Fecha;
   protected String Persona_Correo;
   protected String Persona_Calle;
   protected String Persona_Cruzamiento1;
   protected String Persona_Cruzamiento2;
   protected String Persona_Telefono;
   protected String Persona_Colonia;
   protected String Persona_NumCasa;
   protected String Persona_LugarTrabajo;
   protected String Persona_PuestoTrabajo;
   protected ResultSet rs;
   
    //metodos getters 
    
    public String getNombrePersona() {
        return this.getPersona_Nombre();
    }
    public String getPersonaAp() {
        return this.getPersona_Ap();
    }
    public String getPersonaAm() {
        return this.getPersona_Am();
    }
    public String getPersonaCalle() {
        return this.getPersona_Calle();
    }
    public String getPersonaTelefono() {
        return this.getPersona_Telefono();
    }
    public String getPersonaColonia() {
        return this.getPersona_Colonia();
    }
     
    
    //metodos setters
    
    public void setPersonaNombre(String Persona_Nombre){
        this.setPersona_Nombre(Persona_Nombre);
    }
    public void setPersonaAp(String Persona_Ap){
        this.setPersona_Ap(Persona_Ap);
    }
    public void setPersonaAm(String Persona_Am){
        this.setPersona_Am(Persona_Am);
    }
    public void setPersonaCalle(String Persona_Calle){
        this.setPersona_Calle(Persona_Calle);
    }
     public void setPersonaTelefono(String Persona_Telefono){
         this.setPersona_Telefono(Persona_Telefono);
    }
     public void setPersonaColonia(String Persona_Colonia){
         this.setPersona_Colonia(Persona_Colonia);
    }
    
     public void setPersonaTipo(String Persona_Tipo){
         this.setTipo(Persona_Tipo);
     }
     
     public void setPersonaFecha(Date Persona_Fecha){
         this.setPersona_Fecha(Persona_Fecha); 
     }
    
     public void setPersonaCorreo(String Correo){
         this.setPersona_Correo(Correo);
     }
     
     public void setPersonaCruzamiento1(String Cruza1){
         this.setPersona_Cruzamiento1(Cruza1);
     }
     
     public void setPersonaCruzamiento2(String Cruza2){
         this.setPersona_Cruzamiento2(Cruza2);
     }
    
     public void setPersonaNumCasa(String numCasa){
         this.setPersona_NumCasa(numCasa);
     }
     
     public void setPersonaLugar(String lugar){
         this.setPersona_LugarTrabajo(lugar);
     }
     
     public void setPersonaPuesto(String Cruza2){
         this.setPersona_PuestoTrabajo(Cruza2);
     }

    /**
     * @return the Tipo
     */
    public String getTipo() {
        return Tipo;
    }

    /**
     * @param Tipo the Tipo to set
     */
    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    /**
     * @return the Persona_Nombre
     */
    public String getPersona_Nombre() {
        return Persona_Nombre;
    }

    /**
     * @param Persona_Nombre the Persona_Nombre to set
     */
    public void setPersona_Nombre(String Persona_Nombre) {
        this.Persona_Nombre = Persona_Nombre;
    }

    /**
     * @return the Persona_Ap
     */
    public String getPersona_Ap() {
        return Persona_Ap;
    }

    /**
     * @param Persona_Ap the Persona_Ap to set
     */
    public void setPersona_Ap(String Persona_Ap) {
        this.Persona_Ap = Persona_Ap;
    }

    /**
     * @return the Persona_Am
     */
    public String getPersona_Am() {
        return Persona_Am;
    }

    /**
     * @param Persona_Am the Persona_Am to set
     */
    public void setPersona_Am(String Persona_Am) {
        this.Persona_Am = Persona_Am;
    }

    /**
     * @return the Persona_Fecha
     */
    public Date getPersona_Fecha() {
        return Persona_Fecha;
    }

    /**
     * @param Persona_Fecha the Persona_Fecha to set
     */
    public void setPersona_Fecha(Date Persona_Fecha) {
        this.Persona_Fecha = Persona_Fecha;
    }

    /**
     * @return the Persona_Correo
     */
    public String getPersona_Correo() {
        return Persona_Correo;
    }

    /**
     * @param Persona_Correo the Persona_Correo to set
     */
    public void setPersona_Correo(String Persona_Correo) {
        this.Persona_Correo = Persona_Correo;
    }

    /**
     * @return the Persona_Calle
     */
    public String getPersona_Calle() {
        return Persona_Calle;
    }

    /**
     * @param Persona_Calle the Persona_Calle to set
     */
    public void setPersona_Calle(String Persona_Calle) {
        this.Persona_Calle = Persona_Calle;
    }

    /**
     * @return the Persona_Cruzamiento1
     */
    public String getPersona_Cruzamiento1() {
        return Persona_Cruzamiento1;
    }

    /**
     * @param Persona_Cruzamiento1 the Persona_Cruzamiento1 to set
     */
    public void setPersona_Cruzamiento1(String Persona_Cruzamiento1) {
        this.Persona_Cruzamiento1 = Persona_Cruzamiento1;
    }

    /**
     * @return the Persona_Cruzamiento2
     */
    public String getPersona_Cruzamiento2() {
        return Persona_Cruzamiento2;
    }

    /**
     * @param Persona_Cruzamiento2 the Persona_Cruzamiento2 to set
     */
    public void setPersona_Cruzamiento2(String Persona_Cruzamiento2) {
        this.Persona_Cruzamiento2 = Persona_Cruzamiento2;
    }

    /**
     * @return the Persona_Telefono
     */
    public String getPersona_Telefono() {
        return Persona_Telefono;
    }

    /**
     * @param Persona_Telefono the Persona_Telefono to set
     */
    public void setPersona_Telefono(String Persona_Telefono) {
        this.Persona_Telefono = Persona_Telefono;
    }

    /**
     * @return the Persona_Colonia
     */
    public String getPersona_Colonia() {
        return Persona_Colonia;
    }

    /**
     * @param Persona_Colonia the Persona_Colonia to set
     */
    public void setPersona_Colonia(String Persona_Colonia) {
        this.Persona_Colonia = Persona_Colonia;
    }

    /**
     * @return the Persona_NumCasa
     */
    public String getPersona_NumCasa() {
        return Persona_NumCasa;
    }

    /**
     * @param Persona_NumCasa the Persona_NumCasa to set
     */
    public void setPersona_NumCasa(String Persona_NumCasa) {
        this.Persona_NumCasa = Persona_NumCasa;
    }

    /**
     * @return the Persona_LugarTrabajo
     */
    public String getPersona_LugarTrabajo() {
        return Persona_LugarTrabajo;
    }

    /**
     * @param Persona_LugarTrabajo the Persona_LugarTrabajo to set
     */
    public void setPersona_LugarTrabajo(String Persona_LugarTrabajo) {
        this.Persona_LugarTrabajo = Persona_LugarTrabajo;
    }

    /**
     * @return the Persona_PuestoTrabajo
     */
    public String getPersona_PuestoTrabajo() {
        return Persona_PuestoTrabajo;
    }

    /**
     * @param Persona_PuestoTrabajo the Persona_PuestoTrabajo to set
     */
    public void setPersona_PuestoTrabajo(String Persona_PuestoTrabajo) {
        this.Persona_PuestoTrabajo = Persona_PuestoTrabajo;
    }

    /**
     * @return the rs
     */
    public ResultSet getRs() {
        return rs;
    }

    /**
     * @param rs the rs to set
     */
    public void setRs(ResultSet rs) {
        this.rs = rs;
    }
    
}
