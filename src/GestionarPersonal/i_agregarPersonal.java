/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GestionarPersonal;

import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class i_agregarPersonal extends javax.swing.JFrame {

    private c_agregarPersonal cap;
    private i_gestionarPersonal personal;
    private String personal_id;
    private final Validaciones veri;
    private boolean mostrar = true;

    public i_agregarPersonal() {
        this.setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.limpiarCampos();
        this.cap = new c_agregarPersonal();
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30);
        this.setShape(forma);
        this.veri = new Validaciones();
        this.jComboBox1.removeAllItems();
        this.jComboBox1.addItem("Encargado");
        this.jComboBox1.addItem("Auxiliar");
        this.jTextField1.setVisible(false);
        this.verificaciones();
    }
    
    public void setAgregarPersonal(c_agregarPersonal cAP){
        this.cap = cAP;
    }
    public void verificaciones() {

        //limitar que sean letras o numeros
        this.veri.soloLetras(this.jtNombre);
        this.veri.soloLetras(this.jtPaterno);
        this.veri.soloLetras(this.jtMaterno);
        this.veri.soloNumeros(this.jtTelefono);
        this.veri.soloNumeros(this.jtCodigoPostal);

        //limitar caracteres
        this.veri.limitarNumeros(this.jtTelefono, 10);
        this.veri.limitarNumeros(this.jPasswordField1, 25);
        this.veri.limitarNumeros(this.jtCruzamiento1, 30);
        this.veri.limitarNumeros(this.jtCruzamiento2, 30);
        this.veri.limitarNumeros(this.jtCodigoPostal, 5);
        this.veri.limitarNumeros(this.jtNombre, 30);
        this.veri.limitarNumeros(this.jtPaterno, 15);
        this.veri.limitarNumeros(this.jtMaterno, 15);
        this.veri.limitarNumeros(this.jPasswordField1, 30);
        this.veri.limitarNumeros(this.jTextField1, 30);

    }

    public void limpiarCampos() {
        jtNombre.setText("");
        jtPaterno.setText("");
        jtMaterno.setText("");
        jtTelefono.setText("");
        jtColonia.setText("");
        jtUsuario.setText("");
        this.jtCalle.setText("");
        this.jtCruzamiento1.setText(null);
        this.jtCodigoPostal.setText("");
        this.jtCruzamiento2.setText("");
        this.jPasswordField1.setText("");
        this.jComboBox1.setSelectedIndex(0);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jtMaterno = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtPaterno = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jtTelefono = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jtCalle = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jtColonia = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jtCruzamiento1 = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        jtCruzamiento2 = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        jtCodigoPostal = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jtUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        jTextField1 = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(102, 0, 0));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Agrega un nuevo Personal");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(235, 235, 235)
                .addComponent(jLabel1)
                .addContainerGap(236, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(16, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, -1));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos generales"));

        jtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtNombreFocusGained(evt);
            }
        });

        jLabel2.setText("Nombre");

        jLabel3.setText("Segundo Apellido");

        jLabel9.setText("Primer Apellido");

        jtPaterno.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtPaternoFocusGained(evt);
            }
        });

        jLabel11.setText("Teléfono");

        jLabel17.setText("*");

        jLabel18.setText("*");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtNombre, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtPaterno))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtMaterno, javax.swing.GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel17)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel18)))
                .addGap(16, 16, 16)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 290, 190));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos domiciliarios"));

        jLabel10.setText("Calle");

        jLabel16.setText("Colonia");

        jLabel20.setText("Primer cruzamiento");

        jLabel21.setText("Segundo cruzamiento");

        jLabel22.setText("Codigo Postal");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtCruzamiento1))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtCruzamiento2))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtColonia))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(30, 30, 30)
                                .addComponent(jtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel22)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 14, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtCruzamiento1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGap(9, 9, 9)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel21)
                    .addComponent(jtCruzamiento2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(jtColonia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel22)
                    .addComponent(jtCodigoPostal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 60, 290, 190));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Datos de cuenta"));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setText("Usuario");
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 31, 62, 20));

        jtUsuario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jtUsuarioFocusGained(evt);
            }
        });
        jPanel5.add(jtUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 30, 160, -1));

        jLabel5.setText("Password");
        jPanel5.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 72, -1, -1));

        jLabel12.setText("Tipo Personal");
        jPanel5.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 110, -1, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel5.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 110, 110, -1));

        jLabel19.setText("Mostrar");
        jLabel19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel19MousePressed(evt);
            }
        });
        jPanel5.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 70, -1, -1));

        jPasswordField1.setText("jPasswordField1");
        jPanel5.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 160, -1));

        jTextField1.setText("jTextField1");
        jPanel5.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 160, -1));

        jLabel23.setText("*");
        jPanel5.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 30, 10, 20));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 260, 340, 140));

        jPanel6.setBackground(new java.awt.Color(0, 0, 0));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Refresh_40px_1.png"))); // NOI18N
        jLabel13.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel13MousePressed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Save_48px.png"))); // NOI18N
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel6MousePressed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Cancel_48px.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel8MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(189, 189, 189)
                .addComponent(jLabel13)
                .addGap(35, 35, 35)
                .addComponent(jLabel6)
                .addGap(29, 29, 29)
                .addComponent(jLabel8)
                .addContainerGap(221, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel6)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 460, 610, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel8MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MousePressed

        this.personal.setBandeUsoAgregar(true);
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jLabel8MousePressed

    private void jLabel6MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel6MousePressed
        String password = "";

        JTextField[] busq = new JTextField[3];
        busq[0] = this.jtNombre;
        busq[1] = this.jtPaterno;
        busq[2] = this.jtUsuario;

        boolean vacio = true;
        for (int i = 0; i < busq.length; i++) {
            if (busq[i].getText().length() == 0) {
                vacio = false;
                busq[i].setBackground(Color.red);
            }
        }

        if (vacio) {
            boolean encontrarPersonal = this.cap.ExistenciaPersonal(this.jtNombre.getText(),
                    this.jtPaterno.getText());

            boolean encontrarUsuario = this.cap.ExistenciaDeusuario(this.jtUsuario.getText());
            if (!encontrarPersonal && !encontrarUsuario) {

                if (this.jPasswordField1.isVisible()) {
                    password = this.jPasswordField1.getText();
                } else {
                    if (this.jTextField1.isVisible()) {
                        password = this.jTextField1.getText();
                    }
                }

                Object[] datos = new Object[12];
                datos[0] = this.jtNombre.getText();
                datos[1] = this.jtPaterno.getText();
                datos[2] = this.jtMaterno.getText();
                datos[3] = this.jtCalle.getText();
                datos[4] = this.jtTelefono.getText();
                datos[5] = this.jtColonia.getText();
                datos[6] = this.jtUsuario.getText();
                datos[7] = password;
                datos[8] = this.jComboBox1.getSelectedItem();
                datos[9] = this.jtCruzamiento1.getText();
                datos[10] = this.jtCruzamiento2.getText();
                datos[11] = this.jtCodigoPostal.getText();

                //mando mi interfaz gestionar personal a la clase de control
                //agregar personal
                this.cap.setGestionarPersonal(personal);

                this.cap.setIap(this);
                //registra los datos ingresados
                this.cap.registrarPersonal(datos);
            } else {
                JOptionPane.showMessageDialog(null, "Personal y/o usuario registrado",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Nombre y Apellido son oobligatorios",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jLabel6MousePressed

    private void jtPaternoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtPaternoFocusGained
        // TODO add your handling code here:
        this.jtPaterno.setBackground(Color.WHITE);
    }//GEN-LAST:event_jtPaternoFocusGained

    private void jtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtNombreFocusGained
        // TODO add your handling code here:
        this.jtNombre.setBackground(Color.WHITE);
    }//GEN-LAST:event_jtNombreFocusGained

    private void jLabel13MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel13MousePressed
        // TODO add your handling code here:

        JTextField[] datos = new JTextField[2];
        Object[] datosAct = new Object[10];
        datos[0] = this.jtNombre;
        datos[1] = this.jtPaterno;
        boolean vacio = true;

        for (int i = 0; i < datos.length; i++) {
            if (datos[i].getText().length() == 0) {
                vacio = false;
                datos[i].setBackground(Color.red);
            }
        }

        if (vacio) {
            datosAct[0] = this.personal_id;
            datosAct[1] = this.jtNombre.getText();
            datosAct[2] = this.jtPaterno.getText();
            datosAct[3] = this.jtMaterno.getText();
            datosAct[4] = this.jtCalle.getText();
            datosAct[5] = this.jtTelefono.getText();
            datosAct[6] = this.jtColonia.getText();
            datosAct[7] = this.jtUsuario.getText();
            datosAct[8] = this.jPasswordField1.getText();
            datosAct[9] = this.jComboBox1.getSelectedItem();
            this.cap.setIap(this);
            this.cap.setGestionarPersonal(personal);
            this.cap.actualizarPersonal(datosAct);
        }

    }//GEN-LAST:event_jLabel13MousePressed

    private void jLabel19MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel19MousePressed
        // TODO add your handling code here:
        if (this.mostrar) {
            this.jPasswordField1.setVisible(false);
            this.jTextField1.setText(this.jPasswordField1.getText());
            this.jTextField1.setVisible(true);
            this.mostrar = false;

        } else {
            this.jPasswordField1.requestFocus();
            this.jPasswordField1.setVisible(true);
            this.jTextField1.setVisible(false);
            this.mostrar = true;
        }
    }//GEN-LAST:event_jLabel19MousePressed

    private void jtUsuarioFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_jtUsuarioFocusGained
        // TODO add your handling code here:
        this.jtUsuario.setBackground(Color.WHITE);
    }//GEN-LAST:event_jtUsuarioFocusGained

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new i_agregarPersonal().setVisible(true);
            }
        });
    }

    public void setVisibleLabel6(boolean estado) {
        if (estado) {
            this.jLabel13.setVisible(false);
        } else {
            this.jLabel6.setVisible(estado);
            this.jLabel13.setVisible(true);
        }
    }

    public void setGestionarPersonal(i_gestionarPersonal gPersonal) {
        this.personal = gPersonal;
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jtCalle;
    private javax.swing.JTextField jtCodigoPostal;
    private javax.swing.JTextField jtColonia;
    private javax.swing.JTextField jtCruzamiento1;
    private javax.swing.JTextField jtCruzamiento2;
    private javax.swing.JTextField jtMaterno;
    private javax.swing.JTextField jtNombre;
    private javax.swing.JTextField jtPaterno;
    private javax.swing.JTextField jtTelefono;
    private javax.swing.JTextField jtUsuario;
    // End of variables declaration//GEN-END:variables
}
