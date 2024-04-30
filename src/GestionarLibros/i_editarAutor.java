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
public class i_editarAutor extends javax.swing.JFrame {

    /**
     * Creates new form i_agregarAutor
     */
    i_gestionarLibros igl;
 
    public i_editarAutor() {
        initComponents();
        this.setLocationRelativeTo(null);
        validaciones();
        jTID.setEditable(false);
        jTNombre.setEditable(false);
        jTPrimer.requestFocus();
    }
    public void cargarDatos(String id, String nombre, String primero, String segundo){
         jTID.setText(id);
         jTNombre.setText(nombre);
         jTPrimer.setText(primero);
         jTSegundo.setText(segundo);
    }
    public void validaciones(){
        Validaciones v = new Validaciones();
        v.soloLetras(jTNombre);
        v.limitarCaracteres(jTNombre, 10);
        v.soloLetras(jTPrimer);
        v.limitarCaracteres(jTPrimer, 10);
        v.soloLetras(jTSegundo);
        v.limitarCaracteres(jTSegundo, 10);
    }
public void setInterfazGestionarLibro(i_gestionarLibros i)
{
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
        jLabel5 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jTID = new javax.swing.JTextField();
        jTNombre = new javax.swing.JTextField();
        jTPrimer = new javax.swing.JTextField();
        jTSegundo = new javax.swing.JTextField();
        jLiTitulo = new javax.swing.JLabel();
        jLCancelar = new javax.swing.JLabel();
        jLActualizar = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setForeground(new java.awt.Color(51, 153, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setText("Nombre:");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 40, -1, 20));

        jLabel3.setText("Primer apellido:");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, -1, 20));

        jLabel4.setText("Segundo apellido:");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 100, -1, 20));

        jSeparator1.setForeground(new java.awt.Color(0, 153, 204));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 60, 109, 10));

        jSeparator2.setForeground(new java.awt.Color(0, 153, 204));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 90, 109, 10));

        jSeparator3.setForeground(new java.awt.Color(0, 153, 204));
        jPanel2.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 109, 10));

        jLabel5.setText("ID:");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 10, 20, 20));

        jSeparator4.setForeground(new java.awt.Color(0, 153, 204));
        jPanel2.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 109, 10));
        jPanel2.add(jTID, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 110, -1));
        jPanel2.add(jTNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 110, -1));
        jPanel2.add(jTPrimer, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 110, -1));
        jPanel2.add(jTSegundo, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 100, 110, -1));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 302, 159));

        jLiTitulo.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLiTitulo.setText("Editar autor");
        jPanel1.add(jLiTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(139, 15, -1, -1));

        jLCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Cancel_48px.png"))); // NOI18N
        jLCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLCancelarMousePressed(evt);
            }
        });
        jPanel1.add(jLCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 200, -1, -1));

        jLActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Refresh_40px.png"))); // NOI18N
        jLActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLActualizarMousePressed(evt);
            }
        });
        jPanel1.add(jLActualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 200, -1, 48));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLCancelarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLCancelarMousePressed

      igl.reiniciarColores();
     this.igl.banderaDeUsoEditarAutor = true;
      this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLCancelarMousePressed

    private void jLActualizarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLActualizarMousePressed
        c_editarAutor cea = new c_editarAutor();
        cea.setInterfazGestionarLibro(igl);
        cea.setInterfazEditarAutor(this);
        cea.actualizarAutor(jTID.getText(), jTNombre.getText(), jTPrimer.getText(), jTSegundo.getText());// TODO add your handling code here:
    }//GEN-LAST:event_jLActualizarMousePressed

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
            java.util.logging.Logger.getLogger(i_editarAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(i_editarAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(i_editarAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(i_editarAutor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new i_editarAutor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLActualizar;
    private javax.swing.JLabel jLCancelar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLiTitulo;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTextField jTID;
    private javax.swing.JTextField jTNombre;
    private javax.swing.JTextField jTPrimer;
    private javax.swing.JTextField jTSegundo;
    // End of variables declaration//GEN-END:variables
}
