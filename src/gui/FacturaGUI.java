package gui;

import conexion.ConMySql;
import dao.DetalleFacturaDAO;
import dao.DistritoDAO;
import dao.FacturaDAO;
import hilo.AudioConHilos;
import java.awt.Desktop;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.print.PrinterJob;
import java.io.File;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;
import to.DetalleFacturaTO;
import to.FacturaTO;

public class FacturaGUI extends javax.swing.JInternalFrame {

    DefaultTableModel objDtm;
    FacturaDAO objFacturaDAO = new FacturaDAO();
    DistritoDAO objDistritoDAO = new DistritoDAO();
    FacturaTO objFacturaTO = new FacturaTO();
    DetalleFacturaDAO objDetalleFacturaDAO = new DetalleFacturaDAO();
    ResultSet rsDistrito;
    int xiddistrito;
    int xidfactura;
    boolean sw;
    boolean bt;
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
    AudioConHilos select = new AudioConHilos("/sonidos/WSelect.wav");
    AudioConHilos off = new AudioConHilos("/sonidos/WOff.wav");
    AudioConHilos salir = new AudioConHilos("/sonidos/WSalir.wav");
    AudioConHilos Imprimir = new AudioConHilos("/sonidos/Imprimir.wav");
    double importe;
    double precio;
    int cantidad;
    double subtotal;
    double igv;
    double total;

    public FacturaGUI() {
        initComponents();
        setVisible(true);
        setSize(598, 732);
        objDtm = (DefaultTableModel) jtblRegistros.getModel();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtxtFecha = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jbtnNuevo = new javax.swing.JButton();
        jbtnGrabar = new javax.swing.JButton();
        jbtnCancelar = new javax.swing.JButton();
        jbtnSalir = new javax.swing.JButton();
        jbtnImprimir = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jtxtIdcliente = new javax.swing.JTextField();
        jtxtNombclie = new javax.swing.JTextField();
        jtxtDireclie = new javax.swing.JTextField();
        jtxtCiudad = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jtxtCelular = new javax.swing.JTextField();
        jbtnCliente = new javax.swing.JButton();
        jtxtFactura = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jtxtSubtotal = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jtxtIgv = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jtxtTotal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtblRegistros = new javax.swing.JTable();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jtxtIdproducto = new javax.swing.JTextField();
        jtxtNombprod = new javax.swing.JTextField();
        jtxtCantidad = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jtxtImporte = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jtxtPrecio = new javax.swing.JTextField();
        jbtnAgregar = new javax.swing.JButton();
        jbtnEliminar = new javax.swing.JButton();
        jbtnProducto = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jtxtIdempleado = new javax.swing.JTextField();
        jtxtNombempl = new javax.swing.JTextField();
        jtxtPaterno = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jtxtMaterno = new javax.swing.JTextField();
        jbtnEmpleado = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setText("Fecha:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 40, -1));

        jtxtFecha.setEditable(false);
        getContentPane().add(jtxtFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 50, 120, -1));

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 130, -1, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jbtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/nuevo_1.png"))); // NOI18N
        jbtnNuevo.setText("Nuevo");
        jbtnNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnNuevoActionPerformed(evt);
            }
        });
        jPanel5.add(jbtnNuevo, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 10, 110, 45));

        jbtnGrabar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/grabar_1.png"))); // NOI18N
        jbtnGrabar.setText("Grabar");
        jbtnGrabar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnGrabar.setEnabled(false);
        jbtnGrabar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnGrabarActionPerformed(evt);
            }
        });
        jPanel5.add(jbtnGrabar, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, -1, 45));

        jbtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cancelar_1.png"))); // NOI18N
        jbtnCancelar.setText("Cancelar");
        jbtnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnCancelar.setEnabled(false);
        jbtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCancelarActionPerformed(evt);
            }
        });
        jPanel5.add(jbtnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 120, 45));

        jbtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/salir_1.png"))); // NOI18N
        jbtnSalir.setText("Salir");
        jbtnSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalirActionPerformed(evt);
            }
        });
        jPanel5.add(jbtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 70, 100, 45));

        jbtnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/factura_1.png"))); // NOI18N
        jbtnImprimir.setText("Imprimir");
        jbtnImprimir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnImprimir.setEnabled(false);
        jbtnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnImprimirActionPerformed(evt);
            }
        });
        jPanel5.add(jbtnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 70, 110, 45));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 560, 370, 130));

        jPanel6.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel6.setText("Codigo Cliente: ");
        jPanel6.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));

        jLabel7.setText("Nombre Cliente:");
        jPanel6.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 20));

        jLabel8.setText("Dirección:");
        jPanel6.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 70, -1, 20));

        jtxtIdcliente.setEditable(false);
        jtxtIdcliente.setMinimumSize(new java.awt.Dimension(6, 30));
        jtxtIdcliente.setPreferredSize(new java.awt.Dimension(6, 30));
        jPanel6.add(jtxtIdcliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 120, 25));

        jtxtNombclie.setEditable(false);
        jtxtNombclie.setMinimumSize(new java.awt.Dimension(6, 30));
        jtxtNombclie.setPreferredSize(new java.awt.Dimension(6, 30));
        jPanel6.add(jtxtNombclie, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 400, 25));

        jtxtDireclie.setEditable(false);
        jtxtDireclie.setMinimumSize(new java.awt.Dimension(6, 30));
        jtxtDireclie.setPreferredSize(new java.awt.Dimension(6, 30));
        jPanel6.add(jtxtDireclie, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 400, 25));

        jtxtCiudad.setEditable(false);
        jtxtCiudad.setMinimumSize(new java.awt.Dimension(6, 30));
        jtxtCiudad.setPreferredSize(new java.awt.Dimension(6, 30));
        jPanel6.add(jtxtCiudad, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 120, 25));

        jLabel9.setText("Ciudad:");
        jPanel6.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 100, -1, 20));

        jLabel10.setText("Celular:");
        jPanel6.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 100, -1, 20));

        jtxtCelular.setEditable(false);
        jtxtCelular.setMinimumSize(new java.awt.Dimension(6, 30));
        jtxtCelular.setPreferredSize(new java.awt.Dimension(6, 30));
        jPanel6.add(jtxtCelular, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 100, 120, 25));

        jbtnCliente.setText("...");
        jbtnCliente.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnCliente.setEnabled(false);
        jbtnCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnClienteActionPerformed(evt);
            }
        });
        jPanel6.add(jbtnCliente, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 560, 140));

        jtxtFactura.setEditable(false);
        getContentPane().add(jtxtFactura, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 10, 120, -1));

        jPanel7.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtxtSubtotal.setEditable(false);
        jPanel7.add(jtxtSubtotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 100, 25));

        jLabel13.setText("Sub. Total:");
        jPanel7.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 20));

        jLabel14.setText("Igv 18%");
        jPanel7.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, -1, 20));

        jtxtIgv.setEditable(false);
        jPanel7.add(jtxtIgv, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 100, 25));

        jLabel25.setText("TOTAL: ");
        jPanel7.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, -1, 20));

        jtxtTotal.setEditable(false);
        jPanel7.add(jtxtTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 70, 100, 25));

        getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 560, 190, 110));

        jtblRegistros.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255)));
        jtblRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE", "PRECIO", "CANTIDAD", "IMPORTE"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblRegistros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(jtblRegistros);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 460, 560, 100));

        jPanel8.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel8.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setText("Codigo Producto: ");
        jPanel8.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));

        jLabel17.setText("Nombre Producto:");
        jPanel8.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 20));

        jtxtIdproducto.setEditable(false);
        jtxtIdproducto.setMinimumSize(new java.awt.Dimension(6, 30));
        jtxtIdproducto.setPreferredSize(new java.awt.Dimension(6, 30));
        jPanel8.add(jtxtIdproducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 150, 25));

        jtxtNombprod.setEditable(false);
        jtxtNombprod.setMinimumSize(new java.awt.Dimension(6, 30));
        jtxtNombprod.setPreferredSize(new java.awt.Dimension(6, 30));
        jPanel8.add(jtxtNombprod, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 40, 400, 25));

        jtxtCantidad.setEditable(false);
        jtxtCantidad.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        jtxtCantidad.setMinimumSize(new java.awt.Dimension(6, 30));
        jtxtCantidad.setPreferredSize(new java.awt.Dimension(6, 30));
        jtxtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtCantidadActionPerformed(evt);
            }
        });
        jPanel8.add(jtxtCantidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 70, 70, 25));

        jLabel18.setText("Cantidad");
        jPanel8.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 70, -1, 20));

        jLabel19.setText("Importe:");
        jPanel8.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 70, -1, 20));

        jtxtImporte.setEditable(false);
        jtxtImporte.setMinimumSize(new java.awt.Dimension(6, 30));
        jtxtImporte.setPreferredSize(new java.awt.Dimension(6, 30));
        jPanel8.add(jtxtImporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 100, 25));

        jLabel20.setText("Precio");
        jPanel8.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, 20));

        jtxtPrecio.setEditable(false);
        jtxtPrecio.setMinimumSize(new java.awt.Dimension(6, 30));
        jtxtPrecio.setPreferredSize(new java.awt.Dimension(6, 30));
        jPanel8.add(jtxtPrecio, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 70, 60, 25));

        jbtnAgregar.setText("Agregar");
        jbtnAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnAgregar.setEnabled(false);
        jbtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAgregarActionPerformed(evt);
            }
        });
        jPanel8.add(jbtnAgregar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 110, 140, -1));

        jbtnEliminar.setText("Eliminar");
        jbtnEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnEliminar.setEnabled(false);
        jbtnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEliminarActionPerformed(evt);
            }
        });
        jPanel8.add(jbtnEliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 110, 150, -1));

        jbtnProducto.setText("...");
        jbtnProducto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnProducto.setEnabled(false);
        jbtnProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnProductoActionPerformed(evt);
            }
        });
        jPanel8.add(jbtnProducto, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        getContentPane().add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 310, 560, 150));

        jPanel9.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel9.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel21.setText("Codigo Empleado: ");
        jPanel9.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));

        jLabel22.setText("   Nombre :");
        jPanel9.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 60, 20));

        jtxtIdempleado.setEditable(false);
        jtxtIdempleado.setMinimumSize(new java.awt.Dimension(6, 30));
        jtxtIdempleado.setPreferredSize(new java.awt.Dimension(6, 30));
        jPanel9.add(jtxtIdempleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 150, 25));

        jtxtNombempl.setEditable(false);
        jtxtNombempl.setMinimumSize(new java.awt.Dimension(6, 30));
        jtxtNombempl.setPreferredSize(new java.awt.Dimension(6, 30));
        jPanel9.add(jtxtNombempl, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 120, 25));

        jtxtPaterno.setEditable(false);
        jtxtPaterno.setMinimumSize(new java.awt.Dimension(6, 30));
        jtxtPaterno.setPreferredSize(new java.awt.Dimension(6, 30));
        jPanel9.add(jtxtPaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 120, 25));

        jLabel23.setText("Paterno:");
        jPanel9.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, -1, 20));

        jLabel24.setText("Materno:");
        jPanel9.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, 20));

        jtxtMaterno.setEditable(false);
        jtxtMaterno.setMinimumSize(new java.awt.Dimension(6, 30));
        jtxtMaterno.setPreferredSize(new java.awt.Dimension(6, 30));
        jPanel9.add(jtxtMaterno, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 50, 120, 25));

        jbtnEmpleado.setText("...");
        jbtnEmpleado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jbtnEmpleado.setEnabled(false);
        jbtnEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnEmpleadoActionPerformed(evt);
            }
        });
        jPanel9.add(jbtnEmpleado, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        getContentPane().add(jPanel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 560, 90));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("STORE S.A.");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 20, 140, 30));

        jLabel3.setText("Factura:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 10, 50, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalirActionPerformed
        exit.run();
        dispose();
    }//GEN-LAST:event_jbtnSalirActionPerformed

    private void jbtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCancelarActionPerformed
        habilitaControles(false);
        cancelar.run();
        cancelado.run();
        limpiaControles();
    }//GEN-LAST:event_jbtnCancelarActionPerformed

    private void jbtnGrabarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnGrabarActionPerformed
        try {
            start.run();
            String mensaje;
            objFacturaTO.setIdcliente(Integer.parseInt(jtxtIdcliente.getText()));
            objFacturaTO.setIdempleado(Integer.parseInt(jtxtIdempleado.getText()));
            objFacturaTO.setStotfact(subtotal);
            objFacturaTO.setIgvfact(igv);
            objFacturaTO.setTotafact(total);
            objFacturaTO.setObsvfact("");
            if (sw) {
                objFacturaDAO.insert(objFacturaTO);
                xidfactura = objFacturaDAO.obtenerIdFactura();
                int filas = jtblRegistros.getRowCount();
                for (int i = 0; i < filas; i++) {
                    DetalleFacturaTO objDetalleFacturaTO = new DetalleFacturaTO();
                    objDetalleFacturaTO.setIdfactura(xidfactura);
                    objDetalleFacturaTO.setIdproducto(Integer.parseInt(jtblRegistros.getValueAt(i, 0).toString()));
                    objDetalleFacturaTO.setPrecio(Double.parseDouble(jtblRegistros.getValueAt(i, 2).toString()));
                    objDetalleFacturaTO.setCantidad(Integer.parseInt(jtblRegistros.getValueAt(i, 3).toString()));
                    objDetalleFacturaTO.setImporte(Double.parseDouble(jtblRegistros.getValueAt(i, 4).toString()));
                    objDetalleFacturaDAO.insert(objDetalleFacturaTO);
                }
                grabado.run();
                mensaje = "REGISTRO GRABADO";
                try {
                    Connection cn = ConMySql.getInstance().getConnection();
                    String direccion = System.getProperty("user.dir") + "\\src\\reporte\\repFactura.jrxml";
                    JasperReport reporte = JasperCompileManager.compileReport(direccion);
                    Map parametros = new HashMap();
                    parametros.put("parametro_idfactura", objFacturaDAO.obtenerIdFactura());
                    JasperPrint mostrarReporte = JasperFillManager.fillReport(reporte, parametros, cn);
                    JasperViewer view = new JasperViewer(mostrarReporte, false);
                    view.setTitle("Reporte de Clientes");
                    view.setExtendedState(MAXIMIZED_BOTH);
                    view.setVisible(true);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage());
                }
            } else {
                actualizado.run();
                mensaje = "REGISTRO ACTUALIZADO";
            }
            habilitaControles(false);
            JOptionPane.showMessageDialog(rootPane, mensaje);
            limpiaControles();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_jbtnGrabarActionPerformed

    private void jbtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnNuevoActionPerformed
        start.run();
        limpiaControles();
        try {
            java.util.Date utilDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            jtxtFactura.setText(String.valueOf(objFacturaDAO.obtenerIdFactura()));
            jtxtFecha.setText(String.valueOf(sqlDate));
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(rootPane, ex);
        }
        habilitaControles(true);
        sw = true;
    }//GEN-LAST:event_jbtnNuevoActionPerformed

    private void jtxtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtCantidadActionPerformed
        precio = Double.parseDouble(jtxtPrecio.getText().trim());
        cantidad = Integer.parseInt(jtxtCantidad.getText().trim());
        importe = precio * cantidad;
        jtxtImporte.setText(String.format("%.2f", importe));
    }//GEN-LAST:event_jtxtCantidadActionPerformed

    private void jbtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAgregarActionPerformed
        start.run();
        if (jtxtIdcliente.getText().equals("")) {
            JOptionPane.showMessageDialog(rootPane, "Falta ingresar un cliente");
        } else {
            if (jtxtIdempleado.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Falta ingresar un empleado");
            } else {
                if (cantidad == 0) {
                    JOptionPane.showMessageDialog(rootPane, "Error al agregar un nuevo registro");
                } else {
                    int cont = 0;
                    int idproducto = Integer.parseInt(jtxtIdproducto.getText());
                    boolean sw = false;
                    Object registro[] = {jtxtIdproducto.getText(), jtxtNombprod.getText(), precio,
                        cantidad, importe};
                    if (objDtm.getRowCount() == 0) {
                        objDtm.addRow(registro);
                    } else {
                        while (cont < objDtm.getRowCount()) {
                            if (idproducto == Integer.parseInt(objDtm.getValueAt(cont, 0).toString())) {
                                sw = true;
                                JOptionPane.showMessageDialog(rootPane, "El registro ya existe");
                            }
                            cont++;
                        }
                        if (!sw) {
                            objDtm.addRow(registro);
                        }
                    }
                    limpiaproducto();
                    calcularTotales();
                }
            }
        }
    }//GEN-LAST:event_jbtnAgregarActionPerformed

    private void jbtnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEliminarActionPerformed
        try {
            exclamtion.run();
            objDtm.removeRow(jtblRegistros.getSelectedRow());
            calcularTotales();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Debe seleccionar una fila dentro de la columna");
        }
    }//GEN-LAST:event_jbtnEliminarActionPerformed

    private void jbtnClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnClienteActionPerformed
        start.run();
        MenuGUI.desktopPane.add(new BuscarClienteGUI());
    }//GEN-LAST:event_jbtnClienteActionPerformed

    private void jbtnEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnEmpleadoActionPerformed
        start.run();
        MenuGUI.desktopPane.add(new BuscarEmpleado());
    }//GEN-LAST:event_jbtnEmpleadoActionPerformed

    private void jbtnProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnProductoActionPerformed
        start.run();
        MenuGUI.desktopPane.add(new BuscarProducto());
    }//GEN-LAST:event_jbtnProductoActionPerformed

    private void jbtnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnImprimirActionPerformed
        try {
            select.run();            
            int op = JOptionPane.showConfirmDialog(rootPane, "Desea imprimir la ultima factura", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (op == JOptionPane.YES_OPTION) {
                select.run();
                Connection cn = ConMySql.getInstance().getConnection();
                String direccion = System.getProperty("user.dir") + "\\src\\reporte\\repFactura.jrxml";
                JasperReport reporte = JasperCompileManager.compileReport(direccion);
                Map parametros = new HashMap();
                parametros.put("parametro_idfactura", objFacturaDAO.obtenerIdFactura());
                JasperPrint mostrarReporte = JasperFillManager.fillReport(reporte, parametros, cn);
                JasperExportManager.exportReportToPdfFile(mostrarReporte, System.getProperty("user.dir") + "\\src\\reporte\\repFactura.pdf");
                imprimir();
            } else {
                select.run();
                int p = Integer.parseInt(JOptionPane.showInputDialog("INGRESE EL ID DE LA FACTURA"));
                Connection cn = ConMySql.getInstance().getConnection();
                String direccion = System.getProperty("user.dir") + "\\src\\reporte\\repFactura.jrxml";
                JasperReport reporte = JasperCompileManager.compileReport(direccion);
                Map parametros = new HashMap();
                parametros.put("parametro_idfactura", p);
                JasperPrint mostrarReporte = JasperFillManager.fillReport(reporte, parametros, cn);
                JasperExportManager.exportReportToPdfFile(mostrarReporte, System.getProperty("user.dir") + "\\src\\reporte\\repFactura.pdf");
                imprimir();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }//GEN-LAST:event_jbtnImprimirActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnAgregar;
    private javax.swing.JButton jbtnCancelar;
    private javax.swing.JButton jbtnCliente;
    private javax.swing.JButton jbtnEliminar;
    private javax.swing.JButton jbtnEmpleado;
    private javax.swing.JButton jbtnGrabar;
    private javax.swing.JButton jbtnImprimir;
    private javax.swing.JButton jbtnNuevo;
    private javax.swing.JButton jbtnProducto;
    private javax.swing.JButton jbtnSalir;
    private javax.swing.JTable jtblRegistros;
    private javax.swing.JTextField jtxtCantidad;
    public static javax.swing.JTextField jtxtCelular;
    public static javax.swing.JTextField jtxtCiudad;
    public static javax.swing.JTextField jtxtDireclie;
    private javax.swing.JTextField jtxtFactura;
    private javax.swing.JTextField jtxtFecha;
    public static javax.swing.JTextField jtxtIdcliente;
    public static javax.swing.JTextField jtxtIdempleado;
    public static javax.swing.JTextField jtxtIdproducto;
    private javax.swing.JTextField jtxtIgv;
    private javax.swing.JTextField jtxtImporte;
    public static javax.swing.JTextField jtxtMaterno;
    public static javax.swing.JTextField jtxtNombclie;
    public static javax.swing.JTextField jtxtNombempl;
    public static javax.swing.JTextField jtxtNombprod;
    public static javax.swing.JTextField jtxtPaterno;
    public static javax.swing.JTextField jtxtPrecio;
    private javax.swing.JTextField jtxtSubtotal;
    private javax.swing.JTextField jtxtTotal;
    // End of variables declaration//GEN-END:variables

    public void imprimir() {
        PrinterJob job = PrinterJob.getPrinterJob();
        job.printDialog();
        String impresora = job.getPrintService().getName();
        Imprimir.run();
        Desktop desktop = Desktop.getDesktop();
        File fichero = new File(System.getProperty("user.dir") + "\\src\\reporte\\repFactura.pdf");
        if (desktop.isSupported(Desktop.Action.PRINT)) {
            try {
                try {
                    Process pr = Runtime.getRuntime().exec("Rundll32 printui.dll,PrintUIEntry /y /n \"" + impresora + "\"");
                } catch (Exception ex) {
                    System.out.println("Ha ocurrido un error al ejecutar el comando. Error: " + ex);
                }
                desktop.print(fichero);
            } catch (Exception e) {
                System.out.print("El sistema no permite imprimir usando la clase Desktop");
            }
        } else {
            System.out.print("El sistema no permite imprimir usando la clase Desktop");
        }
    }

    private void habilitaControles(boolean b) {
        jtxtCantidad.setEditable(b);
        jbtnGrabar.setEnabled(b);
        jbtnCancelar.setEnabled(b);
        jbtnCliente.setEnabled(b);
        jbtnEmpleado.setEnabled(b);
        jbtnProducto.setEnabled(b);
        jbtnAgregar.setEnabled(b);
        jbtnEliminar.setEnabled(b);
        jbtnImprimir.setEnabled(b);
        jbtnNuevo.setEnabled(!b);
        jbtnSalir.setEnabled(!b);
    }

    private void limpiaControles() {
        limpiarJTable();
        JTextField[] arrTextFields = {jtxtCelular, jtxtCiudad, jtxtDireclie, jtxtFactura,
            jtxtFecha, jtxtIgv, jtxtNombclie, jtxtSubtotal, jtxtTotal, jtxtCantidad, jtxtIdcliente, jtxtIdempleado,
            jtxtIdproducto, jtxtImporte, jtxtMaterno, jtxtNombprod, jtxtNombempl, jtxtPaterno, jtxtPrecio};
        for (JTextField obJTextField : arrTextFields) {
            obJTextField.setText(null);
        }
    }

    private void limpiarJTable() {
        while (objDtm.getRowCount() > 0) {
            objDtm.removeRow(0);
        }
    }

    private void limpiaproducto() {
        jtxtIdproducto.setText(null);
        jtxtNombprod.setText(null);
        jtxtPrecio.setText(null);
        jtxtCantidad.setText(null);
        jtxtImporte.setText(null);
        cantidad = 0;
        importe = 0;
        precio = 0;
    }   

    private void calcularTotales() {
        subtotal = 0;
        igv = 0;
        total = 0;
        int filas = objDtm.getRowCount();
        int cont = 0;
        while (cont < filas) {
            total = total + Double.parseDouble(objDtm.getValueAt(cont, 4).toString());
            cont++;
        }
        subtotal = total / 1.18;
        igv = total - subtotal;
        jtxtSubtotal.setText(String.format("%.2f", subtotal));
        jtxtIgv.setText(String.format("%.2f", igv));
        jtxtTotal.setText(String.format("%.2f", total));
    }
}
