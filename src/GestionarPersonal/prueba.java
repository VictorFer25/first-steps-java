/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionarPersonal;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author alan
 */
public class prueba {
    
    public static void main(String[] args){
        Scanner tec = new Scanner(System.in);
        String palabra = "";
        Pattern patron = Pattern.compile("[A-Za-z]*\\d*");
        palabra = tec.nextLine();
        Matcher mat = patron.matcher(palabra);
        boolean e = mat.matches();
        System.out.println(e);
    }
    
}
