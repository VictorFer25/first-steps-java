/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsultaLibros;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Yoviicttoorr
 */
public class CRUDUsuario {

    private conexionBD conexion = new conexionBD();
    private Connection con;
    private Statement st;
    private ResultSet rs;

    //constructor
    public CRUDUsuario() {
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
    
    public ResultSet verificarUsuario(int usuario){
        try{
            String sql = "SELECT * FROM usuario WHERE usuario_id = ?";
            PreparedStatement pst = this.con.prepareStatement(sql);
            pst.setInt(1, usuario);
            
            this.rs = pst.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
        return this.rs;
    }
    
    public ResultSet getCantidadLibrosPrestados(int usuario_id){
        try{
            String Sql = "SELECT COUNT(libro_id) AS totalLibros FROM usuario u "
                    + "INNER JOIN prestamo p ON p.usuario_id = u.usuario_id "
                    + "INNER JOIN detallePrestamo dP ON dP.prestamo_id = p.prestamo_id "
                    + "WHERE u.usuario_id = ? AND dP.estado_prestamo = 'Prestado';";
            PreparedStatement pst = this.con.prepareStatement(Sql);
            pst.setInt(1, usuario_id);
            this.rs = pst.executeQuery();
            return this.rs;
        }catch(Exception e){
            e.printStackTrace();
        }
        return this.rs;
    }
    
    public ResultSet getLibrosId(int usuario_id){
        try{
            String Sql = "SELECT libro_id FROM usuario u "
                    + "INNER JOIN prestamo p ON p.usuario_id = u.usuario_id "
                    + "INNER JOIN detallePrestamo dP ON dP.prestamo_id = p.prestamo_id "
                    + "WHERE u.usuario_id = ? AND dP.estado_prestamo = 'Prestado';";
            PreparedStatement pst = this.con.prepareStatement(Sql);
            pst.setInt(1, usuario_id);
            this.rs = pst.executeQuery();
            return this.rs;
        }catch(Exception e){
            e.printStackTrace();
        }
        return this.rs;
    }
}