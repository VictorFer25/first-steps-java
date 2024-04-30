package GestionarPersonal;

import java.sql.ResultSet;

public class E_Persona {
    private String Persona_Nombre;
    private String Persona_Ap;
    private String Persona_Am;
    private String Persona_Calle;
    private String Persona_Cruzamiento1;
    private String Persona_Cruzamiento2;
    private int Persona_CodigoPostal;    
    private String Persona_Telefono;
    private String Persona_Colonia;
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
    public String getPersonaCruzamiento() {
        return this.Persona_Cruzamiento1;
    }
    public String getPersonaCruzamiento1() {
        return this.Persona_Cruzamiento2;
    }
    public int getPersonaCodigoPostal(){
        return this.Persona_CodigoPostal;
    }

    public String getPersonaTelefono() {
        return this.Persona_Telefono;
    }

    public String getPersonaColonia() {
        return this.Persona_Colonia;
    }

    //metodos setters
    public void setPersonaNombre(String Persona_Nombre) {
        this.Persona_Nombre = Persona_Nombre;
    }

    public void setPersonaAp(String Persona_Ap) {
        this.Persona_Ap = Persona_Ap;
    }

    public void setPersonaAm(String Persona_Am) {
        this.Persona_Am = Persona_Am;
    }

    public void setPersonaCalle(String Persona_Calle) {
        this.Persona_Calle = Persona_Calle;
    }
    
    public void setPersonaCruzamiento1(String cruzamiento){
        this.Persona_Cruzamiento1 = cruzamiento;
    }
    public void setPersonaCruzamiento2(String cruzamiento){
        this.Persona_Cruzamiento2 = cruzamiento;
    }
    public void setCodigoPostal(int codigoPostal){
        this.Persona_CodigoPostal = codigoPostal;
    }

    public void setPersonaTelefono(String Persona_Telefono) {
        this.Persona_Telefono = Persona_Telefono;
    }

    public void setPersonaColonia(String Persona_Colonia) {
        this.Persona_Colonia = Persona_Colonia;
    }
}
