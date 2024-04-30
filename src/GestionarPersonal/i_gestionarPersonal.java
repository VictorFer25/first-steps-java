package GestionarPersonal;

import GestionarPersonal.c_gestionarPersonal;
import Menu.Menu;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Shape;
import java.awt.event.ItemEvent;
import java.awt.geom.RoundRectangle2D;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

public class i_gestionarPersonal extends javax.swing.JFrame {

    private DefaultTableModel modelo = new DefaultTableModel();
    private c_gestionarPersonal cPersonal;
    private int posx;
    private int posy;
    private boolean apretado = false;
    private Espera espera;

    private boolean banderaDeUsoAgregar = true;

    private boolean banderaDeUsoEditar = true;

    public i_gestionarPersonal() {
        this.setUndecorated(true);
        initComponents();
        this.espera = new Espera();
        this.espera.setGestionarPersonal(this);
        //obtiene el tamaño el ancho de la pantalla
        //int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        //obtiene el alto de la pantalla
        //int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        //this.setSize(ancho, alto);
        this.setLocationRelativeTo(null);
        setColor(btn_libro);
        modelo = (DefaultTableModel) jTLibro.getModel();
        Shape forma = new RoundRectangle2D.Double(0, 0, this.getBounds().width, this.getBounds().height, 30, 30);
        this.setShape(forma);
        this.jTextField1.setVisible(true);
        this.cPersonal = new c_gestionarPersonal();
        this.cPersonal.setGestionarPersonal(this);
        this.jComboBox1.removeAllItems();
        this.jComboBox1.addItem("Seleccione un filtro");
        this.jComboBox1.addItem("ID");
        this.jComboBox1.addItem("Nombre");
        this.jComboBox1.addItem("Apellido");
        this.jTextField1.setVisible(false);
        jSeparator2.setVisible(false);

    }

    public void setBandeUsoAgregar(boolean banderaAgregar) {
        this.banderaDeUsoAgregar = banderaAgregar;
    }

    public void setBanderaUsoEditar(boolean banderaEditar) {
        this.banderaDeUsoEditar = banderaEditar;
    }

    public void mostrarListaPersonal(ResultSet listapersonal) {
        limpiarTabla();
        //ResultSet rs = listapersonal;
        try {
            while (listapersonal.next()) {
                Object row[] = new Object[4];
                for (int i = 0; i < 4; i++) {
                    row[i] = listapersonal.getObject(i + 1); //El resulset los indices empiezan en 1, mi for lo empieso en 0 por eso le sumo i+1
                }
                //Agregamos cada registro al modelo de la tabla
                modelo.addRow(row);
            }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error al cargar los datos del personal.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i -= 1;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Modificar = new javax.swing.JPopupMenu();
        Modificar1 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel2 = new javax.swing.JPanel();
        btn_libro = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_agregar = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btn_editar = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        btn_eliminar = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        btn_menu = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTLibro = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jComboBox1 = new javax.swing.JComboBox<>();
        jPanel4 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();

        Modificar1.setText("Modificar");
        Modificar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Modificar1ActionPerformed(evt);
            }
        });
        Modificar.add(Modificar1);

        jMenuItem1.setText("Eliminar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        Modificar.add(jMenuItem1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(0, 153, 204));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btn_libro.setBackground(new java.awt.Color(0, 153, 204));
        btn_libro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_libro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_libroMousePressed(evt);
            }
        });

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_User_40px.png"))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Personal");

        javax.swing.GroupLayout btn_libroLayout = new javax.swing.GroupLayout(btn_libro);
        btn_libro.setLayout(btn_libroLayout);
        btn_libroLayout.setHorizontalGroup(
            btn_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_libroLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(47, 47, 47)
                .addComponent(jLabel3)
                .addContainerGap(106, Short.MAX_VALUE))
        );
        btn_libroLayout.setVerticalGroup(
            btn_libroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_libroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(btn_libroLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(btn_libro, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, -1, -1));

        btn_agregar.setBackground(new java.awt.Color(0, 153, 204));
        btn_agregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_agregar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_agregarMousePressed(evt);
            }
        });

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Add_40px.png"))); // NOI18N

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Agregar Personal");

        javax.swing.GroupLayout btn_agregarLayout = new javax.swing.GroupLayout(btn_agregar);
        btn_agregar.setLayout(btn_agregarLayout);
        btn_agregarLayout.setHorizontalGroup(
            btn_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_agregarLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel4)
                .addGap(47, 47, 47)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_agregarLayout.setVerticalGroup(
            btn_agregarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_agregarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(btn_agregarLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(btn_agregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 258, -1));

        btn_editar.setBackground(new java.awt.Color(0, 153, 204));
        btn_editar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_editar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_editarMousePressed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Refresh_40px.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Editar Personal");

        javax.swing.GroupLayout btn_editarLayout = new javax.swing.GroupLayout(btn_editar);
        btn_editar.setLayout(btn_editarLayout);
        btn_editarLayout.setHorizontalGroup(
            btn_editarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_editarLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel6)
                .addGap(47, 47, 47)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_editarLayout.setVerticalGroup(
            btn_editarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_editarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(btn_editarLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel7)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(btn_editar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 258, -1));

        btn_eliminar.setBackground(new java.awt.Color(0, 153, 204));
        btn_eliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_eliminar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_eliminarMousePressed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Delete_42px.png"))); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Eliminar Personal");

        javax.swing.GroupLayout btn_eliminarLayout = new javax.swing.GroupLayout(btn_eliminar);
        btn_eliminar.setLayout(btn_eliminarLayout);
        btn_eliminarLayout.setHorizontalGroup(
            btn_eliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_eliminarLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel8)
                .addGap(47, 47, 47)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        btn_eliminarLayout.setVerticalGroup(
            btn_eliminarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_eliminarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(btn_eliminarLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel9)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(btn_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 258, -1));

        btn_menu.setBackground(new java.awt.Color(0, 153, 204));
        btn_menu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_menu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btn_menuMousePressed(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Home_40px.png"))); // NOI18N

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Menu");

        javax.swing.GroupLayout btn_menuLayout = new javax.swing.GroupLayout(btn_menu);
        btn_menu.setLayout(btn_menuLayout);
        btn_menuLayout.setHorizontalGroup(
            btn_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_menuLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel10)
                .addGap(47, 47, 47)
                .addComponent(jLabel11)
                .addContainerGap(110, Short.MAX_VALUE))
        );
        btn_menuLayout.setVerticalGroup(
            btn_menuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(btn_menuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(btn_menuLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel11)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.add(btn_menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 258, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Gestión del Personal");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jSeparator1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 52, 190, 10));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));

        jTLibro.setBackground(new java.awt.Color(255, 255, 204));
        jTLibro.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jTLibro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "Anatomia", "Yo", "Trillas"},
                {"2", "Matematicas", "Tu", "Santillana"},
                {"3", "Fisica", "Ella", "Mexivergas"},
                {"4", "Español", "Nosotros", null}
            },
            new String [] {
                "ID", "Nombre", "Apellido Paterno", "Apellido Materno"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTLibro.setComponentPopupMenu(Modificar);
        jTLibro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jTLibro.setShowHorizontalLines(false);
        jTLibro.setShowVerticalLines(false);
        jScrollPane1.setViewportView(jTLibro);
        if (jTLibro.getColumnModel().getColumnCount() > 0) {
            jTLibro.getColumnModel().getColumn(0).setResizable(false);
            jTLibro.getColumnModel().getColumn(2).setResizable(false);
            jTLibro.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel1.setBackground(new java.awt.Color(0, 153, 204));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jSeparator2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel1.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 40, 230, 10));

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Search_30px.png"))); // NOI18N
        jLabel14.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel14MousePressed(evt);
            }
        });
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 20, -1, -1));

        jTextField1.setFont(new java.awt.Font("Segoe UI", 0, 13)); // NOI18N
        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField1KeyReleased(evt);
            }
        });
        jPanel1.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 230, 20));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBox1.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                jComboBox1ItemStateChanged(evt);
            }
        });
        jPanel1.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        jPanel4.setBackground(new java.awt.Color(0, 153, 204));
        jPanel4.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel4MouseDragged(evt);
            }
        });
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel4MousePressed(evt);
            }
        });

        jLabel16.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Expand_Arrow_32px_1.png"))); // NOI18N
        jLabel16.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel16MousePressed(evt);
            }
        });

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/icons8_Delete_32px_1.png"))); // NOI18N
        jLabel17.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jLabel17MousePressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel17)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel16)
                    .addComponent(jLabel17))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_agregarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_agregarMousePressed
        setColor(btn_agregar);
        resetColor(btn_editar);
        resetColor(btn_eliminar);
        resetColor(btn_menu);
        resetColor(btn_libro);
        if (this.banderaDeUsoAgregar) {
            c_agregarPersonal aP = new c_agregarPersonal();
            aP.setGestionarPersonal(this);
            aP.setAgregarPersonal(aP);
            aP.getPrepararInterfaz();
            this.banderaDeUsoAgregar = false;
        }
    }//GEN-LAST:event_btn_agregarMousePressed

    private void btn_editarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_editarMousePressed
        setColor(btn_editar);
        resetColor(btn_eliminar);
        resetColor(btn_menu);
        resetColor(btn_libro);
        resetColor(btn_agregar);
        int selec = this.jTLibro.getSelectedRow();
        if (selec != -1) {
            this.jTLibro.clearSelection();
            if (this.banderaDeUsoEditar) {
                String personal_id = String.valueOf(this.jTLibro.getValueAt(selec, 0));
                c_EditarPersonal per = new c_EditarPersonal();
                per.setGestionarPersonal(this);
                per.preparazInterEditarPersonal();
                per.cargarDatosEdicion(personal_id);
                this.banderaDeUsoEditar = false;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una fila", "ERROR", JOptionPane.ERROR_MESSAGE);
        }


    }//GEN-LAST:event_btn_editarMousePressed

    private void btn_eliminarMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_eliminarMousePressed
        setColor(btn_eliminar);
        resetColor(btn_menu);
        resetColor(btn_libro);
        resetColor(btn_agregar);
        resetColor(btn_editar);

        int selec = this.jTLibro.getSelectedRow();
        if (selec != -1) {
            this.jTLibro.clearSelection();
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                String personal_Id = String.valueOf(this.jTLibro.getValueAt(selec, 0));
                boolean confir = this.cPersonal.eliminaPersonal(personal_Id);
                if (confir) {
                    this.mostrarListaPersonal(this.cPersonal.getListaPersonal());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Elija una fila", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_btn_eliminarMousePressed

    private void btn_menuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_menuMousePressed
        setColor(btn_menu);
        resetColor(btn_libro);
        resetColor(btn_agregar);
        resetColor(btn_editar);
        resetColor(btn_eliminar);
        Menu me = new Menu();
        me.setVisible(true);
        this.dispose();// TODO add your handling code here:
    }//GEN-LAST:event_btn_menuMousePressed

    private void btn_libroMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_libroMousePressed
        setColor(btn_libro);
        resetColor(btn_agregar);
        resetColor(btn_editar);
        resetColor(btn_eliminar);
        resetColor(btn_menu);
    }//GEN-LAST:event_btn_libroMousePressed

    private void jLabel14MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel14MousePressed
        // TODO add your handling code here:
        String nombre = this.jTextField1.getText();
        this.cPersonal.buscarxNombre(nombre);
    }//GEN-LAST:event_jLabel14MousePressed

    private void jTextField1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyReleased
        //este metodo sirve cada vez que yo dejo de apretar una tecla
        String busq = this.jTextField1.getText();

        //creo un objeto de tipo patron para verifcar el lenguaje que 
        //voy a usar en lo sera el modulo de buscar por id
        Pattern patron = Pattern.compile("[0-9]*");

        //compruebo que busq pertenezca al lenguaje
        Matcher m = patron.matcher(busq);

        //esto retorna un booleano para ver si busq se encuentra dentro
        //del lenguaje
        boolean b = m.matches();

        if (this.jComboBox1.getSelectedItem().equals("Nombre")) {
            this.cPersonal.empiezaPorNombre(busq);
        }
        if (this.jComboBox1.getSelectedItem().equals("Apellido")) {
            this.cPersonal.empiezaPorApellido(busq);
        }
        if (this.jComboBox1.getSelectedItem().equals("ID")) {
            //aqui compruebo que si busq es igual a cero
            //o b es igual a verdadero me muestre todos los registros
            if (busq.length() == 0 || !b) {
                this.mostrarListaPersonal(this.cPersonal.getListaPersonal());
            } else {
                this.cPersonal.empiezaPorId(busq);
            }

        }

    }//GEN-LAST:event_jTextField1KeyReleased

    private void Modificar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Modificar1ActionPerformed
        int selec = this.jTLibro.getSelectedRow();
        if (selec != -1) {
            if (this.banderaDeUsoEditar) {
                String personal_id = String.valueOf(this.jTLibro.getValueAt(selec, 0));
                c_EditarPersonal per = new c_EditarPersonal();
                per.setGestionarPersonal(this);
                per.preparazInterEditarPersonal();
                per.cargarDatosEdicion(personal_id);
                this.banderaDeUsoEditar = false;
            }
        }

    }//GEN-LAST:event_Modificar1ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        int selec = this.jTLibro.getSelectedRow();
        if (selec != -1) {
            this.jTLibro.clearSelection();
            int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
            if (resp == JOptionPane.YES_OPTION) {
                String personal_Id = String.valueOf(this.jTLibro.getValueAt(selec, 0));
                boolean confir = this.cPersonal.eliminaPersonal(personal_Id);
                if (confir) {
                    this.mostrarListaPersonal(this.cPersonal.getListaPersonal());
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Elija una fila", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jPanel4MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseDragged
        // TODO add your handling code here
        Point point = MouseInfo.getPointerInfo().getLocation();
        int x = point.x - this.posx;
        int y = point.y - this.posy;
        this.setLocation(x, y);

    }//GEN-LAST:event_jPanel4MouseDragged

    private void jPanel4MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MousePressed
        // TODO add your handling code here:
        this.posx = evt.getX();
        this.posy = evt.getY();
    }//GEN-LAST:event_jPanel4MousePressed

    private void jLabel16MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel16MousePressed
        // TODO add your handling code here:
        this.setExtendedState(ICONIFIED);
    }//GEN-LAST:event_jLabel16MousePressed

    private void jLabel17MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel17MousePressed
        // TODO add your handling code here:
        int resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro?", "Alerta!", JOptionPane.YES_NO_OPTION);
        if (resp == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jLabel17MousePressed

    private void jComboBox1ItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_jComboBox1ItemStateChanged
        // TODO add your handling code here:
        if (evt.getStateChange() == ItemEvent.SELECTED) {
            if (this.jComboBox1.getSelectedItem().equals("Seleccione un filtro")) {
                this.jTextField1.setVisible(false);
                jSeparator2.setVisible(false);
            } else {
                this.jTextField1.setVisible(true);
                jSeparator2.setVisible(true);
            }
        }

    }//GEN-LAST:event_jComboBox1ItemStateChanged

    public void setColor(JPanel jpanel) {
        jpanel.setBackground(new java.awt.Color(0, 176, 247));
    }

    public void resetColor(JPanel jpanel) {
        jpanel.setBackground(new java.awt.Color(0, 153, 204));
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(i_gestionarPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(i_gestionarPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(i_gestionarPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(i_gestionarPersonal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new i_gestionarPersonal().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPopupMenu Modificar;
    private javax.swing.JMenuItem Modificar1;
    private javax.swing.JPanel btn_agregar;
    private javax.swing.JPanel btn_editar;
    private javax.swing.JPanel btn_eliminar;
    private javax.swing.JPanel btn_libro;
    private javax.swing.JPanel btn_menu;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTLibro;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
