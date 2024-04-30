package registrarAcceso;

import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CRUDRegistro {
    
    private conexionBD conexion = new conexionBD();
    private Connection con;
    private Statement st;
    
    public CRUDRegistro() {
        try{
            if((con = conexion.obtenerConexion())==null){
                JOptionPane.showMessageDialog(null,"Error con la conexion a la BD");
                return;
            }
            st = con.createStatement();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //Metodo que trae todos los libros
    public boolean agregar(String Matricula){
        try {
            String query = "insert into registroacceso values('"+Matricula+"', localtimestamp)";
            st.executeUpdate(query);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}