package Login;


import GestionarLibros.conexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CRUDLogin {

    private conexionBD conexion = new conexionBD();
    private Connection con;
    private Statement st;
    private ResultSet rs;
    public Object datos = new Object();

    public CRUDLogin() {
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
    
    public ResultSet verificarExistenciaPersona(String pNombre,String aPaterno) {
        try {
            String SQL = "SELECT * FROM personal "
                    + "WHERE personal_nombre = ? AND personal_primer_apellido = ?;";
            PreparedStatement pst = this.con.prepareStatement(SQL);
            pst.setString(1, pNombre);
            pst.setString(2, aPaterno);
            this.rs = pst.executeQuery();
            return this.rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet VerificarUsuario(String usuario){
        try{
            String sql = "select personal_usuario from personal where personal_usuario = '"+usuario+"';";
            rs = st.executeQuery(sql);
            return rs;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet VerificarPassword(String usuario){
        try{
            String sql = "select personal_password from personal where personal_usuario = '"+usuario+"';";
            rs = st.executeQuery(sql);
            return rs;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet VerificarTipoUsuario(String usuario){
        try{
            String sql = "select personal_tipoPersonal from personal where personal_usuario = '"+usuario+"';";
            rs = st.executeQuery(sql);
            return rs;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet datosPersonal(String usuario, String password){
        try{
            String sql = "select personal_id from personal where personal_usuario = ? and personal_password = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString(1, usuario);
            pst.setString(2, password);
            this.rs = pst.executeQuery();
            return this.rs;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}