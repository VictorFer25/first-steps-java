/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionarUsuarios;

import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Elmer Yam
 */
public class c_gestionarUsuario {

    public ResultSet listaUsuarios;
    private i_gestionarUsuarios igu;
    e_Usuario Eu;
    
    //constructor de esta clase
    public c_gestionarUsuario() {

        e_Usuario lib = new e_Usuario();
        this.listaUsuarios = lib.getListaUsuarios();
        Eu = new e_Usuario();
        //igu = new i_gestionarUsuarios();

    }
    
    public void setGestionarUsuarios(i_gestionarUsuarios obj_Usuario){
        this.igu = obj_Usuario;
    }

    //Este metodo despliega la interfaz de gestionar usuario en pantalla
    public void prepararInterfaz() {
        //Se crea la instancia
        i_gestionarUsuarios igu = new i_gestionarUsuarios();
        //Carga todos los datos de los usuarios
        igu.mostrarListaUsuarios(listaUsuarios);
        //Despliega interfaz
        igu.setVisible(true);

    }

    //Este metodo busca a un usuario por el dato y por la opcion seleccionada
    public void buscarUsuarioPorNombre(String Dato, int opcion) {
        //le dice a la entidad usuario que obtenga una lista con la consulta
        ResultSet listanombre = Eu.getListaUsuarioPorNombre(Dato, opcion);
        //mandamos el resultset al metodo que pone los datos en la tabla
        this.igu.mostrarListaUsuarios(listanombre);
    }

    //Este metodo Puede eliminar datos de un usuario en la base de datos
    public boolean eliminarRegistroUsuario(String matri) {
        Eu.setMatricula(matri);
        boolean confirmacion = Eu.eliminarUsuario();
        if(confirmacion){
             JOptionPane.showMessageDialog(null, "Personal Eliminado", "Eliminado", JOptionPane.INFORMATION_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(null, "Error al eliminar", "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        return confirmacion;
    }

    public ResultSet getListaPersonal() {
        this.listaUsuarios = this.Eu.getListaUsuarios();
        return this.listaUsuarios;
    }
}
