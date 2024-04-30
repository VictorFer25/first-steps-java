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
public class CRUDFolio {

    private conexionBD conexion = new conexionBD();
    private Connection con;
    private Statement st;
    private ResultSet rs;

    public CRUDFolio() {
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

    public ResultSet verificarFolio(int folio) {
        try {
            String sql = "SELECT * FROM folio WHERE folio_id = " + folio + ";";
            this.rs = this.st.executeQuery(sql);
            return this.rs;
        } catch (Exception e) {
            e.printStackTrace();
            return this.rs;
        }
    }

    public boolean insertarDatosPrestamo(int folio, ArrayList<Integer> librosId, String estadoPrestamo, int usuario_id) {
        try {
            String sql = "INSERT INTO folio (folio_id,libro_id,estado_libro,usuario_id) VALUES (?,?,?,?);";
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
