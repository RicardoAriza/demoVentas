package gui;

import conexion.ConMySql;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

public class MenuGUI extends javax.swing.JFrame {

    public MenuGUI(int i) {
        initComponents();
        if (i == 0) {
            audFactura.setVisible(false);
        }
        setExtendedState(MAXIMIZED_BOTH);
    }

    public MenuGUI() {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        mnuMante = new javax.swing.JMenu();
        manCliente = new javax.swing.JMenuItem();
        manDistrito = new javax.swing.JMenuItem();
        manEmpleado = new javax.swing.JMenuItem();
        manProducto = new javax.swing.JMenuItem();
        manProvincia = new javax.swing.JMenuItem();
        manSalir = new javax.swing.JMenuItem();
        mnuFacturacion = new javax.swing.JMenu();
        facGenerar = new javax.swing.JMenuItem();
        mnuReportes = new javax.swing.JMenu();
        repCliente = new javax.swing.JMenuItem();
        repDistrito = new javax.swing.JMenuItem();
        repFactura = new javax.swing.JMenuItem();
        repProducto = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        audFactura = new javax.swing.JMenuItem();
        backup = new javax.swing.JMenuItem();
        restore = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        Pacman = new javax.swing.JMenuItem();
        mnuAyuda = new javax.swing.JMenu();
        ayuAcerca = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mnuMante.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/maintenance.png"))); // NOI18N
        mnuMante.setMnemonic('m');
        mnuMante.setText("Mantenimiento");

        manCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, 0));
        manCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cliente.png"))); // NOI18N
        manCliente.setMnemonic('c');
        manCliente.setText("Cliente");
        manCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manClienteActionPerformed(evt);
            }
        });
        mnuMante.add(manCliente);

        manDistrito.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, 0));
        manDistrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/distrito.png"))); // NOI18N
        manDistrito.setMnemonic('d');
        manDistrito.setText("Distrito");
        manDistrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manDistritoActionPerformed(evt);
            }
        });
        mnuMante.add(manDistrito);

        manEmpleado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, 0));
        manEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/empleado.png"))); // NOI18N
        manEmpleado.setMnemonic('e');
        manEmpleado.setText("Empleado");
        manEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manEmpleadoActionPerformed(evt);
            }
        });
        mnuMante.add(manEmpleado);

        manProducto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, 0));
        manProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/producto.png"))); // NOI18N
        manProducto.setMnemonic('p');
        manProducto.setText("Producto");
        manProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manProductoActionPerformed(evt);
            }
        });
        mnuMante.add(manProducto);

        manProvincia.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, 0));
        manProvincia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/provincia.png"))); // NOI18N
        manProvincia.setMnemonic('v');
        manProvincia.setText("Provincia");
        manProvincia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manProvinciaActionPerformed(evt);
            }
        });
        mnuMante.add(manProvincia);

        manSalir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, 0));
        manSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/salir.png"))); // NOI18N
        manSalir.setMnemonic('s');
        manSalir.setText("Salir");
        manSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manSalirActionPerformed(evt);
            }
        });
        mnuMante.add(manSalir);

        menuBar.add(mnuMante);

        mnuFacturacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/factura.png"))); // NOI18N
        mnuFacturacion.setMnemonic('f');
        mnuFacturacion.setText("Facturación");

        facGenerar.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G, 0));
        facGenerar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/factura_color.png"))); // NOI18N
        facGenerar.setMnemonic('g');
        facGenerar.setText("Generar factura");
        facGenerar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facGenerarActionPerformed(evt);
            }
        });
        mnuFacturacion.add(facGenerar);

        menuBar.add(mnuFacturacion);

        mnuReportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/array.png"))); // NOI18N
        mnuReportes.setMnemonic('r');
        mnuReportes.setText("Reporte");

        repCliente.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.ALT_MASK));
        repCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/cliente.png"))); // NOI18N
        repCliente.setMnemonic('c');
        repCliente.setText("Cliente");
        repCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repClienteActionPerformed(evt);
            }
        });
        mnuReportes.add(repCliente);

        repDistrito.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.ALT_MASK));
        repDistrito.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/distrito.png"))); // NOI18N
        repDistrito.setMnemonic('d');
        repDistrito.setText("Distrito");
        repDistrito.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repDistritoActionPerformed(evt);
            }
        });
        mnuReportes.add(repDistrito);

        repFactura.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.ALT_MASK));
        repFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/factura_color.png"))); // NOI18N
        repFactura.setMnemonic('f');
        repFactura.setText("Factura");
        repFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repFacturaActionPerformed(evt);
            }
        });
        mnuReportes.add(repFactura);

        repProducto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        repProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/producto.png"))); // NOI18N
        repProducto.setMnemonic('p');
        repProducto.setText("Producto");
        repProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                repProductoActionPerformed(evt);
            }
        });
        mnuReportes.add(repProducto);

        menuBar.add(mnuReportes);

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/seguridad.png"))); // NOI18N
        jMenu1.setMnemonic('u');
        jMenu1.setText("Auditoria");

        audFactura.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, 0));
        audFactura.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/factura.png"))); // NOI18N
        audFactura.setMnemonic('f');
        audFactura.setText("Factura");
        audFactura.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                audFacturaActionPerformed(evt);
            }
        });
        jMenu1.add(audFactura);

        backup.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, 0));
        backup.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/backup.png"))); // NOI18N
        backup.setText("Backup");
        backup.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backupActionPerformed(evt);
            }
        });
        jMenu1.add(backup);

        restore.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, 0));
        restore.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/restore.png"))); // NOI18N
        restore.setText("Restore");
        restore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                restoreActionPerformed(evt);
            }
        });
        jMenu1.add(restore);

        menuBar.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/juegos.png"))); // NOI18N
        jMenu2.setText("Juegos");

        Pacman.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_MASK));
        Pacman.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/pacman.png"))); // NOI18N
        Pacman.setText("Pacman");
        Pacman.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PacmanActionPerformed(evt);
            }
        });
        jMenu2.add(Pacman);

        menuBar.add(jMenu2);

        mnuAyuda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/acercaDe.png"))); // NOI18N
        mnuAyuda.setMnemonic('a');
        mnuAyuda.setText("Ayuda");

        ayuAcerca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_H, 0));
        ayuAcerca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/iconos/ayuda.png"))); // NOI18N
        ayuAcerca.setMnemonic('h');
        ayuAcerca.setText("Acerca de ...");
        mnuAyuda.add(ayuAcerca);

        menuBar.add(mnuAyuda);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.DEFAULT_SIZE, 542, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(desktopPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 266, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void manProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manProductoActionPerformed
        MenuGUI.desktopPane.add(new ProductoGUI());
    }//GEN-LAST:event_manProductoActionPerformed

    private void manDistritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manDistritoActionPerformed
        MenuGUI.desktopPane.add(new DistritoGUI());
    }//GEN-LAST:event_manDistritoActionPerformed

    private void manEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manEmpleadoActionPerformed
        MenuGUI.desktopPane.add(new EmpleadoGUI());
    }//GEN-LAST:event_manEmpleadoActionPerformed

    private void manClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manClienteActionPerformed
        MenuGUI.desktopPane.add(new ClienteGUI());
    }//GEN-LAST:event_manClienteActionPerformed

    private void manSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manSalirActionPerformed
        dispose();
    }//GEN-LAST:event_manSalirActionPerformed

    private void repProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repProductoActionPerformed
        try {
            Connection cn = ConMySql.getInstance().getConnection();
            String direccion = System.getProperty("user.dir") + "\\src\\reporte\\repProducto.jrxml";
            JasperReport reporte = JasperCompileManager.compileReport(direccion);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporte, null, cn);
            JasperViewer view = new JasperViewer(mostrarReporte, false);
            view.setTitle("Reporte de Producto");
            view.setExtendedState(MAXIMIZED_BOTH);
            view.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_repProductoActionPerformed

    private void repFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repFacturaActionPerformed
        try {
            int p = Integer.parseInt(JOptionPane.showInputDialog("INGRESE EL ID DE LA FACTURA"));
            Connection cn = ConMySql.getInstance().getConnection();
            String direccion = System.getProperty("user.dir") + "\\src\\reporte\\repFactura.jrxml";
            JasperReport reporte = JasperCompileManager.compileReport(direccion);
            Map parametros = new HashMap();
            parametros.put("parametro_idfactura", p);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporte, parametros, cn);
            JasperViewer view = new JasperViewer(mostrarReporte, false);
            view.setTitle("Reporte de la Factura");
            view.setExtendedState(MAXIMIZED_BOTH);
            view.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }//GEN-LAST:event_repFacturaActionPerformed

    private void repDistritoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repDistritoActionPerformed
        try {
            Connection cn = ConMySql.getInstance().getConnection();
            String direccion = System.getProperty("user.dir") + "\\src\\reporte\\repDistrito.jrxml";
            JasperReport reporte = JasperCompileManager.compileReport(direccion);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporte, null, cn);
            JasperViewer view = new JasperViewer(mostrarReporte, false);
            view.setTitle("Reporte de Distrito");
            view.setExtendedState(MAXIMIZED_BOTH);
            view.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_repDistritoActionPerformed

    private void repClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_repClienteActionPerformed
        try {
            Connection cn = ConMySql.getInstance().getConnection();
            String direccion = System.getProperty("user.dir") + "\\src\\reporte\\repCliente.jrxml";
            JasperReport reporte = JasperCompileManager.compileReport(direccion);
            JasperPrint mostrarReporte = JasperFillManager.fillReport(reporte, null, cn);
            JasperViewer view = new JasperViewer(mostrarReporte, false);
            view.setTitle("Reporte del Cliente");
            view.setExtendedState(MAXIMIZED_BOTH);
            view.setVisible(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_repClienteActionPerformed

    private void facGenerarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facGenerarActionPerformed
        MenuGUI.desktopPane.add(new FacturaGUI());
    }//GEN-LAST:event_facGenerarActionPerformed

    private void manProvinciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manProvinciaActionPerformed
        MenuGUI.desktopPane.add(new ProvinciaGUI());
    }//GEN-LAST:event_manProvinciaActionPerformed

    private void audFacturaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_audFacturaActionPerformed
        MenuGUI.desktopPane.add(new AuditoriaFacturaGUI());
    }//GEN-LAST:event_audFacturaActionPerformed

    private void PacmanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PacmanActionPerformed
        try {
            Runtime objrun = Runtime.getRuntime();
            String ruta = System.getProperty("user.dir") + "\\src\\juegos\\Pacman.exe";
            objrun.exec(ruta);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, "error al cargar juego " + e);
        }
    }//GEN-LAST:event_PacmanActionPerformed

    private void backupActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backupActionPerformed
        try {
            Process p = Runtime.getRuntime().exec("C:/xampp/mysql/bin/mysqldump --routines -u root ventas20201");
            InputStream is = p.getInputStream();
            FileOutputStream fos = new FileOutputStream("backup_ventas20201.sql");
            byte[] buffer = new byte[1000];
            int leido = is.read(buffer);
            while (leido > 0) {
                fos.write(buffer, 0, leido);
                leido = is.read(buffer);
            }
            fos.close();
            JOptionPane.showMessageDialog(rootPane, "BASE DE DATOS GUARDADA");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e);
        }
    }//GEN-LAST:event_backupActionPerformed

    private void restoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_restoreActionPerformed
        try {
//            PreparedStatement ps=null;
//            Connection cn=ConMySQL.getInstance().getConnection();
//            String sql1="drop database if exists ventas20201";
//            String sql2="create database ventas20201";
//            ps=cn.prepareStatement(sql1);
//            ps.execute();
//            ps=cn.prepareStatement(sql2);
//            ps.execute();
            JFileChooser archivo = new JFileChooser();
            archivo.showOpenDialog(null);
            File file = archivo.getSelectedFile();
            Process p = Runtime.getRuntime().exec("C:/xampp/mysql/bin/mysql -u root ventas20201");
            OutputStream os = p.getOutputStream();
            FileInputStream fis = new FileInputStream(String.valueOf(file));
            byte[] buffer = new byte[1000];
            int leido = fis.read(buffer);
            while (leido > 0) {
                os.write(buffer, 0, leido);
                leido = fis.read(buffer);
            }
            os.flush();
            os.close();
            fis.close();
            JOptionPane.showMessageDialog(rootPane, "BASE DE DATOS RESTAURADA");
        } catch (Exception e) {

            e.printStackTrace();
        }
    }//GEN-LAST:event_restoreActionPerformed

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
            java.util.logging.Logger.getLogger(AcessoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AcessoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AcessoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AcessoGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem Pacman;
    private javax.swing.JMenuItem audFactura;
    private javax.swing.JMenuItem ayuAcerca;
    private javax.swing.JMenuItem backup;
    public static javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem facGenerar;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem manCliente;
    private javax.swing.JMenuItem manDistrito;
    private javax.swing.JMenuItem manEmpleado;
    private javax.swing.JMenuItem manProducto;
    private javax.swing.JMenuItem manProvincia;
    private javax.swing.JMenuItem manSalir;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu mnuAyuda;
    private javax.swing.JMenu mnuFacturacion;
    private javax.swing.JMenu mnuMante;
    private javax.swing.JMenu mnuReportes;
    private javax.swing.JMenuItem repCliente;
    private javax.swing.JMenuItem repDistrito;
    private javax.swing.JMenuItem repFactura;
    private javax.swing.JMenuItem repProducto;
    private javax.swing.JMenuItem restore;
    // End of variables declaration//GEN-END:variables

}
