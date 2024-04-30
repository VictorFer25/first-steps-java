/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionarUsuarios;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author elmer
 */
public class e_Usuario extends e_Persona {

    CRUDUsuarios cl = new CRUDUsuarios();
    private String matricula;

    //constructor
    public ResultSet getListaUsuarios() {
        CRUDUsuarios cl = new CRUDUsuarios();
        this.rs = cl.selectXtodas();
        return rs;
    }
    public ResultSet obtenerDatosUsuarios(){
        rs = cl.selectMatriculaTodos(this.getMatricula());
        return rs;
    }
    /**
     * @return the matricula
     */
    public String getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(String matricula) {
        this.matricula = matricula;
        System.out.println("matricula entidad" + this.matricula);
    }

    //llama al metodo altaUsuario para guardar un registro
    public boolean agregarUsuario() {
        CRUDUsuarios bd = new CRUDUsuarios();
        return bd.altaUsuario(Tipo, matricula, Persona_Nombre, Persona_Ap, Persona_Am, Persona_Fecha, Persona_Correo ,Persona_Calle, Persona_Cruzamiento1, Persona_Cruzamiento2, Persona_Colonia, Persona_Telefono, Persona_NumCasa,Persona_LugarTrabajo,Persona_PuestoTrabajo);
    }

    //Buscar todos los registros por el nombre dato
    public ResultSet getListaUsuarioPorNombre(String Datos, int opcion) {

        //hace un cast para saber que metodo que metodo va a mandar a llamar
        switch (opcion) {
            //si al opcion es uno, busca por nombre
            case 1:
                rs = this.cl.selectXnombre(Datos);
                return rs;
            //si la opcion es dos busca por apellido
            case 2:
                rs = this.cl.selectXapellido(Datos);
                return rs;
            //si la opcion es tres busca por matricula
            case 3:
                if (Datos.length() == 0) {
                    rs = this.cl.selectXtodas();
                } else {
                    rs = this.cl.selectXmatricula(Datos);
                }

                return rs;
            default:
                break;
        }
        return null;
    }

    //metodo que elimina un usuario
    public boolean eliminarUsuario() {
        return this.cl.deleteUser(this.matricula);
    }

    //metodo que regresa la consulta de una matricula
    public boolean verificarExistencia(String matricula) {
        rs = cl.selectXmatricula(matricula);
        boolean resultado = false;
        try {
            resultado = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
       }
        return resultado;
    }

    public ResultSet cargarDatos() {
        //llama la consulta y le manda como parametro la matricula
        this.rs = this.cl.selectMatriculaTodos(this.getMatricula());
        return rs;
    }
}
