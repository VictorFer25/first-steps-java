/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionarLibros;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Yovii
 */
public class i_agregarAutor extends javax.swing.JFrame {

    /**
     * Creates new form i_agregarAutor
     */
    i_gestionarLibros igl;

    public i_agregarAutor() {
        initComponents();
        this.setLocationRelativeTo(null);
        limpiarCampos();
        validaciones();
    }
    public void limpiarCampos() {

        jTPrimer.setText("");
        jTSegundo.setText("");
        jTNombre.setText("");
    }
    
    public void validaciones() {
        Validaciones v = new Validaciones();
        v.soloLetras(jTNombre);
        v.limitarCaracteres(jTNombre, 15);
        v.soloLetras(jTPrimer);
        v.limitarCaracteres(jTPrimer, 10);
        v.soloLetras(jTSegundo);
        v.limitarCaracteres(jTSegundo, 10);
    }

    public void setInterfazGestionarLibro(i_gestionarLibros i) {
        this.igl = i;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        jTNombre = new javax.swing.JTextField();
        jTPrimer = new javax.swing.JTextField();
        jTSegundo = new javax.swing.JTextField();
        jLiTitulo = new javax.swing.JLabel();
        jLCancelar = new javax.swing.JLabel();
        jLGuardar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setForeground(new java.awt.Color(51, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Nombre:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 30, -1, 20));

        jLabel3.setText("Primer apellido:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, -1, 20));

        jLabel4.setText("Segundo apellido:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 90, -1, 20));

        jSeparator1.setForeground(new java.awt.Color(0, 153, 204));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 50, 109, 10));

        jSeparator2.setForeground(new java.awt.Color(0, 153, 204));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 80, 109, 10));

        jSeparator3.setForeground(new java.awt.Color(0, 153, 204));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 110, 109, 20));
        jPanel2.add(jTNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 110, -1));
        jPanel2.add(jTPrimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 110, -1));
        jPanel2.add(jTSegundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 110, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(37, 38, 302, 159));

        jLiTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLiTitulo.setText("Agregar autor");
        jPanel1.add(jLiTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 15, -1, -1));

        jLCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Cancel_48px.png"))); // NOI18N
        jLCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLCancelarMousePressed(evt);
            }
        });
        jPanel1.add(jLCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 200, -1, -1));

        jLGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Save_48px.png"))); // NOI18N
        jLGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLGuardarMousePressed(evt);
            }
        });
        jPanel1.add(jLGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 251, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void jLGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLGuardarMousePressed
        c_agregarAutor caa = new c_agregarAutor();
        caa.setInterfazGestionarLibro(igl);

        caa.registrarAutor(jTNombre.getText(), jTPrimer.getText(), jTSegundo.getText());
        limpiarCampos();
        jTNombre.requestFocus();

        // TODO add your handling code here:

    }//GEN-LAST:event_jLGuardarMousePressed

    private void jLCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCancelarMousePressed
        igl.reiniciarColores();
        igl.banderaDeUsoAgregarAutor = true;
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLCancelarMousePressed

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
            java.util.logging.Logger.getLogger(i_agregarAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(i_agregarAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(i_agregarAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(i_agregarAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new i_agregarAutor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLCancelar;
    private javax.swing.JLabel jLGuardar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLiTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTPrimer;
    private javax.swing.JTextField jTSegundo;
    // End of variables declaration//GEN-END:variables
}
