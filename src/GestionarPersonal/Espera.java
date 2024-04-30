/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionarPersonal;

import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

/**
 *
 * @author alan
 */
public class Espera extends javax.swing.JFrame {

    private Container panelPrincipal;
    private Bola bola;
    boolean vivo = false;
    private i_gestionarPersonal igp;

    public Espera() {
        this.setUndecorated(true);
        this.initComponents();
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30);
        this.setShape(forma);
    }

    public void initComponents() {
        this.setSize(200, 170);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.panelPrincipal = this.getContentPane();

        this.bola = new Bola(this.getWidth(), this.getHeight());

        this.panelPrincipal.add(this.bola);
    }
    
    public void setGestionarPersonal(i_gestionarPersonal igp){
        this.igp = igp;
    }
    public void mover() {
        Thread hilo = new Thread(this.bola);
        this.bola.setEspera(this);
        this.bola.setGestionarPersonal(igp);
        hilo.start();
        this.vivo = hilo.isAlive();
    }
    
    public boolean getEstaVivo(){
        return this.vivo;
    }
    public void setVivo(boolean vivo){
        this.vivo = vivo;
    }
}

class Bola extends javax.swing.JPanel implements Runnable {

    private int posx = 0;
    private int posy = 0;
    private Espera esp;
    private i_gestionarPersonal igp;

    public Bola(int ancho, int alto) {
        this.setSize(ancho, alto);
        this.setBackground(new Color(0, 153, 204));
    }

    public void moverPunto(int angulo) {
        this.posx = (int) Math.round(70 * Math.cos(Math.toRadians(angulo)) + 0);
        this.posy = (int) Math.round(70 * Math.sin(Math.toRadians(angulo)) + 0);
    }

    public void setEspera(Espera esp) {
        this.esp = esp;
    }
    public void setGestionarPersonal(i_gestionarPersonal igp){
        this.igp = igp;
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.translate(this.getWidth() / 2, this.getHeight() / 2);
        g2.rotate(Math.toRadians(270));
        Ellipse2D circulo = new Ellipse2D.Float(this.posx, this.posy, 20, 20);
        g2.setColor(Color.WHITE);
        g2.draw(circulo);
        g2.fill(circulo);

        g2.rotate(Math.toRadians(90));
        g2.drawString("Cargando..", -30, 0);

    }

    @Override
    public void run() {
        try {
            int angulo = 10;
            int tiempo = (int) (Math.random() * 100) + 1;
            System.out.println(tiempo);
            for (int i = 0; i <= tiempo; i++) {
                this.moverPunto(angulo);
                this.repaint();
                Thread.sleep(20);
                angulo += 10;
            }
            this.esp.setVivo(false);
            this.igp.mostrarListaPersonal(new E_Personal().getListaPersonal());
            this.esp.dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
