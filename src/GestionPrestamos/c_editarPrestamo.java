package GestionPrestamos;

import java.sql.ResultSet;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class c_editarPrestamo {
    //private String personal_id;
    private ResultSet rs;
    private i_editarPrestamo iep;
    private E_prestamo ep;
    
    public c_editarPrestamo(){
        this.ep = new E_prestamo();
        this.iep = new i_editarPrestamo();
    }
    
    public void PreparaInterfaz(String personal_id, String prestamo){
        //this.personal_id = personal_id;
        this.cargarDatosUsuario(prestamo);
        this.datosPersonal(personal_id);
        this.obtenerFecha();
        this.iep.mostrarListaPrestamo(this.ep.getPrestamos(prestamo));
        this.iep.jlFolio.setText(prestamo);
        this.iep.setVisible(true);
    }
    
    public void obtenerFecha(){
        Calendar cal = Calendar.getInstance();
        
        cal.add(Calendar.MONTH, 1);
        // obtiene la fecha actual del sistema y la concatena todo en una variable
        String fechaPrestamo = cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DATE);
        this.iep.jlFechaPrestamo.setText(fechaPrestamo);
        
        // a fecha le suma tres, para la la fecha de entrega
        cal.add(Calendar.DATE, 3); 
        
        // nueva fecha, la cual sera la de entrega del libro;
        //String fechaDevolucion = cal.get(Calendar.DATE)+"/"+cal.get(Calendar.MONTH)+"/"+cal.get(Calendar.YEAR);
        String fechaDevolucion = cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DATE);
        this.iep.jlfechaDevolucion.setText(fechaDevolucion);
    }
    
    public void cargarDatosUsuario(String prestamo){
        this.rs = this.ep.obtenerNombre(prestamo);
        try{
            while(rs.next()){
                this.iep.jlMatricula.setText(rs.getString ("usuario_id"));
                this.iep.JlNombre.setText(rs.getString ("usuario_nombre"));
                this.iep.jlApellido1.setText(rs.getString ("usuario_primer_apellido"));
                this.iep.jlApellido2.setText(rs.getString ("usuario_segundo_apellido"));
            }
        }catch(Exception e) {
        }
    }
    
    public void datosPersonal(String personal){    
        //this.ep = new E_prestamo();
        this.rs = this.ep.datosPersonal(personal);
        
        try{
            while(this.rs.next()){
                this.iep.jlIdentifcadorP.setText(personal);
                this.iep.jlnombrePersonal.setText(this.rs.getString("personal_nombre"));
                this.iep.jlPrimerApellidoP.setText(this.rs.getString("personal_primer_apellido"));
                this.iep.jlSegundoApellidoP.setText(this.rs.getString("personal_segundo_apellido"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    public void actualizarRegistro(String libro_id, String estado){
        int con = JOptionPane.showConfirmDialog(null, "¿Desea actualizar el registro?", "Seleccione una opcion...", JOptionPane.YES_NO_OPTION);
        if (con == JOptionPane.YES_OPTION) {
            this.ep.setLibroId(libro_id);
            this.ep.setEstadoPrestamo(estado);
            if(this.ep.actualizaRegistro()){
                JOptionPane.showMessageDialog(null, "Se actualizo el registro con exito");
            }else {
                JOptionPane.showMessageDialog(null, "No se pudo completar, vuelva a intentar");
            }
        }
    }
    
    public void incrementaLibros(int cantidad, int libro_id){
        this.ep.actualizaCantidadLibro(cantidad, libro_id);
    }
    
    // fin de la clase
}