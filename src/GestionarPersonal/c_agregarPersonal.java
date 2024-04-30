/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionarPersonal;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author Yovii
 */
public class c_agregarPersonal {

    private i_agregarPersonal iap;
    //Object e = new Object();
    private i_gestionarPersonal personal;
    
    private final E_Personal pe;

    private c_agregarPersonal cap;
    
    public c_agregarPersonal() {
        //iap = new i_agregarPersonal();
        //iap.setVisible(true);
        
        this.pe = new E_Personal();
    }

    public void setGestionarPersonal(i_gestionarPersonal aPersonal) {
        //le asigno a mi variable de tipo personal 
        //el objeto que recibo de la clase gestionar personal
        this.personal = aPersonal;
    }
    
    public void setAgregarPersonal(c_agregarPersonal cAP){
        this.cap = cAP;
    }

    public void setIap(i_agregarPersonal iap) {
        this.iap = iap;
    }

    public void getPrepararInterfaz() {
        //cargo mi interfaz
        //y le vuelvo a mandar mi interfaz de gestionar
        this.iap = new i_agregarPersonal();
        this.iap.setGestionarPersonal(personal);
        //deshabilito el boton de actualizar
        this.iap.setVisibleLabel6(true);
        this.iap.setAgregarPersonal(this.cap);
        this.iap.setVisible(true);
        //hago visible

    }

    public void registrarPersonal(Object[] datos) {
        
        int con = JOptionPane.showConfirmDialog(null, "¿Deseas guardar el personal?", "Seleccione una opcion...", JOptionPane.YES_NO_OPTION);
        if (con == JOptionPane.YES_OPTION) {
            String usuario = datos[6].toString();
            boolean usrVer = this.ExistenciaDeusuario(usuario);
            if (!usrVer) {

               
                pe.setPersonaNombre(datos[0].toString());
                pe.setPersonaAp(datos[1].toString());
                pe.setPersonaAm(datos[2].toString());
                pe.setPersonaCalle(datos[3].toString());
                pe.setPersonaTelefono(datos[4].toString());
                pe.setPersonaColonia(datos[5].toString());
                pe.setPersonalUsuario(datos[6].toString());
                pe.setPersonalPassword(datos[7].toString());
                pe.setPersonalTipoPersonal(datos[8].toString());
                pe.setPersonaCruzamiento1(datos[9].toString());
                pe.setPersonaCruzamiento2(datos[10].toString());
                pe.setCodigoPostal(Integer.parseInt(datos[11].toString()));
                if (pe.agregarPersonal()) {
                    
                    //carga los datos a la tabla de mi interfaz gestionar personal
                    this.personal.mostrarListaPersonal(new E_Personal().getListaPersonal());
                    JOptionPane.showMessageDialog(null, "Personal registrado");
                    this.iap.limpiarCampos();
                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo completar vuelva a intentar");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Usuario ya existe","ERROR",JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public boolean ExistenciaDeusuario(String usuario) {

        boolean ver = false;
        try {
            E_Personal per = new E_Personal();
            per.setPersonalUsuario(usuario);
            ResultSet rs = per.verificarExistenciaUsuario();
            ver = rs.next();
            return ver;
        } catch (Exception E) {
            E.printStackTrace();
            return ver;
        }
    }
    
    public boolean ExistenciaPersonal(String nombre,String primerApellido) {
        boolean ver = false;
        try {
            E_Personal per = new E_Personal();
            per.setPersonaNombre(nombre);
            per.setPersonaAp(primerApellido);
            ResultSet rs = per.verificarExistenciaPersonal();
            ver = rs.next();
        } catch (Exception E) {
            E.printStackTrace();
        }
        return ver;
    }

    public void actualizarPersonal(Object[] datos) {
       boolean encaja = true;
        Pattern patron = Pattern.compile("[A-Za-z]*\\d*");
        
        for (int i = 0;i < datos.length;i++){
            Matcher match = patron.matcher(datos[i].toString());
            encaja = match.matches();
            if(!encaja){
                break;
            }
            
        }

        pe.setPersonaId(datos[0].toString());
        pe.setPersonaNombre(datos[1].toString());
        pe.setPersonaAp(datos[2].toString());
        pe.setPersonaAm(datos[3].toString());
        pe.setPersonaCalle(datos[4].toString());
        pe.setPersonaTelefono(datos[5].toString());
        pe.setPersonaColonia(datos[6].toString());
        pe.setPersonalUsuario(datos[7].toString());
        pe.setPersonalPassword(datos[8].toString());
        pe.setPersonalTipoPersonal(datos[9].toString());
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION && encaja) {
            if (pe.modificarPersonal()) {
                this.iap.dispose();
                this.personal.mostrarListaPersonal(new E_Personal().getListaPersonal());
                JOptionPane.showMessageDialog(null, "Personal Actualizado correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar personal", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
//}
