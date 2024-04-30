package Login;

import GestionarPersonal.CRUDPersonal;
import GestionarPersonal.E_Personal;
import Menu.Menu;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class c_identificarse {
    private ResultSet rs;
    Menu me;
    E_login el;
    
    public c_identificarse(){
        el = new E_login();
        me = new Menu();
    }
    
    public void desplegarPantallaPrincipal(){
        login l = new login();
        l.setVisible(true);
    }
    
    public boolean verificaDatos(String usuario, String password){
        
        boolean valor = false;
        
        try {
            if(el.verificarUsuario(usuario)){
                if(el.verificarPassword(usuario, password)){
                    this.rs = el.DatosPersonal(usuario, password);
                    if(el.verificarTipoPersonal(usuario)){
                        // encargado
                        me.desplegarInterfazMenu(this.rs);
                        valor = true;
                        // mando a llamar al metodo de desplegar menu para encargapo
                    }else{
                        //auxiliar
                        me.desplegarInterfazMenu(this.rs);
                        valor = true;
                    }
                }else{
                    JOptionPane.showMessageDialog(null, "Password incorrecta");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Usuario invalido");
            }
        } catch (SQLException ex) {
            Logger.getLogger(c_identificarse.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
    
    public void DatosPersonal(){
    
    }
}