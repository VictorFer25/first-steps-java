/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsultaLibros;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author alan
 */
public class E_Folio {
    private int folio;
    private ArrayList<Integer> librosId;
    private String estadoPrestamo;
    private CRUDFolio cF;
    private int usuario_id; 
    
    public E_Folio(){
        this.cF = new CRUDFolio();
        this.librosId = new ArrayList<>();
    }
    
    public void setFolio(int folio){
        this.folio = folio;
    }
    public void setLibros(ArrayList<Integer> librosId){
        this.librosId = librosId;
    }
    public void setEstado(String estadoPrestamo){
        this.estadoPrestamo = estadoPrestamo;
    }
    public void setUsuarioId(int usuario_id){
        this.usuario_id = usuario_id;
    }
    
    //metodos getters 
    
    public int getFolio(){
        return this.folio;
    }
    public ArrayList<Integer> getLibros(){
        return this.librosId;
    }
    public String getEstado(){
        return this.estadoPrestamo;
    }
    
    
    public ResultSet verificarFolio(){
        int fol = this.getFolio();
        ResultSet rs = this.cF.verificarFolio(fol);
        return rs;
    }
    
    
    public boolean insertarDatosPrestamo(){
        return this.cF.insertarDatosPrestamo(this.folio, this.librosId, 
                this.estadoPrestamo,this.usuario_id);
    }
    
    
    
    
    
    
    
}
