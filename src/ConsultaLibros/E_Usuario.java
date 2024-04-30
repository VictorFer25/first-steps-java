/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsultaLibros;

/**
 *
 * @author alan
 */

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Yoviicttoorr
 */
public class E_Usuario extends E_Persona {

    CRUDUsuario cl;
    private int matricula;
    
    //constructor
    public E_Usuario(){
        this.cl = new CRUDUsuario();
    }

    /**
     * @return the matricula
     */
    
    public int getMatricula() {
        return matricula;
    }

    /**
     * @param matricula the matricula to set
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    //llama al metodo altaUsuario para guardar un registro

    //Buscar todos los registros por el nombre dato
   
    
    public ResultSet verificarUsuario(){
       ResultSet rs = this.cl.verificarUsuario(this.matricula);
       return rs;
    }
    
    public int getCantidadLibros(){
        int cantidadLibros = 0;
        ResultSet rs = this.cl.getCantidadLibrosPrestados(matricula);
        try{
            while(rs.next()){
                cantidadLibros = rs.getInt("totalLibros");
            }
        }catch(Exception e){
            
        }
        return cantidadLibros;
    }
    
    public ArrayList<Integer> getIdLibros(){
        ArrayList<Integer> librosId = new ArrayList<>();
        ResultSet rs = this.cl.getLibrosId(this.matricula);
        try{
            while(rs.next()){
                librosId.add(rs.getInt("libro_id"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return librosId;
    }
    
}
