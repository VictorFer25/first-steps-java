/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionarLibros;

import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Yovii
 */
public class i_editarLibro extends javax.swing.JFrame {

    /**
     * Creates new form agregarlibro
     */
  
    i_gestionarLibros igl;
    private ArrayList<Integer> autores_id = new ArrayList<>();
    //private ArrayList<Integer> editorial_id = new ArrayList<>();
    //private ArrayList<Integer> pais_id = new ArrayList<>();
   
    public i_editarLibro() {
        initComponents();
        this.setLocationRelativeTo(null);
        limpiarCampos();
        validaciones();
            //jtEditorial.setVisible(false);
            //jtLugar.setVisible(false);
    }
    public void validaciones()
    {
        Validaciones v = new Validaciones();
        v.soloLetras(jtColection);
        v.limitarCaracteres(jtColection, 1);
        v.letrasYnumerosYpuntos(this.jtSignatura);
        v.limitarCaracteres(jtSignatura, 20);
        v.soloLetras(jtMateria);
        v.limitarCaracteres(jtMateria, 30);
        v.letrasYnumerosYpuntos(jtTitulo);
        v.limitarCaracteres(jtTitulo,30);
        v.letrasYnumerosYpuntos(jtTitulo);
        v.limitarCaracteres(jtTitulo,45);
        v.soloNumeros(jtEjemplares);
        v.limitarCaracteres(jtEjemplares, 2);
        v.soloNumeros(jtEdition);
        v.limitarCaracteres(jtEdition,2 );
        v.soloLetras(jtEditorial);
        v.limitarCaracteres(jtEditorial, 30);
        v.letraXYnumerosYGuiones(jtISBN);
        v.limitarCaracteres(jtISBN, 20);
        v.soloNumeros(jtCopyrigh);
        v.limitarCaracteres(jtCopyrigh, 4);
        v.soloLetras(jtSerie);
        v.limitarCaracteres(jtSerie, 30);
        v.soloLetras(jtLugar);
        v.limitarCaracteres(jtLugar, 15);
        v.soloNumeros(jtAnio);
        v.limitarCaracteres(jtAnio, 4);
        v.letrasYnumerosYpuntos(jtPagVol);
        v.limitarCaracteres(jtPagVol, 10);
        
      
       
    }
    public void cargarAutores(ResultSet rs){
         try{

            while(rs.next()){
                this.autores_id.add(rs.getInt(1));
                String nombreautor = String.valueOf(rs.getObject(2));
                String primero = String.valueOf(rs.getObject(3));
                String segundo = String.valueOf(rs.getObject(4));
                jcbAutor.addItem(nombreautor +" " + primero + " " +segundo );
                //Agregamos cada registro al modelo de la tabla
      
            }
        }catch(Exception e){
            e.printStackTrace();
             JOptionPane.showMessageDialog(this, "Error al cargar los datos de los autores.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
   public void cargarDatosLibro(ResultSet rs){
       
        try {

          
               while(rs.next()){
                    jlID.setText(rs.getString("libro_id"));
                    jtColection.setText(rs.getString("libro_coleccion"));
                    jtSignatura.setText(rs.getString("libro_asignatura"));
                    jtMateria.setText(rs.getString("libro_materia"));
                    jtTitulo.setText(rs.getString("libro_titulo"));
                    jtSubtitulo1.setText(rs.getString("libro_subtitulo"));
                    jtEjemplares.setText(rs.getString("libro_ejemplares"));
                    jtEdition.setText(rs.getString("libro_edicion"));
                    jtEditorial.setText(rs.getString("libro_editorial"));
                    jtISBN.setText(rs.getString("libro_isbn"));
                    jtCopyrigh.setText(rs.getString("libro_copyright"));
                    jtSerie.setText(rs.getString("libro_serie"));
                    jtLugar.setText(rs.getString("libro_lugar"));
                    jtAnio.setText(rs.getString("libro_año"));
                    jtPagVol.setText(rs.getString("libro_pagvol"));
               }
               
            
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos de los libros.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
       
            
    public void setInterfazGestionarLibro(i_gestionarLibros libro) {
        this.igl = libro;
    }
    public void limpiarCampos() {
        jtColection.setText("");
        jtSignatura.setText("");
        jtTitulo.setText("");
        jtTitulo.setText("");
        jtEjemplares.setText("");
        jtEditorial.setText("");
        jtISBN.setText("");
        jtCopyrigh.setText("");
        jtLugar.setText("");
        jtAnio.setText("");
        jtMateria.setText("");
        jtEdition.setText("");
        jtPagVol.setText("");
        jtSerie.setText("");
        jcbAutor.setSelectedIndex(0);
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
        jLabel1 = new javax.swing.JLabel();
        jlGuardar = new javax.swing.JLabel();
        jlSalir = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jtColection = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jtSignatura = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jtMateria = new javax.swing.JTextField();
        jlClave = new javax.swing.JLabel();
        jlID = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtISBN = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtCopyrigh = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jtLugar = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jtAnio = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jtPagVol = new javax.swing.JTextField();
        jtEditorial = new javax.swing.JTextField();
        jtSerie = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel25 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtTitulo = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jtEjemplares = new javax.swing.JFormattedTextField();
        jLabel16 = new javax.swing.JLabel();
        jcbAutor = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        jtEdition = new javax.swing.JTextField();
        jtSubtitulo1 = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 102, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Editar libro");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(320, 320, 320)
                .addComponent(jLabel1)
                .addContainerGap(469, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 846, -1));

        jlGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Refresh_40px.png"))); // NOI18N
        jlGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlGuardar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlGuardarMousePressed(evt);
            }
        });
        jPanel1.add(jlGuardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 440, -1, 50));

        jlSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Cancel_48px.png"))); // NOI18N
        jlSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jlSalirMousePressed(evt);
            }
        });
        jPanel1.add(jlSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 440, -1, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("Datos Generales");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 11, -1, -1));
        jPanel3.add(jtColection, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 69, 144, -1));

        jLabel2.setText("Coleccion:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(23, 72, -1, -1));

        jLabel9.setText("Signatura:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(22, 95, -1, -1));
        jPanel3.add(jtSignatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 95, 144, -1));

        jLabel19.setText("Clave:");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(41, 50, -1, -1));

        jLabel23.setText("Materia:");
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 120, -1, -1));
        jPanel3.add(jtMateria, new org.netbeans.lib.awtextra.AbsoluteConstraints(76, 120, 144, -1));

        jlClave.setText("CH1");
        jPanel3.add(jlClave, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 51, 30, -1));

        jlID.setText("ID:");
        jPanel3.add(jlID, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, -1, -1));

        jLabel8.setText("ID:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 30, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 290, 160));

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel10.setText("Datos editoriales");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(125, 11, -1, -1));

        jLabel4.setText("Editorial:");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 70, 50, 20));

        jLabel5.setText("ISBN:");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(51, 103, -1, -1));
        jPanel4.add(jtISBN, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, 150, -1));

        jLabel12.setText("Copyrigh:");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 134, -1, -1));
        jPanel4.add(jtCopyrigh, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 130, 150, -1));

        jLabel13.setText("Serie:");
        jPanel4.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(52, 163, -1, -1));
        jPanel4.add(jtLugar, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 150, -1));

        jLabel14.setText("Pais:");
        jPanel4.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(57, 192, -1, -1));
        jPanel4.add(jtAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 150, -1));

        jLabel15.setText("Año:");
        jPanel4.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 220, 30, -1));

        jLabel24.setText("Pag/vol:");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 250, 40, 20));
        jPanel4.add(jtPagVol, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 150, -1));
        jPanel4.add(jtEditorial, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 150, 20));
        jPanel4.add(jtSerie, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 150, -1));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 70, 300, 360));

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel25.setText("Datos del libro");
        jPanel5.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 11, -1, -1));

        jLabel3.setText("Titulo:");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 40, -1, 20));

        jLabel11.setText("Subitutlo:");
        jPanel5.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, -1, 20));
        jPanel5.add(jtTitulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 144, -1));

        jLabel20.setText("Ejemplares:");
        jPanel5.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, 20));

        jtEjemplares.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter()));
        jPanel5.add(jtEjemplares, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 144, -1));

        jLabel16.setText("Autor:");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(45, 163, 40, -1));

        jcbAutor.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccionar autor" }));
        jPanel5.add(jcbAutor, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 160, -1, -1));

        jLabel22.setText("Edicion:");
        jPanel5.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 130, 40, 20));
        jPanel5.add(jtEdition, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 130, 144, -1));
        jPanel5.add(jtSubtitulo1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 144, -1));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 240, 290, 190));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 690, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jlSalirMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlSalirMousePressed
        this.igl.banderaDeUsoEditarLibro = true;
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jlSalirMousePressed

    private void jlGuardarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlGuardarMousePressed
        
        if (jcbAutor.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "No ha ingresado todos los datos necesarios del libro");
        } else {
            c_editarLibro cel = new c_editarLibro();
            cel.setInterfazGestionarLibro(igl);
            cel.setInterfazEditarLibro(this);
            int seleccionAutor = jcbAutor.getSelectedIndex() - 1;
            String autor_id = String.valueOf(this.autores_id.get(seleccionAutor));
            

            cel.actualizarLibro(jlID.getText(),jlClave.getText(), jtColection.getText(), jtSignatura.getText(), jtTitulo.getText(),
                    jtTitulo.getText(), jtEjemplares.getText(), autor_id, jtEdition.getText(), jtEditorial.getText(), jtISBN.getText(),
                     jtCopyrigh.getText(), jtSerie.getText(), jtLugar.getText(), jtAnio.getText(), jtMateria.getText(), jtPagVol.getText());
        }



    }//GEN-LAST:event_jlGuardarMousePressed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(i_editarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(i_editarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(i_editarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(i_editarLibro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new i_editarLibro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JComboBox<String> jcbAutor;
    private javax.swing.JLabel jlClave;
    private javax.swing.JLabel jlGuardar;
    private javax.swing.JLabel jlID;
    private javax.swing.JLabel jlSalir;
    private javax.swing.JTextField jtAnio;
    private javax.swing.JTextField jtColection;
    private javax.swing.JTextField jtCopyrigh;
    private javax.swing.JTextField jtEdition;
    private javax.swing.JTextField jtEditorial;
    private javax.swing.JFormattedTextField jtEjemplares;
    private javax.swing.JTextField jtISBN;
    private javax.swing.JTextField jtLugar;
    private javax.swing.JTextField jtMateria;
    private javax.swing.JTextField jtPagVol;
    private javax.swing.JTextField jtSerie;
    private javax.swing.JTextField jtSignatura;
    private javax.swing.JTextField jtSubtitulo1;
    private javax.swing.JTextField jtTitulo;
    // End of variables declaration//GEN-END:variables
}
