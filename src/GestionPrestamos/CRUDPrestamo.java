package GestionPrestamos;


import GestionarLibros.conexionBD;
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
    public Object datos = new Object();
    
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
    
    //consultas de la interfaz_general;
    public ResultSet selectXtodas() {
        try {
            String sql = "select p.prestamo_id, u.usuario_nombre, u.usuario_primer_apellido, p.fecha_prestamo, pe.personal_nombre, p.fecha_devolucion, pe.personal_nombre "
                    + "from prestamo p "
                    + "inner join usuario u on p.usuario_id = u.usuario_id "
                    + "inner join personal pe on p.personal_id_salida = pe.personal_id ";
                    //+ "inner join detalleprestamo dp on dp.prestamo_id = p.prestamo_id "
                    //+ "and p.personal_id_entrada = pe.personal_id "
                    //+ "and dp.estado_prestamo = 'prestado' limit 1;";
            PreparedStatement pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    
    //------------------------------------------------------------------------------------------------------------
    
    // consultas de la interfaz agregar
    public ResultSet tablaXfolio(String  folio){
        try{
            String sql = "select l.libro_id, l.libro_titulo, l.libro_clave, a.autor_nombre, libro_cantidad from temporal t "
                    + "inner join libro l on t.libro_id = l.libro_id inner join autor a on l.autor_id = a.autor_id where t.folio = ? or t.usuario_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(folio));
            pst.setInt(2, Integer.parseInt(folio));
            this.rs = pst.executeQuery();
            return this.rs;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean registroPrestamo(Object[] datosPrestamo){
        try{
            String sql = "insert into prestamo "
                    + "values(?, ?, ?, ?, ?, ?);";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt (1, Integer.parseInt(datosPrestamo[0].toString())); //prestamo_id
            pst.setInt (2, Integer.parseInt(datosPrestamo[1].toString())); //usuario_id
            pst.setInt (3, Integer.parseInt(datosPrestamo[2].toString())); // personal_id_salida
            pst.setDate(4, java.sql.Date.valueOf(datosPrestamo[3].toString())); // fecha_prestamo
            pst.setDate(5, java.sql.Date.valueOf(datosPrestamo[4].toString())); // fecha_devolucion
            pst.setInt (6, Integer.parseInt(datosPrestamo[2].toString()));  //personal_id_entrada
            pst.execute();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean registroDetallePrestamo(Object[] datosDetalle){
        try{
            String sql = "insert into detallePrestamo values(?, ?, ?, ?)";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt (1, Integer.parseInt(datosDetalle[0].toString())); //prestamo_id
            pst.setInt (2, Integer.parseInt(datosDetalle[1].toString())); //libro_id
            pst.setObject  (3, datosDetalle[2]); // estado_prestamo
            pst.setObject  (4, datosDetalle[3]); // prestamo_tipo
            pst.execute();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public ResultSet verificarPrestamo(String prestamo){
        try{
            String sql = "select prestamo_id from prestamo where prestamo_id = ?;";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(prestamo));
            this.rs = pst.executeQuery();
            return rs;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    //-----------------------------------------------------------------------------------------
    
    // consultas de aditar prestamo
    
    public ResultSet tablaXprestamo(String prestamo){
        try{
            String sql = "select l.libro_id, l.libro_titulo, l.libro_clave, a.autor_nombre, l.libro_cantidad "
                    + "from detallePrestamo dp "
                    + "inner join libro l on dp.libro_id = l.libro_id "
                    + "inner join autor a on a.autor_id = l.autor_id where dp.prestamo_id = ?  and dp.estado_prestamo = 'prestado'";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(prestamo));
            this.rs = pst.executeQuery();
            return this.rs;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public boolean eliminarRegistro(String registro){
        try{
            String sql ="delete from temporal where folio = ?;";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(registro));
            pst.execute();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean actualizaPrestamo(String estado, String libro_id){
        try{
            String sql = "update detalleprestamo set estado_prestamo = ? where libro_id = ?;";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setString (1, estado);
            pst.setInt    (2, Integer.parseInt(libro_id));
            pst.execute();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
    
    public void actualizaCantidadLibro(int cantidad, int libro_id){
        try{
            String sql = "update libro set libro_cantidad = ? where libro_id = ?";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt (1, cantidad);
            pst.setInt (2, libro_id);
            pst.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    //-----------------------------------------------------------------------------
    
    
    // consultas compartidas
    public ResultSet busquedaAlumno(String Matricula){
        try{
            String sql = "select u.usuario_id, u.usuario_nombre, u.usuario_primer_apellido, u.usuario_segundo_apellido"
                    + " from temporal t inner join usuario u "
                    + "on t.usuario_id = u.usuario_id where t.folio = ? or t.usuario_id = ? limit 1;";
            PreparedStatement pst = con.prepareStatement(sql);
            pst.setInt(1, Integer.parseInt(Matricula));
            pst.setInt(2, Integer.parseInt(Matricula));
            this.rs = pst.executeQuery();
            return this.rs;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public ResultSet datosPersonal(String personal_id){
        try{
        String sql = "select personal_nombre, personal_primer_apellido, personal_segundo_apellido "
                + "from personal where personal_id = ?;";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setInt(1, Integer.parseInt(personal_id));
        this.rs = pst.executeQuery();
        return this.rs;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
}