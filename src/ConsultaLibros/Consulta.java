/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsultaLibros;

import java.awt.Shape;
import java.awt.event.ItemEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author alan
 */
public class Consulta extends javax.swing.JFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    private DefaultTableModel modelo1 = new DefaultTableModel();
    private int id_Usuario;
    private final c_ControlBusqueda cB;
    private int valor = 0;
    private int limitePrestamos;
    private ArrayList<Integer> librosPrestados = new ArrayList<>();

    public Consulta() {
        this.setUndecorated(true);
        initComponents();
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30);
        this.setShape(forma);
        this.setLocationRelativeTo(null);
        this.modelo = (DefaultTableModel) this.tablaLibros.getModel();
        this.modelo1 = (DefaultTableModel) this.tablaLibroPrestamos.getModel();
        this.tablaLibros.setComponentPopupMenu(this.jPopupMenu1);
        this.tablaLibroPrestamos.setComponentPopupMenu(this.jPopupMenu2);
        this.limpiarTabla(this.modelo1);
        this.tablaLibros.getTableHeader().setReorderingAllowed(false);
        this.tablaLibroPrestamos.getTableHeader().setReorderingAllowed(false);
        this.jComboBox1.removeAllItems();
        this.jComboBox1.addItem("Seleccione un filtro");
        this.jComboBox1.addItem("Titulo");
        this.jComboBox1.addItem("Subtitulo");
        this.jComboBox1.addItem("Materia");
        this.jComboBox1.addItem("Autor");
        this.jTextField1.setVisible(false);
        this.cB = new c_ControlBusqueda();
        this.cB.setConsulta(this);
        this.valorCheckBox();
        new timer(this.jlMinutos, this.jlSegundos, this).start();

    }

    public void setLibrosId(ArrayList<Integer> librosId) {
        this.librosPrestados = librosId;
    }

    public void valorCheckBox() {
        for (int i = 0; i < this.modelo.getRowCount(); i++) {
            this.tablaLibros.setValueAt(false, i, 0);
        }
    }

    public void limpiarTabla(DefaultTableModel model) {
        for (int i = 0; i < model.getRowCount(); i++) {
            model.removeRow(i);
            i -= 1;
        }
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public void setLimitePrestamos(int limite) {
        this.limitePrestamos = limite;
    }

    public DefaultTableModel getModelo() {
        return this.modelo;
    }

    public DefaultTableModel getModelo1() {
        return this.modelo1;
    }

    public void setIdUsuario(int id_Usuario) {
        this.id_Usuario = id_Usuario;
    }

    public void mostrarListaLibros(ResultSet listaLibros, DefaultTableModel model) {
        limpiarTabla(model);
        //ResultSet rs = listapersonal;
        try {
            while (listaLibros.next()) {
                Object row[] = new Object[this.modelo.getColumnCount()];
                row[0] = false;
                for (int i = 1; i < row.length; i++) {
                    row[i] = listaLibros.getObject(i);//El resulset los indices empiezan en 1, mi for lo empieso en 0 por eso le sumo i+1
                }
                //Agregamos cada registro al modelo de la tabla
                modelo.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos del personal.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPopupMenu2 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jlMinutos = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jlSegundos = new javax.swing.JLabel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaLibros = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaLibroPrestamos = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ConsultaLibros/icons8_Buy_20px.png"))); // NOI18N
        jMenuItem2.setText("Añadir al carro");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ConsultaLibros/icons8_Clear_Shopping_Cart_20px.png"))); // NOI18N
        jMenuItem1.setText("Eliminar del carro");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu2.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Delete_32px_1.png"))); // NOI18N
        jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel4MousePressed(evt);
            }
        });

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Expand_Arrow_32px_1.png"))); // NOI18N
        jLabel5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel5MousePressed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel7.setText("Busqueda y préstamo");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(237, 237, 237)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel7)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(4, 4, 4)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(0, 153, 204));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel8.setText("Tiempo:");

        jlMinutos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlMinutos.setText("jLabel9");

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText(":");

        jlSegundos.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlSegundos.setText("jLabel11");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(58, 58, 58)
                .addComponent(jlMinutos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jlSegundos)
                .addGap(358, 358, 358))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jlMinutos)
                    .addComponent(jLabel10)
                    .addComponent(jlSegundos))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jTabbedPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel3.setBackground(new java.awt.Color(0, 153, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaLibros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "agregar", "ID", "Nombre Libro", "Subitulo", "Autor", "Materia", "Estado", "Cantidad"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaLibros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        tablaLibros.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tablaLibros);
        if (tablaLibros.getColumnModel().getColumnCount() > 0) {
            tablaLibros.getColumnModel().getColumn(0).setResizable(false);
            tablaLibros.getColumnModel().getColumn(1).setResizable(false);
            tablaLibros.getColumnModel().getColumn(2).setResizable(false);
            tablaLibros.getColumnModel().getColumn(3).setResizable(false);
            tablaLibros.getColumnModel().getColumn(4).setResizable(false);
            tablaLibros.getColumnModel().getColumn(5).setResizable(false);
            tablaLibros.getColumnModel().getColumn(6).setResizable(false);
            tablaLibros.getColumnModel().getColumn(7).setResizable(false);
        }

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 57, 980, 320));

        jLabel1.setText("Buscar Libro");
        jPanel3.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 20, -1, -1));

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel3.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 20, 340, -1));

        jLabel2.setText("buscar");
        jLabel2.setToolTipText("");
        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 10, -1, 40));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jPanel3.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 20, -1, -1));
        jPanel3.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, 299, -1));

        jLabel3.setText("Formato APA:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 410, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ConsultaLibros/icons8_Buy_20px.png"))); // NOI18N
        jButton1.setText("Añadir al Carro");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, -1, -1));

        jTabbedPane1.addTab("Consulta", jPanel3);

        jPanel4.setBackground(new java.awt.Color(0, 153, 204));

        tablaLibroPrestamos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Titulo", "Subtitulo", "Autor", "Materia", "Estado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tablaLibroPrestamos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane2.setViewportView(tablaLibroPrestamos);
        if (tablaLibroPrestamos.getColumnModel().getColumnCount() > 0) {
            tablaLibroPrestamos.getColumnModel().getColumn(0).setResizable(false);
            tablaLibroPrestamos.getColumnModel().getColumn(1).setResizable(false);
            tablaLibroPrestamos.getColumnModel().getColumn(2).setResizable(false);
            tablaLibroPrestamos.getColumnModel().getColumn(3).setResizable(false);
            tablaLibroPrestamos.getColumnModel().getColumn(4).setResizable(false);
            tablaLibroPrestamos.getColumnModel().getColumn(5).setResizable(false);
        }

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setText("Libros por prestar");

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ConsultaLibros/icons8_Clear_Shopping_Cart_20px.png"))); // NOI18N
        jButton2.setText("Eliminar del carro");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton2MousePressed(evt);
            }
        });

        jButton3.setText("Prestar");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton3MousePressed(evt);
            }
        });

        jButton4.setText("Salir");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton4MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton2)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGap(0, 386, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(321, 321, 321))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jButton3)
                                .addGap(18, 18, 18)
                                .addComponent(jButton4)
                                .addGap(24, 24, 24))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(33, 33, 33))
        );

        jTabbedPane1.addTab("Bandeja préstamo", jPanel4);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jTabbedPane1)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addComponent(jTabbedPane1))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        int fila = this.tablaLibros.getSelectedRow();
        String id = String.valueOf(this.tablaLibros.getValueAt(fila, 1));
        boolean en = false;
        boolean buscado = false;

        for (int j = 0; j < this.tablaLibroPrestamos.getRowCount(); j++) {
            String idPres = String.valueOf(this.tablaLibroPrestamos.getValueAt(j, 0));
            if (idPres.equals(id)) {
                en = true;
                break;
            }
        }

        if (this.librosPrestados.size() > 0) {
            for (int pos = 0; pos < this.librosPrestados.size(); pos++) {
                System.out.println(this.librosPrestados.get(pos));
                if ((int) this.tablaLibros.getValueAt(fila, 1) == this.librosPrestados.get(pos)) {
                    buscado = true;
                    break;
                }
            }
        }

        if (!en && !buscado) {
            if (fila != -1) {
                if (this.modelo1.getRowCount() <= 2) {
                    Object[] row = new Object[this.modelo.getColumnCount() - 1];
                    for (int i = 0; i < row.length; i++) {
                        row[i] = this.tablaLibros.getValueAt(fila, i + 1);
                    }
                    this.valor += 1;
                    this.modelo1.addRow(row);
                    JOptionPane.showMessageDialog(null, "Añadido al carro", "CORRECTO",
                            JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Excediste el limite de "
                            + "prestamos", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "No se puede prestar el mismo libro",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:

        int fila = this.tablaLibroPrestamos.getSelectedRow();

        int con = JOptionPane.showConfirmDialog(null, "¿Seguro que desea elimina"
                + "r?", "", JOptionPane.YES_NO_OPTION);
        if (con == JOptionPane.YES_OPTION) {
            this.modelo1.removeRow(fila);
            this.valor -= 1;
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jButton3MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MousePressed

        //compara si hay libros en la bandeja
        if (this.tablaLibroPrestamos.getRowCount() != 0) {

            Object[] detalles = new Object[6];

            ArrayList<String> libros = new ArrayList<>();

            ArrayList<Integer> librosId = new ArrayList<>();
            Calendar cal = Calendar.getInstance();
            String fechaPrestamo = cal.get(Calendar.DATE) + "/"
                    + (cal.get(Calendar.MONTH) + 1)
                    + "/" + cal.get(Calendar.YEAR);

            cal.add(Calendar.DATE, 3);

            if (cal.get(Calendar.DAY_OF_WEEK) == 7) {
                //en caso de que la fecha caiga un sabado se le suman 
                //dos dias para que la devolucion se el lunes
                cal.add(Calendar.DATE, 2);
            }
            if (cal.get(Calendar.DAY_OF_WEEK) == 1) {
                //en caso de que la fecha de devolucion caiga un domingo
                //se le suma un dia mas 
                cal.add(Calendar.DATE, 1);
            }

            String fechaDevolucion = cal.get(Calendar.DATE) + "/"
                    + (cal.get(Calendar.MONTH) + 1) + "/"
                    + cal.get(Calendar.YEAR);

            for (int i = 0; i < this.tablaLibroPrestamos.getRowCount(); i++) {
                libros.add((String) this.tablaLibroPrestamos.getValueAt(i, 1));
                librosId.add((int) this.tablaLibroPrestamos.getValueAt(i, 0));
            }

            detalles[0] = this.cB.generarFolio();
            detalles[1] = this.id_Usuario;
            detalles[2] = "En proceso";
            detalles[3] = fechaPrestamo;
            detalles[4] = fechaDevolucion;
            detalles[5] = "externo";

            c_Confirmar cCon = new c_Confirmar();
            cCon.setConsulta(this);
            cCon.preparazInterfaz(detalles, libros, librosId);
        } else {
            JOptionPane.showMessageDialog(null, "No hay libros en la tabla",
                    "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton3MousePressed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        // TODO add your handling code here:
        String busqueda = this.jTextField1.getText();

        switch (this.jComboBox1.getSelectedIndex()) {
            case 1:
                this.cB.buscarPorTitulo(busqueda);
                break;
            case 2:
                this.cB.buscarPorSubtitulo(busqueda);
                break;
            case 3:
                this.cB.buscarPorMateria(busqueda);
                break;
            case 4:
                this.cB.buscarPorAutor(busqueda);
                break;

            default:
                break;

        }

    }//GEN-LAST:event_jTextField1KeyReleased

    private void jLabel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MousePressed
        // TODO add your handling code here:
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel4MousePressed

    private void jLabel5MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MousePressed
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabel5MousePressed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (this.jComboBox1.getSelectedItem().equals("Seleccione un filtro")) {
                this.jTextField1.setVisible(false);

                //this.jTextField2.setVisible(falso);
            } else {
                this.jTextField1.setVisible(true);
                //this.jTextField2.setVisible(verdadero);
            }
        }
    }//GEN-LAST:event_jComboBox1ItemStateChanged

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed

        int fila = this.tablaLibros.getSelectedRow();
        if (fila != 1) {
            String id = String.valueOf(this.tablaLibros.getValueAt(fila, 1));
            boolean en = false;
            boolean buscado = false;

            for (int j = 0; j < this.tablaLibroPrestamos.getRowCount(); j++) {
                String idPres = String.valueOf(this.tablaLibroPrestamos.getValueAt(j, 0));
                if (idPres.equals(id)) {
                    en = true;
                    break;
                }
            }

            if (this.librosPrestados.size() > 0) {
                for (int pos = 0; pos < this.librosPrestados.size(); pos++) {
                    System.out.println(this.librosPrestados.get(pos));
                    if ((int) this.tablaLibros.getValueAt(fila, 1) == this.librosPrestados.get(pos)) {
                        buscado = true;
                        break;
                    }
                }
            }

            if (!en && !buscado) {
                if (this.modelo1.getRowCount() <= 2) {
                    Object[] row = new Object[this.modelo.getColumnCount() - 1];
                    for (int i = 0; i < row.length; i++) {
                        row[i] = this.tablaLibros.getValueAt(fila, i + 1);
                    }
                    this.modelo1.addRow(row);
                    this.valor += 1;
                    this.tablaLibros.clearSelection();
                } else {
                    JOptionPane.showMessageDialog(null, "Excediste el limite de "
                            + "prestamos", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "No se puede prestar el mismo libro",
                        "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
        //este for me sirve para recorrer la tabla completa
        for (int i = 0; i < this.tablaLibros.getRowCount(); i++) {

            //obtengo el valor booleado del check box de mi tabla
            boolean check = (Boolean) this.tablaLibros.getValueAt(i, 0);

            //en caso de que sea verdadero y el numero de libros no exceda 
            //el limite de presmos entrará en la condición
            if (check && this.valor < this.limitePrestamos) {

                //esta me sirve para ver si encuntra el id dentro de mi 
                //bandeja de prestamos
                boolean encontrado = false;

                //de igual menera me sirve la variable buscado pero en este
                //caso se usara para buscarlo dentro de mi arraylist de id´s
                boolean buscado = false;

                /*este if comprueba si mi tabla de la bandeja ya posee o esta 
                en ella la id que se se haya seleccionado*/
                if (this.tablaLibroPrestamos.getRowCount() > 0) {
                    for (int j = 0; j < this.tablaLibroPrestamos.getRowCount(); j++) {
                        if ((int) this.tablaLibros.getValueAt(i, 1) == (int) this.tablaLibroPrestamos.getValueAt(j, 0)) {
                            encontrado = true;
                            break;
                        }
                    }
                }

                /*este if comprueba si mi lista de libros prestados esta vacia
                en caso de que no este vacia procede a comprobar si la id que
                selecciono esta dentro de los prestamos ya realizados anteriormente*/
                if (this.librosPrestados.size() > 0) {
                    for (int pos = 0; pos < this.librosPrestados.size(); pos++) {
                        if ((int) this.tablaLibros.getValueAt(i, 1) == this.librosPrestados.get(pos)) {
                            buscado = true;
                            break;
                        }
                    }
                }

                //si entrado y buscado son falsos se cargaran los datos 
                // ami bandeja de libros
                if (!encontrado && !buscado) {

                    //creo de tipo object la fila donde se almacenaran los datos
                    Object[] datos = new Object[this.modelo.getColumnCount() - 1];

                    //recorro la fila para obtener los datos de cada columna
                    for (int j = 0; j < datos.length; j++) {

                        //agrego el dato de mi columna a la posición que vaya
                        datos[j] = this.tablaLibros.getValueAt(i, j + 1);
                    }

                    //lo ayado a mi bandeja de prestamos
                    this.modelo1.addRow(datos);

                    //aumento el valor de los libros que ya ha prestado
                    this.valor += 1;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Excediste el limite de "
                        + "prestamos", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }

        JOptionPane.showMessageDialog(null, "Añadido al carro", "CORRECTO",
                JOptionPane.INFORMATION_MESSAGE);

        for (int i = 0; i < this.modelo.getRowCount(); i++) {
            this.tablaLibros.setValueAt(false, i, 0);
        }
    }//GEN-LAST:event_jButton1MousePressed

    private void jButton2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MousePressed
        // TODO add your handling code here:
        int fila = this.tablaLibroPrestamos.getSelectedRow();
        if (fila != -1) {

            this.modelo1.removeRow(fila);
            this.valor -= 1;

        } else {
            this.limpiarTabla(this.modelo1);
            this.valor = 0;
        }
    }//GEN-LAST:event_jButton2MousePressed

    private void jButton4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4MousePressed

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
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Consulta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Consulta().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JPopupMenu jPopupMenu2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JLabel jlMinutos;
    private javax.swing.JLabel jlSegundos;
    private javax.swing.JTable tablaLibroPrestamos;
    private javax.swing.JTable tablaLibros;
    // End of variables declaration//GEN-END:variables
}

class timer extends Thread {

    private int minutos = 0;
    private int segundos = 0;
    private Consulta consul;

    private javax.swing.JLabel jlMinutos;
    private javax.swing.JLabel jlsegundos;

    public timer(javax.swing.JLabel jlMinutos, javax.swing.JLabel jlSegundos, Consulta consul) {
        this.jlMinutos = jlMinutos;
        this.jlsegundos = jlSegundos;
        this.consul = consul;
    }

    @Override
    public void run() {

        String segundo = "0";
        String minutos = "0";
        while (this.minutos <= 9) {
            if (this.segundos >= 60) {
                this.segundos = 0;
                this.minutos += 1;
            }
            segundo = "0" + this.segundos;
            minutos = "0" + this.minutos;

            if (segundo.length() >= 3) {
                segundo = String.valueOf(this.segundos);
            }
            if (minutos.length() >= 3) {
                minutos = String.valueOf(this.minutos);
            }
            this.jlMinutos.setText(minutos);
            this.jlsegundos.setText(segundo);
            this.segundos += 1;
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        LoginBusqueda logBusq = new LoginBusqueda();
        logBusq.setVisible(true);
        this.consul.dispose();

    }

}
