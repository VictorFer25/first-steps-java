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
public class Temporal {
    private int folio;
    private ArrayList <Integer> libro_id;
    private int usuario_id;
    private CRUDTemporal cT;
    
    public Temporal(){
        this.libro_id = new ArrayList<>();
        this.cT = new CRUDTemporal();
    }
    public int getFolio(){
        return this.folio;
    }
    
    public ArrayList<Integer> getLibros(){
        return this.libro_id;
    }
    
    public int getUsuarioId(){
        return this.usuario_id;
    }
    
    public void setFolio(int folio){
        this.folio = folio;
    }
    public void setLibrosId(ArrayList<Integer> librosId){
        this.libro_id = librosId;
    }
    public void setUsuarioId(int usuarioId){
        this.usuario_id = usuarioId;
    }
    public ResultSet verificarFolio(){
        int fol = this.getFolio();
        ResultSet rs = this.cT.verificarFolio(fol);
        return rs;
    }
    
    public boolean  agregarRegistroTemporal(){
        
        boolean result = this.cT.agregarRegistroTemporal(folio, libro_id, usuario_id);
        return result;
    }
}
