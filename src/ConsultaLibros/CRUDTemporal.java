/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsultaLibros;

import GestionarLibros.conexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alan
 */
public class CRUDTemporal {

    private conexionBD conexion = new conexionBD();
    private Connection con;
    private Statement st;
    private ResultSet rs;
    
    public CRUDTemporal(){
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
    
    public boolean agregarRegistroTemporal(int folio,ArrayList<Integer> librosId,int usuario_id){
        try{
            String sql = "INSERT INTO temporal (folio,libro_id,usuario_id) "
                    + "VALUES (?,?,?);";
            
            PreparedStatement pst = this.con.prepareStatement(sql);
            
            for (int i = 0; i <librosId.size();i++){
                pst.setInt(1, folio);
                pst.setInt(2, librosId.get(i));
                pst.setInt(3, usuario_id);
                pst.executeUpdate();
            }
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public ResultSet getLimitePrestamos(){
        try{
            String sql = "SELECT * FROM limitePrestamos;";
            PreparedStatement pst = this.con.prepareStatement(sql);
            this.rs = pst.executeQuery();
        }catch(Exception e){
            e.printStackTrace();
        }
        return this.rs;
    }
    
     public ResultSet verificarFolio(int folio) {
        try {
            String sql = "SELECT * FROM temporal WHERE folio = " + folio + ";";
            this.rs = this.st.executeQuery(sql);
            return this.rs;
        } catch (Exception e) {
            e.printStackTrace();
            return this.rs;
        }
    }
     
    public boolean insertarDatosPrestamo(int folio, ArrayList<Integer> librosId, String estadoPrestamo, int usuario_id) {
        try {
            String sql = "INSERT INTO temporal (folio_id,libro_id,usuario_id) VALUES (?,?,?);";
            PreparedStatement pS = this.con.prepareStatement(sql);
            for (int i = 0; i < librosId.size(); i++) {
                pS.setInt(1, folio);
                pS.setInt(2, librosId.get(i));
                pS.setString(3, estadoPrestamo);
                pS.setInt(4, usuario_id);
                pS.executeUpdate();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    } 
}
