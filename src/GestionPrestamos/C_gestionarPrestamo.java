package GestionPrestamos;

import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class C_gestionarPrestamo {
    private i_gestionarPrestamo igp;
    private E_prestamo ep;
    
    public C_gestionarPrestamo(){
        this.ep = new E_prestamo();
    }
    
    
    public void preparaInterfaz(String personal){
        this.igp = new i_gestionarPrestamo();
        this.igp.mostrarListaPersonal(ep.getListaPrestamo());
        this.igp.personal_id = personal;
        this.igp.setVisible(true);
    }
    
    /*public void busquedasRapidas(String busqueda, String tipo_busqueda){
            //este metodo sirve cada vez que yo dejo de apretar una tecla
        String busq = busqueda;

        //creo un objeto de tipo patron para verifcar el lenguaje que 
        //voy a usar en lo sera el modulo de buscar por id
        Pattern patron = Pattern.compile("([A-Z]|[a-z])*");

        //compruebo que busq pertenezca al lenguaje
        Matcher m = patron.matcher(busq);

        //esto retorna un booleano para ver si busq se encuentra dentro
        //del lenguaje
        boolean b = m.matches();
        
        if (busq.length() > 0 || b) {
            //si la longitud es mayor a 0, busca los resultados
            // y los manda a la tabla principal
            this.cPersonal.empiezaPorId(busq);
        }else {
            //de lo contrario, manda a la tabla principal
            // todos los resultados
            this.igp.mostrarListaPersonal(this.listaPrestamo);
        }
    }*/
    
    //fin de la clase
}
