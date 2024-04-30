/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionarLibros;

/**
 *
 * @author Yoviicttoorr
 */
import java.sql.Connection;
import java.sql.DriverManager;

public class conexionBD {
	private Connection conexion = null;
        //private String url = "jdbc:postgresql://host97.ddns.net:5432/Sistema_control_escolar";
	private String url = "jdbc:postgresql://localhost:5432/Sistema_control_escolar";
        //private String url = "jdbc:postgresql://192.168.43.79:5432/Sistema_control_escolar";
	private String usuario = "examen";
	private String contraseña = "examen";
	
	public Connection obtenerConexion(){
		try{
			Class.forName("org.postgresql.Driver");
			this.conexion = DriverManager.getConnection(this.url,this.usuario,this.contraseña);
			return this.conexion;
		}catch(Exception e){
			e.printStackTrace();
			return this.conexion;
		}
	}
}
