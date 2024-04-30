/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsultaLibros;

/**
 *
 * @author alan
 */
import java.sql.ResultSet;

public class E_Persona {
   
   // la herencia siempre usa modificadores de acceso protected
   protected String Persona_Nombre;
   protected String Persona_Ap;
   protected String Persona_Am;
   protected String Persona_Calle;
   protected String Persona_Telefono;
   protected String Persona_Colonia;
   
   public ResultSet rs;
   
    //metodos getters 
    
    public String getNombrePersona() {
        return this.Persona_Nombre;
    }
    public String getPersonaAp() {
        return this.Persona_Ap;
    }
    public String getPersonaAm() {
        return this.Persona_Am;
    }
    public String getPersonaCalle() {
        return this.Persona_Calle;
    }
    public String getPersonaTelefono() {
        return this.Persona_Telefono;
    }
    public String getPersonaColonia() {
        return this.Persona_Colonia;
    }
     
    
    //metodos setters
    
    public void setPersonaNombre(String Persona_Nombre){
        this.Persona_Nombre = Persona_Nombre;
    }
    public void setPersonaAp(String Persona_Ap){
        this.Persona_Ap = Persona_Ap;
    }
    public void setPersonaAm(String Persona_Am){
        this.Persona_Am = Persona_Am;
    }
    public void setPersonaCalle(String Persona_Calle){
        this.Persona_Calle = Persona_Calle;
    }
     public void setPersonaTelefono(String Persona_Telefono){
        this.Persona_Telefono = Persona_Telefono;
    }
     public void setPersonaColonia(String Persona_Colonia){
        this.Persona_Colonia = Persona_Colonia;
    }
    
    
    
    
}

