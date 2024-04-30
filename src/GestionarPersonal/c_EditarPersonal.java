/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionarPersonal;

import java.sql.ResultSet;
import javax.swing.JOptionPane;



/**
 *
 * @author alan
 */
public class c_EditarPersonal {
    
    private i_EditarPersonal eP;
    private i_gestionarPersonal personal;
    private final E_Personal pe; 
    
    
    public c_EditarPersonal(){
        this.pe = new E_Personal();
    }
    
    public void preparazInterEditarPersonal(){
        this.eP = new i_EditarPersonal();
        this.eP.setGestionarPersonal(this.personal);
        this.eP.setVisible(true);
    }
    
     public void setIep(i_EditarPersonal eP) {
        this.eP = eP;
    }
     public void setGestionarPersonal(i_gestionarPersonal aPersonal) {
        //le asigno a mi variable de tipo personal 
        //el objeto que recibo de la clase gestionar personal
        this.personal = aPersonal;
    }
     
     
     
    public void cargarDatosEdicion(String personal_id) {

        try {
            this.pe.setPersonaId(personal_id);
            ResultSet rs = this.pe.cargarDatos();
            if (rs.next()) {
                rs = pe.cargarDatos();
                this.eP.cargarDatosPersonal(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    
    public void actualizarPersonal(Object[] datos) {
        this.pe.setPersonaId(datos[0].toString());
        this.pe.setPersonaNombre(datos[1].toString());
        this.pe.setPersonaAp(datos[2].toString());
        this.pe.setPersonaAm(datos[3].toString());
        this.pe.setPersonaCalle(datos[4].toString());
        this.pe.setPersonaTelefono(datos[5].toString());
        this.pe.setPersonaColonia(datos[6].toString());
        this.pe.setPersonalUsuario(datos[7].toString());
        this.pe.setPersonalPassword(datos[8].toString());
        this.pe.setPersonalTipoPersonal(datos[9].toString());
        this.pe.setPersonaCruzamiento1(datos[10].toString());
        this.pe.setPersonaCruzamiento2(datos[11].toString());
        this.pe.setCodigoPostal(Integer.parseInt(datos[12].toString()));
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            if (this.pe.modificarPersonal()) {
                this.eP.dispose();
                this.personal.mostrarListaPersonal(new E_Personal().getListaPersonal());
                JOptionPane.showMessageDialog(null, "Personal Actualizado correctamente", "Correcto", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar personal", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
