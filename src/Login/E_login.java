package Login;

import Login.CRUDLogin;
import java.sql.ResultSet;
import java.sql.SQLException;

public class E_login {
    
    //atributos de la clase Personal
    CRUDLogin cl = new CRUDLogin();
    private ResultSet rs = null;
    
    public boolean verificarUsuario(String usuario) throws SQLException{
        this.rs = cl.VerificarUsuario(usuario);
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
        this.rs = cl.VerificarPassword(usuario);
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
        this.rs = cl.VerificarTipoUsuario(usuario);
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
    
    public ResultSet DatosPersonal(String usuario, String password){
    this.rs = this.cl.datosPersonal(usuario, password);
    return this.rs;
    }
}
