package GestionPrestamos;

import java.sql.ResultSet;
import java.util.Calendar;
import javax.swing.JOptionPane;

public class c_agregarPrestamo {
    
    private ResultSet rs;
    private String personal_id;
    E_prestamo ep;
    i_agregarPrestamo iap;
    
    public c_agregarPrestamo(){
        this.iap = new i_agregarPrestamo();
        this.ep = new E_prestamo();
    }
    
    public void PreparaInterfaz(String personal_id){
        this.personal_id = personal_id;
        this.iap.personal_id = personal_id;
        this.obtenerFecha();
        this.datosPersonal();
        this.iap.setVisible(true);
    }
    
    // uno de los metodos principal que trabaja con la tabla detallePrestamo en la db
    //este funciona con for en la interfaz
    public void agregarDetallePrestamo(Object[] datosPrestamo){
           
        ep.setLibroId(datosPrestamo[0].toString());
        ep.setEstadoPrestamo(datosPrestamo[1].toString());
        ep.setPrestamoTipo(datosPrestamo[2].toString());
        
        if(ep.agregarDetallePrestamo()){
            
        }else {
        }
    }
    
    // segundo metodo principal, el cual trabaja con la tabla prestamo
    // realiza solo una insersion en la tabla.
    public void agregarPrestamo(Object[] datosPrestamo){
        
        int con = JOptionPane.showConfirmDialog(null, "¿Desea guardar el prestamo?", "Seleccione una opcion...", JOptionPane.YES_NO_OPTION);
        if (con == JOptionPane.YES_OPTION) {

            ep.setFolio(datosPrestamo[0].toString());
            ep.setUsuarioId(datosPrestamo[1].toString());
            ep.setPersonalIdSalida(datosPrestamo[2].toString()); //id personal en el momento de la entrega
            ep.setFechaPrestamo(datosPrestamo[3].toString());
            ep.setFechaDevolucion(datosPrestamo[4].toString());
            
            if(ep.AgregarPrestamo()){
                JOptionPane.showMessageDialog(null, "prestamo registrado");
            }else {
                JOptionPane.showMessageDialog(null, "No se pudo completar vuelva a intentar");
            }
        }
    }
    
    //metodo que manda la cantidad de libros y su id y lo decrementa en 1, cuando se realize un prestamo;
    public void decrementarLibro(int cantidad, int libro_id){
        this.ep.actualizaCantidadLibro(cantidad, libro_id);
    }
    
    public void obtenerFecha(){
        Calendar cal = Calendar.getInstance();
        
        // obtiene la fecha actual del sistema y la concatena todo en una variable
        //cal.add(Calendar.MONTH, 1);
        String fechaPrestamo = cal.get(Calendar.YEAR)+"-"+ (cal.get(Calendar.MONTH)+1)+"-"+cal.get(Calendar.DATE);
        //String fechaPrestamo = cal.get(Calendar.DATE)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.YEAR);
        this.iap.jlFechaPrestamo.setText(fechaPrestamo);
        
        // a fecha le suma tres, para la la fecha de entrega
        cal.add(Calendar.DATE, 3); 
        
        // nueva fecha, la cual sera la de entrega del libro;
        //String fechaDevolucion = cal.get(Calendar.DATE)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.YEAR);
        String fechaDevolucion = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DATE);
        this.iap.jlfechaDevolucion.setText(fechaDevolucion);
    }
    
    public void datosPersonal(){    
        //this.ep = new E_prestamo();
        this.rs = this.ep.datosPersonal(this.personal_id);
        
        try{
            while(this.rs.next()){
                this.iap.jlIdentifcadorP.setText(this.personal_id);
                this.iap.jlnombrePersonal.setText(this.rs.getString("personal_nombre"));
                this.iap.jlPrimerApellidoP.setText(this.rs.getString("personal_primer_apellido"));
                this.iap.jlSegundoApellidoP.setText(this.rs.getString("personal_segundo_apellido"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    
    // metodo secundario que busca los libros que se han registrados en la tabla temporal
    public ResultSet buscarFolio(String folio){
         this.obtenerNombre(folio);
        try{
            this.rs = ep.getListaFolio(folio);
            return this.rs; //retorna los datos del libro
        }catch(Exception e){
            return null;
        }
    }
    
    // obtiene el nombre del usuario el cual presto el libro;
    public ResultSet obtenerNombre(String folio){
        this.rs = this.ep.obtenerNombre(folio);
        return this.rs;
    }
     
    // requisito no funcional de segural que me permite validar si un prestamo ya esta registrado.
    public boolean validasPrestamo(String folio){
        this.rs = this.ep.VerificaPrestamo(folio);
        String validacion;
        boolean correcto = false;
        
        try{
            while (this.rs.next()){
                validacion = rs.getString("prestamo_id");
                 if (validacion != folio){
                     correcto =  true;
                 }else{
                     correcto = false;
                 }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return correcto;
    }
    // fin de la clase
}
