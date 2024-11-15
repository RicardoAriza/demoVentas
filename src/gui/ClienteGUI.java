package gui;

import dao.DistritoDAO;
import dao.ClienteDAO;
import dao.ProvinciaDAO;
import hilo.AudioConHilos;
import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.ResultSet;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import to.ClienteTO;

public class ClienteGUI extends javax.swing.JInternalFrame {

    ClienteDAO objClienteDAO = new ClienteDAO();
    DefaultTableModel objDtm;
    int xidcliente;
    int xiddistrito;
    int xidprovincia;
    ResultSet rsCliente;
    ResultSet rsDistrito;
    ResultSet rsProvincia;
    DistritoDAO objDistritoDAO = new DistritoDAO();
    ProvinciaDAO objProvinciaDAO = new ProvinciaDAO();
    boolean sw;
    boolean ft = true;
    ButtonGroup objButtonGroup = new ButtonGroup();
    static final String ruta = System.getProperty("file.separator");
    static final String cli = "D:" + ruta + ruta + "fotosClientes";
    Icon icono;
    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    byte[] imagen = new byte[1024 * 1024];
    FileInputStream entrada;
    FileOutputStream salida;
    File fotos = new File(cli);
    AudioConHilos borrar = new AudioConHilos("/sonidos/RegistroBorrado.wav");
    AudioConHilos nuevo = new AudioConHilos("/sonidos/RegistroNuevo.wav");
    AudioConHilos actualizado = new AudioConHilos("/sonidos/RegistroActualizado.wav");
    AudioConHilos cancelado = new AudioConHilos("/sonidos/RegistroCancelado.wav");
    AudioConHilos grabado = new AudioConHilos("/sonidos/RegistroGrabado.wav");
    AudioConHilos error = new AudioConHilos("/sonidos/SeleccioneRegistro.wav");
    AudioConHilos start = new AudioConHilos("/sonidos/Start.wav");
    AudioConHilos exclamtion = new AudioConHilos("/sonidos/WExclamation.wav");
    AudioConHilos cancelar = new AudioConHilos("/sonidos/WCancelar.wav");
    AudioConHilos exit = new AudioConHilos("/sonidos/WExit.wav");
    AudioConHilos off = new AudioConHilos("/sonidos/WOff.wav");
    AudioConHilos salir = new AudioConHilos("/sonidos/WSalir.wav");
    AudioConHilos select = new AudioConHilos("/sonidos/WSelect.wav");

    public ClienteGUI() {
        initComponents();
        setSize(697, 648);
        objDtm = (DefaultTableModel) jtblRegistros.getModel();
        setVisible(true);
    }

    private void limpiarJTable() {
        while (objDtm.getRowCount() > 0) {
            objDtm.removeRow(0);
        }
    }

    private void habilitaControles(boolean b) {
        jbtnGrabar.setEnabled(b);
        jbtnCancelar.setEnabled(b);
        jbtnNuevo.setEnabled(!b);
        jbtnEditar.setEnabled(!b);
        jbtnBorrar.setEnabled(!b);
        jbtnSalir.setEnabled(!b);
        jtxtBuscar.setEditable(!b);
        JTextField[] objTextFields = {jtxtCelular, jtxtDireccion, jtxtEmail, jtxtFijo,
            jtxtNombre, jtxtObservacion, jtxtRuc};
        for (JTextField obJTextField : objTextFields) {
            obJTextField.setEditable(b);
        }
        jtxtNombre.grabFocus();
    }

    private void limpiaControles() {
        limpiarJTable();
        jcmbDistrito.removeAllItems();
        jcmbProvincia.removeAllItems();
        JTextField[] objTextFields = {jtxtCelular, jtxtDireccion, jtxtEmail, jtxtFijo,
            jtxtNombre, jtxtObservacion, jtxtRuc, jtxtCodigo};
        for (JTextField obJTextField : objTextFields) {
            obJTextField.setText(null);
        }
    }

    private void llenaComboDistrito() {
        try {
            rsDistrito = objDistritoDAO.buscar("%");
            if (sw) {
                while (rsDistrito.next()) {
                    jcmbDistrito.addItem(rsDistrito.getString(2));
                }
            } else {
                String nombre = jcmbDistrito.getSelectedItem().toString();
                while (rsDistrito.next()) {
                    if (!nombre.equals(rsDistrito.getString(2))) {
                        jcmbDistrito.addItem(rsDistrito.getString(2));
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    private void llenaComboProvincia() {
        try {
            rsProvincia = objProvinciaDAO.buscar("%");
            if (sw) {
                while (rsProvincia.next()) {
                    jcmbProvincia.addItem(rsProvincia.getString(2));
                }
            } else {
                String nombre = jcmbProvincia.getSelectedItem().toString();
                while (rsProvincia.next()) {
                    if (!nombre.equals(rsProvincia.getString(2))) {
                        jcmbProvincia.addItem(rsProvincia.getString(2));
                    }
                }
            }
        } catch (Exception e) {
        }
    }

    private void obtenerIddistrito() {
        try {
            String nombre = jcmbDistrito.getSelectedItem().toString();
            rsDistrito.first();
            do {
                if (nombre.equals(rsDistrito.getString(2))) {
                    xiddistrito = rsDistrito.getInt(1);
                    rsDistrito.last();
                }
            } while (rsDistrito.next());
        } catch (Exception e) {
        }
    }

    private void obtenerIdprovincia() {
        try {
            String nombre = jcmbProvincia.getSelectedItem().toString();
            rsProvincia.first();
            do {
                if (nombre.equals(rsProvincia.getString(2))) {
                    xidprovincia = rsProvincia.getInt(1);
                    rsProvincia.last();
                }
            } while (rsProvincia.next());
        } catch (Exception e) {
        }
    }

    private void obtenerIdcliente() {
        try {
            rsCliente = objClienteDAO.buscar("%");
            while (rsCliente.next()) {
                xidcliente = rsCliente.getInt(1);
            }
        } catch (Exception e) {
        }
    }

    public byte[] AbrirArchivo(File archivo) {
        try {
            entrada = new FileInputStream(archivo);
            entrada.read(imagen);
        } catch (Exception e) {
        }
        return imagen;
    }

    public String GuardarArchivo(byte[] imagen) {
        String mensaje = null;
        try {
            salida = new FileOutputStream(fotos + "/" + xidcliente + ".jpg");
            salida.write(imagen);
            mensaje = "Archivo Guardado";
        } catch (Exception e) {
        }
        return mensaje;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtxtBuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblRegistros = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jbtnNuevo = new javax.swing.JButton();
        jbtnGrabar = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();
        jbtnEditar = new javax.swing.JButton();
        jbtnBorrar = new javax.swing.JButton();
        jbtnSalir = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jtxtCodigo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtxtRuc = new javax.swing.JTextField();
        jtxtNombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtxtDireccion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jtxtEmail = new javax.swing.JTextField();
        jtxtFijo = new javax.swing.JTextField();
        jtxtObservacion = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jtxtCelular = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jcmbDistrito = new javax.swing.JComboBox<>();
        jlblFoto = new javax.swing.JLabel();
        jcmbProvincia = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CODIGO");

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Ingrese nombre a buscar:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jtxtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtBuscarKeyReleased(evt);
            }
        });
        getContentPane().add(jtxtBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(221, 11, 230, -1));

        jtblRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "R.U.C.", "NOMBRE"
            }
        ));
        jtblRegistros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jtblRegistros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtblRegistrosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtblRegistros);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 41, 660, 110));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jbtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/nuevo.png"))); // NOI18N
        jbtnNuevo.setText("Nuevo");
        jbtnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevoActionPerformed(evt);
            }
        });

        jbtnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/grabar.png"))); // NOI18N
        jbtnGrabar.setText("Grabar");
        jbtnGrabar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnGrabar.setEnabled(false);
        jbtnGrabar.setMaximumSize(new java.awt.Dimension(120, 45));
        jbtnGrabar.setMinimumSize(new java.awt.Dimension(120, 45));
        jbtnGrabar.setPreferredSize(new java.awt.Dimension(120, 45));
        jbtnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGrabarActionPerformed(evt);
            }
        });

        jbtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancelar.png"))); // NOI18N
        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnCancelar.setEnabled(false);
        jbtnCancelar.setMaximumSize(new java.awt.Dimension(120, 45));
        jbtnCancelar.setMinimumSize(new java.awt.Dimension(120, 45));
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });

        jbtnEditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/editar.png"))); // NOI18N
        jbtnEditar.setText("Editar");
        jbtnEditar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEditarActionPerformed(evt);
            }
        });

        jbtnBorrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/borrar.png"))); // NOI18N
        jbtnBorrar.setText("Borrar");
        jbtnBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBorrarActionPerformed(evt);
            }
        });

        jbtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/salir.png"))); // NOI18N
        jbtnSalir.setText("Salir");
        jbtnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(138, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(148, 148, 148))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnGrabar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, 660, 120));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CODIGO");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 12, 111, -1));

        jtxtCodigo.setEditable(false);
        jtxtCodigo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanel2.add(jtxtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 12, 144, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("NOMBRE");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 88, 111, -1));

        jtxtRuc.setEditable(false);
        jtxtRuc.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtRuc, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 50, 280, -1));

        jtxtNombre.setEditable(false);
        jtxtNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 88, 280, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("R.U.C.");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 50, 111, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("DISTRITO");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 164, 111, -1));

        jtxtDireccion.setEditable(false);
        jtxtDireccion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 126, 280, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("DIRECCION");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 126, 111, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("TELF. FIJO");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 111, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("E-MAIL");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 270, 111, -1));

        jtxtEmail.setEditable(false);
        jtxtEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 270, 207, -1));

        jtxtFijo.setEditable(false);
        jtxtFijo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtFijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 230, 207, -1));

        jtxtObservacion.setEditable(false);
        jtxtObservacion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtObservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 511, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("OBSERVACION");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 111, -1));

        jtxtCelular.setEditable(false);
        jtxtCelular.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 230, 167, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("CELULAR");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 230, 111, -1));

        jcmbDistrito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jcmbDistrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 164, 282, -1));

        jlblFoto.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jlblFoto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblFoto.setText("FOTO");
        jlblFoto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jlblFoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jlblFoto.setMaximumSize(new java.awt.Dimension(100, 100));
        jlblFoto.setMinimumSize(new java.awt.Dimension(100, 100));
        jlblFoto.setPreferredSize(new java.awt.Dimension(100, 100));
        jlblFoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlblFotoMouseClicked(evt);
            }
        });
        jPanel2.add(jlblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 13, 183, 171));

        jcmbProvincia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jcmbProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 200, 282, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("PROVINCIA");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 111, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 149, 660, 340));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNuevoActionPerformed
        habilitaControles(true);
        start.run();
        limpiaControles();
        sw = true;
        llenaComboDistrito();
        llenaComboProvincia();
    }//GEN-LAST:event_jbtnNuevoActionPerformed

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        habilitaControles(false);
        cancelar.run();
        cancelado.run();
        jlblFoto.setIcon(null);
        limpiaControles();
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jbtnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGrabarActionPerformed
        try {
            start.run();
            ClienteTO objClienteTO = new ClienteTO();
            objClienteTO.setNombclie(jtxtNombre.getText().toUpperCase());
            objClienteTO.setRucclie(jtxtRuc.getText().toUpperCase());
            objClienteTO.setDireclie(jtxtDireccion.getText().toUpperCase());
            obtenerIddistrito();
            objClienteTO.setIddistrito(xiddistrito);
            obtenerIdprovincia();
            objClienteTO.setIdprovincia(xidprovincia);
            objClienteTO.setTelfclie(Integer.parseInt(jtxtFijo.getText()));
            objClienteTO.setCeluclie(Integer.parseInt(jtxtCelular.getText()));
            objClienteTO.setEmaiclie(jtxtEmail.getText().toUpperCase());
            objClienteTO.setObsvclie(jtxtObservacion.getText().toUpperCase());
            if (sw) {
                objClienteDAO.insert(objClienteTO);
                grabado.run();
                obtenerIdcliente();
                JOptionPane.showMessageDialog(rootPane, "Registro Grabado");
            } else {
                if (ft) {
                    objClienteTO.setIdcliente(xidcliente);
                    File cambio = new File(cli + "/" + xidcliente + ".jpg");
                    imagen = AbrirArchivo(cambio);
                    actualizado.run();
                    objClienteDAO.update(objClienteTO);
                    JOptionPane.showMessageDialog(rootPane, "Registro Actualizado");
                } else {
                    objClienteTO.setIdcliente(xidcliente);
                    File cambio = new File(cli + "/" + xidcliente + ".jpg");
                    imagen = AbrirArchivo(cambio);
                    GuardarArchivo(imagen);
                    actualizado.run();
                    objClienteDAO.update(objClienteTO);
                    JOptionPane.showMessageDialog(rootPane, "Registro Actualizado");
                }
            }
            habilitaControles(false);
            limpiaControles();
            jtxtBuscar.setText(null);
            jlblFoto.setIcon(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jbtnGrabarActionPerformed

    private void jbtnBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBorrarActionPerformed
        try {
            exclamtion.run();
            int op = JOptionPane.showConfirmDialog(rootPane, "¿Esta seguro que desea eliminar?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (op == JOptionPane.YES_OPTION) {
                select.run();
                ClienteTO objClienteTO = new ClienteTO();
                objClienteTO.setIdcliente(xidcliente);
                objClienteDAO.delete(objClienteTO);
                limpiaControles();
                borrar.run();
                JOptionPane.showMessageDialog(rootPane, "Registro Borrado");
                jlblFoto.setIcon(null);
            } else {
                select.run();
            }
        } catch (Exception e) {
            error.run();
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jbtnBorrarActionPerformed

    private void jbtnEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEditarActionPerformed
        sw = false;
        start.run();
        llenaComboDistrito();
        llenaComboProvincia();
        habilitaControles(true);
    }//GEN-LAST:event_jbtnEditarActionPerformed

    private void jbtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalirActionPerformed
        exit.run();
        dispose();
    }//GEN-LAST:event_jbtnSalirActionPerformed

    private void jtxtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtBuscarKeyReleased
        try {
            limpiarJTable();
            if (!jtxtBuscar.getText().isEmpty()) {
                rsCliente = objClienteDAO.buscar(jtxtBuscar.getText());
                while (rsCliente.next()) {
                    Object registro[] = {rsCliente.getInt(1), rsCliente.getString(2), rsCliente.getString(3)};
                    objDtm.addRow(registro);
                }
                jtblRegistros.setModel(objDtm);
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_jtxtBuscarKeyReleased

    private void jtblRegistrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtblRegistrosMouseClicked
        try {
            start.run();
            xidcliente = Integer.parseInt(jtblRegistros.getValueAt(jtblRegistros.getSelectedRow(), 0).toString());
            rsCliente.first();
            do {
                if (xidcliente == rsCliente.getInt(1)) {
                    jtxtCodigo.setText(rsCliente.getString(1));
                    jtxtRuc.setText(rsCliente.getString(2));
                    jtxtNombre.setText(rsCliente.getString(3));
                    jtxtDireccion.setText(rsCliente.getString(4));
                    jcmbDistrito.removeAllItems();
                    jcmbDistrito.addItem(rsCliente.getString(5));
                    jcmbProvincia.removeAllItems();
                    jcmbProvincia.addItem(rsCliente.getString(6));
                    jtxtFijo.setText(rsCliente.getString(7));
                    jtxtCelular.setText(rsCliente.getString(8));
                    jtxtEmail.setText(rsCliente.getString(9));
                    jtxtObservacion.setText(rsCliente.getString(10));
                    ImageIcon recurso = new ImageIcon(cli + "/" + xidcliente + ".jpg");
                    icono = new ImageIcon(recurso.getImage().getScaledInstance(jlblFoto.getWidth(), jlblFoto.getHeight(), Image.SCALE_DEFAULT));
                    jlblFoto.setIcon(icono);
                    rsCliente.last();
                }
            } while (rsCliente.next());
        } catch (Exception e) {
            error.run();
        }
    }//GEN-LAST:event_jtblRegistrosMouseClicked

    private void jlblFotoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlblFotoMouseClicked
        start.run();
        if (!fotos.isDirectory()) {
            fotos.mkdirs();
        }
        if (seleccionar.showDialog(null, null) == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();
            if (archivo.canRead()) {
                if (archivo.getName().endsWith("jpg") || archivo.getName().endsWith("png") || archivo.getName().endsWith("jpeg")) {
                    imagen = AbrirArchivo(archivo);
                    ImageIcon recurso = new ImageIcon(archivo.getAbsolutePath());
                    icono = new ImageIcon(recurso.getImage().getScaledInstance(jlblFoto.getWidth(), jlblFoto.getHeight(), Image.SCALE_DEFAULT));
                    jlblFoto.setIcon(icono);
                } else {
                    JOptionPane.showMessageDialog(null, "Archivo no Compatible");
                }
            }
        }
    }//GEN-LAST:event_jlblFotoMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnBorrar;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnEditar;
    private javax.swing.JButton jbtnGrabar;
    private javax.swing.JButton jbtnNuevo;
    private javax.swing.JButton jbtnSalir;
    private javax.swing.JComboBox<String> jcmbDistrito;
    private javax.swing.JComboBox<String> jcmbProvincia;
    private javax.swing.JLabel jlblFoto;
    private javax.swing.JTable jtblRegistros;
    private javax.swing.JTextField jtxtBuscar;
    private javax.swing.JTextField jtxtCelular;
    private javax.swing.JTextField jtxtCodigo;
    private javax.swing.JTextField jtxtDireccion;
    private javax.swing.JTextField jtxtEmail;
    private javax.swing.JTextField jtxtFijo;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtObservacion;
    private javax.swing.JTextField jtxtRuc;
    // End of variables declaration//GEN-END:variables
}
