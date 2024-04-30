/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsultaLibros;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alan
 */
public class c_Confirmar {
    
    private confirmar con; 
    private Consulta consulta;
    
    public void preparazInterfaz(Object [] detalles,ArrayList <String> libros,ArrayList <Integer> librosId){
        this.con = new confirmar();
        this.con.setConsulta(this.consulta);
        this.con.setLibrosId(librosId);
        this.con.cargarDatos(detalles, libros);
        this.con.setVisible(true);
    }
    
    public void setConfirmar(confirmar con){
        this.con = con;
    }
    public void setConsulta(Consulta consulta){
        this.consulta = consulta;
    }
    
    
    public void AgregarRegistroTemporal(int folio, ArrayList<Integer> librosId,int usuario_id){
        Temporal fol = new Temporal();
        fol.setFolio(folio);
        fol.setLibrosId(librosId);
        fol.setUsuarioId(usuario_id);
        if(fol.agregarRegistroTemporal()){
            JOptionPane.showMessageDialog(null, "PRESTAMO EN PROCESO ACUDA CON EL PERSONAL", 
                    "EXITO",JOptionPane.INFORMATION_MESSAGE ,null);
            this.consulta.limpiarTabla(this.consulta.getModelo1());
            this.con.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "ERROR", "ERROR",JOptionPane.ERROR_MESSAGE ,null);
        }
        
    }
}
