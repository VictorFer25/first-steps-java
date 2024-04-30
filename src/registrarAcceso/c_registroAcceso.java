package registrarAcceso;

import java.util.regex.*;
import javax.swing.JOptionPane;

public class c_registroAcceso {

    i_Acceso ia;
    E_Acceso ea;
    
    public c_registroAcceso(){
        ea = new E_Acceso();
    }
    
    public void limpiarPantalla(){
        ia.jtMatricula.setText("");
    }
    
    public void preparaInterfazRegistrarAcceso(){
        ia = new i_Acceso();
        ia.setVisible(true);
        //ia.desplegarInterfazRegistro();
    }
    
    public void guardarRegistro(String matricula){
    
        // comprueba datos el usuario
	Pattern patron = Pattern.compile(".{8}\\d{0,9}");
	Matcher coincidencia = patron.matcher(matricula);
	boolean existe = coincidencia.matches();
        
        if (existe){
            ea.getMatricula(matricula);
            JOptionPane.showMessageDialog(null, "Gracias por su tiempo");
        }else{
            JOptionPane.showMessageDialog(null, "matricula erronea");
        }
    }
}