/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionarUsuarios;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Yovii
 */
public class c_editarUsuario {

    private i_gestionarUsuarios obj_igl;
    private e_Usuario chatUser;
    private i_agregarUsuario obj_iau;

    public c_editarUsuario() {
        chatUser = new e_Usuario();
    }

    public void setInterfazGestionarUsuario(i_gestionarUsuarios usuario) {
        //le asigno a mi variable de tipo personal 
        //el objeto que recibo de la clase gestionar personal
        this.obj_igl = usuario;
    }

    public void setInterfazAgrefarusuario(i_agregarUsuario agregarUsuario) {
        this.obj_iau = agregarUsuario;
    }

    public void prepararInterfazAgregarUsuario() {
        i_agregarUsuario mensajeroI_Au = new i_agregarUsuario();
        mensajeroI_Au.setInterfazGestionarUsuario(obj_igl);
        mensajeroI_Au.desplegarInterfazAgregarUsuario();
    }

    //metodo para guardar un registro de un alumno
    public void guardarRegistro(String tipo, String matricula, String nombre, String aPaterno, String aMaterno, Date fecha, String correo, String Telefono,
            String colonia, String calle, String cruza1, String cruza2, String numCasa, String lugarT, String puestoT) {
        //variables para la comprovacion de fecha

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //String stringFechaConHora = "2014-09-15 ";
        //Date fechaConHora = sdf.parse(stringFechaConHora);

        Date fechaB = new Date(2000, 1, 1);

        long d = fechaB.getTime();
        java.sql.Date fechaC = new java.sql.Date(d);
        System.out.println(fecha);
        System.out.println(fechaC);

        //comprobamos que tipo de usuario es
        if (tipo.equals("Externo")) {
            matricula = String.valueOf(generarMatricula());
        }
        //si los campos requeridos estan vacios se manda un mensaje de advertencia
        if (matricula.length() == 0 || nombre.length() == 0 || aPaterno.length() == 0 || colonia.length() == 0 || calle.length() == 0) {
            JOptionPane.showMessageDialog(null, "Faltan campos por rellenar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else if (fecha.after(fechaB)) {
            //de lo contrario manda un mensaje de confirmacion para guardar los datos
            int con = JOptionPane.showConfirmDialog(null, "¿Desea Guardar los datos?", "Warning", JOptionPane.YES_NO_OPTION);

            //si acepta se guardan los datos en la base de datos
            if (con == JOptionPane.YES_OPTION) {
                if (!chatUser.verificarExistencia(matricula)) {
                    chatUser.setPersonaTipo(tipo);
                    chatUser.setPersonaNombre(nombre);
                    chatUser.setPersonaAp(aPaterno);
                    chatUser.setPersonaAm(aMaterno);
                    chatUser.setPersonaFecha(fecha);
                    chatUser.setPersonaCorreo(correo);
                    chatUser.setPersonaCalle(calle);
                    chatUser.setPersonaCruzamiento1(cruza1);
                    chatUser.setPersonaCruzamiento2(cruza2);
                    chatUser.setPersonaNumCasa(numCasa);
                    chatUser.setPersonaTelefono(Telefono);
                    chatUser.setPersonaColonia(colonia);
                    chatUser.setMatricula(matricula);
                    chatUser.setPersonaLugar(lugarT);
                    chatUser.setPersonaPuesto(puestoT);
                    //tengo que verificar usuario debe estar en la clase entidad usuario
                    if (chatUser.agregarUsuario()) {
                        JOptionPane.showMessageDialog(null, "Usuario registrado");
                        this.obj_igl.mostrarListaUsuarios(new e_Usuario().getListaUsuarios());
                        this.obj_iau.dispose();

                    } else {
                        JOptionPane.showMessageDialog(null, "No se pudo completar, vuelva a intentar");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "La matricula ya se encuentra registrado, Intente con otra");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "la fecha  de nacimiento es incorrecta", "Error", JOptionPane.WARNING_MESSAGE);
        }

    }

    //metodo para guardar un registro de un usuario externo
    public void guardarRegistroExterno(String tipo, String nombre, String aPaterno, String aMaterno, Date fecha, String correo, String Telefono,
            String Colonia, String calle, String cruza1, String cruza2, String numCasa, String lugar, String puesto) {
        //si los campos requeridos estan vacios se manda un mensaje de advertencia
        if (nombre.length() == 0 || calle.length() == 0) {
            JOptionPane.showMessageDialog(null, "Faltan campos por rellenar", "Advertencia", JOptionPane.WARNING_MESSAGE);
        } else {
            //de lo contrario manda un mensaje de confirmacion
            int dialogButton = JOptionPane.YES_NO_OPTION;
            JOptionPane.showConfirmDialog(null, "¿Desea Guardar los datos Introducidos?", "Advertencia", dialogButton);

            //si acepta se guardan los datos en la base de datos
            if (dialogButton == JOptionPane.YES_OPTION) {

                e_Usuario chatUser = new e_Usuario();

                //asignamos los valores al objeto usuario
                chatUser.setPersonaTipo(tipo);
                chatUser.setPersonaNombre(nombre);
                chatUser.setPersonaAp(aPaterno);
                chatUser.setPersonaAm(aMaterno);
                chatUser.setPersonaFecha(fecha);
                chatUser.setPersonaCorreo(correo);
                chatUser.setPersonaTelefono(Telefono);
                chatUser.setPersonaColonia(Colonia);
                chatUser.setPersonaCalle(calle);
                chatUser.setPersonaCruzamiento1(cruza1);
                chatUser.setPersonaCruzamiento2(cruza2);
                chatUser.setPersonaNumCasa(numCasa);
                chatUser.setPersonaLugar(lugar);
                chatUser.setPersonaPuesto(puesto);
                chatUser.agregarUsuario();

                if (chatUser.agregarUsuario()) {
                    JOptionPane.showMessageDialog(null, "Usuario registrado");

                } else {
                    JOptionPane.showMessageDialog(null, "No se pudo completar, vuelva a intentar");
                }
            }
        }

    }

    //metodo que genera una id para un externo
    public int generarMatricula() {
        int matricula;
        boolean verifica;
        //hacer la comprovacion asta que no sea una id repetida
        do {
            matricula = (int) (Math.random() * (999999 - 100000 + 1) + 100000);
            verifica = chatUser.verificarExistencia(String.valueOf(matricula));
        } while (verifica == true);
        //retorna la matricula generada
        return matricula;
    }

    //obtiene el objeto de la interfaz gestionar usuario
    void setEditarPersonal(i_gestionarUsuarios aThis) {
        //le asigno a mi variable de tipo personal 
        //el objeto que recibo de la clase gestionar usuarios
        this.obj_igl = aThis;
    }

    //obtiene los datos de los usuarios para poder mostrarlos en pantalla
    void obtenerDatosUsuario(String matricula) {
        
    }

    void prepararInterfazEditarUsuario() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
