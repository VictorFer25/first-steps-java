/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsultaLibros;

//import sistemabiblioteca.conexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CRUDPrestamo {
    
    private conexionBD conexion = new conexionBD();
    private Connection con;
    private Statement st;
    private ResultSet rs;
    private Object datos = new Object();
    
    public CRUDPrestamo(){
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
    
    public ResultSet verificarFolio(int folio){
        try {
            String sql = "SELECT * FROM prestamo WHERE prestamo_id = " + folio + ";";
            this.rs = this.st.executeQuery(sql);
            return this.rs;
        } catch (Exception e) {
            e.printStackTrace();
            return this.rs;
        }
    }
    
    
    
}
