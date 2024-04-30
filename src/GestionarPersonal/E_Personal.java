package GestionarPersonal;

import java.sql.ResultSet;
import java.sql.SQLException;

public class E_Personal extends E_Persona {

    //atributos de la clase Personal
    CRUDPersonal crud_personal = new CRUDPersonal();
    private String Personal_Id;
    private String Personal_Usuario;
    private String Personal_Password;
    private String Personal_TiporPesonal;
    //atributos 
    private ResultSet rs = null;
    private Object[] datosPersonal;

    public E_Personal() {
        this.datosPersonal = new Object[12];
    }

    //metodos getters
    public String getPersonaId() {
        return this.Personal_Id;
    }

    public String getPersonalUsuario() {
        return this.Personal_Usuario;
    }

    public String getPersonalPassword() {
        return this.Personal_Password;
    }

    public String getPersonalTipoPersonal() {
        return this.Personal_TiporPesonal;
    }

    //metodos setters
    public void setPersonaId(String Persona_Id) {
        this.Personal_Id = Persona_Id;
    }

    public void setPersonalUsuario(String Personal_Usuario) {
        this.Personal_Usuario = Personal_Usuario;
    }

    public void setPersonalPassword(String Personal_Password) {
        this.Personal_Password = Personal_Password;
    }

    public void setPersonalTipoPersonal(String Personal_TipoPersonal) {
        this.Personal_TiporPesonal = Personal_TipoPersonal;
    }

    //metodos de busqueda a la base de datos
    public ResultSet buscarPersonalxId() {

        return this.rs;
    }

    public ResultSet buscarPersonaxNombre() {
        String Personal_Nombre = this.getNombrePersona();
        this.rs = this.crud_personal.buscarPorNombre(Personal_Nombre);
        if (this.rs != null) {
            return this.rs;
        } else {
            return null;
        }
    }

    public ResultSet cargarDatos() {
        String personal_id = this.getPersonaId();
        this.rs = this.crud_personal.DatosPersonales(personal_id);
        return rs;
    }

    public ResultSet PorFiltroNombre() {
        String filtro = this.getNombrePersona();
        this.rs = this.crud_personal.buscarPorFiltroNombre(filtro);
        return this.rs;
    }

    public ResultSet PorFiltroApellido() {
        String filtro = this.getPersonaAp();
        this.rs = this.crud_personal.buscarPorFiltroApellido(filtro);
        return this.rs;
    }

    public ResultSet PorFiltroId() {
        String id = this.getPersonaId();
        this.rs = this.crud_personal.buscarPorID(id);
        return this.rs;
    }

    //metodos de verificacion de datos de personal
    public boolean verificarUsuario(String usuario) throws SQLException{
        this.rs = crud_personal.VerificarUsuario(usuario);
        String Consultado = "";
        
        while(rs.next()){
        Consultado = this.rs.getString("personal_usuario");
        }
        
        if(Consultado.equals(usuario)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean verificarPassword(String usuario, String password) throws SQLException{
        this.rs = crud_personal.VerificarPassword(usuario);
        String Consultado = "";
        
        while(rs.next()){
            Consultado = this.rs.getString("personal_password");
        }
        
        if(Consultado.equals(password)){
            return true;
        }else{
            return false;
        }
    }
    
    public boolean verificarTipoPersonal(String usuario) throws SQLException{
        this.rs = crud_personal.VerificarTipoUsuario(usuario);
        String Consultado = "";
        
        while(rs.next()){
            Consultado = this.rs.getString("personal_tipoPersonal");
        }
        
        if(Consultado.equals("Encargado")){
            // es un usuario encargado
            return true;
        }else{
            // es un auxiliar
            return false;
        }
    }

    public ResultSet verificarExistenciaUsuario() {
        String usuario = this.getPersonalUsuario();
        this.rs = this.crud_personal.verificarExistenciaUsr(usuario);
        return rs;
    }
     public ResultSet verificarExistenciaPersonal() {
        String nombre = this.getNombrePersona();
        String aPaterno = this.getPersonaAp();
        //System.out.println(nombre);
        //System.out.println(aPaterno);
        this.rs = this.crud_personal.verificarExistenciaPersona(nombre,aPaterno);
        return this.rs;
    }

    //metodos de eliminacion agregacion y modificacion
    public boolean eliminarPersonal() {
        String personal_id = this.getPersonaId();
        boolean confirmacion = this.crud_personal.eliminar(personal_id);
        return confirmacion;
    }

    public boolean modificarPersonal() {
         this.datosPersonal[0] = this.getNombrePersona();
        this.datosPersonal[1] = this.getPersonaAp();
        this.datosPersonal[2] = this.getPersonaAm();
        this.datosPersonal[3] = this.getPersonaCalle();
        this.datosPersonal[4] = this.getPersonaTelefono();
        this.datosPersonal[5] = this.getPersonaColonia();
        this.datosPersonal[6] = this.getPersonalUsuario();
        this.datosPersonal[7] = this.getPersonalPassword();
        this.datosPersonal[8] = this.getPersonalTipoPersonal();
        this.datosPersonal[9] = this.getPersonaCruzamiento();
        this.datosPersonal[10] = this.getPersonaCruzamiento1();
        this.datosPersonal[11] = this.getPersonaCodigoPostal();
        
        boolean conf = this.crud_personal.actualizar(this.datosPersonal,Integer.parseInt(this.getPersonaId()));
        return conf;
    }

    //metodo de obtener lista de personal
    public ResultSet getListaPersonal() {
        rs = this.crud_personal.selectXtodas();
        return this.rs;
    }

    //metodos de insercion a la tabla personal
    public boolean agregarPersonal() {
        //this.datosPersonal[0] = this.getPersonaId();
        this.datosPersonal[0] = this.getNombrePersona();
        this.datosPersonal[1] = this.getPersonaAp();
        this.datosPersonal[2] = this.getPersonaAm();
        this.datosPersonal[3] = this.getPersonaCalle();
        this.datosPersonal[4] = this.getPersonaTelefono();
        this.datosPersonal[5] = this.getPersonaColonia();
        this.datosPersonal[6] = this.getPersonalUsuario();
        this.datosPersonal[7] = this.getPersonalPassword();
        this.datosPersonal[8] = this.getPersonalTipoPersonal();
        this.datosPersonal[9] = this.getPersonaCruzamiento();
        this.datosPersonal[10] = this.getPersonaCruzamiento1();
        this.datosPersonal[11] = this.getPersonaCodigoPostal();

        if (this.crud_personal.agregar(this.datosPersonal)) {
            return true;
        } else {
            return false;
        }
    }
}
