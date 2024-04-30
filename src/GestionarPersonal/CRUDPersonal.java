
package GestionarPersonal;

import GestionarLibros.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class CRUDPersonal {

    private conexionBD conexion = new conexionBD();
    private Connection con;
    private Statement st;
    private ResultSet rs;
    public Object datos = new Object();

    public CRUDPersonal() {
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
    //Metodo que trae todos los libros

    public ResultSet selectXtodas() {
        try {
            String sql = "select * from personal;";
            rs = st.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // datos reg String nombre, String apellido_p, String apellido_m, String telefono, String colonia, String usuario, String password,String tipo_personal
    // Agrega un nuevo registro
    public boolean agregar(Object[] datosPersonal) {
        try {
            String SQL = "INSERT INTO personal (personal_nombre,"
                    + "personal_primer_apellido,personal_segundo_apellido,"
                    + "personal_calle,personal_telefono,"
                    + "personal_colonia,personal_usuario,personal_password,"
                    + "personal_tipoPersonal,cruzamiento_1,cruzamiento_2,codigo_postal)"
                    + " values (?,?,?,?,?,?,?,?,?,?,?,?);";

            PreparedStatement pst = this.con.prepareStatement(SQL);
            pst.setString(1, datosPersonal[0].toString());
            pst.setString(2, datosPersonal[1].toString());
            pst.setString(3, datosPersonal[2].toString());
            pst.setString(4, datosPersonal[3].toString());
            pst.setString(5, datosPersonal[4].toString());
            pst.setString(6, datosPersonal[5].toString());
            pst.setString(7, datosPersonal[6].toString());
            pst.setString(8, datosPersonal[7].toString());
            pst.setString(9, datosPersonal[8].toString());
            pst.setString(10, datosPersonal[9].toString());
            pst.setString(11, datosPersonal[10].toString());
            pst.setInt(12, Integer.parseInt(datosPersonal[11].toString()));
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // elimina un Registro
    public boolean eliminar(String p_id) {
        try {
            String sql = "DELETE FROM personal WHERE personal_id = '" + p_id + "';";
            st.executeUpdate(sql);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // busca un registro
    public ResultSet buscarPorID(String Id) {
        try {
            String sql = "SELECT * FROM personal WHERE personal_id = '" + Id + "'"
                    + ";";
            rs = st.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet buscarPorNombre(String nombre) {
        try {
            String sql = "Select * from personal where personal_nombre ILIKE '%" + nombre + "%';";
            rs = st.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // actualiza los datos de un registro.
    public boolean actualizar(Object[] datosPersonal,int personal_id) {
        try {
            String SQL = "UPDATE personal SET personal_nombre = ?,personal_primer_apellido = ?"
                    + ",personal_segundo_apellido = ?,personal_calle = ?,personal_telefono = ?"
                    + ",personal_colonia = ?,personal_usuario = ?,personal_password = ?"
                    + ",personal_tipopersonal = ?,cruzamiento_1 = ?, cruzamiento_2 = ?"
                    + ",codigo_postal = ? WHERE personal_id = ?";

            PreparedStatement pst = this.con.prepareStatement(SQL);
            pst.setString(1, datosPersonal[0].toString());
            pst.setString(2, datosPersonal[1].toString());
            pst.setString(3, datosPersonal[2].toString());
            pst.setString(4, datosPersonal[3].toString());
            pst.setString(5, datosPersonal[4].toString());
            pst.setString(6, datosPersonal[5].toString());
            pst.setString(7, datosPersonal[6].toString());
            pst.setString(8, datosPersonal[7].toString());
            pst.setString(9, datosPersonal[8].toString());
            pst.setString(10, datosPersonal[9].toString());
            pst.setString(11, datosPersonal[10].toString());
            pst.setInt(12, Integer.parseInt(datosPersonal[11].toString()));
            pst.setInt(13, personal_id);
            pst.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ResultSet buscarPorFiltroNombre(String filtro) {
        try {
            String SQL = "SELECT * FROM personal WHERE personal_nombre ILIKE '%" + filtro + "%';";
            this.rs = this.st.executeQuery(SQL);
            return this.rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet buscarPorFiltroApellido(String filtro) {
        try {
            String SQL = "SELECT * FROM personal WHERE personal_primer_apellido ILIKE '%" + filtro + "%';";
            this.rs = this.st.executeQuery(SQL);
            return this.rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet DatosPersonales(String personal_id) {
        try {
            String SQL = "SELECT * FROM personal "
                    + "WHERE personal_id = '" + personal_id + "';";
            this.rs = this.st.executeQuery(SQL);
            return this.rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet verificarExistenciaUsr(String usuario) {
        try {
            String SQL = "SELECT * FROM personal "
                    + "WHERE personal_usuario = '" + usuario + "';";

            this.rs = this.st.executeQuery(SQL);
            return this.rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet verificarExistenciaPersona(String pNombre, String aPaterno) {
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

    public ResultSet VerificarUsuario(String usuario) {
        try {
            String sql = "select personal_usuario from personal where personal_usuario = '" + usuario + "';";
            rs = st.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet VerificarPassword(String usuario) {
        try {
            String sql = "select personal_password from personal where personal_usuario = '" + usuario + "';";
            rs = st.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet VerificarTipoUsuario(String usuario) {
        try {
            String sql = "select personal_tipoPersonal from personal where personal_usuario = '" + usuario + "';";
            rs = st.executeQuery(sql);
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
