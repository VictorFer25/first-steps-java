package Login;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import javax.swing.ImageIcon;
//import javax.swing.JPanel;

// clase que inicializa el metodo de panel panelEspera
public class esperaLogin extends javax.swing.JFrame {

    private Container panel;
    private panelEspera imagen;

    public esperaLogin() {
        this.initComponents();
    }

    // inicializa componentes
    public void initComponents() {
        this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.imagen = new panelEspera(this.getWidth(), this.getHeight());
        this.panel = this.getContentPane();
        this.panel.add(this.imagen);
    }

    // inicializa en hilo de la instancia imagen.
    public void animacion() {
        Thread anima = new Thread(this.imagen);
        this.imagen.setJframe(this);
        anima.start();
    }

    public static void main(String[] args) {
        esperaLogin esp = new esperaLogin();
        esp.setVisible(true);
        esp.animacion();
    }
}

// clase panel en el cual tiene la funcionde iniciar el panel
class panelEspera extends javax.swing.JPanel implements Runnable {

    private int progreso = 0;
    private esperaLogin esp;

    // tamaño del panel.
    public panelEspera(int ancho, int alto) {
        this.setSize(ancho, alto);
    }
    
    //toma el valor de esp en espera
    public void setJframe(esperaLogin esp){
        this.esp = esp;
    }

    // metodo de pintado de la pantalla
    public void paint(Graphics g) {
        Dimension tamanio = this.getSize();
        ImageIcon imagenFondo = new ImageIcon(getClass().getResource("Biblioteca.jpg"));
        g.drawImage(imagenFondo.getImage(), 0, 0, tamanio.width, tamanio.height, null);
        this.setOpaque(false);
        super.paint(g);

        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.translate(this.getWidth() / 2, this.getHeight() / 2);
        g2.rotate(Math.toRadians(270));

        Arc2D.Float arc = new Arc2D.Float(Arc2D.PIE);
        Ellipse2D circulo = new Ellipse2D.Float(0, 0, 110, 110);
        Ellipse2D circulo1 = new Ellipse2D.Float(0, 0, 110, 110);

        arc.setFrameFromCenter(new Point(0, 0), new Point(150, 150));
        circulo.setFrameFromCenter(new Point(0, 0), new Point(130, 130));
        circulo1.setFrameFromCenter(new Point(0, 0), new Point(150, 150));

        arc.setAngleStart(1);
        arc.setAngleExtent(-this.progreso * 3.6);

        g2.setColor(Color.WHITE);
        g2.draw(circulo1);
        g2.fill(circulo1);

        g2.setColor(new Color(0, 153, 204));
        g2.draw(arc);
        g2.fill(arc);

        g2.setColor(Color.WHITE);
        g2.draw(circulo);
        g2.fill(circulo);

        g2.rotate(Math.toRadians(90));
        g2.setColor(Color.blue);
        g2.drawString(this.progreso + "%", -5, 0);

    }

    @Override   
    // metodo de la funcion en la cual tiene la funcion del hilo
    public void run() {
        try {
            int tiempo = (int) (Math.random() * 100) + 1;

            for (int i = 1; i <= tiempo; i++) {
                this.progreso = i;
                this.repaint();
                Thread.sleep(30);
            }
            this.esp.dispose();
            login log = new login();
            log.setVisible(true);

        } catch (Exception e) {

        }
    }
}