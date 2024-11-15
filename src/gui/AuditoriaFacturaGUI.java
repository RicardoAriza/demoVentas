package gui;

import conexion.ConMySql;
import dao.FacturaDAO;
import dao.HFacturaDAO;
import hilo.AudioConHilos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class AuditoriaFacturaGUI extends javax.swing.JInternalFrame {

    ResultSet rsFactura;
    HFacturaDAO objHfacturaDAO = new HFacturaDAO();
    DefaultTableModel objDtm;
    AudioConHilos select = new AudioConHilos("/sonidos/WSelect.wav");
    AudioConHilos exit = new AudioConHilos("/sonidos/WExit.wav");

    public AuditoriaFacturaGUI() {
        initComponents();
        setSize(891, 302);
        setVisible(true);
        setLocation(100, 50);
        objDtm = (DefaultTableModel) jtblRegistros.getModel();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jtblRegistros = new javax.swing.JTable();
        jbtnSalir = new javax.swing.JButton();
        jbtnBuscar = new javax.swing.JButton();
        jdatFinal = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();
        jdatInicio = new com.toedter.calendar.JDateChooser();
        jLabel2 = new javax.swing.JLabel();
        jbtnImprimir = new javax.swing.JButton();

        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jtblRegistros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FACTURA", "FECHA", "CLIENTE", "NOMB_EMPL", "AP_EMPL", "AM_EMPL", "TOTAL", "TRANSAC", "USUARIO", "FECHA_MOD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtblRegistros.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane1.setViewportView(jtblRegistros);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 58, 847, 154));

        jbtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/salir.png"))); // NOI18N
        jbtnSalir.setText("Salir");
        jbtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnSalirActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(399, 223, 135, -1));

        jbtnBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/Buscar.png"))); // NOI18N
        jbtnBuscar.setText("Buscar");
        jbtnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnBuscarActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnBuscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(741, 11, 110, -1));
        getContentPane().add(jdatFinal, new org.netbeans.lib.awtextra.AbsoluteConstraints(481, 20, 250, -1));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("FECHA FINAL :");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(382, 20, -1, 20));
        getContentPane().add(jdatInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(114, 20, 250, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("FECHA INICIO :");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, 20));

        jbtnImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/factura_1.png"))); // NOI18N
        jbtnImprimir.setText("Imprimir");
        jbtnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnImprimirActionPerformed(evt);
            }
        });
        getContentPane().add(jbtnImprimir, new org.netbeans.lib.awtextra.AbsoluteConstraints(246, 223, 135, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnSalirActionPerformed
        exit.run();
        dispose();
    }//GEN-LAST:event_jbtnSalirActionPerformed

    private void jbtnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnBuscarActionPerformed
        try {            
            select.run();
            java.util.Date utilDate = jdatInicio.getDate();
            java.util.Date utilDat = jdatFinal.getDate();
            java.sql.Date fecha1 = new java.sql.Date(utilDate.getTime());
            java.sql.Date fecha2 = new java.sql.Date(utilDat.getTime());
            rsFactura = objHfacturaDAO.buscarHFfactura(fecha1, fecha2);
        while (rsFactura.next()) {    
            Object[] registro={rsFactura.getInt(1),rsFactura.getDate(2),rsFactura.getString(3),rsFactura.getString(4),
            rsFactura.getString(5),rsFactura.getString(6),rsFactura.getDouble(9),rsFactura.getString(11),
            rsFactura.getString(12),rsFactura.getDate(13)};
            objDtm.addRow(registro);
            }        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        } 
    }//GEN-LAST:event_jbtnBuscarActionPerformed

    private void jbtnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnImprimirActionPerformed
        try {
            Connection cn= ConMySql.getInstance().getConnection();
            java.util.Date utilDate = jdatInicio.getDate();
            java.util.Date utilDat = jdatFinal.getDate();
            java.sql.Date fecha1 = new java.sql.Date(utilDate.getTime());
            java.sql.Date fecha2 = new java.sql.Date(utilDat.getTime());
            String direccion=System.getProperty("user.dir")+"\\src\\reporte\\repAuditoriaFactura.jrxml";
            JasperReport reporte=JasperCompileManager.compileReport(direccion);
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("fechaInicio", fecha1);
            map.put("fechaFinal", fecha2);
            JasperPrint mostrarReporte=JasperFillManager.fillReport(reporte,map, cn);
            JasperViewer view=new JasperViewer(mostrarReporte,false);
            view.setTitle("Reporte Auditoria de Factura");
            view.setVisible(true);
        } catch (Exception ex) {
            
        }
    }//GEN-LAST:event_jbtnImprimirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnBuscar;
    private javax.swing.JButton jbtnImprimir;
    private javax.swing.JButton jbtnSalir;
    private com.toedter.calendar.JDateChooser jdatFinal;
    private com.toedter.calendar.JDateChooser jdatInicio;
    private javax.swing.JTable jtblRegistros;
    // End of variables declaration//GEN-END:variables
}
