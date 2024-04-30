
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionarUsuarios;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author User
 */
public class validacionUsuario {
    
    //metodo para validacion de solo letras
    public void  validarLetras(JTextField campo){
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                System.out.println(c);
                if (!Character.isLetter(c) && c != KeyEvent.VK_SPACE) {
                    e.consume();//ingnora el caracter
                }
            }
        });
    }
    //validando que sea solo numeros
    public void  validarNumeros(JTextField campo){
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isLetter(c)) {
                    e.consume();
                }

            }
        });
    }
    
    //metodo para limitar caracteres
    public void limitarCaracteres(JTextField campo, int cantidad){
        campo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                int cant = campo.getText().length();
                if (cant >= cantidad) {
                    e.consume();
                }
            }
        });
    }
    
    //public void validarMatricula
}
