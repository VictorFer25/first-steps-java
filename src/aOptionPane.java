
import java.awt.Color;
import java.awt.Shape;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.RoundRectangle2D;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;



public class aOptionPane extends javax.swing.JFrame {

    int yes_Option = 1;
    int no_Option = 0;
    int yes_no_Option = -1;
    
    
    private JButton aceptar;
    private boolean evaluar = false;
    
    public aOptionPane() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30);
        this.setShape(forma);
        this.getContentPane().setBackground(new Color(0,153,204));
        this.aceptar = new JButton("Aceptar");
        this.aceptar.setBounds(this.getWidth()/2, this.getHeight()-50, 80, 20);
        this.jLabel1.setSize(50,50);
        this.aceptar.addMouseListener(new MouseAdapter(){
            @Override
            public void mousePressed(MouseEvent e){
                aceptarMousePressed(e);
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setMaximumSize(new java.awt.Dimension(50, 50));
        jLabel1.setMinimumSize(new java.awt.Dimension(50, 50));
        jLabel1.setPreferredSize(new java.awt.Dimension(50, 50));

        jButton1.setText("Si");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        jButton2.setText("no");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(jButton1)
                .addGap(19, 19, 19)
                .addComponent(jButton2)
                .addContainerGap(64, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 222, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1)
                    .addComponent(jButton2)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
        this.evaluar = true;
        this.yes_no_Option = 1;
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        // TODO add your handling code here:
        this.evaluar = true;
        this.yes_no_Option = 0;
    }//GEN-LAST:event_jButton2MousePressed

    private void aceptarMousePressed(MouseEvent e){
        this.evaluar = true;
    }
    
    public int confirmDialog(String mensaje){
        
        
       JLabel jlmensaje = new JLabel(mensaje);
       jlmensaje.setBounds(this.getWidth()/2, this.getHeight()/2,100, 20);
       this.getContentPane().add(jlmensaje);
        this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/icons8_Checked_50px_1.png")));
        while(!evaluar){
            this.show();
        }
        this.dispose();
       
        return this.yes_no_Option;
    }
    
    public void ErrorMessage(String MensajeError){
        //this.mensaje.setText(MensajeError);
        this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/icons8_Error_50px_2.png")));
        this.evaluar = false;
        this.remove(this.jButton1);
        this.remove(this.jButton2);
        this.add(this.aceptar);
        
        while(!evaluar){
            this.show();
        }
        this.dispose();
    }
    
    public void informacionMessage(String mensaje){
        //this.mensaje.setText(mensaje);
        this.jLabel1.setIcon(new ImageIcon(getClass().getResource("/icons8_Help_50px_3.png")));
        this.evaluar = false;
        this.remove(this.jButton1);
        this.remove(this.jButton2);
        this.add(this.aceptar);
        
        while(!this.evaluar){
            this.show();
        }
        this.dispose();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(aOptionPane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(aOptionPane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(aOptionPane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(aOptionPane.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new aOptionPane().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
