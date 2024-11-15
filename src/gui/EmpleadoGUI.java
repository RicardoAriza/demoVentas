package gui;

import dao.DistritoDAO;
import dao.EmpleadoDAO;
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
import to.EmpleadoTO;

public class EmpleadoGUI extends javax.swing.JInternalFrame {

    EmpleadoDAO objEmpleadoDAO = new EmpleadoDAO();
    DefaultTableModel objDtm;
    int xidempleado;
    int xiddistrito;
    int xidprovincia;
    ResultSet rsEmpleado;
    ResultSet rsDistrito;
    ResultSet rsProvincia;
    DistritoDAO objDistritoDAO = new DistritoDAO();
    ProvinciaDAO objProvinciaDAO = new ProvinciaDAO();
    boolean sw;
    boolean ft = true;
    ButtonGroup objButtonGroup = new ButtonGroup();
    Icon icono;
    JFileChooser seleccionar = new JFileChooser();
    File archivo;
    static final String ruta = System.getProperty("file.separator");
    static final String emp = "D:" + ruta + ruta + "fotosEmpleados";
    File fotos = new File(emp);
    byte[] imagen = new byte[1024 * 1024];
    ;
    FileInputStream entrada;
    FileOutputStream salida;
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
            salida = new FileOutputStream(fotos + "/" + xidempleado + ".jpg");
            salida.write(imagen);
            mensaje = "Archivo Guardado";
        } catch (Exception e) {
        }
        return mensaje;
    }

    public EmpleadoGUI() {
        initComponents();
        setSize(697, 630);
        objDtm = (DefaultTableModel) jtblRegistros.getModel();
        objButtonGroup.add(jrbtFemenino);
        objButtonGroup.add(jrbtMasculino);
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
        jrbtFemenino.setEnabled(b);
        jrbtMasculino.setEnabled(b);
        JTextField[] objTextFields = {jtxtCelular, jtxtDireccion, jtxtEmail, jtxtFijo,
            jtxtMaterno, jtxtNombre, jtxtObservacion, jtxtPaterno};
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
            jtxtMaterno, jtxtNombre, jtxtObservacion, jtxtPaterno, jtxtCodigo};
        for (JTextField obJTextField : objTextFields) {
            obJTextField.setText(null);
        }
        objButtonGroup.clearSelection();
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

    private void obtenerIdempleado() {
        try {
            rsEmpleado = objEmpleadoDAO.buscar("%");
            while (rsEmpleado.next()) {
                xidempleado = rsEmpleado.getInt(1);
            }
        } catch (Exception e) {
        }
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
        jtxtPaterno = new javax.swing.JTextField();
        jtxtNombre = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jtxtDireccion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jtxtMaterno = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jtxtEmail = new javax.swing.JTextField();
        jtxtFijo = new javax.swing.JTextField();
        jtxtObservacion = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        jtxtCelular = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jrbtMasculino = new javax.swing.JRadioButton();
        jrbtFemenino = new javax.swing.JRadioButton();
        jlblFoto = new javax.swing.JLabel();
        jcmbDistrito = new javax.swing.JComboBox<>();
        jLabel19 = new javax.swing.JLabel();
        jcmbProvincia = new javax.swing.JComboBox<>();

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("CODIGO");

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Ingrese apellido paterno a buscar:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, -1));

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
                "CODIGO", "NOMBRE", "AP PATERNO", "AP MATERNO"
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

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 660, 120));

        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("CODIGO");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 12, 111, -1));

        jtxtCodigo.setEditable(false);
        jPanel2.add(jtxtCodigo, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 12, 88, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("AP PATERNO");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 64, 111, -1));

        jtxtPaterno.setEditable(false);
        jtxtPaterno.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 64, 280, -1));

        jtxtNombre.setEditable(false);
        jtxtNombre.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 38, 280, -1));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("NOMBRE");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 38, 111, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("DISTRITO");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 194, 111, -1));

        jtxtDireccion.setEditable(false);
        jtxtDireccion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtDireccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 156, 280, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("DIRECCION");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 156, 111, -1));

        jtxtMaterno.setEditable(false);
        jtxtMaterno.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 95, 280, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("AP MATERNO");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(13, 95, 111, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("TELF. FIJO");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 225, 111, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("E-MAIL");
        jPanel2.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 256, 111, -1));

        jtxtEmail.setEditable(false);
        jtxtEmail.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 256, 207, -1));

        jtxtFijo.setEditable(false);
        jtxtFijo.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtFijo, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 225, 207, -1));

        jtxtObservacion.setEditable(false);
        jtxtObservacion.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtObservacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 287, 511, -1));

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("OBSERVACION");
        jPanel2.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 287, 111, -1));

        jtxtCelular.setEditable(false);
        jtxtCelular.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jPanel2.add(jtxtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 225, 183, -1));

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("CELULAR");
        jPanel2.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(349, 225, 111, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("SEXO");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(11, 128, 111, -1));

        jrbtMasculino.setText("MASCULINO");
        jrbtMasculino.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jrbtMasculino, new org.netbeans.lib.awtextra.AbsoluteConstraints(128, 122, 94, -1));

        jrbtFemenino.setText("FEMENINO");
        jrbtFemenino.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jrbtFemenino, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 122, 95, -1));

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
        jPanel2.add(jlblFoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 12, 183, 171));

        jcmbDistrito.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jcmbDistrito, new org.netbeans.lib.awtextra.AbsoluteConstraints(126, 194, 209, -1));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("PROVINCIA");
        jPanel2.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(345, 194, 111, -1));

        jcmbProvincia.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanel2.add(jcmbProvincia, new org.netbeans.lib.awtextra.AbsoluteConstraints(466, 194, 183, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 149, 660, 320));

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
            EmpleadoTO objEmpleadoTO = new EmpleadoTO();
            start.run();
            objEmpleadoTO.setNombempl(jtxtNombre.getText().toUpperCase());
            objEmpleadoTO.setApatempl(jtxtPaterno.getText().toUpperCase());
            objEmpleadoTO.setAmatempl(jtxtMaterno.getText().toUpperCase());
            if (jrbtMasculino.isSelected()) {
                objEmpleadoTO.setSexoempl("M");
            }
            if (jrbtFemenino.isSelected()) {
                objEmpleadoTO.setSexoempl("F");
            }
            objEmpleadoTO.setDireempl(jtxtDireccion.getText().toUpperCase());
            obtenerIddistrito();
            objEmpleadoTO.setIddistrito(xiddistrito);
            obtenerIdprovincia();
            objEmpleadoTO.setIdprovincia(xidprovincia);
            objEmpleadoTO.setTelfempl(Integer.parseInt(jtxtFijo.getText()));
            objEmpleadoTO.setCeluempl(Integer.parseInt(jtxtCelular.getText()));
            objEmpleadoTO.setEmaiempl(jtxtEmail.getText().toUpperCase());
            objEmpleadoTO.setObsvempl(jtxtObservacion.getText().toUpperCase());
            if (sw) {
                objEmpleadoDAO.insert(objEmpleadoTO);
                obtenerIdempleado();
                GuardarArchivo(imagen);
                grabado.run();
                JOptionPane.showMessageDialog(rootPane, "Registro Grabado");
            } else {
                if (ft) {
                    objEmpleadoTO.setIdempleado(xidempleado);
                    objEmpleadoDAO.update(objEmpleadoTO);
                    xidempleado = Integer.parseInt(jtxtCodigo.getText());
                    actualizado.run();
                    JOptionPane.showMessageDialog(rootPane, "Registro Actualizado");
                } else {
                    objEmpleadoTO.setIdempleado(xidempleado);
                    objEmpleadoDAO.update(objEmpleadoTO);
                    xidempleado = Integer.parseInt(jtxtCodigo.getText());
                    GuardarArchivo(imagen);
                    actualizado.run();
                    JOptionPane.showMessageDialog(rootPane, "Registro Actualizado");
                }
            }
            habilitaControles(false);
            limpiaControles();
            jlblFoto.setIcon(null);
            jtxtBuscar.setText(null);
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
                EmpleadoTO objEmpleadoTO = new EmpleadoTO();
                objEmpleadoTO.setIdempleado(xidempleado);
                objEmpleadoDAO.delete(objEmpleadoTO);
                limpiaControles();
                borrar.run();
                JOptionPane.showMessageDialog(rootPane, "Registro Borrado");
                jlblFoto.setIcon(null);
            }else{
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
                rsEmpleado = objEmpleadoDAO.buscar(jtxtBuscar.getText());
                while (rsEmpleado.next()) {
                    Object registro[] = {rsEmpleado.getInt(1), rsEmpleado.getString(2), rsEmpleado.getString(3), rsEmpleado.getString(4)};
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
            xidempleado = Integer.parseInt(jtblRegistros.getValueAt(jtblRegistros.getSelectedRow(), 0).toString());
            rsEmpleado.first();
            do {
                if (xidempleado == rsEmpleado.getInt(1)) {
                    jtxtCodigo.setText(String.valueOf(rsEmpleado.getInt(1)));
                    jtxtNombre.setText(rsEmpleado.getString(2));
                    jtxtPaterno.setText(rsEmpleado.getString(3));
                    jtxtMaterno.setText(rsEmpleado.getString(4));
                    if (rsEmpleado.getString(5).equals("M")) {
                        jrbtMasculino.setSelected(true);
                    }
                    if (rsEmpleado.getString(5).equals("F")) {
                        jrbtFemenino.setSelected(true);
                    }
                    jtxtDireccion.setText(rsEmpleado.getString(6));
                    jcmbDistrito.removeAllItems();
                    jcmbDistrito.addItem(rsEmpleado.getString(7));
                    jcmbProvincia.removeAllItems();
                    jcmbProvincia.addItem(rsEmpleado.getString(8));
                    jtxtFijo.setText(rsEmpleado.getString(9));
                    jtxtCelular.setText(rsEmpleado.getString(10));
                    jtxtEmail.setText(rsEmpleado.getString(11));
                    jtxtObservacion.setText(rsEmpleado.getString(12));
                    ImageIcon recurso = new ImageIcon(emp + "/" + xidempleado + ".jpg");
                    icono = new ImageIcon(recurso.getImage().getScaledInstance(jlblFoto.getWidth(), jlblFoto.getHeight(), Image.SCALE_DEFAULT));
                    jlblFoto.setIcon(icono);
                    rsEmpleado.last();
                }
            } while (rsEmpleado.next());
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
                    ft = false;
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
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JRadioButton jrbtFemenino;
    private javax.swing.JRadioButton jrbtMasculino;
    private javax.swing.JTable jtblRegistros;
    private javax.swing.JTextField jtxtBuscar;
    private javax.swing.JTextField jtxtCelular;
    private javax.swing.JTextField jtxtCodigo;
    private javax.swing.JTextField jtxtDireccion;
    private javax.swing.JTextField jtxtEmail;
    private javax.swing.JTextField jtxtFijo;
    private javax.swing.JTextField jtxtMaterno;
    private javax.swing.JTextField jtxtNombre;
    private javax.swing.JTextField jtxtObservacion;
    private javax.swing.JTextField jtxtPaterno;
    // End of variables declaration//GEN-END:variables
}
