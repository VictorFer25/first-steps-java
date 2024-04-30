package registrarAcceso;

import java.sql.Connection;
import java.sql.DriverManager;

public class conexionBD {
	private Connection conexion = null;
	private String url = "jdbc:postgresql://localhost:5432/Sistema_control_escolar";
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