package registrarAcceso;

import javax.swing.JOptionPane;

public class E_Acceso {

    CRUDRegistro cr = new CRUDRegistro();
    private String matricula;
    
    public void getMatricula(String Matricula){
        this.matricula = Matricula;
    }
    
    public void setMatricula(String Matricula){
        this.matricula = Matricula;
        if(cr.agregar(matricula)){
        }else{
            JOptionPane.showMessageDialog(null,"Error con la conexion a la BD");
        }
    }
}
